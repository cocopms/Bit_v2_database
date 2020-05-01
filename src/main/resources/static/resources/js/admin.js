"use strict"
var admin = admin || {}

admin = (() => {
	let init = () => { //호출되는 함수
		alert('1')
		onCreate()
	}
	let onCreate = () => { //감춰지는 함수(clsoure, 보안)
		alert('2')
	}
	return {init}
	
})()