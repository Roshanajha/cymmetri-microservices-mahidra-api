package com.cymmetri.ms.user.service;

import java.util.List;

public interface MfaExlusionService {

	List<String> getUserNamesByRuleId(String groupId);

	Boolean assignGroupDTOResponse(String login);

	Boolean unAssignGroupDTOResponse(String login);
}
