// Нужные функции
// 1 Сумма
// 2 Разница
// 3 Умножение
// 4 Деление

// 5 Квадратный корень
// 6 Остача от деления
// 7 Возвести в степень

// Отображать результат
// Входящие данные
// Выполняемая функция


// var plus = document.getElementsByClassName('operation')[0];
$(function(){
	var plus = $('.plus');
	var substract = $('.substract');
	var divide = $('.divide');
	var multiply = $('.multiply');
	var input = $('#input');
	var equal = $('#equal');

	var firstValue = null;
	var operation = null;
	var result = null;


	function action(op) {
			firstValue = Number.parseFloat(input.val());
			operation = op;
			input.val(null);
			input.attr('placeholder', String(firstValue) + ' ' + op);
	}

	plus.click(function(){
		action('+');
	});
	substract.click(function(){
		action('-');
	});
	multiply.click(function(){
		action('*');
	});
	divide.click(function(){
		action('/');
	});

	equal.click(function () {
		secondValue = Number.parseFloat(input.val());

		switch (operation) {
			case '+':
				result = firstValue + secondValue;
				break;
			case '-':	
				result = firstValue - secondValue;
				break;
			case '*':
				result = firstValue * secondValue;
				break;
			case '/':
				result = firstValue / secondValue;
				break;
		}

		input.val(result);
	});
});
