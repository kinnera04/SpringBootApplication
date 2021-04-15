package test.application.model;

import java.math.BigInteger;

import javax.persistence.*;

public class task {


	private String message;
	
	private int Status;

	public task(String message, int status) {
		super();
		this.message = message;
		Status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}
	
	
	
	
}
