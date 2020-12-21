package com.cymmetri.ms.user.service.impl;
import com.cymmetri.common.audit.AuditService;
import com.cymmetri.common.resetpassword.dto.ResetPasswordRequest;
import com.cymmetri.ms.user.auditaction.revokeallsession.RevokeAllSessionAudit;
import com.cymmetri.ms.user.service.RevokeAllSessionUserService;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RevokeAllSessionUserServiceImpl implements RevokeAllSessionUserService {

	private final com.cymmetri.common.revokesession.RevokeAllSessionUserService revokeAllSessionUserService;

	private final AuditService auditService;

	public RevokeAllSessionUserServiceImpl(com.cymmetri.common.revokesession.RevokeAllSessionUserService revokeAllSessionUserService, AuditService auditService) {
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
		catch (Exception exception){
			log.error("Exception :- ",exception);
			auditBuilder.fail();
			throw exception;
		}
		finally {
			this.auditService.log(auditBuilder.build());
		}

		return status;
	}
}
