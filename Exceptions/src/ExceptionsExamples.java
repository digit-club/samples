import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ExceptionsExamples {

    public static void main(String[] args) {
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public static void fileNotFoundExample() throws FileNotFoundException {
        FileReader fileReader = new FileReader(new File("D://file.txt"));
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

    /**
     * @throws ArithmeticException
     */
    public static void zeroDevisionExample(){
        int i = 10 / 0;
    }

}
