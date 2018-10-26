$(function(){
	$.get( "/data.json", function(data){
		data.map((item, index) => {
			let pos = index + 1;
			addRow(pos, item.name, item.lovesShabbat);
		});
	});

	let tbody = $('#people-table tbody');
	function addRow(index, name, lovesShabbat) {
		let lovesShabbatPretty = lovesShabbat?'Да':'Нет';
		let pos = index?index:''
		tbody.append(`<tr><td>${pos}</td><td>${name}</td><td>${lovesShabbatPretty}</td></tr>`);
	}

	$('form').on('submit', function(event){
		event.preventDefault();

		let myPeopleGo = $(this).find('#name').val();
		let lovesShabbat = $(this).find('#loves-shabbat').is(':checked');

		addRow(false, myPeopleGo, lovesShabbat);
	});
	// $.ajax({
	// 	url: "/data.json",
	//     success: function(data) {
	//         console.log(data);
	//     },
	//     error: function(jqXHR, textStatus, errorThrown) {
	//         console.log(textStatus); //error logging
	//         console.log(errorThrown)
	//     }
	// });
});
