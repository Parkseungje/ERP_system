package kr.happyjob.study.login.service;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

//import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
//import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

@Service
public class MailSendServiceImpl implements MailSendService {
	public void sendEmail(String emailNum, String authNumId){
		String host = "smtp.gmail.com"; // smtp 서버
		String subject = "ChaimMaker 인증번호 전달";
		String fromName = "ChaimMaker관리자";
		String from = "2dh2wdk2@gmail.com"; // 보내는 메일
		String to1 = emailNum;
		
		String content = "인증번호 [" + authNumId + "]";
		
		try {
			Properties props = new Properties();
			//G-Mail
			props.put("mail.smtp.startttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);
			props.setProperty("mail.smtp.socketFactory.class",  "javax.net.ssl.SSLSocketFactory");
			
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.auth", "true");
			
			Session mailSession = Session.getInstance(props,
					new javax.mail.Authenticator(){
						protected PasswordAuthentication getPasswordAuthentication(){
							return new PasswordAuthentication("2dh2wdk2@gmail.com", "1q2w3e!Q@W#E");
						}
						});
							Message msg = new MimeMessage(mailSession);
							msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName, "UTF-8", "B"))); // 보내는 사람 설정
							InternetAddress[] address1 = {new InternetAddress(to1)};
							msg.setRecipients(Message.RecipientType.TO, address1); //받는 사람 설정
							msg.setSubject(subject); //제목 설정
							msg.setSentDate(new java.util.Date()); // 보내는 날짜 설정
							msg.setContent(content, "text/html;charset=euc-kr"); // 내용 형식 설정(HTML 형식)
							
							Transport.send(msg); // 메일 보내기
						} catch (MessagingException e) {
							e.printStackTrace();
						} catch (Exception e){
							e.printStackTrace();
						}			
	}

public String RandomNum() {
	StringBuffer buffer = new StringBuffer();
	for(int i =0; i<=6; i++){
		int n = (int) (Math.random()*10);
		buffer.append(n);
	}
	return buffer.toString();
}
}
