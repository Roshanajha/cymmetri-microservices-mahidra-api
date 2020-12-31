package com.cymmetri.ms.user.endpoint;

import com.cymmetri.common.changepassword.dto.ChangePassword;
import com.cymmetri.ms.user.dto.Response;
import com.cymmetri.ms.user.exception.ChangePasswordException;
import com.cymmetri.ms.user.exception.PasswordValidationException;
import com.cymmetri.ms.user.service.ChangePasswordService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/changepassword")
public class ChangePasswordController {

	private final ChangePasswordService changePasswordService;

	public ChangePasswordController(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}

	@PostMapping("/changepassword")
	public ResponseEntity<Response> changePassword(@Valid @RequestBody ChangePassword changePassword) throws PasswordValidationException, ChangePasswordException {

		log.info("... changePassword controller ...");
		Response response = new Response();
		response.succeed();
		response.setData(this.changePasswordService.changePassword(changePassword));
		return ResponseEntity.ok().body(response);
	}
}
