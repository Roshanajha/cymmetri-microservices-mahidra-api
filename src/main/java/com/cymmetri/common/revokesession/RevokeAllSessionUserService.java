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
package com.cymmetri.common.revokesession;

import com.cymmetri.ms.user.dto.Response;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RevokeAllSessionUserService {

	private final RevokeAllSessionUserClient revokeAllSessionUserClient;

	public RevokeAllSessionUserService(RevokeAllSessionUserClient revokeAllSessionUserClient) {
		this.revokeAllSessionUserClient = revokeAllSessionUserClient;
	}

	public Boolean revokeAllSessionForUser(String login) {

		ResponseEntity<Response> responseEntity = this.revokeAllSessionUserClient.resetPassword(login);
		Response response = responseEntity.getBody();

		if (response.getSuccess()) {
			return true;
		}

		return false;
	}

}
