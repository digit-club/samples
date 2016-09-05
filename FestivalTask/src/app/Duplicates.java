package app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Duplicates {

    public static void main(String[] args) {
        String [] names = new String[] {
          "Вася", "Петя", "Жора", "Инна", "Лера", "Петя", "Саша", "Инна", "Лена", "Вася"
        };
        System.out.println(Arrays.toString(names));

        //remove duplicates
        Set<String> namesSet = new HashSet<>();
        namesSet.addAll(Arrays.asList(names));
        System.out.println(namesSet);
    }

}
