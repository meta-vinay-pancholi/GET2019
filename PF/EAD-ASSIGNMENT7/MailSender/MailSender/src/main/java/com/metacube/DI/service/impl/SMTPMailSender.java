package com.metacube.DI.service.impl;

import org.springframework.stereotype.Component;

import com.metacube.DI.service.MailSender;

@Component("smtpMailSender")
public class SMTPMailSender implements MailSender {

	public void sendMail() {
		System.out.println("SMTP mail....");
	}
}
