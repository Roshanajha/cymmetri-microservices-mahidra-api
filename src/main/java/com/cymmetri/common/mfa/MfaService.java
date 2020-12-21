package com.cymmetri.common.mfa;

import com.cymmetri.common.mfa.dto.AdminRemoveRegisteredMfaRequest;
import com.cymmetri.ms.user.dto.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

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

}
