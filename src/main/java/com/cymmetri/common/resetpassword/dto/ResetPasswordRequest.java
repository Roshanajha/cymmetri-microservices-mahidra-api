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
package com.cymmetri.common.resetpassword.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author roshan
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResetPasswordRequest {

	private String userName;

	private String newPassword;

}
