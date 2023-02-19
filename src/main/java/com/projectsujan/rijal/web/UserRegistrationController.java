package com.projectsujan.rijal.web;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectsujan.rijal.service.UserService;
import com.projectsujan.rijal.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	
	private UserService userServiec;

	public UserRegistrationController(UserService userServiec) {
		super();
		this.userServiec = userServiec;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		
		return new UserRegistrationDto();
		
	}
//   we can also use this to return empty object
	
//	@GetMapping
//	public String viewRegistrationForm( Model model ) {
//		
//		model.addAttribute("user", new UserRegistrationDto());
//		
//		return "registration";
//	}
	
	
	@GetMapping
	public String viewRegistrationForm(  ) {
		
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		
		userServiec.save(registrationDto);
		return "redirect:/registration?success";
	}

}
