package com.cymmetri.common.changepassword;

import com.cymmetri.common.changepassword.dto.ChangePassword;
import com.cymmetri.common.changepassword.dto.ValidatePassword;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyDto;
import com.cymmetri.ms.user.dto.Response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "changepasswordclient", url = "${cymmetri.authsrvc.api}")
public interface ChangePasswordClient {

	@PostMapping("passwordPolicy/pub/validate/plain")
	ResponseEntity<Response> validatePassword(@RequestBody ValidatePassword validatePassword);

	@PostMapping("auth/api/resetPassword")
	ResponseEntity<Response> changePassword(@RequestBody ChangePassword changePassword);
}
