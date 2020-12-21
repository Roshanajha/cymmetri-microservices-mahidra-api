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

import com.querydsl.core.annotations.PropertyType;
import com.querydsl.core.annotations.QueryEmbeddable;
import com.querydsl.core.annotations.QueryEmbedded;
import com.querydsl.core.annotations.QueryType;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class ProvisionedApps.
 *
 * @author unotech .
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@QueryEmbeddable
public class ProvisionedApps {

	/** The app id. */
	private String appId;

	/** The assigned roles. */
	private List<String> assignedRoles;

	/** The login. */
	@QueryEmbedded
	@QueryType(PropertyType.COMPARABLE)
	private Login login;

}
