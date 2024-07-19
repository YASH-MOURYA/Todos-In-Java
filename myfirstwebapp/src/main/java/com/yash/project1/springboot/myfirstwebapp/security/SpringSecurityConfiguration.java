package com.yash.project1.springboot.myfirstwebapp.security;

import  static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	//LDAp or Database
	// in here using in memeory configuration
	
	//InMemoryUserDetailsManager
//@SuppressWarnings("deprecation")
@Bean
public InMemoryUserDetailsManager createUserDetailsManager() {
//	String username = "yash";
//	String password = "dummy";
	
	UserDetails userDetails1 = createNewUser("yash", "dummy");
	UserDetails userDetails2 = createNewUser("yash1", "dummy1");
	UserDetails userDetails3 = createNewUser("yash2", "dummy2");
				return new InMemoryUserDetailsManager(userDetails1,userDetails2,userDetails3);
		

	}
private UserDetails createNewUser(String username, String password) {
	Function<String, String> passwordEncoder
		=input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("USER","ADMIN")
				.build();
	return userDetails;
}
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests(auth ->auth.anyRequest().authenticated());
	http.formLogin(withDefaults());
	http.csrf().disable();
	http.headers().frameOptions().disable();
	return http.build();
}
@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}
}
