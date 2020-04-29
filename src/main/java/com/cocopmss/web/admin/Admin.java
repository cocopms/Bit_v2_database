package com.cocopmss.web.admin;

import lombok.Data;

@Data //이 외의 값을 자바스크립트에 입력하면 null값이 뜬다
public class Admin {
	private String employeeNumber, name, passwd, position, profile, registerDate, phoneNumber, email;

}
//employeenumber random