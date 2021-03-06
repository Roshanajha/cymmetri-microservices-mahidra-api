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

package com.cymmetri.common.mfa.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cymmetri.common.mfa.enums.MfaType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdminRemoveRegisteredMfaRequest {

	@NotBlank
	private String userId;

	@NotNull
	private MfaType mfaType;

}
