package com.metacube.StudentHibernate.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.metacube.StudentHibernate.controller.HomeController;

/**
 * Spring Security configuration file
 * @author vinay
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(final AuthenticationManagerBuilder auth)
			throws Exception {
		auth.jdbcAuthentication()
				.dataSource(
						(DataSource) HomeController.factory
								.getBean("dataSource1"))
				.usersByUsernameQuery(
						"SELECT username, password, enabled FROM users WHERE username = ?")
				.authoritiesByUsernameQuery(
						"SELECT username, userRole from user_Role WHERE username = ?")
				.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/login")
				.permitAll().antMatchers("/home").hasAuthority("User")
				.antMatchers("/showStudent").hasAuthority("Admin")
				.anyRequest().authenticated().and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/home", true)
				.failureForwardUrl("/login?error=true");

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
