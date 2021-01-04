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
package com.cymmetri.common.mfaexclusion.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class AssignGroupDTO.
 *
 * @author unotech .
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignGroupDTO {

	/** The group ids. */
	@NotNull
	private List<String> groupIds;

	/** The user ids. */
	@NotNull
	private List<String> userIds;

}
