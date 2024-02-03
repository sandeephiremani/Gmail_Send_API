package com.gmailapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gmailapi.entites.GmailEntity;
import com.gmailapi.service.GmailService;

@RestController
@CrossOrigin
public class GmailController {
 
	@Autowired
	private GmailService gmailService;
	
	@GetMapping("/check")
	public String check() {
		return "Checking..........";
	}
	
//	Controller for sending mail
	@PostMapping("/sendmail")
	public ResponseEntity<?> mailSend(@RequestBody GmailEntity request){
		boolean mail = this.gmailService.sendMail(request.getMessage(), request.getSubject(), request.getTo());
		System.out.println(request);
		if(mail) {
			return ResponseEntity.ok("Send Successfully......");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not send due Error");
		}
	}
}
