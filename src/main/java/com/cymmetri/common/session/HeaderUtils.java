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
package com.cymmetri.common.session;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;

public final class HeaderUtils {

	/** The HTTP {@code Tenant} header field name. */
	public static final String TENANT_HEADER = "Tenant";

	/** The HTTP {@code User} header field name. */
	public static final String USER_HEADER = "UserId";

	/** The HTTP {@code User} header field name. */
	public static final String PRINCIPAL_HEADER = "Principal";

	/** The HTTP {@code Role} header field name. */
	public static final String ROLES_HEADER = "Roles";

	/** The HTTP {@code Role} header field name. */
	public static final String CLIENT_IP_HEADER = "ClientIp";

	private HeaderUtils() {

	}

	public static String getCaseInsensitiveHeader(final HttpServletRequest request, final String lowerCaseHeaderName) {
		String retVal = null;
		if (request.getHeaderNames() != null) {
			final Enumeration<String> names = request.getHeaderNames();
			while (names.hasMoreElements()) {
				final String name = names.nextElement();
				if (name != null) {
					if (name.toLowerCase().equals(lowerCaseHeaderName)) {
						retVal = request.getHeader(name);
						break;
					}
				}
			}
		}
		return retVal;
	}

	public static String getClientIP(final HttpServletRequest httpRequest) {
		return httpRequest.getHeader(HeaderUtils.CLIENT_IP_HEADER);
	}

	public static String getUserId(final HttpServletRequest httpRequest) {
		return httpRequest.getHeader(HeaderUtils.USER_HEADER);
	}

	public static String getPrincipal(final HttpServletRequest httpRequest) {
		return httpRequest.getHeader(HeaderUtils.PRINCIPAL_HEADER);
	}

	public static String getTenantId(final HttpServletRequest httpRequest) {
		return httpRequest.getHeader(HeaderUtils.TENANT_HEADER);
	}

	public static String getRoles(final HttpServletRequest httpRequest) {
		return httpRequest.getHeader(HeaderUtils.ROLES_HEADER);
	}

	public static String getUserAgent(final HttpServletRequest httpRequest) {
		return httpRequest.getHeader(HttpHeaders.USER_AGENT);
	}

	public static String getAuthorization(final HttpServletRequest httpRequest) {
		return httpRequest.getHeader(HttpHeaders.AUTHORIZATION);
	}

}
