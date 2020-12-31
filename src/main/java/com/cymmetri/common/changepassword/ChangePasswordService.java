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
package com.cymmetri.common.changepassword;

import com.cymmetri.common.changepassword.dto.ChangePassword;
import com.cymmetri.common.changepassword.dto.ValidatePassword;
import com.cymmetri.common.passwordpolicy.dto.PasswordChangeRule;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyComposition;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyDto;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyResponse;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicySearchResponse;
import com.cymmetri.ms.user.dto.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChangePasswordService {

	private final ChangePasswordClient changePasswordClient;

	public ChangePasswordService(ChangePasswordClient changePasswordClient) {
		this.changePasswordClient = changePasswordClient;
	}

	public boolean validatePassword(ValidatePassword validatePassword) {

		ResponseEntity<Response> responseEntity;
		responseEntity = this.changePasswordClient.validatePassword(validatePassword);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			return true;
		}

		return false;
	}

	public boolean changePassword(ChangePassword changePassword) {

		ResponseEntity<Response> responseEntity;
		responseEntity = this.changePasswordClient.changePassword(changePassword);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			return true;
		}

		return false;
	}

}
