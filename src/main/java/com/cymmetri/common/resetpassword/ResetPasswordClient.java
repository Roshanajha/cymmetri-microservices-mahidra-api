package com.cymmetri.common.resetpassword;

import com.cymmetri.common.resetpassword.dto.ResetPasswordRequest;
import com.cymmetri.ms.user.dto.Response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "resetpasswordclient", url = "${cymmetri.authsrvc.api}")
public interface ResetPasswordClient {

	@PostMapping("auth/resetPassword")
	ResponseEntity<Response> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest);



}
