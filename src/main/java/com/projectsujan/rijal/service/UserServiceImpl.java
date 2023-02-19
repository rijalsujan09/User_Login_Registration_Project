package com.projectsujan.rijal.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.projectsujan.rijal.model.Role;
import com.projectsujan.rijal.model.User;
import com.projectsujan.rijal.repository.UserRepository;
import com.projectsujan.rijal.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {
	

	private UserRepository userRepository;
	

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User save(UserRegistrationDto registrationDto) {
		
		User user = new User(registrationDto.getFirstName(),
				registrationDto.getLastName(),
				registrationDto.getEmail(),
				registrationDto.getPassword(),Arrays.asList(new Role("ROLE_USER")));
				
	return  userRepository.save(user);
	}

}
