package com.cocopmss.web.util;

import java.io.File;

public enum Data {
	ADMINS, USERS, ITEMS;

	@Override
	public String toString() {
		String path = "C:"+File.separator+"Users"+File.separator+"bit"+File.separator
			+"Basic"+File.separator+"Bit"+File.separator+"cocopmss"+File.separator
			+"src"+File.separator+"main"+File.separator+"resources"
			+File.separator+"static"+File.separator+"resources"+File.separator+"file"+File.separator;
			switch (this) {
		case ADMINS :
			path = path.concat("admins.csv"); //합치다. 오버로딩
			break;
		case USERS :
			path = path.concat("users.csv");
			break;
		case ITEMS :
			path = path.concat("items.csv");
			break;
		default : break;
		}
		return path;
	}
}