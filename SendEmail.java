package com.javamultiplex.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	public static void main(String[] args)
	{
		String to="geurohit.21@gmail.com";
		Properties properties=new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");  
		properties.put("mail.smtp.socketFactory.class",  
		            "javax.net.ssl.SSLSocketFactory");  
		properties.put("mail.smtp.auth", "true");  
		properties.put("mail.smtp.port", "465"); 
		  
		  Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator(){
			  
			  protected PasswordAuthentication getPasswordAuthentication() {  
				   return new PasswordAuthentication("ctsrohit.21@gmail.com","ROHIT12345");  
				   }
			  
		  });
		  
		  try
		  {
			  MimeMessage message=new MimeMessage(session);
			  message.setFrom(new InternetAddress("ctsrohit.21@gmail.com"));
			  message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			  message.setSubject("Second Mail yr");
			  message.setText("yipeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee!!!!!!");
			  Transport.send(message);
			  System.out.println("Success");
		  }
		  catch(MessagingException exp)
		  {
			  exp.printStackTrace();
		  }
		  
	}

}
