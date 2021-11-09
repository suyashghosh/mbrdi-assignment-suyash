package com.mbrdi.model;

public class StatusMessage {
	
	private boolean status;
	private String message;
	
	public StatusMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public StatusMessage(boolean status, String message) {
		this.status = status;
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
		

}
