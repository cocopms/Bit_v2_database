"use strict"
var admin = admin || {}

admin = (() => {
	let init = () => { // 호출되는 함수
		onCreate()
	}
	let onCreate = () => { // 감춰지는 함수(clsoure, 보안)
		setContentView()
		$.getJSON('/users', d=> {
			$('#total_count').text('총 회원수 : '+d.length)
			$.each(d, (i, j) => { //왜?
			`
			<tr>
            	<td>
                    <span>${i+1}</span>
                </td>
                <td>
                    <span>${j.userid}</span>
                </td>
                <td>
                    <span id="user_`+(i+1)+`"></span>
                </td>
                 <td>
                    <span>${j.ssn}</span>
                </td>
               <td>
                    <span>${j.email}</span>
                </td>
                <td>
                    <span>${j.phoneNumber}</span>
                </td>
                <td>
                    <span>${j.registerDate}</span>
                </td>
            </tr>
            `
			}).appentTo('#userData')
			
			$(`<a>${j.name}</a>`) //??
			.css({cursor: 'pointer', color: 'blue'})
			.appendTo('#user_'+(i+1))
			.click(e => {
				alert(`${j.userid}`)
			})
		})
		let setContentView = () => {
			$('#userData tr').first().css({'background-color':'yellow'}) //굳이 first를 쓰는 이유
		}

	}
	return {init}
})()