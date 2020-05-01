"use strict" // 문법을 엄격하게 적용하겠다
var user = user || {} // = java의 new user=null, 가독성을 위해 파일명과 객체명을 맞출 것
						// user로 사용하던가(or) {}안에 json을 넣어서 쓰던가, 네임스페이스면서 json
						// 전역함수 : 어디서든 <script>로 가져다 쓸 수 있다
						// 파일 안에 내재되지 않고 따로 외부에서 불러 속도를 향상시키고 template를 통일시킨다
						// 코드에 네임스페이스를 지정해주며, 코드 내의 이름 충돌뿐만 아니라 이 코드와 같은 페이지에
						// 존재하는 또 다른 자바스크립트 라이브러리나 위젯등 서드파티 코드와의 이름 충돌도 미연에 방지
						// {}여기는 이름이 없으므로 어나니머스 함수(람다식) = 공간을 하나도 차지하지 않음(공간이
						// 있긴한데 찍자마자 사라짐, 계속 그자리에서 기능을 호출함) = 넷플릭스가 움직히는 방법 =
						// 속도에 영향을 미치지 않음

//3단구조 : 호출, json, css

user = (()=> { // 즉시실행, 우선처리, 모듈패턴이라고도 함
	let init = () => { // init = new, =java의 user=new User()
		alert('1')
		onCreate() // 호출
	}
	let onCreate = () => { // on : 만들어지자마자 바로 실행하세요! 그래서 즉시실행
		setContentView() // 호출
		alert('2')
		$('.logo')
	.css('cursor', 'pointer')
	.click( e => {
		e.preventDefault()
		location.href = '/home'
		})
		$('#register_but')
		.click( e => {
			e.preventDefault()
			location.href = '/admin'
		})
		$('#access_but')
		.css('cursor','pointer')
		.click( e=> {
			e.preventDefault()
			location.href = 'admin/access.html'
		})
		$('#join_but')
		.css('cursor','pointer')
		.click( e=> {
			e.preventDefault()
			location.href = 'user/signup.html'
		})
		$('#login_but')
		.css('cursor','pointer')
		.click( e=> {
			e.preventDefault()
			location.href = 'user/access.html'
		})
	}
	let setContentView = () => {
		alert('3')
		//css 요소
	}
	// html로 보내주기
	return {init} // var user = user || {} 의 json인 {}로 리턴
})()