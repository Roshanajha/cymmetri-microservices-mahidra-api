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
package com.cymmetri.ms.user.exception;

import java.util.Map;

import com.cymmetri.ms.user.dto.Response;
import feign.FeignException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		this.log.error("Exception: ", ex);

		return this.exception(new InvalidArgumentsException());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> exception(Exception ex) {
		this.log.error("Exception: ", ex);
		return buildResponseEntity(new Response(ex), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NullPointerException.class)
	protected ResponseEntity<Object> handleNullPointerException(NullPointerException ex) {
		String debugMessage = String.format("Exception: ");
		this.log.error(debugMessage, ex);
		return buildResponseEntity(new Response(ex), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidArgumentsException.class)
	public ResponseEntity<Object> exception(InvalidArgumentsException ex) {
		this.log.error("Exception: ", ex);
		return buildResponseEntity(new Response(ex), HttpStatus.BAD_REQUEST);
	}

	/**
	 * FeignException.
	 * @param ex the FeignException
	 * @return the response entity
	 */
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<Object> exception(FeignException ex) {
		this.log.error("Exception: ", ex);
		Map<String, Object> map = new JSONObject(ex.contentUTF8()).toMap();

		return ResponseEntity.status(ex.status()).body(map);
	}

	private ResponseEntity<Object> buildResponseEntity(Response response, HttpStatus status) {
		return new ResponseEntity<>(response, status);
	}

}
