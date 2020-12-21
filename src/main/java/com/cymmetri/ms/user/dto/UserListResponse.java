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
package com.cymmetri.ms.user.dto;

import com.cymmetri.ms.user.entity.ProvisionedApps;
import com.cymmetri.ms.user.entity.User;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class UserListResponse.
 *
 * @author unotech .
 */

@Data
@NoArgsConstructor
public class UserListResponse {

	/** The id. */
	private String id;

	/** The display name. */
	private String displayName;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The email. */
	private String email;

	/** The mobile. */
	private String mobile;

	/** The designation. */
	private String designation;

	/** The status. */
	private String status;

	private String profilePic;

	private String login;

	private Map<String, String> provStatus = new HashMap<String, String>(0);

	public UserListResponse(User user, String profilePic, String applicationId) {
		this.setId(user.getId());
		this.setDisplayName(user.getDisplayName());
		this.setFirstName(user.getFirstName());
		this.setLastName(user.getLastName());
		this.setEmail(user.getEmail());
		this.setMobile(user.getMobile());
		this.setDesignation(user.getDesignation());
		this.setProfilePic(profilePic);

		String status = Objects.nonNull(user.getStatus()) ? user.getStatus().name() : null;
		this.setStatus(status);

		final String defaultAppStr = com.cymmetri.ms.user.constants.Constant.DEFAULT_APP;
		ProvisionedApps defaultApp = user.getProvisionedApps().get(defaultAppStr);
		this.setLogin(defaultApp.getLogin().getLogin());
		if (StringUtils.isNotBlank(applicationId)) {
			ProvisionedApps provisionApp = user.getProvisionedApps().get(applicationId);
			if (ObjectUtils.isNotEmpty(provisionApp)) {

				this.getProvStatus().put(applicationId, provisionApp.getLogin().getStatus());
			}
		}
	}

	public UserListResponse(User user, String profilePic) {
		this(user, profilePic, null);
	}

}
