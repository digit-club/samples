package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.*;
import java.util.ArrayList;


public class Controller {

    @FXML
    private TextArea chatBox;

    @FXML
    private TextField messageBox;

    private List<String> db;
    private MyClient client;

    public Controller() {
    }

    @FXML
    private void initialize() throws IOException {
        db = new ArrayList<>();
        client = new MyClient();
        client.setController(this);
        chatBox.setText(getDbText());
    }

    @FXML
    public void onEnter(ActionEvent event) throws IOException {
        String message = messageBox.getCharacters().toString();

        db.add("Me: " + message);
        messageBox.clear();

        chatBox.setText(getDbText());

        client.send(message);
    }

    private String getDbText()
    {
        StringBuffer sb = new StringBuffer();
        db.forEach(s -> sb.append(s).append("\n"));
        return sb.toString();
    }

    public TextField getMessageBox()
    {
        return messageBox;
    }

    public TextArea getChatBox(){
        return chatBox;
    }

    public void addMessage(String s) {
        db.add(s);
    }

    public void refresh(){
        chatBox.setText(getDbText());
    }
}
