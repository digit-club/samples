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


var plus = document.getElementsByClassName('operation')[0];
var substract = document.getElementsByClassName('operation')[1];
var multiply = document.getElementsByClassName('operation')[2];
var divide = document.getElementsByClassName('operation')[3];
var input = document.getElementById('input');
var equal = document.getElementById('equal');

var firstValue = null;
var operation = null;
var result = null;


function action(op) {
	return function() {
		firstValue = Number.parseFloat(input.value);
		operation = op;
		input.value = null;
		input.placeholder = String(firstValue) + ' ' + op
	}
}

plus.onclick = action('+');
substract.onclick = action('-');
multiply.onclick = action('*');
divide.onclick = action('/');


equal.onclick = function () {
	secondValue = Number.parseFloat(input.value);

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

	input.value = result;
}
