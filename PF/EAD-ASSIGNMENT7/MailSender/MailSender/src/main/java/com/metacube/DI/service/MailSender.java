package com.metacube.DI.service;

import org.springframework.stereotype.Component;

@Component
public interface MailSender {

	public void sendMail();
}
