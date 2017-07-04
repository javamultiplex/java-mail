package com.javamultiplex.mail;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class ReceiveEmail {

	
	public static void main(String[] args)
	{
		  String host = "imap.gmail.com";  
		  String mailStoreType = "imaps";  
		  String username= "ctsrohit.21@gmail.com";  
		  String password= "ROHIT12345"; 
		  
		  receiveEmail(host, mailStoreType, username, password);  
	}

	private static void receiveEmail(String host, String mailStoreType, String username, String password) {
		
		try
		{
			Properties prop=System.getProperties();
			prop.setProperty("mail.store.protocol", mailStoreType);
			Session session=Session.getDefaultInstance(prop,null);
			Store emailStrore=session.getStore(mailStoreType);
			emailStrore.connect(host,username,password);
			Folder folder=emailStrore.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			Message[] messages = folder.getMessages();  
			   for (int i = 0; i < messages.length; i++) {  
			    Message message = messages[i];  
			    System.out.println("---------------------------------");  
			    System.out.println("Email Number " + (i + 1));  
			    System.out.println("Subject: " + message.getSubject());  
			    System.out.println("From: " + message.getFrom()[0]);  
			    System.out.println("Text: " + message.getContent().toString()); 
			
			   }
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}
	
}