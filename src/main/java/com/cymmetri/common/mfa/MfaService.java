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
package com.cymmetri.common.mfa;

import com.cymmetri.common.mfa.dto.AdminRemoveRegisteredMfaRequest;
import com.cymmetri.common.mfa.dto.ListOfMfaUserDto;
import com.cymmetri.common.mfa.dto.UserIdRequest;
import com.cymmetri.common.mfaexcludeduser.dto.GetRuleByIdResponse;
import com.cymmetri.ms.user.dto.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MfaService {

	private final MfaClient mfaClient;

	public MfaService(MfaClient mfaClient) {
		this.mfaClient = mfaClient;
	}

	public Boolean removeMfa(AdminRemoveRegisteredMfaRequest mfaRequest) {
		ResponseEntity<Response> responseEntity;
		responseEntity = this.mfaClient.removeMfaConfig(mfaRequest);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			return true;
		}

		return false;
	}

	public ListOfMfaUserDto listOfMfaUser(UserIdRequest userId) {
		ListOfMfaUserDto listOfMfaUser = null;
		ResponseEntity<Response> responseEntity;
		responseEntity = this.mfaClient.listMfaForUser(userId);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
			listOfMfaUser = mapper.convertValue(response.getData(), ListOfMfaUserDto.class);
		}

		return listOfMfaUser;
	}

}
