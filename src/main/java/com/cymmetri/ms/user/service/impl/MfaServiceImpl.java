package com.cymmetri.ms.user.service.impl;

import com.cymmetri.common.audit.AuditService;
import com.cymmetri.common.mfa.dto.AdminRemoveRegisteredMfaRequest;
import com.cymmetri.common.userservice.UserFilterDto;
import com.cymmetri.common.userservice.UserListDto;
import com.cymmetri.common.userservice.UserService;
import com.cymmetri.common.userservice.UserSortBy;
import com.cymmetri.ms.user.auditaction.mfa.MfaAuthRemoveRegisteredAudit;
import com.cymmetri.ms.user.dto.AdminRemoveRegisteredMfaRequestDto;
import com.cymmetri.ms.user.service.MfaService;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MfaServiceImpl implements MfaService {

	private final com.cymmetri.common.mfa.MfaService mfaService;

	private final AuditService auditService;

	private final UserService userService;

	public MfaServiceImpl(com.cymmetri.common.mfa.MfaService mfaService, AuditService auditService, UserService userService) {
		this.mfaService = mfaService;
		this.auditService = auditService;
		this.userService = userService;
	}

	@Override
	public Boolean mfaConfig(AdminRemoveRegisteredMfaRequestDto mfaRequest) {

		String userId = getUserId(mfaRequest.getLogin());
		AdminRemoveRegisteredMfaRequest adminRemoveRegisteredMfaRequest = AdminRemoveRegisteredMfaRequest.builder()
				.userId(userId)
				.mfaType(mfaRequest.getMfaType()).build();

		MfaAuthRemoveRegisteredAudit auditBuilder = new MfaAuthRemoveRegisteredAudit();
		Boolean status;
		try {
			status = this.mfaService.removeMfa(adminRemoveRegisteredMfaRequest);
			auditBuilder.sourceId(mfaRequest.getLogin());
			auditBuilder.succeed();
		}
		catch (Exception exception){
			log.error("Exception :- ",exception);
			auditBuilder.fail();
			throw exception;
		}
		finally {
			Map<String, Object> eventAttribute = new HashMap<>();
			eventAttribute.put("AUTH_TYPE", mfaRequest.getMfaType());
			auditBuilder.eventAttributes(eventAttribute);
			this.auditService.log(auditBuilder.build());
		}

		return status;
	}

	public String getUserId(String login) {

		UserListDto userListDto = UserListDto.builder().direction(Sort.Direction.ASC).pageNumber(0).pageSize(1)
				.sort(UserSortBy.FIRST_NAME)
				.filters(UserFilterDto.builder().locked(false).status(Collections.singletonList("ACTIVE")).build())
				.keyword(login).build();

		return this.userService.getUserId(userListDto);
	}
}
