package com.cocopmss.web.admin;

import java.util.List;

// 기본 : add, list, detail, count, update, delete
public interface AdminService {

	void register(Admin admin);

	List<Admin> findAll();

	Admin findOne(String employeeNumbe);

	void modify(Admin admin);

	void remove(Admin admin);


}