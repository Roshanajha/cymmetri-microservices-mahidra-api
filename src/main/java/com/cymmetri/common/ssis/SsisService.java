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
package com.cymmetri.common.ssis;

import com.cymmetri.ms.user.dto.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SsisService {

	private final SsisClient ssisClient;

	private final ObjectMapper mapper;

	public SsisService(SsisClient ssisClient, ObjectMapper mapper) {
		this.ssisClient = ssisClient;
		this.mapper = mapper;
	}

	public void callSsisService() {

		ResponseEntity<Response> responseEntity;
		try {
			responseEntity = this.ssisClient.unAssignApplicationToUser();
		}
		catch (Exception exception) {
			log.info("... encountered error during application assignment {} ...", exception);
			return;
		}
	}

}
