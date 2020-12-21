package com.cymmetri.ms.user.endpoint;

import com.cymmetri.ms.user.dto.Response;
import com.cymmetri.ms.user.service.RevokeAllSessionUserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/revokesession")
public class RevokeAllSessionUserController {

	private final com.cymmetri.ms.user.service.RevokeAllSessionUserService revokeAllSessionUserService;

	public RevokeAllSessionUserController(RevokeAllSessionUserService revokeAllSessionUserService) {
		this.revokeAllSessionUserService = revokeAllSessionUserService;
	}

	@GetMapping("{login}")
	public ResponseEntity<Response> revokeSession(@PathVariable(required = true) String login){
		Response response = new Response();
		response.succeed();
		response.setData(this.revokeAllSessionUserService.revokeSession(login));
		return ResponseEntity.ok().body(response);
	}
}
