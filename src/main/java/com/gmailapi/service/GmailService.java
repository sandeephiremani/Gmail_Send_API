package com.gmailapi.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class GmailService {

	public boolean sendMail(String message, String subject, String to) {
		boolean f = false;
//		This is the Send mail API 
		String from = "deppuv00@gmail.com";
//		variable for gamil
		String host = "smtp.gmail.com";

//		Get the system parametrs

		Properties properties = System.getProperties();
		System.out.println("Properties : " + properties);

//		setting importatant information to properties object
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

//		step 1 :get the session object
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("deppuv00@gmail.com", "hyfzqsqkukebyinw");
			}
		});
		session.setDebug(true);

//		Step 2 : compose the message [text,multi media]
		MimeMessage mimeMessage = new MimeMessage(session);

		try {
//			from the mail
			mimeMessage.setFrom(new InternetAddress(from));
			mimeMessage.setSubject(subject);
//			adding recipicnt
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

//			adding subject to subject

			mimeMessage.setText(message);

//			send the message using transport

			Transport.send(mimeMessage);
			System.out.println("Send success");
			f=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return f;
	}

}
