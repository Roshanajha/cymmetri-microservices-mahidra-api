package com.cymmetri.common.revokesession;

import com.cymmetri.common.resetpassword.dto.ResetPasswordRequest;
import com.cymmetri.ms.user.dto.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RevokeAllSessionUserService {

	private final RevokeAllSessionUserClient revokeAllSessionUserClient;

	public RevokeAllSessionUserService(RevokeAllSessionUserClient revokeAllSessionUserClient) {
		this.revokeAllSessionUserClient = revokeAllSessionUserClient;
	}

	public Boolean revokeAllSessionForUser(String login) {

		ResponseEntity<Response> responseEntity = this.revokeAllSessionUserClient.resetPassword(login);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			return true;
		}

		return false;
	}
}
