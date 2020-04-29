package com.cocopmss.web.util;

import java.io.File;

public enum Data {
	LIST, CSV, USER_PATH, ADMIN_PATH;

	@Override
	public String toString() {
		String returnValue = "";
		switch (this) {
		case USER_PATH:
			returnValue = "C:"+File.separator+"Users"+File.separator+"bit"+File.separator+"spring-workspace"+File.separator+"cocopm"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"user"+File.separator;
			break;
		case ADMIN_PATH:
			returnValue = "C:"+File.separator+"Users"+File.separator+"bit"+File.separator+"spring-workspace"+File.separator+"cocopm"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"admin"+File.separator;
			break;
		case CSV :
			returnValue = ".csv";
			break;
		case LIST :
			returnValue = "list";
			break;
		default : break;
		}
		return returnValue;
	}
}