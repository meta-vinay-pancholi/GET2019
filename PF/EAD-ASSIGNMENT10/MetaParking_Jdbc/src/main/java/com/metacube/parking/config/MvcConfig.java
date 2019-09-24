package com.metacube.parking.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.parking.filter.MyFilter;


@Configuration
public class MvcConfig {

	@Bean
	public FilterRegistrationBean<MyFilter> validationFilter() {
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new MyFilter());
		registrationBean.addUrlPatterns("/vehicleRegistration",
				 "/showProfile", "/pass", "/friends",
				"/getPass", "/logout" , "/update");

		return registrationBean;
	}
}
