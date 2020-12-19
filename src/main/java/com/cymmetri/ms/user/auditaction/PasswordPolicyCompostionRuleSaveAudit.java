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

package com.cymmetri.ms.user.auditaction;

import com.cymmetri.common.audit.AbstractAuditBuilder;
import com.cymmetri.common.audit.AuditLogResult;

public class PasswordPolicyCompostionRuleSaveAudit extends AbstractAuditBuilder {

	/**
	 * "SOURCE_TYPE" qualifier.
	 */
	public static final String SOURCE_TYPE = "PASSWORD_POLICY";

	/**
	 * "TARGET_TYPE" qualifier.
	 */
	public static final String TARGET_TYPE = "";

	/**
	 * "PASSWORD_POLICY_COMPOSITION_RULE_SAVE" qualifier.
	 */
	public static final String PASSWORD_POLICY_COMPOSITION_RULE_SAVE = "PASSWORD_POLICY_COMPOSITION_RULE_SAVE";

	/**
	 * "DESC_FAIL" qualifier.
	 */
	public static final String DESC_FAIL = "Password policy composition rule update failed.";

	/**
	 * "DESC_PASS" qualifier.
	 */
	public static final String DESC_PASS = "Password policy composition rule updated successfully.";

	public PasswordPolicyCompostionRuleSaveAudit() {
		super(PASSWORD_POLICY_COMPOSITION_RULE_SAVE, SOURCE_TYPE, TARGET_TYPE);
	}

	AuditLogResult auditLogResult = AuditLogResult.FAIL;

	@Override
	protected void process() {
		String description = (this.isSuccess()) ? DESC_PASS : DESC_FAIL;
		this.description(String.format(description));
	}

}
