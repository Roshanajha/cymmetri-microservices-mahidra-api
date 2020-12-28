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
import com.cymmetri.ms.user.auditaction.revokeallsession.RevokeAllSessionAudit;
import com.cymmetri.ms.user.service.RevokeAllSessionUserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RevokeAllSessionUserServiceImpl implements RevokeAllSessionUserService {

	private final com.cymmetri.common.revokesession.RevokeAllSessionUserService revokeAllSessionUserService;

	private final AuditService auditService;

	public RevokeAllSessionUserServiceImpl(
			com.cymmetri.common.revokesession.RevokeAllSessionUserService revokeAllSessionUserService,
			AuditService auditService) {
		this.revokeAllSessionUserService = revokeAllSessionUserService;
		this.auditService = auditService;
	}

	@Override
	public Boolean revokeSession(String login) {

		RevokeAllSessionAudit auditBuilder = new RevokeAllSessionAudit();
		Boolean status;

		try {
			status = this.revokeAllSessionUserService.revokeAllSessionForUser(login);
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

		return status;
	}

}
