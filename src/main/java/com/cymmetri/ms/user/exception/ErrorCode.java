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
package com.cymmetri.ms.user.exception;

public enum ErrorCode {

	/**
	 * Error-codes.
	 */
	UNKNOWN,

	/**
	 * {@code USER_NOT_FOUND}.
	 */
	USER_NOT_FOUND,

	/**
	 * {@code INVALID_ARGUMENTS}.
	 */
	INVALID_ARGUMENTS,

	/**
	 * {@code TENANT_NOT_FOUND}.
	 */
	TENANT_NOT_FOUND,

	/**
	 * {@code PASSWORD_VALIDATION_FAILED}.
	 */
	PASSWORD_VALIDATION_FAILED,

	/**
	 * {@code CHANGE_PASSWORD_FAILED}.
	 */
	CHANGE_PASSWORD_FAILED,

	/**
	 * {@code EAMIL_EXISTS}.
	 */
	EAMIL_EXISTS;

	/**
	 * servicePrefix is prefix for all the error-codes from current module, it will help
	 * to identify service-module from API error-code.
	 */
	private String servicePrefix = "SAMPLESRVC";

	public String code() {

		StringBuilder errorCode = new StringBuilder();
		// @formatter:off
		errorCode
		.append(this.servicePrefix)
		.append('.')
		.append(this);
		// @formatter:on
		return errorCode.toString();
	}

}
