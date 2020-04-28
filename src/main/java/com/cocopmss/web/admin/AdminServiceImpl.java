package com.cocopmss.web.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

//controller은 네트워크에서 new를 해주고 있다
@Service
public class AdminServiceImpl implements AdminService {

	@Override
	public Map<String, Object> add(Admin admin) {
		Map<String, Object> map = new HashMap<>();
		map.put(admin.getEmail(), admin);
		return map;
	}
}