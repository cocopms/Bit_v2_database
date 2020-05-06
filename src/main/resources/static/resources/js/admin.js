"use strict"
var admin = admin || {}
admin = (() => {
	const ERROR = `호출하는 JS 파일을 찾지 못했습니다.`
	let user_vue
	let init = () => { // 호출되는 함수
		user_vue = `resources/vue/user_vue.js`
		onCreate()
	}
	let onCreate = () => { // 감춰지는 함수(clsoure, 보안)
		$.when(
			$.getScript(user_vue)
		) .done(() => {
			setContentView()
			$.getJSON('/users/list', d=> {
				$('#total_count').text('총 회원수 : '+d.length)
				$.each(d, (i, j) => { //i : 순서, j : object
					$(`
					<tr>
                	<th>
                        <span>${i+1}</span>
                    </th>
                    <th>
                        <span>${j.userid}</span>
                    </th>
                    <th>
                        <span id="user_`+(i+1)+`"></span>
                    </th>
                     <th>
                        <span>${j.ssn}</span>
                    </th>
                   <th>
                        <span>${j.email}</span>
                    </th>
                    <th>
                        <span>${j.phoneNumber}</span>
                    </th>
                    <th>
                        <span>${j.registerDate}</span>
                    </th>
                </tr>
                `
				).appendTo('#userData')
			
				$(`<a>${j.name}</a>`) //??
				.css({cursor: 'pointer', color: 'blue'})
				.appendTo('#user_'+(i+1))
				.click(e => {
					$('#userData').empty()
					$(userVue.detail())
					.appendTo('#userData') //userData table에 detail을 넣는다
					$.getJSON(`/users/${j.userid}`, d=> { //왜?
						$('#userid').text(d.userid)
						$('#name').text(d.name)
						$('#ssn').text(d.ssn)
						$('#addr').text(d.addr)
						$('#email').text(d.email)
						$('#phoneNumber').text(d.phoneNumber)
						$('#registerDate').text(d.registerDate)
					})
				})
			})
		})
		.fail(()=>{
			alert(ERROR)
		})
	})
	$('.user_list').click(e => {
		e.preventDefault()
		location.href = '/admin'
	})
	$('.item_list').click(e => {
		e.preventDefault()
			setContentView()
			$('#content').empty()
			$('#content').html(
					`
					<table id="itemData">
						<tr>
							<td><a>분실물 ID</a></td>
							<td><a>습득물품명</a></td>
							<td><a>습득일자</a></td>
							<td><a>습득물분류</a></td>
							<td><a>습득위치(지하철)</a></td>
						</tr>
					</table>
                `
			)
			$.getJSON('/items', d => {
				$.each(d, (i, j) => {
					$(`
							<tr>
		                	<th>
		                        <span>${i+1}</span>
		                    </th>
		                    <th>
		                        <span>${j.itemId}</span>
		                    </th>
		                     <th>
		                        <span>${j.itemName}</span>
		                    </th>
		                   <th>
		                        <span>${j.takeDate}</span>
		                    </th>
		                    <th>
		                        <span>${j.category}</span>
		                    </th>
		                    <th>
		                        <span>${j.takePlace}</span>
		                    </th>
		                </tr>
		                `
						).appendTo('#itemData')
				})
			})
		})
	}

		let setContentView = () => {
			$('#userData tr').first().css({'background-color':'yellow'}) //굳이 first를 쓰는 이유
		}
		return {init}
})()