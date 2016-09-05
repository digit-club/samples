package app;

public class Basic {

    public static void main(String[] args) {
        int n = 10;

        System.out.println("Задача-1: Вывести на экран слова 'Jewish open space!' " + n + " раз.");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + ". Jewish open space!");
        }

        System.out.println("Задача-2: Если n больше 10 вывести его на экран.");
        if (n > 10) {
            System.out.println("n=" + n);
        }

        System.out.println("Задача-3: Выяснить, парное ли число " + n);
        boolean odd = n % 2 == 1;
        System.out.println("Число n : " + (odd ? "непарное." : "парное."));
    }

}
