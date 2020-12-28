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
import com.cymmetri.common.unlocklogin.UnlockLoginService;
import com.cymmetri.ms.user.auditaction.unlocklogin.UnlockUserAudit;
import com.cymmetri.ms.user.service.UnlockUserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UnlockUserServiceImpl implements UnlockUserService {

	private final UnlockLoginService unlockLoginService;

	private final AuditService auditService;

	public UnlockUserServiceImpl(UnlockLoginService unlockLoginService, AuditService auditService) {
		this.unlockLoginService = unlockLoginService;
		this.auditService = auditService;
	}

	@Override
	public Boolean unlockUser(String login) {

		Boolean unlockLogin;
		UnlockUserAudit auditBuilder = new UnlockUserAudit();

		try {
			unlockLogin = this.unlockLoginService.unlockLogin(login);
			auditBuilder.succeed();
			auditBuilder.sourceId(login);
		}
		catch (Exception exception) {
			auditBuilder.fail();
			log.error("Exception :-", exception);
			throw exception;
		}
		finally {
			this.auditService.log(auditBuilder.build());
		}
		return unlockLogin;
	}

}
