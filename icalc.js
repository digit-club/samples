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


console.log('Yo! DigIT!');

var plus = document.getElementsByClassName('operation')[0];
var firstValue = 0;

plus.onclick = function () {
	var input = document.getElementById('input');

	if (firstValue != '') {
		alert(Number.parseInt(firstValue) + Number.parseInt(input.value))
	} else {
		firstValue = input.value;
		input.value = '';
	} 

	
}
