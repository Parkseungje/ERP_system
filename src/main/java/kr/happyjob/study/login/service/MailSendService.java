package kr.happyjob.study.login.service;


public interface MailSendService {
	/* 로그인 ID 조회 메일 발송*/
	public void sendEmail(String emailNum, String authNumId) throws Exception;
	/* 로그인ID 조회 난수 발생*/
	public String RandomNum() throws Exception;
}