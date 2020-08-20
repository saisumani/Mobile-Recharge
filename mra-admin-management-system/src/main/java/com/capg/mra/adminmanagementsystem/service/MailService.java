package com.capg.mra.adminmanagementsystem.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service

public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(String toEmail, String subject, String message) throws MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(message, true);
		javaMailSender.send(mimeMessage);

	}

}
