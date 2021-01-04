package com.cymmetri.common.mfaexclusion;

import com.cymmetri.common.mfaexclusion.dto.AssignGroupDTO;
import com.cymmetri.ms.user.dto.Response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mfaexclusionclient", url = "${cymmetri.usersrvc.uri}")
public interface MfaExclusionClient {

	@PutMapping("api/group/assign")
	ResponseEntity<Response> assignUserToMfaGroup(@RequestBody AssignGroupDTO assignGroupDTO);

	@PutMapping("api/group/unassign")
	ResponseEntity<Response> unAssignUserToMfaGroup(@RequestBody AssignGroupDTO assignGroupDTO);

}
