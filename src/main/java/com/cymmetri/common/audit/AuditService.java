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
package com.cymmetri.common.audit;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.cymmetri.common.session.Principal;
import com.cymmetri.common.session.PrincipalContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

	@Autowired
	private AuditClient auditClient;

	public void log(Audit audit) {

		Principal principal = PrincipalContext.getPrincipal();

		Map<String, String> source = new HashMap<>(0);
		source.put("userAgent", principal.getUserAgent());
		source.put("ipAddress", principal.getIpAddress());

		audit.setSourceAttributes(source);
		audit.setRequestorId(principal.getUserId());
		audit.setPerformedAt(LocalDateTime.now());

		this.auditClient.log(audit);
	}

}
