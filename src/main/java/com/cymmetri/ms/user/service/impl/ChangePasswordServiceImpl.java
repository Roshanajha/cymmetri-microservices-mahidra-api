package com.cymmetri.ms.user.service.impl;

import com.cymmetri.common.audit.AuditService;
import com.cymmetri.common.changepassword.dto.ChangePassword;
import com.cymmetri.common.changepassword.dto.ValidatePassword;
import com.cymmetri.common.userservice.UserFilterDto;
import com.cymmetri.common.userservice.UserListDto;
import com.cymmetri.common.userservice.UserService;
import com.cymmetri.common.userservice.UserSortBy;
import com.cymmetri.ms.user.auditaction.changepassword.CustomAdminResetPasswordAudit;
import com.cymmetri.ms.user.exception.ChangePasswordException;
import com.cymmetri.ms.user.exception.PasswordValidationException;
import com.cymmetri.ms.user.service.ChangePasswordService;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {

	private final com.cymmetri.common.changepassword.ChangePasswordService changePasswordService;

	private final UserService userService;

	private final AuditService auditService;

	public ChangePasswordServiceImpl(com.cymmetri.common.changepassword.ChangePasswordService changePasswordService, UserService userService, AuditService auditService) {
		this.changePasswordService = changePasswordService;
		this.userService = userService;
		this.auditService = auditService;
	}

	@Override
	public Boolean changePassword(ChangePassword changePassword) throws PasswordValidationException, ChangePasswordException {

		log.info("... changePassword Service implementation ...");
		CustomAdminResetPasswordAudit auditBuilder = new CustomAdminResetPasswordAudit();
		try {
			if (!validatePassword(changePassword)){
				log.info("... password validation failed ...");
				throw new PasswordValidationException();
			}
			if (!changePasswordService.changePassword(changePassword)){
				log.info("... change password failed ...");
				throw new ChangePasswordException();
			}
		}
		catch (Exception exception) {
			log.error("Exception :- ", exception);
			auditBuilder.fail();
			throw exception;
		}
		finally {
			Map<String, Object> eventAttribute = new HashMap<>();
			eventAttribute.put("LOGIN", changePassword.getUserName());
			auditBuilder.eventAttributes(eventAttribute);
			this.auditService.log(auditBuilder.build());
		}
		return true;
	}

	private Boolean validatePassword(ChangePassword changePassword){
		log.info("... validate password service implementation ...");
		log.info("... toString representation is changePassword Object {} ...",changePassword.toString());
		String userId = getUserId(changePassword.getUserName());
		log.info("... userId {} for the {} ", userId, changePassword.getUserName());
		return changePasswordService.validatePassword(ValidatePassword.builder().
				login(changePassword.getUserName()).
				password(changePassword.getPassword()).
				userId(userId).build());
	}

	private String getUserId(String userName){

		UserListDto userListDto = UserListDto.builder().direction(Sort.Direction.ASC).pageNumber(0).pageSize(1)
				.sort(UserSortBy.FIRST_NAME)
				.filters(UserFilterDto.builder().locked(false).status(Collections.singletonList("ACTIVE")).build())
				.keyword(userName).build();

		return this.userService.getUserId(userListDto);
	}
}
