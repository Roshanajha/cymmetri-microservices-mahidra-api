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
package com.cymmetri.common.passwordpolicy;

import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyComposition;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyDto;
import com.cymmetri.ms.user.dto.Response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "passwordpolicyclient", url = "${cymmetri.authsrvc.api}")
public interface PasswordPolicyClient {

	@PostMapping("passwordPolicy/createPolicy")
	ResponseEntity<Response> createNewPasswordPolicy(@RequestBody PasswordPolicyDto passwordPolicyDto);

	@PostMapping("passwordPolicy/savePolicy/{id}")
	ResponseEntity<Response> updatePasswordPolicy(@PathVariable String id,
			@RequestBody PasswordPolicyDto passwordPolicyDto);

	@GetMapping("passwordPolicy/search")
	ResponseEntity<Response> searchPasswordPolicy(@RequestParam("name") String name,
			@RequestParam("pageNo") Integer pageNo, @RequestParam("size") Integer size,
			@RequestParam("sortBy") String sortBy, @RequestParam("order") String order);

	@GetMapping("passwordPolicy/getPolicy/{id}")
	ResponseEntity<Response> getPasswordPolicyById(@PathVariable String id);

	@GetMapping("passwordPolicy/getPasswordChangeRule/{id}")
	ResponseEntity<Response> getPasswordChangedRule(@PathVariable String id);

	@PostMapping("passwordPolicy/savePasswordCompositionRule/{id}")
	ResponseEntity<Response> savePasswordCompositionRule(@PathVariable String id,
			@RequestBody PasswordPolicyComposition passwordPolicyComposition);

}
