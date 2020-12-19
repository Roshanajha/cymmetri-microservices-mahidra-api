package com.cymmetri.common.passwordpolicy.dto;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

import lombok.Data;

@Data
public class PasswordPolicySearchResponse {

	private List<PasswordPolicyResponse> content;
}
