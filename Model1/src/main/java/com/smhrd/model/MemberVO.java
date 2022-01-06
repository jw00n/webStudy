package com.smhrd.model;

public class MemberVO {
//field 변수명이 table의 칼럼 이름과 같아야한다.
	private String id;
	private String pw;
	private String nickname;
	
	
	public MemberVO(String id, String pw, String nickname) {
		super();
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
	}


}
