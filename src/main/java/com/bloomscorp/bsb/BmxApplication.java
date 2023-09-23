package com.bloomscorp.bsb;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BmxApplication implements ErrorController {

	@RequestMapping(value = "/error")
	@ResponseStatus(HttpStatus.OK)
	public String error() {
		return "forward:/index.html";
	}
}
