package com.example.demo.login.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	private MailSender sender;

	public void sendMail(String to) {
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setFrom("tamuten310@gmail.com");
		msg.setTo("tamuten0310@aol.jp");
		msg.setSubject("テストメール");//タイトルの設定
		msg.setText("Spring Boot より本文送信"); //本文の設定

		this.sender.send(msg);
	}
}
