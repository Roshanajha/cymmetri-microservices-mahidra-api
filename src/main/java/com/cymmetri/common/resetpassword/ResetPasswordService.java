package com.cymmetri.common.resetpassword;

import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyResponse;
import com.cymmetri.common.resetpassword.dto.ResetPasswordRequest;
import com.cymmetri.ms.user.dto.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

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
