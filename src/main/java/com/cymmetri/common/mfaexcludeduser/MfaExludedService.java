package com.cymmetri.common.mfaexcludeduser;

import com.cymmetri.common.mfaexcludeduser.dto.GetRuleByIdResponse;
import com.cymmetri.common.mfaexclusion.dto.AssignGroupDTO;
import com.cymmetri.ms.user.dto.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MfaExludedService {

	private final MfaExcludedClient mfaExcludedClient;

	public MfaExludedService(MfaExcludedClient mfaExcludedClient) {
		this.mfaExcludedClient = mfaExcludedClient;
	}

	public GetRuleByIdResponse listExcludedUser(String ruleId) {
		GetRuleByIdResponse getRuleByIdResponse = null;
		ResponseEntity<Response> responseEntity;
		responseEntity = this.mfaExcludedClient.listExcludedUser(ruleId);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
			getRuleByIdResponse = mapper.convertValue(response.getData(), GetRuleByIdResponse.class);
		}

		return getRuleByIdResponse;
	}
}
