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

package com.cymmetri.ms.user.auditaction.mfa;

import com.cymmetri.common.audit.AbstractAuditBuilder;
import com.cymmetri.common.audit.AuditLogResult;

public class MfaAuthRemoveRegisteredAudit extends AbstractAuditBuilder {

	/**
	 * "SOURCE_TYPE" qualifier.
	 */
	public static final String SOURCE_TYPE = "USER";

	/**
	 * "TARGET_TYPE" qualifier.
	 */
	public static final String TARGET_TYPE = "";

	/**
	 * "CYMMETRI_AUTH_REMOVE_REGISTERED" qualifier.
	 */
	public static final String MFA_AUTH_REMOVE_REGISTERED = "MFA_AUTH_REMOVE_REGISTERED";

	/**
	 * "DESC_FAIL" qualifier.
	 */
	public static final String DESC_FAIL = "Failed To Remove MFA Authenticator Registration.";

	/**
	 * "DESC_PASS" qualifier.
	 */
	public static final String DESC_PASS = "Cymmetri Authenticator Registration Removed Successfully.";

	public MfaAuthRemoveRegisteredAudit() {
		super(MFA_AUTH_REMOVE_REGISTERED, SOURCE_TYPE, TARGET_TYPE);
	}

	AuditLogResult auditLogResult = AuditLogResult.FAIL;

	@Override
	protected void process() {
		String description = (this.isSuccess()) ? DESC_PASS : DESC_FAIL;
		this.description(String.format(description));
	}

}
