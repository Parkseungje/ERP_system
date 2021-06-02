import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {

	public static void main(String[] args) {
		
//		String host = "mail.crystal-clear.kr";
//		int port = 587;
//		final String user   = "crystalclear@crystal-clear.kr";
//		final String password  = "wnwjdgh1!";
//		
//		
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "mail.crystal-clear.kr");
//		props.put("mail.smtp.port", "587");
//		
//		// 인증을 포함한 메시지 만들기
//		Message msg = new MimeMessage(Session.getInstance(props, new Authenticator()
//		{
//			public PasswordAuthentication getPasswordAuthentication()
//			{
//				return new PasswordAuthentication(user, password);
//			}
//		}));
//		
//		
//		try {
//			msg.setFrom(new InternetAddress("crystalclear@crystal-clear.kr"));
//			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jujujoy75@gmail.com"));
//			msg.setSubject("web mail test");
//			msg.setContent("가나다라마바사", "text/html;charset=UTF-8");
//			msg.setSentDate(new Date());
//			Transport.send(msg);	
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
			
		

		String host     = "mail.crystal-clear.kr";
		final String user   = "crystalclear@crystal-clear.kr";
		final String password  = "zmfltmxkf1!";

		String to = "jujujoy75@gmail.com";

		  
	  // Get the session object
	  Properties props = new Properties();
	  props.put("mail.smtp.host", host);
	  props.put("mail.smtp.auth", "true");
	  props.put("mail.smtp.starttls.enable", "true");
	  props.put("mail.smtp.port", "587");
	
	  Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	   protected PasswordAuthentication getPasswordAuthentication() {
	    return new PasswordAuthentication(user, password);
	   }
	  });
	
	  // Compose the message
	  try {
	   MimeMessage message = new MimeMessage(session);
	   message.setFrom(new InternetAddress(user));
	   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	
	   // Subject
	   message.setSubject("[Subject] Java Mail Test");
	   
	   // Text
	   message.setText("Simple mail test..");
	
	   // send the message
	   Transport.send(message);
	   System.out.println("message sent successfully...");
	
	  } catch (MessagingException e) {
		  e.printStackTrace();
	  }
	}
}
