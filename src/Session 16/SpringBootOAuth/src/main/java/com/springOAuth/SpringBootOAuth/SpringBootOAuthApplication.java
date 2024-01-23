package com.springOAuth.SpringBootOAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SpringBootApplication
public class SpringBootOAuthApplication extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
				.authorizeRequests(auth ->
						auth.antMatchers("/", "/error", "/webjars/**").permitAll()
								.anyRequest().authenticated()
				)
				.exceptionHandling(exception ->
						exception.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
				)
				.csrf(csrf ->
						csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				)
				.logout(logout ->
						logout.logoutSuccessUrl("/").permitAll()
				)
				.oauth2Login();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOAuthApplication.class, args);
	}

}
