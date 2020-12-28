package com.cymmetri.ms.user.endpoint;

import com.cymmetri.common.mfa.dto.AdminRemoveRegisteredMfaRequest;
import com.cymmetri.ms.user.dto.AdminRemoveRegisteredMfaRequestDto;
import com.cymmetri.ms.user.dto.Response;
import com.cymmetri.ms.user.service.MfaService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/mfaconfig")
public class MfaController {

	private final MfaService mfaService;

	public MfaController(MfaService mfaService) {
		this.mfaService = mfaService;
	}

	@PostMapping("remove")
	public ResponseEntity<Response> remove(@Valid @RequestBody AdminRemoveRegisteredMfaRequestDto mfaRequest){
		Response response = new Response();
		response.succeed();
		response.setData(this.mfaService.mfaConfig(mfaRequest));
		return ResponseEntity.ok().body(response);
	}
}
