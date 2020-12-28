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
package com.cymmetri.common.passwordpolicy;

import com.cymmetri.common.passwordpolicy.dto.PasswordChangeRule;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyComposition;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyDto;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyResponse;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicySearchResponse;
import com.cymmetri.ms.user.dto.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PasswordPolicyService {

	private final PasswordPolicyClient passwordPolicyClient;

	public PasswordPolicyService(PasswordPolicyClient passwordPolicyClient) {
		this.passwordPolicyClient = passwordPolicyClient;
	}

	public PasswordPolicyResponse create(PasswordPolicyDto passwordPolicyDto) {
		PasswordPolicyResponse passwordPolicyResponse = null;
		ResponseEntity<Response> responseEntity;
		responseEntity = this.passwordPolicyClient.createNewPasswordPolicy(passwordPolicyDto);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
			passwordPolicyResponse = mapper.convertValue(response.getData(), PasswordPolicyResponse.class);
		}

		return passwordPolicyResponse;
	}

	public PasswordPolicyResponse update(String id, PasswordPolicyDto passwordPolicyDto) {
		PasswordPolicyResponse passwordPolicyResponse = null;
		ResponseEntity<Response> responseEntity = this.passwordPolicyClient.updatePasswordPolicy(id, passwordPolicyDto);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
			passwordPolicyResponse = mapper.convertValue(response.getData(), PasswordPolicyResponse.class);
		}

		return passwordPolicyResponse;
	}

	public PasswordPolicySearchResponse search(String name, Integer pageNo, Integer size, String sortBy, String order) {
		PasswordPolicySearchResponse passwordPolicySearchResponse = null;
		ResponseEntity<Response> responseEntity = this.passwordPolicyClient.searchPasswordPolicy(name, pageNo, size,
				sortBy, order);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
			log.info(String.valueOf(response.getData()));
			passwordPolicySearchResponse = mapper.convertValue(response.getData(), PasswordPolicySearchResponse.class);
		}

		return passwordPolicySearchResponse;
	}

	public PasswordPolicyDto getPasswordPolicyById(String id) {
		PasswordPolicyDto passwordPolicyDto = null;
		ResponseEntity<Response> responseEntity = this.passwordPolicyClient.getPasswordPolicyById(id);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
			passwordPolicyDto = mapper.convertValue(response.getData(), PasswordPolicyDto.class);
		}

		return passwordPolicyDto;
	}

	public PasswordChangeRule getPasswordChangedRule(String id) {
		PasswordChangeRule passwordChangeRule = null;
		ResponseEntity<Response> responseEntity = this.passwordPolicyClient.getPasswordChangedRule(id);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
			passwordChangeRule = mapper.convertValue(response.getData(), PasswordChangeRule.class);
		}

		return passwordChangeRule;
	}

	public PasswordPolicyComposition savePasswordCompositionRule(String id,
			PasswordPolicyComposition passwordPolicyComposition) {
		PasswordPolicyComposition passwordPolicyComposition1 = null;
		ResponseEntity<Response> responseEntity = this.passwordPolicyClient.savePasswordCompositionRule(id,
				passwordPolicyComposition);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
			passwordPolicyComposition1 = mapper.convertValue(response.getData(), PasswordPolicyComposition.class);
		}

		return passwordPolicyComposition1;
	}

}
