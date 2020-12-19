package com.cymmetri.common.unlocklogin;

import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyComposition;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyDto;
import com.cymmetri.ms.user.dto.Response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "unlockloginclient", url = "${cymmetri.authsrvc.api}")
public interface UnlockLoginClient {

	@PostMapping("auth/unlockLogin/{login}")
	ResponseEntity<Response> unlockLogin(@PathVariable String login);



}
