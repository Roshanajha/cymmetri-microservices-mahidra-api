package com.cymmetri.ms.user.service;

import java.util.List;

public interface MfaExlusionService {

	List<Object> getUserNamesByRuleId(String groupId);

	Boolean assignGroupDTOResponse(String login);

	Boolean unAssignGroupDTOResponse(String login);
}
