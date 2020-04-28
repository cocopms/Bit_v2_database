package com.cocopmss.web.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	private String userid, passwd, name, ssn, addr;
		public String toString() {
			return String.format("%s,%s,%s,%s,%s",userid,passwd,name,ssn,addr);
		}
}