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

	PasswordPolicyComposition savePasswordCompositionRule(String id,
			PasswordPolicyComposition passwordPolicyComposition);

}
