package com.cocopmss.web.admin;

import java.util.Map;

// 기본 : add, list, detail, count, update, delete
public interface AdminService {

	public Map<String, Object> add(Admin admin);
}