package com.cymmetri.common.token;

import com.cymmetri.common.resetpassword.dto.ResetPasswordRequest;
import com.cymmetri.ms.user.dto.Response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "resetpasswordclient", url = "${cymmetri.authsrvc.api}")
public interface AuthTokenClient {

	@PostMapping("auth/token")
	ResponseEntity<Response> getAuthToken(@RequestBody ResetPasswordRequest resetPasswordRequest);

}
