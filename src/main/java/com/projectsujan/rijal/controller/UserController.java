package com.projectsujan.rijal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@RequestMapping("/msg")
	public String getMessage() {
		return "Namestey";
	}

}
