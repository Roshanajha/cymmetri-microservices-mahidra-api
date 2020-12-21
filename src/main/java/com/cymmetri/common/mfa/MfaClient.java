package com.cymmetri.common.mfa;

import com.cymmetri.common.mfa.dto.AdminRemoveRegisteredMfaRequest;
import com.cymmetri.ms.user.dto.Response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "removemfaclient", url = "${cymmetri.mfasrvc.api}")
public interface MfaClient {

	@PostMapping("mfaConfig/admin/removeMFAForUser")
	ResponseEntity<Response> removeMfaConfig(@RequestBody AdminRemoveRegisteredMfaRequest mfaRequest);



}
