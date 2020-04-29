package com.cocopmss.web.user;

import java.util.List;

public interface UserService {

	void register(User user);

	List<User> findAll();

	User findOne(String employeeNumber);

	void modify(User user);

	void remove(User user);


}