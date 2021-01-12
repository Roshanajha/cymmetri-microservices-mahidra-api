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

import javax.validation.Valid;

import com.cymmetri.ms.user.dto.AdminRemoveRegisteredMfaRequestDto;
import com.cymmetri.ms.user.dto.Response;
import com.cymmetri.ms.user.service.MfaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mfaconfig")
public class MfaController {

	private final MfaService mfaService;

	public MfaController(MfaService mfaService) {
		this.mfaService = mfaService;
	}

	@PostMapping("remove")
	public ResponseEntity<Response> remove(@Valid @RequestBody AdminRemoveRegisteredMfaRequestDto mfaRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(this.mfaService.mfaConfig(mfaRequest));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("listofmfa/user/{login}")
	public ResponseEntity<Response> listOfMfaUser(@PathVariable String login) {
		Response response = new Response();
		response.succeed();
		response.setData(this.mfaService.listOfMfaUser(login));
		return ResponseEntity.ok().body(response);
	}

}
