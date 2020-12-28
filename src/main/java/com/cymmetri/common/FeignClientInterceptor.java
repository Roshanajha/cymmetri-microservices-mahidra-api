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
package com.cymmetri.common;

import java.util.Map;
import java.util.Objects;

import com.cymmetri.common.session.Principal;
import com.cymmetri.common.session.PrincipalContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FeignClientInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate requestTemplate) {

		Principal principal = PrincipalContext.getPrincipal();
		Map<String, String> headers = MapUtils.emptyIfNull(principal.getHeaders());

		for (Map.Entry<String, String> header : headers.entrySet()) {
			log.info("key {} and value {} is ", header.getKey(), header.getValue());
			if (Objects.equals(header.getKey(), HttpHeaders.USER_AGENT)) {
				log.info("... modifying userAgent from header ... ");
				header.setValue(StringUtils.join(header.getValue(), "-", "INTERNAL_API_CALL"));
			}
			requestTemplate.header(header.getKey(), header.getValue());
		}
	}

}
