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
package com.cymmetri.common.mfaexcludeduser.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GetRuleByIdResponse {

	private String id;

	private String name;

	private String description;

	private Boolean active;

	private String actionGroupId;

	private Boolean forEveryOne;

	private Boolean isAdaptive;

	@ApiModelProperty(value = "true", name = "allConditionApplied", dataType = "Boolean", hidden = false)
	private Boolean allConditionApplied;

	private Integer adaptiveScore;

	private List<IdAndNameDto> attachedGroupIDs;

	private List<IdAndNameDto> attachedUserIDs;

	private List<IdAndNameDto> excludedUserIDs;

	private Map<String, String> actionableElements;

	private String actionToBeExecute;

	private Set<String> conditionIds;

	private String createdBy;

	private LocalDateTime created;

	private LocalDateTime updated;

}
