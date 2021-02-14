package com.ernandorezende.parking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user")
			.password(passwordEncoder().encode("User@123456"))
			.roles("USER")
			.and()
			.passwordEncoder(passwordEncoder());
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//			.antMatchers("/swagger-ui.html").permitAll()
//			.antMatchers("/swagger-resources/**").permitAll()
//			.antMatchers("/webjars/**").permitAll()
//			.antMatchers("/v3/api-docs/**").permitAll()
//			.antMatchers("/").permitAll()
//			.antMatchers("/csrf").permitAll()
//			.antMatchers("/*.js").permitAll()
//			.antMatchers("/*.css").permitAll()
//			.antMatchers("/*.ico").permitAll()
//			.antMatchers("/*.png").permitAll()
//			.anyRequest().authenticated();
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
