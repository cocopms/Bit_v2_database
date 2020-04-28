package com.cocopmss.web.admin;

import org.springframework.stereotype.Service;

//controller은 네트워크에서 new를 해주고 있다
@Service
public class AdminServiceImpl implements AdminService {
	private Admin[] members;
	private int count;

	public AdminServiceImpl() {
		members = new Admin[5];
		count = 0;
	}

	@Override
	public void add(Admin member) {
		members[count] = member;
		++count;
	}

	@Override
	public Admin[] list() {
		return members;
	}

	@Override
	public Admin detail(Admin member) {
		Admin detailValue = null;
		for (int i = 0; i < count; ++i) {
			if (member.getUserid().equals(members[i].getUserid())) {
				detailValue = new Admin();
				detailValue = members[i];
			}
		}
		return detailValue;
	}

	@Override
	public int count() {
		return count;
	}
	
	@Override
	public boolean login(Admin member) {
		boolean loginVal = false;
		for(int i=0;i< count;i++) {
			if(member.getUserid().equals(members[i].getUserid())
					&&
				member.getPasswd().equals(members[i].getPasswd())) {
				loginVal = true;
			}
		}
		return loginVal;
	}

	@Override
	public void update(Admin member) {
		for (int i = 0; i < count; ++i) {
			if (member.getUserid().equals(members[i].getUserid())) {
				members[i].setPasswd(member.getPasswd());
			}
		}
	}

	@Override
	public void delete(Admin member) {
		for (int i = 0; i < count; ++i) {
			if (member.getUserid().equals(members[i].getUserid())
					&& member.getPasswd().equals(members[i].getPasswd())) {
				members[i] = members[count - 1];
				members[count - 1] = null;
			}
		}
	}
}
