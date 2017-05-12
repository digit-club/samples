package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Copy file");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Please specify paths:");
        grid.add(scenetitle, 0, 0/*, 2, 1*/);

        Label userName = new Label("Source:");
        grid.add(userName, 0, 1);
        TextField sourceTextField = new TextField();
        grid.add(sourceTextField, 1, 1);

        Label pw = new Label("Target:");
        grid.add(pw, 2, 1);
        TextField targetTextField = new TextField();
        grid.add(targetTextField, 3, 1);

        Button btn = new Button("Copy");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 5, 1);

        final Text actiontarget = new Text();
        btn.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                String source = sourceTextField.getText();
                String target = targetTextField.getText();
                System.out.println("Source : " + source);
                System.out.println("Target : " + target);
                try {
                    Files.copy(Paths.get(source), Paths.get(target));

                } catch (IOException exception) {
                    exception.printStackTrace();
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Error: " + exception.getClass() + ": " + exception.getMessage());
                    return;
                }
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("File was copied.");
            }
        });
        VBox vBox = new VBox();
        vBox.getChildren().add(grid);
        vBox.getChildren().add(actiontarget);

        StackPane rootPane = new StackPane();
        rootPane.getChildren().add(vBox);
        Scene scene = new Scene(rootPane/*, 300, 275*/);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
