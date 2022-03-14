package com.example.kotprog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Group root = new Group();
        Scene scene = new Scene(root, 1500, 800);
        stage.setTitle("Heroes of Might & Magic - Duel low version"); // title
        stage.getIcons().add(new Image("file:icon.png")); // icon for the program
        Button btn = new Button();
        btn.setLayoutY(100);
        btn.setLayoutY(200);
        btn.setText("ASd");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}