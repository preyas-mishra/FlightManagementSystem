package com.fms.responses;

public class ResponseInfo {

	private int statusCode;
	
	private String statusName;
	
	private String message;
	
	private String path;
	
	
	public ResponseInfo(int statusCode, String statusName, String message, String path) {
		super();
		this.statusCode = statusCode;
		this.statusName = statusName;
		this.message = message;
		this.path = path;
	}
	
	public ResponseInfo() {
		super();
	}

	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
