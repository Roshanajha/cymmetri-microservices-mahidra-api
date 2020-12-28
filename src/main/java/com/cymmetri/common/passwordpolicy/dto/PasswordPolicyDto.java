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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class PasswordPolicyDto {

	@Indexed(unique = true)
	@NotBlank(message = "Null or Empty value is not allowed")
	private String name;

	@NotBlank(message = "Null or Empty value is not allowed")
	private String description;

	@NotNull(message = "Null value is not allowed")
	private Boolean isDefault;

	@NotNull(message = "Null value is not allowed")
	private Boolean active;

}
