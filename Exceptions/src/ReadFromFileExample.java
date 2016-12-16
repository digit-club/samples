import java.io.*;
import java.util.Scanner;

public class ReadFromFileExample {

    public static void main(String[] args) {
        String filePath = "E:\\work\\tmp\\myFile.txt";
        File myFile = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(myFile));
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }

}
