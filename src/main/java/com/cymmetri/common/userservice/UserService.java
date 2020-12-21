/*
 * Copyright (c) 2020 Unotech Software Pvt. Ltd.
 *
 * All Rights Reserved.
 *
 * The software contained on this media is written by  Unotech Software Pvt. Ltd. and
 * is proprietary to and embodies the confidential technology of Unotech Software.
 *
 * The possession or receipt of this information does not convey any right to disclose
 * its contents, reproduce it, or use, or license the use, for manufacture or sale,
 * the information or anything described therein. Any use, disclosure, or reproduction
 * without prior written permission of Unotech Software is strictly prohibited.
 */
package com.cymmetri.common.userservice;

import com.cymmetri.ms.user.dto.Response;
import com.cymmetri.ms.user.dto.UserListResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	private final UserServiceClient userServiceClient;

	@Autowired
	ObjectMapper mapper;

	public UserService(UserServiceClient userServiceClient) {
		this.userServiceClient = userServiceClient;
	}

	public String getUserId(UserListDto userListDto) {

		log.info("... userListDto toString representation ... " + userListDto.toString());
		ResponseEntity<Response> responseEntity = this.userServiceClient.getUserObject(userListDto);

		String writeValueAsString;
		try {
			writeValueAsString = this.mapper.writeValueAsString(responseEntity.getBody().getData());
		}
		catch (JsonProcessingException ex) {
			throw new UnsupportedOperationException("Auto-generated method stub", ex);
		}

		String userId = null;

		try {
			Map<String, Object> userListResponses = this.mapper.readValue(writeValueAsString, new TypeReference<>() {
			});
			ArrayList<UserListResponse> userListResponse = (ArrayList<UserListResponse>) userListResponses
					.get("elements");
			if (!userListResponse.isEmpty()) {
				Map<String, Object> map = (Map<String, Object>) userListResponse.get(0);
				userId = (String) map.get("id");
			}
		}
		catch (JsonProcessingException ex) {
			throw new UnsupportedOperationException("Auto-generated method stub", ex);
		}

		log.info("userListResponse Object Recieved: {}", userId);

		return userId;
	}

}
