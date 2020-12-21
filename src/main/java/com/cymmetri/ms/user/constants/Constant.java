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
package com.cymmetri.ms.user.constants;


import com.cymmetri.ms.user.dto.Status;

import java.util.Arrays;
import java.util.List;

/**
 * The type Constant.
 *
 * @author unotech .
 *
 */
public final class Constant {

	/**
	 * Instantiates a new constant.
	 */
	private Constant() {
		throw new UnsupportedOperationException();
	}

	/** The Constant ROLE_USER. */
	public static final String ROLE_USER = "USER";

	/** The Constant DEFAULT_ORG. */
	public static final String DEFAULT_ORG = "5ebd52974ba32c7bc4f860b7";

	/** The Constant USER_PROVISION_OPERATION. */
	public static final String USER_PROVISION_OPERATION = "CREATE";

	/** The Constant USER_PROVISION_STATUS. */
	public static final String USER_PROVISION_STATUS = "PENDING";

	/** The Constant APPLICATION_STATUS. */
	public static final String APPLICATION_STATUS = "PENDING";

	/** The Constant USER. */
	public static final String USER = "USER";

	/** The Constant USER. */
	public static final String APP = "APP";

	/** The Constant APPLICATION_PROVISIONING. */
	public static final String APPLICATION_PROVISIONING = "Application Provisioning";

	/** The Constant APPLICATION_DEPROVISIONING. */
	public static final String APPLICATION_DEPROVISIONING = "Application De-Provisioning";

	/** The Constant UNOTECH. */
	public static final String UNOTECH = "UNOTECH";

	/** The Constant FALSE. */
	public static final String FALSE = "false";

	/** The Default App to user. */
	public static final String DEFAULT_APP = "CYMMETRI";

	/** The constant NOPROCESS_ALLOWED_STATUS. */
	public static final List<Status> NOPROCESS_ALLOWED_STATUS = Arrays.asList(Status.INACTIVE, Status.DELETE);

	/** The constant NOSEARCH_ALLOWED_STATUS. */
	public static final List<Status> NOSEARCH_ALLOWED_STATUS = Arrays.asList(Status.DELETE);

}
