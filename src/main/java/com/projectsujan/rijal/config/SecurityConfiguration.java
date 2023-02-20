package com.projectsujan.rijal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration

public class SecurityConfiguration {
	
	@Bean
	public  SecurityFilterChain configureFilterChain(HttpSecurity httpSecurity)  throws Exception{
		httpSecurity
		.authorizeHttpRequests()
		.requestMatchers("/registration", "/registration?success", "/", "/login").permitAll()
		.anyRequest()
		.authenticated()
		.and()
//		.formLogin();
      .httpBasic();
		
		return httpSecurity.build();
	}
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	@Bean
	public UserDetailsService GetUser() {
		UserDetails user  = User.withUsername("user").password(getPasswordEncoder().encode("user")).roles("USER").build();
		UserDetails admin  = User.withUsername("admin").password(getPasswordEncoder().encode("admin")).roles("USER","ADMIN").build();
		return new InMemoryUserDetailsManager(user,admin);
	}
}
