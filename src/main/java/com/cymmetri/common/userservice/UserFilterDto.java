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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type User filter dto.
 *
 * @author unotech .
 */

@Getter
@Setter
@ToString
@ApiModel(description = "User List Request Body")
@Builder
public class UserFilterDto {

	/** The location. */
	@ApiModelProperty(notes = "Location", value = "Mumbai", example = "Mumbai")
	private String location;

	/** The reporting manager. */
	@ApiModelProperty(notes = "Reporting Manager", value = "5ebd52974ba32c7bc4f860b7",
			example = "5ebd52974ba32c7bc4f860b7")
	private String reportingManager;

	/** The department. */
	@ApiModelProperty(notes = "Department", value = "Sales", example = "Sales")
	private String department;

	/** The designation. */
	@ApiModelProperty(notes = "Designation", value = "Executive", example = "Executive")
	private String designation;

	/** The group. */
	@ApiModelProperty(notes = "Group", value = "5ebd52974ba32c7bc4f860b7", example = "5ebd52974ba32c7bc4f860b7")
	private String group;

	/** The email. */
	@ApiModelProperty(notes = "Email", value = "email@test.com", example = "email@test.com")
	private String email;

	/** The mobile. */
	@ApiModelProperty(notes = "Mobile", value = "123456789", example = "123456789")
	private String mobile;

	/** The status. */
	@ApiModelProperty(notes = "Status", allowableValues = "ACTIVE, INACTIVE")
	private List<String> status;

	/** The user type. */
	@ApiModelProperty(notes = "User Type", value = "Employee", example = "Employee")
	private String userType;

	@ApiModelProperty(notes = "User Locked", value = "false", example = "false")
	private Boolean locked;

}
