package com.projectsujan.rijal.service;

import com.projectsujan.rijal.model.User;
import com.projectsujan.rijal.web.dto.UserRegistrationDto;

public interface UserService {
	
	User save(UserRegistrationDto registrationDto);

}
