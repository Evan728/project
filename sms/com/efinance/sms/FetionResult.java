package com.efinance.sms;

public class FetionResult {
	private boolean ifSucceed;
	private String result;
	
	public FetionResult() {	}
	
	public FetionResult(boolean ifSucceed, String result) {
		this.ifSucceed = ifSucceed;
		this.result = result;
	}
	
	public boolean isIfSucceed() {
		return ifSucceed;
	}
	public void setIfSucceed(boolean ifSucceed) {
		this.ifSucceed = ifSucceed;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
