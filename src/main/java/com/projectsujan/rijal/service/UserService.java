package com.projectsujan.rijal.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.projectsujan.rijal.model.User;
import com.projectsujan.rijal.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);

}
