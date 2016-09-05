package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    private  static String rsc = "rsc/";
    static String [] files = new String[]{
        "data1.txt",
        "data2.txt",
        "data3.txt",
        "data4.txt"
    };

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        long start = System.currentTimeMillis();
        countWorder();
        long end = System.currentTimeMillis();
        System.out.println("Time spent: " + (end - start));


        start = System.currentTimeMillis();
        concurrentWordCount();
        end = System.currentTimeMillis();
        System.out.println("Time spent: " + (end - start));

    }

    private static void concurrentWordCount() throws InterruptedException {
        Vector<String> vector = new Vector<>();

        List<Thread> threads = new ArrayList<>();
        for (String fileName : files) {
            threads.add(new Thread(new ReadFileTask(fileName, vector)));
        }
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }
        System.out.println("Total word count = " + vector.size());

        //2

        int[] lengths = new int[32];
        threads = new ArrayList<>();
        int step = vector.size() / 4;
        int start = 0;
        int end = step;
        for (int i = 0; i < 4; i++) {
            threads.add(new Thread(new WordCountTask(vector, lengths, start, end)));
            start = end;
            end += step;
        }
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }
        // 3
        for (int x = 0; x < lengths.length; x++) {
            System.out.printf("%d : %d\n", x, lengths[x]);
        }
    }

    public static void countWorder() throws FileNotFoundException {
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            try(Scanner scanner = new Scanner(new FileInputStream(rsc+files[i]))) {
                while (scanner.hasNext()) {
                    strings.add(scanner.next());
                }
                System.out.println("We are read file " + i + ".");
            }
        }

        System.out.println("Total words count = " + strings.size());

        int[] lengths = new int[32];
        for(String str : strings) {
            lengths[str.length()]++;
        }
        for (int x = 0; x < lengths.length; x++) {
            System.out.printf("%d : %d\n", x, lengths[x]);
        }
    }

    private static class ReadFileTask implements Runnable {

        String fileName;
        Vector<String> vector;

        public ReadFileTask(String fileName, Vector<String> vector) {
            super();
            this.fileName = fileName;
            this.vector = vector;
        }

        @Override
        public void run() {
            try(Scanner scanner = new Scanner(new FileInputStream(rsc + fileName))) {
                while (scanner.hasNext()) {
                    vector.add(scanner.next());
                }
                System.out.println("We have read a file '" + fileName + "'.");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static class WordCountTask implements Runnable{

        Vector<String> vector;
        int[] lengths;
        int start; //inclusive
        int end; // excluse

        public WordCountTask(Vector<String> vector, int[] length, int start, int end) {
            this.vector = vector;
            this.start = start;
            this.end = end;
            this.lengths = length;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                lengths[vector.get(i).length()]++;
            }
        }

    }

}
