package com.cymmetri.ms.user.service.impl;
import com.cymmetri.common.audit.AuditService;
import com.cymmetri.common.mfaexcludeduser.MfaExludedService;
import com.cymmetri.common.mfaexclusion.dto.AssignGroupDTO;
import com.cymmetri.common.userservice.UserFilterDto;
import com.cymmetri.common.userservice.UserListDto;
import com.cymmetri.common.userservice.UserService;
import com.cymmetri.common.userservice.UserSortBy;
import com.cymmetri.ms.user.auditaction.assignandunassignusergroup.AssignUserToGroupAudit;
import com.cymmetri.ms.user.auditaction.assignandunassignusergroup.UnassignUserToGroupAudit;
import com.cymmetri.ms.user.dto.UserListResponse;
import com.cymmetri.ms.user.service.MfaExlusionService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;


//readme: two task to complete
//set active true and defaultSelection false default in request
// change api response for illegalArgument

@Slf4j
@Service
public class MfaExlusionServiceImpl implements MfaExlusionService {

	private final com.cymmetri.common.mfaexclusion.MfaExlusionService mfaExlusionService;

	private final MfaExludedService mfaExludedService;

	private final AuditService auditService;

	private final UserService userService;

	@Value("${cymmetri.rulesrvc.mfa.group.id}")
	private String groupId;

	@Value("${cymmetri.mfaexlusion.mfa.group.id}")
	private String mfaExclusionGroupId;

	public MfaExlusionServiceImpl(com.cymmetri.common.mfaexclusion.MfaExlusionService mfaExlusionService, MfaExludedService mfaExludedService, AuditService auditService, UserService userService) {
		this.mfaExlusionService = mfaExlusionService;
		this.mfaExludedService = mfaExludedService;
		this.auditService = auditService;
		this.userService = userService;
	}

	@Override
	public List<Object> getUserNamesByRuleId() {

		List<Object> login = new ArrayList<>();

		try {
			UserListDto userListDto = UserListDto.builder().direction(Sort.Direction.ASC).pageNumber(0).pageSize(Integer.MAX_VALUE)
					.sort(UserSortBy.FIRST_NAME)
					.filters(UserFilterDto.builder().group(mfaExclusionGroupId).build()).build();

			final ArrayList<HashMap<String, Object>> logins = this.userService.getUserLogins(userListDto);

			for (HashMap<String, Object> userListResponse:
				 logins) {
				login.add(userListResponse.get("login"));
			}
/*
			final List<String> listOfUserId = this.mfaExludedService.listExcludedUser(ruleId).getExcludedUserIDs().stream().map(idAndNameDto -> idAndNameDto.getId()).collect(Collectors.toList());
			for (String userId:
				 listOfUserId) {

			}*/
		}
		catch (Exception ex){
			log.error("Exception :- ", ex);
			throw ex;
		}
		return login;
	}

	@Override
	public Boolean assignGroupDTOResponse(String login) {

		List<String> groupIds = new ArrayList<>();
		List<String> userIds = new ArrayList<>();
		boolean status = false;

		String userId = getUserId(login);
		groupIds.add(groupId);
		userIds.add(userId);
		AssignGroupDTO assignGroupDTORequest = AssignGroupDTO.builder().groupIds(groupIds).userIds(userIds).build();

		AssignUserToGroupAudit auditBuilder = new AssignUserToGroupAudit();
		auditBuilder.succeed();

		try {
			final AssignGroupDTO mfaRuleList = this.mfaExlusionService.assignUserToGroup(assignGroupDTORequest);
			if (!mfaRuleList.getUserIds().isEmpty()){
				status = true;
			}
		}
		catch (Exception exception) {
			log.error("Exception :- ", exception);
			auditBuilder.fail();
			throw exception;
		}
		finally {
			Map<String, Object> eventAttribute = new HashMap<>();
			eventAttribute.put("userIds", userIds);
			eventAttribute.put("groupIds", groupIds);
			auditBuilder.eventAttributes(eventAttribute);
			this.auditService.log(auditBuilder.build());
		}
		return status;
	}

	@Override
	public Boolean unAssignGroupDTOResponse(String login) {

		List<String> groupIds = new ArrayList<>();
		List<String> userIds = new ArrayList<>();
		Boolean status = false;

		String userId = getUserId(login);
		groupIds.add(groupId);
		userIds.add(userId);
		AssignGroupDTO assignGroupDTORequest = AssignGroupDTO.builder().groupIds(groupIds).userIds(userIds).build();

		UnassignUserToGroupAudit auditBuilder = new UnassignUserToGroupAudit();
		auditBuilder.succeed();

		try {
			final AssignGroupDTO mfaRuleList = this.mfaExlusionService.unAssignUserToGroup(assignGroupDTORequest);
			if (!mfaRuleList.getUserIds().isEmpty()){
				status = true;
			}
		}
		catch (Exception exception) {
			log.error("Exception :- ", exception);
			auditBuilder.fail();
			throw exception;
		}
		finally {
			Map<String, Object> eventAttribute = new HashMap<>();
			eventAttribute.put("userIds", userIds);
			eventAttribute.put("groupIds", groupIds);
			auditBuilder.eventAttributes(eventAttribute);
			this.auditService.log(auditBuilder.build());
		}
		return status;
	}

	private String getUserId(String userName){

		UserListDto userListDto = UserListDto.builder().direction(Sort.Direction.ASC).pageNumber(0).pageSize(1)
				.sort(UserSortBy.FIRST_NAME)
				.filters(UserFilterDto.builder().locked(false).status(Collections.singletonList("ACTIVE")).build())
				.keyword(userName).build();

		return this.userService.getUserId(userListDto);
	}
}
