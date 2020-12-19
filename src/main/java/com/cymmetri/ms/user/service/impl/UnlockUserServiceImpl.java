package com.cymmetri.ms.user.service.impl;
import com.cymmetri.common.audit.AuditService;
import com.cymmetri.common.unlocklogin.UnlockLoginService;
import com.cymmetri.ms.user.auditaction.unlocklogin.UnlockUserAudit;
import com.cymmetri.ms.user.service.UnlockUserService;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

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
		catch (Exception exception){
			auditBuilder.fail();
			log.error("Exception :-" ,exception);
			throw exception;
		}
		finally {
			this.auditService.log(auditBuilder.build());
		}
		return unlockLogin;
	}
}
