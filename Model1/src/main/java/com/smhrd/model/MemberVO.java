package com.smhrd.model;

public class MemberVO {
//field 변수명이 table의 칼럼 이름과 같아야한다.
	private String id;
	private String pw;
	private String nickname;
	
	
	
	
	public MemberVO(String id, String pw, String nickname) {
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
	}
	


	


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


}
