package view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.HeroesOfMightButton;

import java.util.ArrayList;
import java.util.List;

public class ViewManager {
    private static final int HEIGHT = 800;
    private static final int WIDTH = 1200;
    private final AnchorPane mainPane;
    private final Scene mainScene;
    private final Stage mainStage;

    private final static int MENU_BUTTONS_START_X = WIDTH/6;
    private final static int MENU_BUTTONS_START_Y = 150;

    List<HeroesOfMightButton> menuButtons;

    public ViewManager(){
        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButton();
        createBackground();

    }

    public Stage getMainStage(){
        return mainStage;
    }

    private void addMenuButton(HeroesOfMightButton button){
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 150);
        menuButtons.add(button);
        mainPane.getChildren().add(button);
    }

    private void createButton(){
        createStartButton();
        createModeButton();
        createHowToButton();
        createExitButton();
    }

    private void createStartButton(){
        HeroesOfMightButton startButton = new HeroesOfMightButton("PLAY");
        addMenuButton(startButton);
    }

    private void createModeButton(){
        HeroesOfMightButton ModeButton = new HeroesOfMightButton("MODE");
        addMenuButton(ModeButton);
    }
    private void createHowToButton(){
        HeroesOfMightButton HowToButton = new HeroesOfMightButton("HOW TO");
        addMenuButton(HowToButton);
    }
    private void createExitButton(){
        HeroesOfMightButton ExitButton = new HeroesOfMightButton("EXIT");
        addMenuButton(ExitButton);
    }



    private void createBackground(){
        Image backgroundImage = new Image("grass.png",true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));


    }
}
