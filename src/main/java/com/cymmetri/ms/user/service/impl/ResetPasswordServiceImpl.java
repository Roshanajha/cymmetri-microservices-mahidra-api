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
package com.cymmetri.ms.user.service.impl;

import com.cymmetri.common.audit.AuditService;
import com.cymmetri.common.resetpassword.dto.ResetPasswordRequest;
import com.cymmetri.ms.user.auditaction.resetpassword.AdminResetPasswordAudit;
import com.cymmetri.ms.user.service.ResetPasswordService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {

	private final com.cymmetri.common.resetpassword.ResetPasswordService passwordService;

	private final AuditService auditService;

	public ResetPasswordServiceImpl(com.cymmetri.common.resetpassword.ResetPasswordService passwordService,
			AuditService auditService) {
		this.passwordService = passwordService;
		this.auditService = auditService;
	}

	@Override
	public String resetPassword(String login) {

		String resetPassword;
		AdminResetPasswordAudit auditBuilder = new AdminResetPasswordAudit();
		try {
			resetPassword = this.passwordService.resetPassword(ResetPasswordRequest.builder().userName(login).build());
			auditBuilder.sourceId(login);
			auditBuilder.succeed();
		}
		catch (Exception exception) {
			log.error("Exception :- ", exception);
			auditBuilder.fail();
			throw exception;
		}
		finally {
			this.auditService.log(auditBuilder.build());
		}
		return resetPassword;
	}

}
