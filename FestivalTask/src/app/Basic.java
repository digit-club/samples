package app;

public class Basic {

    public static void main(String[] args) {
        int n = 10;

        System.out.println("Задача-1: Вывести на экран слово 'Радость' " + n + " раз.");
        for (int i = 0; i < n; i++) {
            System.out.print(n + ". Joy! ");
        }
        System.out.println();

        //Задача-2: Если n больше 10 вывести его на экран
        if (n > 10) {
            System.out.println("n=" + n);
        }

        //Задача-3: Выяснить, делиться ли число n на 2
        System.out.println("Задача-3: Выяснить, парное ли число " + n);
        boolean odd = n % 2 == 1;
        System.out.println("Число n парное: " + (odd ? " нет" : " да") + ".");
    }

}
