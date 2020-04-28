package com.cocopmss.web.user;

import java.util.List;

public interface UserService {

	public void add(User user); //savefile, readfile(이제 hasg맵에 저장 안하므로 add가됨
	public List<User> list();
	public int count();

	public User login(User user); //비밀번호는 민감정보라 따로..
	public User detail(String userid); //관리자 검색용

	public boolean update(User user);
	public boolean remove(String userid);
	public boolean check(String userid);
}