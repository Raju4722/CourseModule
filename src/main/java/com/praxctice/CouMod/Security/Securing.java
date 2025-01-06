//package com.praxctice.CouMod.Security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import static org.springframework.security.config.Customizer.withDefaults;
//
//import java.util.function.Function;
//@Configuration
//public class Securing {
//	@Bean
//	public InMemoryUserDetailsManager creating() {
//		Function<String,String> passencoder=input->encodes().encode(input);
//		UserDetails ab=User.builder().
//		passwordEncoder(passencoder)
//		.username("Raju").password("4722").roles("USER").build();
//		return new InMemoryUserDetailsManager(ab);
//	}
//
//	private PasswordEncoder encodes() {
//		
//		return new BCryptPasswordEncoder();
//	}
//}
