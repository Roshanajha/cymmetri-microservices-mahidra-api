package com.cymmetri.common.mfaexcludeduser;

import com.cymmetri.common.mfaexclusion.dto.AssignGroupDTO;
import com.cymmetri.ms.user.dto.Response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mfaexcludedclient", url = "${cymmetri.rulesrvc.uri}")
public interface MfaExcludedClient {

	@GetMapping("rule/getRuleById/{ruleId}")
	ResponseEntity<Response> listExcludedUser(@PathVariable String ruleId);

}
