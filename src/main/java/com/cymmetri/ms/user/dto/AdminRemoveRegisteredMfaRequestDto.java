package com.cymmetri.ms.user.dto;

import com.cymmetri.common.mfa.enums.MfaType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AdminRemoveRegisteredMfaRequestDto {

	@NotBlank
	private String login;

	@NotNull
	private MfaType mfaType;
}
