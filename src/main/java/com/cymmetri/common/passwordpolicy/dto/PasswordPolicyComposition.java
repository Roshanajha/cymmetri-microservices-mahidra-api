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
package com.cymmetri.common.passwordpolicy.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Password Policy Composition.
 *
 * @author Roshan Jha.
 */
@Data
public class PasswordPolicyComposition implements Serializable {

	@ApiModelProperty(notes = "alphaCharactersAmountFrom", value = "1", example = "1", hidden = false)
	private Integer alphaCharactersAmountFrom;

	// @ApiModelProperty(notes = "alphaCharactersAmountTo", value = "3", example = "3",
	// hidden = false)
	// private Integer alphaCharactersAmountTo;

	@ApiModelProperty(notes = "SpecialCharactersAmount", value = "3", example = "3", hidden = false)
	private Integer SpecialCharactersAmount;

	@ApiModelProperty(notes = "lowerCaseCharactersAmountFrom", value = "1", example = "1", hidden = false)
	private Integer lowerCaseCharactersAmountFrom;

	// @ApiModelProperty(notes = "lowerCaseCharactersAmountTo", value = "3", example =
	// "3", hidden = false)
	// private Integer lowerCaseCharactersAmountTo;

	@ApiModelProperty(notes = "numericCharactersAmountFrom", value = "1", example = "1", hidden = false)
	private Integer numericCharactersAmountFrom;

	// @ApiModelProperty(notes = "numericCharactersAmountTo", value = "3", example = "3",
	// hidden = false)
	// private Integer numericCharactersAmountTo;

	@ApiModelProperty(notes = "rejectPasswordEqualsPassword", value = "false", example = "true or false",
			hidden = false)
	private Boolean rejectPasswordEqualsPassword;

	@ApiModelProperty(notes = "passwordHistoryVersion", value = "3", example = "3", hidden = false)
	private Integer passwordHistoryVersion;

	@ApiModelProperty(notes = "passwordLengthFrom", value = "6", example = "6", hidden = false)
	private Integer passwordLengthFrom;

	@ApiModelProperty(notes = "passwordLengthTo", value = "12", example = "12", hidden = false)
	private Integer passwordLengthTo;

	@ApiModelProperty(notes = "rejectPasswordWhichEqualsToLoginId", value = "false", example = "true or false",
			hidden = false)
	private Boolean rejectPasswordWhichEqualsToLoginId;

	@ApiModelProperty(notes = "rejectPasswordWhichEqualsToFirstOrLastName", value = "false", example = "true or false",
			hidden = false)
	private Boolean rejectPasswordWhichEqualsToFirstOrLastName;

	@ApiModelProperty(notes = "charactersNotAllowedInPassword", value = "$", example = "$", hidden = false)
	private String charactersNotAllowedInPassword;

	@ApiModelProperty(notes = "upperCaseCharactersAmountFrom", value = "1", example = "1", hidden = false)
	private Integer upperCaseCharactersAmountFrom;

	// @ApiModelProperty(notes = "upperCaseCharactersAmountTo", value = "3", example =
	// "3", hidden = false)
	// private Integer upperCaseCharactersAmountTo;

}
