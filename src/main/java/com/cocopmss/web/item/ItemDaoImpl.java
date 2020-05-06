package com.cocopmss.web.item;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cocopmss.web.util.Data;

@Repository
public class ItemDaoImpl implements ItemDao { //무조건 try catch

	@Override
	public List<Item> selectAll() {
		List<Item> items = new ArrayList<>(); //try 안에서 하나 밖에서 하나 같으므로 선언해준다
		List<String> temp = new ArrayList<>();
		try {
			File file = new File(Data.ITEMS.toString()); //file생성
//			FileReader fr = new FileReader(file); //fileReader로 읽기
//			BufferedReader reader = new BufferedReader(fr);//결합
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message = "";
			while(reader.readLine() != null) { //얼마나 루핑할지 모르므로
				temp.add(message);
			}
			reader.close();
		} catch(Exception e) {
			System.out.println("에러");
			e.printStackTrace();
		}
		Item i = null;
		for(String s : temp) {
			i = new Item();
			String arr[] = s.split(",");
			i.setItemId(arr[0]);
			i.setItemName(arr[1]);
			i.setTakeDate(arr[2]);
			i.setCategory(arr[3]);
			i.setTakePlace(arr[4]);
			items.add(i);
		}
		return items;
	}

}
