package com.efinance.sms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class FetionSend {
	
	private String user; //mobile number of your fetion
	private String passwd; // the password for your account of fetion
	private String sendTo; // who you want to send
	private String message; // the message content
	
	private static final String httpUrl = "http://quanapi.sinaapp.com/fetion.php";
	

	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getSendTo() {
		return sendTo;
	}


	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	public FetionResult send() throws IOException {
		FetionResult result = new FetionResult();
		result.setIfSucceed(false);
		
		if ("".equals(user) || user == null) {
			result.setResult("The user name can't be empty!");
			return result;
		}
		
		if ("".equals(passwd) || passwd == null) {
			result.setResult("The password can't be empty!");
			return result;
		}
		
		if ("".equals(sendTo) || sendTo == null) {
			result.setResult("The number you send to can't be empty!");
			return result;
		}
		
		if ("".equals(message) || message == null) {
			result.setResult("The message content can't be empty!");
			return result;
		}
		
		String getUrl = new StringBuffer(httpUrl).append("?u=").append(user).append("&p=").append(passwd)
						.append("&to=").append(sendTo).append("&m=").append(URLEncoder.encode(message,"utf-8")).toString();
		URL urlLocate = new URL(getUrl);
		HttpURLConnection connection = (HttpURLConnection) urlLocate.openConnection();
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.connect();
		BufferedReader reader = new BufferedReader( new InputStreamReader(connection.getInputStream()));
		
		String lineResult;
		while ((lineResult = reader.readLine()) != null) {
			System.out.println(lineResult);
		}
		
		return result;
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FetionSend fetion = new FetionSend();
		fetion.setUser("15827119597");
		fetion.setPasswd("13432809648");
		fetion.setSendTo("15827120789");
		fetion.setMessage("����~~!");
		fetion.send();

	}

}
