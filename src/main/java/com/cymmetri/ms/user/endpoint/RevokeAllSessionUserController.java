/*
 * Copyright (c) 2020 Unotech Software Pvt. Ltd.
 *
 * All Rights Reserved.
 *
 * The software contained on this media is written by  Unotech Software Pvt. Ltd. and
 * is proprietary to and embodies the confidential technology of Unotech Software.
 *
 * The possession or receipt of this information does not convey any right to disclose
 * its contents, reproduce it, or use, or license the use, for manufacture or sale,
 * the information or anything described therein. Any use, disclosure, or reproduction
 * without prior written permission of Unotech Software is strictly prohibited.
 */
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
	public ResponseEntity<Response> revokeSession(@PathVariable(required = true) String login) {
		Response response = new Response();
		response.succeed();
		response.setData(this.revokeAllSessionUserService.revokeSession(login));
		return ResponseEntity.ok().body(response);
	}

}
