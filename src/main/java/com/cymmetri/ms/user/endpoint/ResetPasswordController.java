package com.cymmetri.ms.user.endpoint;

import com.cymmetri.ms.user.dto.Response;
import com.cymmetri.ms.user.service.ResetPasswordService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/resetpassword")
public class ResetPasswordController {

	private final ResetPasswordService resetPasswordService;

	public ResetPasswordController(ResetPasswordService resetPasswordService) {
		this.resetPasswordService = resetPasswordService;
	}

	@PostMapping("{login}")
	public ResponseEntity<Response> resetPassword(@PathVariable(required = true) String login){

		final String resetPassword = this.resetPasswordService.resetPassword(login);
		Response response = new Response();
		response.setData(resetPassword);
		response.succeed();
		return ResponseEntity.ok().body(response);

	}
}
