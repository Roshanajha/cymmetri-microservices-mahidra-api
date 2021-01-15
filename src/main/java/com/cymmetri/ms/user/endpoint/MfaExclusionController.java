package com.cymmetri.ms.user.endpoint;

import com.cymmetri.ms.user.dto.Response;
import com.cymmetri.ms.user.service.MfaExlusionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mfaexclusion")
public class MfaExclusionController {

	private final MfaExlusionService mfaExlusionService;


	public MfaExclusionController(MfaExlusionService mfaExlusionService) {
		this.mfaExlusionService = mfaExlusionService;
	}


	@GetMapping("/list/{groupId}")
	public ResponseEntity<Response> listExcludedUser(@PathVariable String groupId){
		Response response = new Response();
		response.succeed();
		response.setData(this.mfaExlusionService.getUserNamesByRuleId(groupId));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/assign/{login}")
	public ResponseEntity<Response> mfaExclusionAddUser(@PathVariable String login){
		Response response = new Response();
		response.succeed();
		response.setData(this.mfaExlusionService.assignGroupDTOResponse(login));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/unassign/{login}")
	public ResponseEntity<Response> mfaExclusionRemoveUser(@PathVariable String login){
		Response response = new Response();
		response.succeed();
		response.setData(this.mfaExlusionService.unAssignGroupDTOResponse(login));
		return ResponseEntity.ok().body(response);
	}
}
