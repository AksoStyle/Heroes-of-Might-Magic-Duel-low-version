package main.kotprog;

import classes.Units.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.SpecButton;

import java.util.ArrayList;

import static main.kotprog.Globals.primaryStage;

public class Map {
    private static final int MAP_WIDTH = 12;
    private static final int MAP_HEIGHT = 10;

    Scene menu = Globals.primaryStage.getScene();
    Pane root = new Pane();


    Foldmuves foldmuves = new Foldmuves();
    Ijasz ijasz = new Ijasz();
    Griff griff = new Griff();
    Cica cica = new Cica();
    PancelosCica pancelosCica = new PancelosCica();
    ArrayList<Unit> units = new ArrayList<Unit>();






    //------------------------------>
        //Label mana = new Label("Mana: ");
        //mana.setLayoutX(30);
        //mana.setLayoutY(30);
        //root.getChildren().addAll(mana);
        //scene.getStylesheets().add("grid-with-borders.css");
        //Image backgroundImage = new Image("grass.png",true);
        //root.setBackground(new Background(new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, null, null)));
        //Globals.primaryStage.setScene(new Scene(root, 1200 , 800));
    }

