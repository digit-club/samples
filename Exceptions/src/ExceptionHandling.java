import java.io.FileNotFoundException;

public class ExceptionHandling {

    public static void main(String[] args) {

        //checked try
        try {
            ExceptionsExamples.fileNotFoundExample();
        } catch (FileNotFoundException e) {
            System.out.println("Catched " + e.getMessage());
        }

        // unchecked try
        try {
            ExceptionsExamples.stackOverflowExample();
        } catch (StackOverflowError error) {
            System.out.println("Catched " + error.toString());
        }

        //multicatch
        try {
            ExceptionsExamples.zeroDevisionExample();
            ExceptionsExamples.nullPointerExample();
        } catch (ArithmeticException | NullPointerException e){
            System.out.println("Catched " + e.toString());
        }

        //nested try
        try {
            try {
                ExceptionsExamples.nullPointerExample();
            } catch (NullPointerException e) {
                System.out.println("Catched " + e.toString());
            }
            ExceptionsExamples.zeroDevisionExample();
        } catch (ArithmeticException e){
            System.out.println("Catched " + e.toString());
        }

        // finally with catch
        try {
            ExceptionsExamples.nullPointerExample();
        } catch (NullPointerException error) {
            System.out.println("Catched " + error.toString());
        } finally {
            System.out.println("In finally block.");
        }

        //finally without catch. Program terminates.
        try {
            ExceptionsExamples.nullPointerExample();
        } finally {
            System.out.println("In finally block.");
        }

        //custom exception
        try {
            catchAndThrowExample();
        } catch (BadCodeException e) {
            System.out.println(e.toString());
        }
    }

    public static void catchAndThrowExample() throws BadCodeException{
        // finally with catch
        try {
            ExceptionsExamples.nullPointerExample();
        } catch (StackOverflowError error) {
            System.out.println("Catched " + error.toString());
            System.out.println("Throwing custom exception");
            throw new BadCodeException();
        }
    }

    private static class BadCodeException extends Exception{
    }

}
