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

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum User sort by.
 * @author unotech .
 */

@Getter
@ApiModel
@AllArgsConstructor
public enum UserSortBy {

	/** The first name. */
	FIRST_NAME("firstName"),

	/** The email. */
	EMAIL("email");

	/** The field name. */
	private String fieldName;

}
