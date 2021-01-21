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

import com.cymmetri.common.passwordpolicy.dto.PasswordChangeRule;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyComposition;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyDto;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyResponse;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicySearchResponse;
import com.cymmetri.ms.user.dto.Response;
import com.cymmetri.ms.user.service.PasswordPolicyService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("passwordpolicy")
public class PasswordPolicyController {

	private final com.cymmetri.ms.user.service.PasswordPolicyService passwordPolicyService;

	public PasswordPolicyController(PasswordPolicyService passwordPolicyService) {
		this.passwordPolicyService = passwordPolicyService;
	}

	@PostMapping("/save")
	public ResponseEntity<Response> saveNewPasswordPolicy(@RequestBody PasswordPolicyDto passwordPolicyDto) {
		final PasswordPolicyResponse data = this.passwordPolicyService.create(passwordPolicyDto);
		Response response = new Response();
		response.succeed();
		response.setData(data);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getPasswordPolicyById(@PathVariable(required = true) String id) {

		final PasswordPolicyDto data = this.passwordPolicyService.getPasswordPolicyById(id);

		Response response = new Response();
		response.succeed();
		response.setData(data);
		return ResponseEntity.ok().body(response);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updatePasswordPolicy(@PathVariable(required = true) String id,
			@RequestBody PasswordPolicyDto passwordPolicyDto) {
		final PasswordPolicyResponse data = this.passwordPolicyService.update(id, passwordPolicyDto);
		Response response = new Response();
		response.succeed();
		response.setData(data);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/search")
	public ResponseEntity<Response> searchPasswordPolicy(
			final @RequestParam(required = false, value = "name") String name,
			final @RequestParam(required = false, value = "pageNo", defaultValue = "0") Integer pageNo,
			final @RequestParam(required = false, value = "size", defaultValue = "9") Integer size,
			final @RequestParam(required = false, value = "sortBy", defaultValue = "name") String sortBy,
			final @RequestParam(required = false, value = "order", defaultValue = "ascending") String order) {

		final PasswordPolicySearchResponse data = this.passwordPolicyService.search(name, pageNo, size, sortBy, order);

		Response response = new Response();
		response.setData(data);
		response.succeed();
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/paswordchangedrule/{id}")
	public ResponseEntity<Response> getPasswordChangedRule(@PathVariable(required = true) String id) {

		final PasswordChangeRule data = this.passwordPolicyService.getPasswordChangedRule(id);

		Response response = new Response();
		response.succeed();
		response.setData(data);
		return ResponseEntity.ok().body(response);
	}

	@PutMapping("/savepasswordcompositionrule/{id}")
	public ResponseEntity<Response> savePasswordCompositionRule(@PathVariable(required = true) String id,
			@RequestBody PasswordPolicyComposition passwordPolicyComposition) {
		final PasswordPolicyComposition data = this.passwordPolicyService.savePasswordCompositionRule(id,
				passwordPolicyComposition);
		Response response = new Response();
		response.succeed();
		response.setData(data);
		return ResponseEntity.ok().body(response);
	}

}
