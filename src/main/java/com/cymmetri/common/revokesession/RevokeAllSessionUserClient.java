package com.cymmetri.common.revokesession;

import com.cymmetri.ms.user.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "revokeallsessionuserclient", url = "${cymmetri.authsrvc.api}")
public interface RevokeAllSessionUserClient {

	@GetMapping("session/revokeAllSessionForUser/{login}")
	ResponseEntity<Response> resetPassword(@PathVariable(required = true) String login);

}
