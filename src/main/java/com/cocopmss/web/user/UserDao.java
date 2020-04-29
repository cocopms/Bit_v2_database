package com.cocopmss.web.user;

import java.util.List;

public interface UserDao {

	void insert(User user);

	List<User> selectAll();

	User selectOne(String employeeNumber);

	void update(User user);

	void delete(User user);

}