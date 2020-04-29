package com.cocopmss.web.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//저장공간이 map에서 file로 바뀌었으므로 구조 다 바뀜
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;
import com.cocopmss.web.util.Data;

@Service
public class UserServiceImpl implements UserService{
	private Map<String, Object> map; //이젠 끄면 사라지는 맵에 저장하지 않고, 오프라인에 저장하려 한다

	@Override
	public void add(User user) {
		map.put(user.getUserid(), user);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<User> list() {
		List<User> list = new ArrayList<>();
		@SuppressWarnings("rawtypes")
		Set set = map.entrySet(); //set = map의 entry를 넣는, map 순서가 없기 때문에 순서 없는 set으로..
		@SuppressWarnings("rawtypes")
		Iterator it= set.iterator();
		while(it.hasNext()) { //다음게 있냐없냐
			@SuppressWarnings("unchecked")
			Map.Entry<String, User> e = (Entry<String, User>) it.next(); //순서대로 리턴
			list.add(e.getValue()); //키는 빼고 value만.. 
		}
		for(int i=0; i<list.size(); ++i) {
			System.out.println(list.get(i));
		}
		return list;
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public User login(User user) {
		User returnUser = null;
		if(map.containsKey(user.getUserid())) {
			User u = detail(user.getUserid());
			if(user.getPasswd().equals(u.getPasswd())) {
				return u;
			}
		}
		return returnUser;
	}

	@Override
	public User detail(String userid) {
		return null;
	}

	@Override
	public boolean update(User user) {
		return true;
	}
	
	public List<User> readfile() {
		List<User> listUser = new ArrayList<>();
		List<String> list = new ArrayList<>();
		try {
			File file = new File(Data.USER_PATH.toString() + Data.LIST.toString() + Data.CSV.toString());
			BufferedReader br = new BufferedReader(new FileReader(file));
			String message = "";
			while((message = br.readLine()) != null) {
				list.add(message);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		User user = null;
		for(int i=0; i<list.size(); ++i) {
			user = new User();
			String[] arr = list.get(i).split(",");
			user.setUserid(arr[0]);
			user.setPasswd(arr[1]);
			user.setName(arr[2]);
			user.setSsn(arr[3]);
			user.setAddr(arr[4]);
			listUser.add(user);
		}
		return listUser;
	}

	@Override
	public boolean remove(String userid) {
		return true;
	}
	
	@Override
	public boolean check(String userid) {
		boolean ok = true;
		List<User> list = list();
		for(int i =0; i<list.size(); ++i) {
			if(userid.equals(list.get(i).getUserid())) { //아이디만 골라서 list id와 비교해야함
				ok = false;
				break;
			}
		}
		return ok;
	}
}
