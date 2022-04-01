package main.kotprog;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import view.ViewManager;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

    try{
        ViewManager manager = new ViewManager();
        primaryStage = manager.getMainStage();
        primaryStage.setResizable(false);
        primaryStage.show();
        Globals.primaryStage = primaryStage;
    } catch(Exception e){
        e.printStackTrace();
    }
        //TITLE
        primaryStage.setTitle("heroes of Might & Magic - Duel low version");
        //TITLE END
        // ICON
        Image icon = new Image("file:icon.png");
        primaryStage.getIcons().add(icon);
        // ICON END


    }

    public static void main(String[] args) {
        launch(args);
    }
}