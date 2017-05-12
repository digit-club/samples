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

import java.io.File;
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

        Text title = new Text("Please specify paths:");
        grid.add(title, 0, 0/*, 2, 1*/);

        Label source = new Label("Source:");
        grid.add(source, 0, 1);
        TextField sourceTextField = new TextField();
        grid.add(sourceTextField, 1, 1);

        Label target = new Label("Target:");
        grid.add(target, 2, 1);
        TextField targetTextField = new TextField();
        grid.add(targetTextField, 3, 1);

        Button btnCopy = new Button("Copy");
        Button btnCancel = new Button("Cancel");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(btnCopy);
        hbBtn.getChildren().add(btnCancel);
        grid.add(hbBtn, 5, 1);

        final Text resultMessage = new Text();

        btnCopy.setOnMouseClicked(e -> {
            String sourcePath = sourceTextField.getText();
            String targetPath = targetTextField.getText();
            System.out.println("Source : " + sourcePath);
            System.out.println("Target : " + targetPath);
            try {
                validate(sourcePath, targetPath);
                // TODO update target path if directory
                Files.copy(Paths.get(sourcePath), Paths.get(targetPath));
                resultMessage.setFill(Color.GREEN);
                resultMessage.setText("File was copied.");
            } catch (IOException exception) {
                exception.printStackTrace();
                resultMessage.setFill(Color.RED);
                resultMessage.setText("Error: " + exception.getClass() + ": " + exception.getMessage());
            } catch (ValidationException validationException) {
                resultMessage.setFill(Color.RED);
                resultMessage.setText(validationException.getMessage());
            }
        });

        btnCancel.setOnMouseClicked(e -> {
            sourceTextField.clear();
            targetTextField.clear();
        });

        VBox vBox = new VBox();
        vBox.getChildren().add(grid);
        vBox.getChildren().add(resultMessage);

        StackPane rootPane = new StackPane();
        rootPane.getChildren().add(vBox);

        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void validate(String source, String target) throws ValidationException {
        File sourceFile = new File(source);
        if (!sourceFile.exists()) {
            throw new ValidationException("Source file doesn't exist!");
        } else if (sourceFile.isDirectory()) {
            throw new ValidationException("Source is not a file!");
        }
    }

    private class ValidationException extends Exception {
        private String message;

        public ValidationException(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }
}
