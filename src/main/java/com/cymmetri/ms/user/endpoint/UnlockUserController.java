package com.cymmetri.ms.user.endpoint;

import com.cymmetri.ms.user.dto.Response;
import com.cymmetri.ms.user.service.UnlockUserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/unlockuser")
public class UnlockUserController {

	private final UnlockUserService unlockUserService;

	public UnlockUserController(UnlockUserService unlockUserService) {
		this.unlockUserService = unlockUserService;
	}

	@PostMapping("{login}")
	public ResponseEntity<Response> unlockLogin(@PathVariable(required = true) String login){
		Response response = new Response();
		response.succeed();
		response.setData(this.unlockUserService.unlockUser(login));
		return ResponseEntity.ok().body(response);
	}
}
