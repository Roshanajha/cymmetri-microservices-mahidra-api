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
package com.cymmetri.common.userservice;

import java.util.List;

import com.cymmetri.common.search.SearchSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearch implements SearchSupport {

	@JsonIgnore
	private String id;

	private String firstName;

	private String lastName;

	private String country;

	@ApiModelProperty(notes = "Mobile", value = "123456789", example = "123456789")
	private String mobile;

	@ApiModelProperty(notes = "Email", value = "email@test.com", example = "email@test.com")
	private String email;

	private String managerId;

	private String userType;

	private String employeeId;

	private String department;

	private String designation;

	private String assignedGroup;

	private String login;

	private String assignedRole;

	@ApiModelProperty(notes = "User Locked", value = "false", example = "false")
	private Boolean locked;

	@ApiModelProperty(notes = "Status", allowableValues = "ACTIVE, INACTIVE")
	private List<String> status;

}
