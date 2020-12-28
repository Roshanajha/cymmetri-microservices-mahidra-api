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
package com.cymmetri.common.resetpassword;

import com.cymmetri.common.resetpassword.dto.ResetPasswordRequest;
import com.cymmetri.ms.user.dto.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ResetPasswordService {

	private final ResetPasswordClient resetPasswordClient;

	public ResetPasswordService(ResetPasswordClient resetPasswordClient) {
		this.resetPasswordClient = resetPasswordClient;
	}

	public String resetPassword(ResetPasswordRequest resetPasswordRequest) {

		String resetPassword = null;
		ResponseEntity<Response> responseEntity = this.resetPasswordClient.resetPassword(resetPasswordRequest);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
			resetPassword = mapper.convertValue(response.getData(), String.class);
		}
		return resetPassword;
	}

}
