package com.cocopmss.web.admin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cocopmss.web.util.Data;
import com.cocopmss.web.util.Messanger;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Override
	public void insert(Admin admin) {
		try {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter(
							new File(Data.ADMIN_PATH.toString()
							+ Data.LIST.toString()
							+ Data.CSV.toString()),true));
			writer.write(admin.toString());
			writer.newLine();
			writer.flush();
		} catch (Exception e) {
			System.out.println(Messanger.FILE_INSERT_ERROR);
		} finally {

		}
	}

	@Override
	public List<Admin> selectAll() {
		List<Admin> list = null;
		try {
			
		} catch(Exception e) {
			System.out.println(Messanger.FILE_INSERT_ERROR);
		} finally {
			
		}
		return list;
	}

	@Override
	public Admin selectOne(String employeeNumber) {
		Admin returnAdmin = null;
		try {
			
		} catch(Exception e) {
			System.out.println(Messanger.FILE_INSERT_ERROR);
		} finally {
			
		}
		return returnAdmin;
	}

	@Override
	public void update(Admin admin) {
		try {
			
		} catch(Exception e) {
			System.out.println(Messanger.FILE_INSERT_ERROR);
		} finally {
			
		}
	}

	@Override
	public void delete(Admin admin) {
		try {
			
		} catch(Exception e) {
			System.out.println(Messanger.FILE_INSERT_ERROR);
		} finally {
			
		}	
	}
	
}