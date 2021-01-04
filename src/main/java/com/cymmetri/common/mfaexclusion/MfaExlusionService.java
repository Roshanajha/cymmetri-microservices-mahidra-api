package com.cymmetri.common.mfaexclusion;

import com.cymmetri.common.mfaexclusion.dto.AssignGroupDTO;
import com.cymmetri.ms.user.dto.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MfaExlusionService {

	private final MfaExclusionClient mfaExclusionClient;

	public MfaExlusionService(MfaExclusionClient mfaExclusionClient) {
		this.mfaExclusionClient = mfaExclusionClient;
	}

	public AssignGroupDTO assignUserToGroup(AssignGroupDTO assignGroupDTO) {
		AssignGroupDTO assignGroupDTOResponse = null;
		ResponseEntity<Response> responseEntity;
		responseEntity = this.mfaExclusionClient.assignUserToMfaGroup(assignGroupDTO);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
			assignGroupDTOResponse = mapper.convertValue(response.getData(), AssignGroupDTO.class);
		}

		return assignGroupDTOResponse;
	}

	public AssignGroupDTO unAssignUserToGroup(AssignGroupDTO assignGroupDTO) {
		AssignGroupDTO assignGroupDTOResponse = null;
		ResponseEntity<Response> responseEntity;
		responseEntity = this.mfaExclusionClient.unAssignUserToMfaGroup(assignGroupDTO);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
			assignGroupDTOResponse = mapper.convertValue(response.getData(), AssignGroupDTO.class);
		}

		return assignGroupDTOResponse;
	}
}
