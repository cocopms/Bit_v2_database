package com.cocopmss.web.user;

import java.util.List;

import com.cocopmss.web.item.Item;

public interface UserDao {

	void insert(User user);

	List<User> selectAll();

	User selectOne(String userid);

	void update(User user);

	void delete(User user);

}