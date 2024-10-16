package com.yedam.vo;

import java.util.Date;
//lombok 활용
//1. eclipse 설치 
//2. 라이브러리 

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

public class MemberVO {
	private String memberId;	
	private String password;
	private String memberName;
	private String phone;
	private String responsibility;
	private Date creationDate;
	
	
}
