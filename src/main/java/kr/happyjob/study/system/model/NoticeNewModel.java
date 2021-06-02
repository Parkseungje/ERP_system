package kr.happyjob.study.system.model;

public class NoticeNewModel {
	
	// 게시판 글 번호 NoticeNewMapper.xml에 있는 select조건을 가져온다 -> general and getter을 한다! 
	private int no;
	private String title;
	private String name;
  private String date;
	// **** 추가코드 ****
	private String loginID;
	private String contents;
	private String delete_yn;   
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}	
	public String getLoginID() {
    return loginID;
  }
  public void setLoginID(String loginID) {
    this.loginID = loginID;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public String getDelete_yn() {
    return delete_yn;
  }
  public void setDelete_yn(String delete_yn) {
    this.delete_yn = delete_yn;
  }
}
