package com.cymmetri.ms.user.service.impl;
import com.cymmetri.common.audit.AuditService;
import com.cymmetri.common.resetpassword.dto.ResetPasswordRequest;
import com.cymmetri.ms.user.auditaction.resetpassword.AdminResetPasswordAudit;
import com.cymmetri.ms.user.service.ResetPasswordService;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {

	private final com.cymmetri.common.resetpassword.ResetPasswordService passwordService;

	private final AuditService auditService;

	public ResetPasswordServiceImpl(com.cymmetri.common.resetpassword.ResetPasswordService passwordService, AuditService auditService) {
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
		catch (Exception exception){
			log.error("Exception :- ",exception);
			auditBuilder.fail();
			throw exception;
		}
		finally {
			this.auditService.log(auditBuilder.build());
		}
		return resetPassword;
	}
}
