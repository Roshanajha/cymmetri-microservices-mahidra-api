package com.cymmetri.ms.user.service.impl;

import com.cymmetri.common.audit.AuditService;
import com.cymmetri.common.passwordpolicy.dto.PasswordChangeRule;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyComposition;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyDto;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicyResponse;
import com.cymmetri.common.passwordpolicy.dto.PasswordPolicySearchResponse;
import com.cymmetri.ms.user.auditaction.passwordpolicy.PasswordPolicyAddAudit;
import com.cymmetri.ms.user.auditaction.passwordpolicy.PasswordPolicyCompostionRuleSaveAudit;
import com.cymmetri.ms.user.auditaction.passwordpolicy.PasswordPolicySaveAudit;
import com.cymmetri.ms.user.service.PasswordPolicyService;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PasswordPolicyServiceImpl implements PasswordPolicyService {

	private final com.cymmetri.common.passwordpolicy.PasswordPolicyService passwordPolicyService;

	private final AuditService auditService;

	public PasswordPolicyServiceImpl(com.cymmetri.common.passwordpolicy.PasswordPolicyService passwordPolicyService, AuditService auditService) {
		this.passwordPolicyService = passwordPolicyService;
		this.auditService = auditService;
	}

	@Override
	public PasswordPolicyResponse create(PasswordPolicyDto passwordPolicyDto) {
		PasswordPolicyResponse passwordPolicyResponse;
		PasswordPolicyAddAudit auditBuilder = new PasswordPolicyAddAudit();
		try {
			passwordPolicyResponse = this.passwordPolicyService.create(passwordPolicyDto);
			auditBuilder.succeed();
			auditBuilder.sourceId(passwordPolicyResponse.getId());
			auditBuilder.newObject(passwordPolicyResponse);
		}
		catch (Exception exception){
			auditBuilder.fail();
			log.error("Exception Thrown :- ",exception);
			throw exception;
		}
		finally {
			this.auditService.log(auditBuilder.build());
		}
		return passwordPolicyResponse;
	}

	@Override
	public PasswordPolicyResponse update(String id, PasswordPolicyDto passwordPolicyDto) {
		PasswordPolicyResponse passwordPolicyResponse;
		PasswordPolicySaveAudit auditBuilder = new PasswordPolicySaveAudit();
		try {
			passwordPolicyResponse = this.passwordPolicyService.update(id, passwordPolicyDto);
			auditBuilder.succeed();
			auditBuilder.sourceId(passwordPolicyResponse.getId());
			auditBuilder.newObject(passwordPolicyResponse);
		}
		catch (Exception exception){
			auditBuilder.fail();
			log.error("Exception Thrown :- ",exception);
			throw exception;
		}
		finally {
			this.auditService.log(auditBuilder.build());
		}
		return passwordPolicyResponse;
	}

	@Override
	public PasswordPolicySearchResponse search(String name, Integer pageNo, Integer size, String sortBy, String order) {
		return this.passwordPolicyService.search(name, pageNo, size, sortBy, order);
	}

	@Override
	public PasswordPolicyDto getPasswordPolicyById(String id) {
		try {
			return this.passwordPolicyService.getPasswordPolicyById(id);
		}
		catch (Exception exception){
			log.error("Exception Thrown :- ",exception);
			throw exception;
		}
	}

	@Override
	public PasswordChangeRule getPasswordChangedRule(String id) {
		try {
			return this.passwordPolicyService.getPasswordChangedRule(id);
		}
		catch (Exception exception){
			log.error("Exception Thrown :- ",exception);
			throw exception;
		}
	}

	@Override
	public PasswordPolicyComposition savePasswordCompositionRule(String id, PasswordPolicyComposition passwordPolicyComposition) {
		PasswordPolicyComposition passwordPolicyCompositionResponse;
		PasswordPolicyCompostionRuleSaveAudit auditBuilder = new PasswordPolicyCompostionRuleSaveAudit();
		try {
			passwordPolicyCompositionResponse = this.passwordPolicyService.savePasswordCompositionRule(id, passwordPolicyComposition);
			auditBuilder.succeed();
			auditBuilder.sourceId(id);
			auditBuilder.newObject(passwordPolicyComposition);
		}
		catch (Exception exception){
			auditBuilder.fail();
			log.error("Exception Thrown :- ",exception);
			throw exception;
		}
		finally {
			this.auditService.log(auditBuilder.build());
		}
		return passwordPolicyCompositionResponse;
	}
}
