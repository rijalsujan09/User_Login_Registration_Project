package com.projectsujan.rijal.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.projectsujan.rijal.service.UserService;

	
	@Configuration
	@EnableWebSecurity
	@EnableMethodSecurity
	public class SecurityConfiguration {
		
		@Autowired
		UserService userService;
		
		
		@Bean
		public SecurityFilterChain cofigureFilterChain(HttpSecurity httpSecurity) throws Exception {
			httpSecurity
			.authorizeHttpRequests()
			.requestMatchers("/registartion**", "js/**" ,"css/**", "img/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login?logout")
			.permitAll();
			return httpSecurity.build();
		}
		
		
		
		@Bean
		public PasswordEncoder getPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
		protected void Configure (AuthenticationManagerBuilder auth) throws Exception{
			auth.authenticationProvider(authenticationProvider());
		}
		
		
		@Bean
		public DaoAuthenticationProvider authenticationProvider() {
			DaoAuthenticationProvider auth  =  new DaoAuthenticationProvider();
			auth.setUserDetailsService(userService);
			auth.setPasswordEncoder(getPasswordEncoder());
			return auth;
		}
		
		
		
		
		
		

}
