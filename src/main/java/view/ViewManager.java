package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.kotprog.Globals;
import model.HeroesOfMightButton;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

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
        mainPane.getChildren().add(Globals.GlobalImgView);

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
        //start --> game starts and getting ready to be played
    private void createStartButton(){
        HeroesOfMightButton startButton = new HeroesOfMightButton("PLAY");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Scene menu = Globals.primaryStage.getScene();
                Pane root = new Pane();
                HeroesOfMightButton exitButtonFromGame = new HeroesOfMightButton("EXIT");
                exitButtonFromGame.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Alert alertBox = new Alert(Alert.AlertType.CONFIRMATION, "Biztosan ki akarsz lépni a játékból?", ButtonType.YES, ButtonType.NO);
                        alertBox.setTitle("Játék elhagyása.");
                        alertBox.setHeaderText("");
                        Optional<ButtonType> result = alertBox.showAndWait();
                        ButtonType button = result.orElse(ButtonType.NO);
                        if(button == ButtonType.YES){
                            Globals.primaryStage.setScene(menu);
                        }
                        else{
                            alertBox.close();
                        }


                    }
                });
                Image backgroundImage = new Image("grass.png",true);
                root.setBackground(new Background(new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, null, null)));
                exitButtonFromGame.setLayoutX(0);
                exitButtonFromGame.setLayoutY(0);
                root.getChildren().add(exitButtonFromGame);
                Globals.primaryStage.setScene(new Scene(root, WIDTH , HEIGHT));
            }
        });
        addMenuButton(startButton);
    }

    private void createModeButton(){
        HeroesOfMightButton ModeButton = new HeroesOfMightButton("MODE");
        ModeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Scene menu = Globals.primaryStage.getScene();
                Pane root = new Pane();
                //easy button
                HeroesOfMightButton easyButton = new HeroesOfMightButton("EASY");
                easyButton.setLayoutX(MENU_BUTTONS_START_X);
                easyButton.setLayoutY(MENU_BUTTONS_START_Y);
                easyButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Globals.difficulty = 1;
                        System.out.println(Globals.difficulty);
                        setDifficultyBackground();
                        Globals.primaryStage.setScene(menu);

                    }
                });

                root.getChildren().add(easyButton);

                //medium button
                HeroesOfMightButton mediumButton = new HeroesOfMightButton("MEDIUM");
                mediumButton.setLayoutX(MENU_BUTTONS_START_X);
                mediumButton.setLayoutY(MENU_BUTTONS_START_Y+150);
                mediumButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Globals.difficulty = 2;
                        System.out.println(Globals.difficulty);
                        setDifficultyBackground();
                        Globals.primaryStage.setScene(menu);
                    }
                });

                root.getChildren().add(mediumButton);

                //hard button
                HeroesOfMightButton hardButton = new HeroesOfMightButton("HARD");
                hardButton.setLayoutX(MENU_BUTTONS_START_X);
                hardButton.setLayoutY(MENU_BUTTONS_START_Y+300);
                hardButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Globals.difficulty = 3;
                        System.out.println(Globals.difficulty);
                        setDifficultyBackground();
                        Globals.primaryStage.setScene(menu);
                    }
                });
                root.getChildren().add(hardButton);
                Image backgroundImage = new Image("grass.png",true);
                root.setBackground(new Background(new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, null, null)));
                Globals.primaryStage.setScene(new Scene(root, WIDTH , HEIGHT));
            }
        });
        addMenuButton(ModeButton);
    }
    private void createHowToButton(){
        HeroesOfMightButton HowToButton = new HeroesOfMightButton("HOW TO");
        HowToButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Scene menu = Globals.primaryStage.getScene();
                Pane root = new Pane();
                Image backgroundImage = new Image("grass.png",true);
                root.setBackground(new Background(new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, null, null)));
                Text text = new Text("random szöveg");
                root.getChildren().add(text);

                Globals.primaryStage.setScene(new Scene(root, WIDTH , HEIGHT));

                }
        });
        addMenuButton(HowToButton);
    }
    private void createExitButton(){
        HeroesOfMightButton ExitButton = new HeroesOfMightButton("EXIT");
        ExitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainStage.close();
            }
        });
        addMenuButton(ExitButton);
    }



    private void createBackground(){
        Image backgroundImage = new Image("grass.png",true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));


    }

    private void setDifficultyBackground(){



        Image easyImage = new Image("easy.png");
        Image mediumImage = new Image("medium.png");
        Image hardImage = new Image("hard.png");
        Globals.GlobalImgView.setFitHeight(400);
        Globals.GlobalImgView.setFitWidth(400);
        Globals.GlobalImgView.setLayoutX(600);
        Globals.GlobalImgView.setLayoutY(250);

        if (Globals.difficulty == 1){

            Globals.GlobalImgView.setImage(easyImage);
        }
        if(Globals.difficulty == 2){

            Globals.GlobalImgView.setImage(mediumImage);
        }
        if(Globals.difficulty == 3){

            Globals.GlobalImgView.setImage(hardImage);
        }



    }
}
