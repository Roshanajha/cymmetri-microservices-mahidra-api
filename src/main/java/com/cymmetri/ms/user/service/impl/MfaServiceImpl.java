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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.cymmetri.common.audit.AuditService;
import com.cymmetri.common.mfa.dto.AdminRemoveRegisteredMfaRequest;
import com.cymmetri.common.mfa.dto.ListOfMfaUserDto;
import com.cymmetri.common.mfa.dto.UserIdRequest;
import com.cymmetri.common.userservice.UserFilterDto;
import com.cymmetri.common.userservice.UserListDto;
import com.cymmetri.common.userservice.UserService;
import com.cymmetri.common.userservice.UserSortBy;
import com.cymmetri.ms.user.auditaction.mfa.MfaAuthRemoveRegisteredAudit;
import com.cymmetri.ms.user.dto.AdminRemoveRegisteredMfaRequestDto;
import com.cymmetri.ms.user.service.MfaService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MfaServiceImpl implements MfaService {

	private final com.cymmetri.common.mfa.MfaService mfaService;

	private final AuditService auditService;

	private final UserService userService;

	public MfaServiceImpl(com.cymmetri.common.mfa.MfaService mfaService, AuditService auditService,
			UserService userService) {
		this.mfaService = mfaService;
		this.auditService = auditService;
		this.userService = userService;
	}

	@Override
	public Boolean mfaConfig(AdminRemoveRegisteredMfaRequestDto mfaRequest) {

		String userId = getUserId(mfaRequest.getLogin());
		AdminRemoveRegisteredMfaRequest adminRemoveRegisteredMfaRequest = AdminRemoveRegisteredMfaRequest.builder()
				.userId(userId).mfaType(mfaRequest.getMfaType()).build();

		MfaAuthRemoveRegisteredAudit auditBuilder = new MfaAuthRemoveRegisteredAudit();
		Boolean status;
		try {
			status = this.mfaService.removeMfa(adminRemoveRegisteredMfaRequest);
			auditBuilder.sourceId(mfaRequest.getLogin());
			auditBuilder.succeed();
		}
		catch (Exception exception) {
			log.error("Exception :- ", exception);
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

    @Override
    public ListOfMfaUserDto[] listOfMfaUser(String login) {
		String userId = getUserId(login);
		UserIdRequest userIdRequest = new UserIdRequest();
		userIdRequest.setUserId(userId);
        return this.mfaService.listOfMfaUser(userIdRequest);
    }

    public String getUserId(String login) {

		UserListDto userListDto = UserListDto.builder().direction(Sort.Direction.ASC).pageNumber(0).pageSize(1)
				.sort(UserSortBy.FIRST_NAME)
				.filters(UserFilterDto.builder().locked(false).status(Collections.singletonList("ACTIVE")).build())
				.keyword(login).build();

		return this.userService.getUserId(userListDto);
	}

}
