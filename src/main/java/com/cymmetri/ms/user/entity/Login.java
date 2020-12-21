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
package com.cymmetri.ms.user.entity;

import com.querydsl.core.annotations.QueryEmbeddable;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Login.
 *
 * @author unotech .
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@QueryEmbeddable
public class Login {

	public Login(String login, String pass, String status, int pwdChangeCount, int authFailCount,
                 boolean isForceChangePassword, LocalDateTime createdTimeStamp, LocalDateTime modifiedTimeStamp,
                 LocalDateTime lastLoginTime, LocalDateTime prevLoginTime) {
		this.login = login;
		this.password = pass;
		this.status = status;
		this.pwdChangeCount = pwdChangeCount;
		this.authFailCount = authFailCount;
		this.isForceChangePassword = isForceChangePassword;
		this.createdTimeStamp = createdTimeStamp;
		this.modifiedTimeStamp = modifiedTimeStamp;
		this.lastLoginTime = lastLoginTime;
		this.prevLoginTime = prevLoginTime;
	}

	/** The login. */
	private String login;

	/** The password. */
	private String password;

	/** The app User-id. */
	private String appUserId;

	/** The status. */
	private String status;

	/** The provStatus. */
	private String provStatus;

	/** The pwd change count. */
	private int pwdChangeCount;

	/** The auth fail count. */
	private int authFailCount;

	/** The is force change password. */
	private boolean isForceChangePassword;

	/** The is force change password. */
	private boolean neverExpiryPassword;

	/** The is force change password. */
	private boolean isInitialLogin;

	/** The nextAction. */
	private String nextAction;

	/** The created time stamp. */
	private LocalDateTime createdTimeStamp;

	/** The modified time stamp. */
	private LocalDateTime modifiedTimeStamp;

	/** The last login time. */
	private LocalDateTime lastLoginTime;

	/** The prev login time. */
	private LocalDateTime prevLoginTime;

	/** The lastPasswordChange time. */
	private LocalDateTime lastPasswordChange;

	/** The lock till the time. */
	private LocalDateTime lockLoginTill;

	/** The lock till the time. */
	private LocalDateTime passwordExpiredAfter;

}
