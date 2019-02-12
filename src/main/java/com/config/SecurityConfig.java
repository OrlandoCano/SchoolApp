package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dao.UserDao;
import com.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan("com")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDao userDao;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			csrf().disable().
			authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/")
			.hasAnyRole("ADMIN", "USER")
			.and().formLogin().loginPage("/login")
			.and().logout().logoutSuccessUrl("/")
			.and().authorizeRequests().antMatchers("/")
			.authenticated().anyRequest().permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new CustomUserDetailsService(userDao));
	}
	
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//	 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
