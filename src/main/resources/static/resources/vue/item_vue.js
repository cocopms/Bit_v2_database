"use strict"
var itemVue = {
		item : () => {
			return `
			<table id="itemData">
					<tr>
						<th id="itemId">분실물ID</th>
						<th id="itemName">습득물품명</th>
						<th id="takeDate">습득일자</th>
						<th id="category">습득물분류</th>
						<th id="takePlace">습득위치(지하철)</th>
					</tr>
			</table>
			`
		}
}