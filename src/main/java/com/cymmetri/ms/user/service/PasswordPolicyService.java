package com.cymmetri.ms.user.service;

import com.cymmetri.common.passwordpolicy.dto.PasswordChangeRule;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyComposition;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyDto;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyResponse;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicySearchResponse;

public interface PasswordPolicyService {

	PasswordPolicyResponse create(PasswordPolicyDto passwordPolicyDto);

	PasswordPolicyResponse update(String id, PasswordPolicyDto passwordPolicyDto);

	PasswordPolicySearchResponse search(String name, Integer pageNo, Integer size, String sortBy, String order);

	PasswordPolicyDto getPasswordPolicyById(String id);

	PasswordChangeRule getPasswordChangedRule(String id);

	PasswordPolicyComposition savePasswordCompositionRule(String id, PasswordPolicyComposition passwordPolicyComposition);
}
