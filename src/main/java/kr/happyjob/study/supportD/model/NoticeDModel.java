package kr.happyjob.study.supportD.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoticeDModel {
	
	private String nt_seq;
	private String nt_title;
	private String nt_contents;
	private int nt_cnt;
	private String enr_user;
	private String enr_date;
	private String upd_user;
	private Date upd_date;
	private String file_nm;
	private String file_loc;
	private String file_size;
	
	public NoticeDModel(){
		
	}

	public NoticeDModel(String nt_seq, String nt_title, String nt_contents, int nt_cnt, String enr_user,
			String enr_date, String upd_user, Date upd_date, String file_nm, String file_loc, String file_size) {
		this.nt_seq = nt_seq;
		this.nt_title = nt_title;
		this.nt_contents = nt_contents;
		this.nt_cnt = nt_cnt;
		this.enr_user = enr_user;
		this.enr_date = enr_date;
		this.upd_user = upd_user;
		this.upd_date = upd_date;
		this.file_nm = file_nm;
		this.file_loc = file_loc;
		this.file_size = file_size;
	}

	public String getNt_seq() {
		return nt_seq;
	}

	public void setNt_seq(String nt_seq) {
		this.nt_seq = nt_seq;
	}

	public String getNt_title() {
		return nt_title;
	}

	public void setNt_title(String nt_title) {
		this.nt_title = nt_title;
	}

	public String getNt_contents() {
		return nt_contents;
	}

	public void setNt_contents(String nt_contents) {
		this.nt_contents = nt_contents;
	}

	public int getNt_cnt() {
		return nt_cnt;
	}

	public void setNt_cnt(int nt_cnt) {
		this.nt_cnt = nt_cnt;
	}

	public String getEnr_user() {
		return enr_user;
	}

	public void setEnr_user(String enr_user) {
		this.enr_user = enr_user;
	}

	public String getEnr_date() {
		return enr_date;
	}

	public void setEnr_date(String enr_date) {
		this.enr_date = enr_date;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String Resultstr = "";
		
		try{
			Date date = format.parse(enr_date);
			SimpleDateFormat resultFormat = new SimpleDateFormat("yyyy-MM-dd");
			Resultstr = resultFormat.format(date);
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		this.enr_date = Resultstr;
	}

	public String getUpd_user() {
		return upd_user;
	}

	public void setUpd_user(String upd_user) {
		this.upd_user = upd_user;
	}

	public Date getUpd_date() {
		return upd_date;
	}

	public void setUpd_date(Date upd_date) {
		this.upd_date = upd_date;
	}

	public String getFile_nm() {
		return file_nm;
	}

	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}

	public String getFile_loc() {
		return file_loc;
	}

	public void setFile_loc(String file_loc) {
		this.file_loc = file_loc;
	}

	public String getFile_size() {
		return file_size;
	}

	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}

	@Override
	public String toString() {
		return "NoticeDModel [nt_seq=" + nt_seq + ", nt_title=" + nt_title + ", nt_contents=" + nt_contents
				+ ", nt_cnt=" + nt_cnt + ", enr_user=" + enr_user + ", enr_date=" + enr_date + ", upd_user=" + upd_user
				+ ", upd_date=" + upd_date + ", file_nm=" + file_nm + ", file_loc=" + file_loc + ", file_size="
				+ file_size + "]";
	}
	
	
	
	

}
