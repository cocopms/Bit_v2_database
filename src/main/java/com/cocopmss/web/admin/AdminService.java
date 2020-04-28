package com.cocopmss.web.admin;

// 기본 : add, list, detail, count, update, delete
public interface AdminService {
	public void add(Admin member);

	public Admin[] list();

	public Admin detail(Admin member);

	public int count();
	
	public boolean login(Admin member);

	public void update(Admin member);

	public void delete(Admin member);
}