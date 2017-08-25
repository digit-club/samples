package sample;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BotDjigit {

    public final String commandSave = "сохрани:";
    public final String commandDance = "танцуй";
    public final String commandPlay = "играй";

    public String Do(String message) {

        // "сохрани: лалалалалал ыаыва"
        // "танцуй"
        // "привет Коля!"
        String[] parts = message.split(" ");
        // ["сохрани:", "лалалалалал", "ыаыва"]
        String firstWord = parts[0];

        switch (firstWord) {
            case commandSave:

                try( PrintWriter out = new PrintWriter( "bot-djigit.txt" ) ){
                    out.println( message );
                } catch (FileNotFoundException e) {
                    // HAHAHAH
                    System.out.println(e.getMessage());
                }

                return "сохранено, мой Господин!";

            case commandDance:
                System.out.println("Бот танцует.");
                return "танцую, мой Господин!";
            case commandPlay:
                return "Червону руту не шукай вечорамы...";
        }

        return "";
    }
}
