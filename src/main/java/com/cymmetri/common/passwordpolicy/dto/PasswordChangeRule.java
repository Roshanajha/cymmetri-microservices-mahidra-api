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
 * Password Change Rule.
 *
 * @author Roshan Jha.
 */
@Data
public class PasswordChangeRule implements Serializable {

	@ApiModelProperty(notes = "changePasswordAfterReset", value = "false", example = "true or false", hidden = false)
	private Boolean changePasswordAfterReset;

	@ApiModelProperty(notes = "passwordExpirationDays", value = "90", example = "90", hidden = false)
	private Integer passwordExpirationDays;

	@ApiModelProperty(notes = "daysToPasswordExpirationWarningFrom", value = "10", example = "10", hidden = false)
	private Integer daysToPasswordExpirationWarningFrom;

}
