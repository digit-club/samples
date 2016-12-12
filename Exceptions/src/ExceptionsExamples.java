import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsExamples {

    public static void main(String[] args) {
    }

    // checked
    public static void fileNotFoundExample() throws FileNotFoundException {
        File file = new File("D://file.txt");
        FileReader fileReader = new FileReader(file);
    }

    //error, unchecked
    public static void stackOverflowExample() {
        stackOverflowExample();
    }

    //runtime, unchecked
    public static void nullPointerExample(){
        Object object = null;
        object.toString();
    }

    //runtime, unchecked
    public static void indexOutOfBoundExample() {
        int num[] = {1, 2, 3, 4};
        System.out.println(num[5]);
    }

    //runtime, unchecked
    public static void zeroDevisionExample(){
        int i = 10 / 0;
    }

}
