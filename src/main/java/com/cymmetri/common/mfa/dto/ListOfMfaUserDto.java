package com.cymmetri.common.mfa.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ListOfMfaUserDto {

	@NotBlank
	private List<String> listOfMfa;
}
