package main.kotprog;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.awt.image.BufferedImage;

import static main.kotprog.Globals.primaryStage;

public class Map {
    private static final int MAP_WIDTH = 12;
    private static final int MAP_HEIGHT = 10;

    private StackPane createCell(BooleanProperty cellSwitch) {

        StackPane cell = new StackPane();

        cell.setOnMouseClicked(e -> cellSwitch.set(! cellSwitch.get() ));

        Circle circle = new Circle(10, Color.CORNFLOWERBLUE);

        circle.visibleProperty().bind(cellSwitch);

        cell.getChildren().add(circle);
        cell.getStyleClass().add("cell");
        return cell;
    }

    private GridPane createGrid(BooleanProperty[][] switches) {

        int numCols = switches.length ;
        int numRows = switches[0].length ;

        GridPane grid = new GridPane();

        for (int x = 0 ; x < numCols ; x++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(cc);
        }

        for (int y = 0 ; y < numRows ; y++) {
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setVgrow(Priority.ALWAYS);
            grid.getRowConstraints().add(rc);
        }

        for (int x = 0 ; x < numCols ; x++) {
            for (int y = 0 ; y < numRows ; y++) {
                grid.add(createCell(switches[x][y]), x, y);
            }
        }

        grid.getStyleClass().add("grid");
        return grid;
    }

    public void gamemapstart(){
        int numCols = MAP_WIDTH ;
        int numRows = MAP_HEIGHT ;

        BooleanProperty[][] switches = new BooleanProperty[numCols][numRows];
        for (int x = 0 ; x < numCols ; x++) {
            for (int y = 0 ; y < numRows ; y++) {
                switches[x][y] = new SimpleBooleanProperty();
            }
        }
        Image backgroundImage = new Image("grass.png",true);
        GridPane grid = createGrid(switches);


        StackPane root = new StackPane(grid);





        Scene scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add("grid-with-borders.css");
        root.setBackground(new Background(new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, null, null)));
        primaryStage.setScene(scene);
        primaryStage.show();
    }





}
