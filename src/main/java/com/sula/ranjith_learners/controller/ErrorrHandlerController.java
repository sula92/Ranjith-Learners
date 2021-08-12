package com.sula.ranjith_learners.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorrHandlerController implements ErrorController {

	@GetMapping("/error")
	public String customError() {
		return "The link you followed may be broken, or the page may have been removed. <h1>xxxxxxx</h1>";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
