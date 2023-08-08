package com.bloomscorp.bsb;

import com.bloomscorp.hastar.AuthorizationException;
import com.bloomscorp.raintree.RainTreeResponse;
import com.fasterxml.jackson.databind.JsonMappingException;
import jakarta.servlet.ServletException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BmxGlobalExceptionHandler {

	private static final String JSON_MAPPING_EXCEPTION = "Looks like we received information we weren't excepting. [JMX]";
	private static final String SERVLET_EXCEPTION = "A minion got dizzy while trying to process your request. [SLX]";
	private static final String DATA_INTG_VIOLATION_EXCEPTION = "Something failed deep down in the dungeons. [DIVX]";
	private static final String NULL_POINTER_EXCEPTION = "A minion wasn't in the right place at the right time. [NPX]";
	private static final String BAD_CREDENTIALS_EXCEPTION = "The username or password is incorrect. [BCX]";
	private static final String TRANSIENT_PROPERTY_VALUE_EXCEPTION = "Something, somewhere, deep down the dungeons, did not add up. [TPVX]";

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(JsonMappingException.class)
	public RainTreeResponse jsonMappingException(JsonMappingException ignored) {
		return new RainTreeResponse(false, JSON_MAPPING_EXCEPTION);
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(ServletException.class)
	public RainTreeResponse nestedServletException(JsonMappingException ignored) {
		return new RainTreeResponse(false, SERVLET_EXCEPTION);
	}

//	@ResponseBody
//	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
//	@ExceptionHandler(DataIntegrityViolationException.class)
//	public RainTreeResponse dataIntegrityViolationException(DataIntegrityViolationException ignored) {
//		return new RainTreeResponse(false, DATA_INTG_VIOLATION_EXCEPTION);
//	}

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(NullPointerException.class)
	public RainTreeResponse nullPointerException(NullPointerException ignored) {
		return new RainTreeResponse(false, NULL_POINTER_EXCEPTION);
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(AuthorizationException.class)
	public RainTreeResponse authorizationException(@NotNull AuthorizationException exception) {
		return new RainTreeResponse(false, exception.getMessage());
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(BadCredentialsException.class)
	public RainTreeResponse badCredentialsException(@NotNull BadCredentialsException ignored) {
		return new RainTreeResponse(false, BAD_CREDENTIALS_EXCEPTION);
	}

//	@ResponseBody
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(TransientPropertyValueException.class)
//	public RainTreeResponse transientPropertyValueException(@NotNull TransientPropertyValueException ignored) {
//		return new RainTreeResponse(false, TRANSIENT_PROPERTY_VALUE_EXCEPTION);
//	}
}
