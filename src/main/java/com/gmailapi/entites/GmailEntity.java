package com.gmailapi.entites;

public class GmailEntity {

	private String message;
	private String subject;
	private String to;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public GmailEntity(String message, String subject, String to) {
		super();
		this.message = message;
		this.subject = subject;
		this.to = to;
	}
	public GmailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GmailEntity [message=" + message + ", subject=" + subject + ", to=" + to + "]";
	}
	
	
	
}
