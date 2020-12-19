package com.cymmetri.common.unlocklogin;

import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyDto;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyResponse;
import com.cymmetri.ms.user.dto.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.BooleanBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UnlockLoginService {

	private final UnlockLoginClient unlockLoginClient;

	public UnlockLoginService(UnlockLoginClient unlockLoginClient) {
		this.unlockLoginClient = unlockLoginClient;
	}

	public Boolean unlockLogin(String login) {
		ResponseEntity<Response> responseEntity;
		responseEntity = this.unlockLoginClient.unlockLogin(login);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			return true;
		}

		return false;
	}
}
