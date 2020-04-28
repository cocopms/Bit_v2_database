package com.cocopmss.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocopmss.web.util.Messanger;

@RestController // 인터넷url을 처리하는 컨트롤러
@RequestMapping("/member") // package명과 같아야 함(standard)
public class AdminController {
	@Autowired AdminService service;
	//Aoutowired 내가 new를 만들지 않아도 new를 만들어준다
	//join에서 가입한 값을 그대로 가져와서 login에서도 적용할 수 있도록 만들어준다(같은 메모리 공간에서 선언되었기 때문에)

	// 컨트롤러는 무조건 return값이 있어야 한다
	// 서버단을 거치는 이유 : 보안때문에 한절차를 걸쳐서 주는 것(방화벽)
	// Mapping 외에는 나타나지 않음

	@PostMapping("/join") //key, value : Mesesanger
	public Messanger addUrl(@RequestBody Admin member) {
		//Member을 다시 던지면 보안상의 문제가 생김 -> enum으로 던지자
		int current = service.count(); //add 전 카운트
		System.out.println(member.toString()); // 롬복 안 걸면 toString 만들기
		service.add(member);
		int count = service.count();
		Messanger result = null; //""하는순간 constant pool로 간다.. heap으로 넣어야 한다
		if (count == (current+1)) {
			result = Messanger.SUCCESS;
		} else {
			result = Messanger.FAIL;
		}
		return result;
	}

	@GetMapping("/list")
	public Admin[] list() {
		Admin[] listMembers = service.list();
		return listMembers;
	}

	@GetMapping("/detail")
	public Admin detail(@RequestBody Admin member) {
		Admin detailMember = new Admin();
		service.detail(member);
		return detailMember;
	}

	@PostMapping("/login") // enum
	public Messanger login(@RequestBody Admin member) {
		return (service.login(member)) ? Messanger.SUCCESS : Messanger.FAIL; // 안드로이드
	}

	@PutMapping("/update")
	public Admin update(@RequestBody Admin member) {
		Admin updateMember = new Admin();
		service.update(member);
		return updateMember;
	}

	@DeleteMapping("/delete")
	public Admin delete(@RequestBody Admin member) {
		Admin deleteMember = new Admin();
		service.delete(member);
		return deleteMember;
	}
}