package view;

import classes.Enemy;
import classes.Hero;
import classes.Units.*;
import classes.magics.VillamCsapas;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.kotprog.Globals;
import model.HeroesOfMightButton;
import model.SpecButton;

import java.util.*;

public class ViewManager {
    private static final int HEIGHT = 800;
    private static final int WIDTH = 1200;
    private final AnchorPane mainPane;
    private final Scene mainScene;
    private final Stage mainStage;
    private GridPane grid;


    private int foldmuvesAmount = 0;
    private int ijaszAmount = 0;
    private int griffAmount = 0;
    private int cicaAmount = 0;
    private int armourdercicaamount = 0;

    private int villamcsapasamount = 0;
    private int tuzlabdaamount = 0;
    private int feltamasztasamount = 0;
    private int bonusamount = 0;
    private int doublehealamount = 0;

    private final static int MENU_BUTTONS_START_X = WIDTH/6;
    private final static int MENU_BUTTONS_START_Y = 150;

    List<HeroesOfMightButton> menuButtons;
    Foldmuves foldmuves = new Foldmuves();
    Ijasz ijasz = new Ijasz();
    Griff griff = new Griff();
    Cica cica = new Cica();
    PancelosCica panceloscica = new PancelosCica();

    public ViewManager(){
        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButton();
        createBackground();
        CreateMainLabelText();
        mainPane.getChildren().add(Globals.GlobalImgView);
        grid = new GridPane();

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
                exitButtonFromGame.setLayoutX(0);
                exitButtonFromGame.setLayoutY(0);
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
                HeroesOfMightButton startGameButton = new HeroesOfMightButton("Start");
                startGameButton.setLayoutX(1009);
                startGameButton.setLayoutY(0);

                startGameButton.setVisible(false);

                startGameButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Enemy randomenemy = new Enemy(1,1,1,1,1,1,0,0,0,0,0);
                        System.out.println(randomenemy);

                        for (int i = 0; i < randomenemy.enemyUnits.size(); i++){
                            Random rnd = new Random();
                            randomenemy.enemyUnits.get(i).x_pos = rnd.nextInt(10, 11+1);
                            randomenemy.enemyUnits.get(i).y_pos = rnd.nextInt(0, 10);
                            grid.add(randomenemy.enemyUnits.get(i).getImage(), randomenemy.enemyUnits.get(i).x_pos, randomenemy.enemyUnits.get(i).y_pos);
                            System.out.println("Az ellenséges " + randomenemy.enemyUnits.get(i).getName() + ", Pozíciója: X: "+ randomenemy.enemyUnits.get(i).x_pos +", Y: "+ randomenemy.enemyUnits.get(i).y_pos);





                            //if (!grid.getChildren().contains(randomenemy.enemyUnits.get(i).getImage())){
                            //   grid.add(randomenemy.enemyUnits.get(i).getImage(), randomenemy.enemyUnits.get(i).x_pos, randomenemy.enemyUnits.get(i).y_pos);
                            //}

                            /*
                            if (grid.getChildren().contains(randomenemy.enemyUnits.get(i).getImage())){
                                randomenemy.enemyUnits.get(i).x_pos = rnd.nextInt(10, 11+1);
                                randomenemy.enemyUnits.get(i).y_pos = rnd.nextInt(0, 10);
                                grid.add(randomenemy.enemyUnits.get(i).getImage(), randomenemy.enemyUnits.get(i).x_pos, randomenemy.enemyUnits.get(i).y_pos);
                                System.out.println("Az ellenséges " + randomenemy.enemyUnits.get(i).getName() + ", Pozíciója: X: "+ randomenemy.enemyUnits.get(i).x_pos +", Y: "+ randomenemy.enemyUnits.get(i).y_pos);
                            }
                            else{
                                grid.add(randomenemy.enemyUnits.get(i).getImage(), randomenemy.enemyUnits.get(i).x_pos, randomenemy.enemyUnits.get(i).y_pos);
                                System.out.println("Az ellenséges " + randomenemy.enemyUnits.get(i).getName() + ", Pozíciója: X: "+ randomenemy.enemyUnits.get(i).x_pos +", Y: "+ randomenemy.enemyUnits.get(i).y_pos);
                            }

                             */


                        }


                        //System.out.println(Arrays.toString(randomenemy.enemyUnits.toArray()));


                        Pane root = new Pane();


                        // save menu
                        Scene menu = Globals.primaryStage.getScene();;

                        // save menu end
                        // bg image
                        Image backgroundImage = new Image("grass.png",true);
                        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
                        root.setBackground(new Background(background));
                        // bg image end

                        grid.setAlignment(Pos.CENTER_RIGHT);
                        HBox hbox = new HBox(root, grid);
                        hbox.setBackground(new Background(background));




                        // grid for the map
                        int rows = 10;

                        int columns = 12;

                        for(int i = 0; i < columns; i++) {
                            ColumnConstraints column = new ColumnConstraints(55);
                            grid.getColumnConstraints().add(column);

                        }
                        for(int i = 0; i < rows; i++) {
                            RowConstraints row = new RowConstraints(55);
                            grid.getRowConstraints().add(row);
                        }


                        /*
                        grid.setOnMouseClicked(new EventHandler<MouseEvent>() {

                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                if (mouseEvent.getY() > 675 || mouseEvent.getY() < 125){
                                    return;
                                }
                                int tmpy = (int)Math.floor((mouseEvent.getY()-125) / 55);
                                int tmpx = (int)Math.floor(mouseEvent.getX() / 55);
                                System.out.println(tmpx + " : " + tmpy);

                                addPictureToCell(tmpx, tmpy,  foldmuves.getImage());
                            }
                        });
                        */

                        grid.setStyle("-fx-grid-lines-visible: true");



                        //Buttons-Labels -  HUD ---------------------------------------------->
                        //Units
                        Label Units = new Label("Egységek kiválasztása:");
                        Units.setLayoutX(0);
                        Units.setLayoutY(0);
                        Units.setFont(new Font("Cardinal", 30));
                        root.getChildren().add(Units);
                        if (foldmuvesAmount != 0){
                            SpecButton fmb = new SpecButton("F");
                            fmb.setLayoutX(0);
                            fmb.setLayoutY(100);
                            root.getChildren().add(fmb);
                            fmb.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {

                                    grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {

                                            if (mouseEvent.getY() > 675 || mouseEvent.getY() < 125){
                                                return;
                                            }
                                            int tmpy = (int)Math.floor((mouseEvent.getY()-125) / 55);
                                            int tmpx = (int)Math.floor(mouseEvent.getX() / 55);
                                            foldmuves.x_pos = tmpx;
                                            foldmuves.y_pos = tmpy;
                                            if (foldmuves.x_pos == ijasz.x_pos && foldmuves.y_pos == ijasz.y_pos){
                                                return;
                                            }
                                            if (foldmuves.x_pos == griff.x_pos && foldmuves.y_pos == griff.y_pos){
                                                return;
                                            }
                                            if (foldmuves.x_pos == cica.x_pos && foldmuves.y_pos == cica.y_pos){
                                                return;
                                            }
                                            if (foldmuves.x_pos == panceloscica.x_pos && foldmuves.y_pos == panceloscica.y_pos){
                                                 return;
                                            }
                                            if (tmpx < 2 ){

                                                addPictureToCell(foldmuves.x_pos, foldmuves.y_pos,  foldmuves.getImage());

                                                System.out.println("Földműves elhelyezve a " + foldmuves.x_pos + " : " + foldmuves.y_pos + " Koordinátára.");
                                                System.out.println("Ijász pozíció jelenleg: " + ijasz.x_pos + " : " + ijasz.y_pos);
                                                System.out.println("Griff pozíció jelenleg: " + griff.x_pos + " : " + griff.y_pos);
                                                System.out.println("Cica pozíció jelenleg: " + cica.x_pos + " : " + cica.y_pos);
                                                System.out.println("Páncéloscica pozíció jelenleg: " + panceloscica.x_pos + " : " + panceloscica.y_pos);
                                                fmb.setVisible(false);
                                                grid.setOnMouseClicked(null);
                                            }



                                        }

                                    });

                                }
                            });



                        }
                        if (ijaszAmount != 0){
                            SpecButton ijb = new SpecButton("I");
                            ijb.setLayoutX(55);
                            ijb.setLayoutY(100);
                            root.getChildren().add(ijb);
                            ijb.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {

                                    grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {

                                            if (mouseEvent.getY() > 675 || mouseEvent.getY() < 125){
                                                return;
                                            }
                                            int tmpy = (int)Math.floor((mouseEvent.getY()-125) / 55);
                                            int tmpx = (int)Math.floor(mouseEvent.getX() / 55);
                                            ijasz.x_pos = tmpx;
                                            ijasz.y_pos = tmpy;
                                            if (ijasz.x_pos == foldmuves.x_pos && ijasz.y_pos == foldmuves.y_pos){
                                                return;
                                            }
                                            if (ijasz.x_pos == griff.x_pos && ijasz.y_pos == griff.y_pos){
                                                return;
                                            }
                                            if (ijasz.x_pos == cica.x_pos && ijasz.y_pos == cica.y_pos){
                                                return;
                                            }
                                            if (ijasz.x_pos == panceloscica.x_pos && ijasz.y_pos == panceloscica.y_pos){
                                                return;
                                            }
                                            if (tmpx < 2 ){

                                                addPictureToCell(ijasz.x_pos, ijasz.y_pos,  ijasz.getImage());

                                                System.out.println("Ijász elhelyezve a " + tmpx + " : " + tmpy + " Koordinátára."); System.out.println("Földműves elhelyezve a " + foldmuves.x_pos + " : " + foldmuves.y_pos + " Koordinátára.");
                                                System.out.println("Földműves pozíció jelenleg: " + foldmuves.x_pos + " : " + foldmuves.y_pos);
                                                System.out.println("Griff pozíció jelenleg: " + griff.x_pos + " : " + griff.y_pos);
                                                System.out.println("Cica pozíció jelenleg: " + cica.x_pos + " : " + cica.y_pos);
                                                System.out.println("Páncéloscica pozíció jelenleg: " + panceloscica.x_pos + " : " + panceloscica.y_pos);
                                                ijb.setVisible(false);
                                                grid.setOnMouseClicked(null);
                                            }



                                        }

                                    });

                                }
                            });
                        }
                        if (griffAmount != 0){
                            SpecButton gb = new SpecButton("G");
                            gb.setLayoutX(110);
                            gb.setLayoutY(100);
                            root.getChildren().add(gb);
                            gb.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {

                                    grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {

                                            if (mouseEvent.getY() > 675 || mouseEvent.getY() < 125){
                                                return;
                                            }
                                            int tmpy = (int)Math.floor((mouseEvent.getY()-125) / 55);
                                            int tmpx = (int)Math.floor(mouseEvent.getX() / 55);
                                            griff.x_pos = tmpx;
                                            griff.y_pos = tmpy;
                                            if (griff.x_pos == foldmuves.x_pos && griff.y_pos == foldmuves.y_pos){
                                                return;
                                            }
                                            if (griff.x_pos == ijasz.x_pos && griff.y_pos == ijasz.y_pos){
                                                return;
                                            }
                                            if (griff.x_pos == cica.x_pos && griff.y_pos == cica.y_pos){
                                                return;
                                            }
                                            if (griff.x_pos == panceloscica.x_pos && griff.y_pos == panceloscica.y_pos){
                                                return;
                                            }
                                            if (tmpx < 2 ){

                                                addPictureToCell(griff.x_pos, griff.y_pos,  griff.getImage());

                                                System.out.println("Griff elhelyezve a " + tmpx + " : " + tmpy + " Koordinátára.");
                                                System.out.println("Földműves pozíció jelenleg: " + foldmuves.x_pos + " : " + foldmuves.y_pos);
                                                System.out.println("Ijász pozíció jelenleg: " + ijasz.x_pos + " : " + ijasz.y_pos);
                                                System.out.println("Cica pozíció jelenleg: " + cica.x_pos + " : " + cica.y_pos);
                                                System.out.println("Páncéloscica pozíció jelenleg: " + panceloscica.x_pos + " : " + panceloscica.y_pos);
                                                gb.setVisible(false);
                                                grid.setOnMouseClicked(null);
                                            }



                                        }

                                    });

                                }
                            });
                        }
                        if (cicaAmount != 0){
                            SpecButton cb = new SpecButton("C");
                            cb.setLayoutX(165);
                            cb.setLayoutY(100);
                            root.getChildren().add(cb);
                            cb.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {

                                    grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {

                                            if (mouseEvent.getY() > 675 || mouseEvent.getY() < 125){
                                                return;
                                            }
                                            int tmpy = (int)Math.floor((mouseEvent.getY()-125) / 55);
                                            int tmpx = (int)Math.floor(mouseEvent.getX() / 55);
                                            cica.x_pos = tmpx;
                                            cica.y_pos = tmpy;
                                            if (cica.x_pos == foldmuves.x_pos && cica.y_pos == foldmuves.y_pos){
                                                return;
                                            }
                                            if (cica.x_pos == ijasz.x_pos && cica.y_pos == ijasz.y_pos){
                                                return;
                                            }
                                            if (cica.x_pos == griff.x_pos && cica.y_pos == griff.y_pos){
                                                return;
                                            }
                                            if (cica.x_pos == panceloscica.x_pos && cica.y_pos == panceloscica.y_pos){
                                                return;
                                            }
                                            if (tmpx < 2 ){

                                                addPictureToCell(cica.x_pos, cica.y_pos,  cica.getImage());

                                                System.out.println("Cica elhelyezve a " + tmpx + " : " + tmpy + " Koordinátára.");
                                                System.out.println("Földműves pozíció jelenleg: " + foldmuves.x_pos + " : " + foldmuves.y_pos);
                                                System.out.println("Ijász pozíció jelenleg: " + ijasz.x_pos + " : " + ijasz.y_pos);
                                                System.out.println("Griff pozíció jelenleg: " + griff.x_pos + " : " + griff.y_pos);
                                                System.out.println("Páncéloscica pozíció jelenleg: " + panceloscica.x_pos + " : " + panceloscica.y_pos);
                                                cb.setVisible(false);
                                                grid.setOnMouseClicked(null);
                                            }



                                        }

                                    });

                                }
                            });
                        }
                        if (armourdercicaamount != 0){
                            SpecButton acb = new SpecButton("P");
                            acb.setLayoutX(220);
                            acb.setLayoutY(100);
                            root.getChildren().add(acb);
                            acb.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {

                                    grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {

                                            if (mouseEvent.getY() > 675 || mouseEvent.getY() < 125){
                                                return;
                                            }
                                            int tmpy = (int)Math.floor((mouseEvent.getY()-125) / 55);
                                            int tmpx = (int)Math.floor(mouseEvent.getX() / 55);
                                            panceloscica.x_pos = tmpx;
                                            panceloscica.y_pos = tmpy;
                                            if (panceloscica.x_pos == foldmuves.x_pos && panceloscica.y_pos == foldmuves.y_pos){
                                                return;
                                            }
                                            if (panceloscica.x_pos == ijasz.x_pos && panceloscica.y_pos == ijasz.y_pos){
                                                return;
                                            }
                                            if (panceloscica.x_pos == griff.x_pos && panceloscica.y_pos == griff.y_pos){
                                                return;
                                            }
                                            if (panceloscica.x_pos == cica.x_pos && cica.y_pos == panceloscica.y_pos){
                                                return;
                                            }
                                            if (tmpx < 2 ){

                                                addPictureToCell(panceloscica.x_pos, panceloscica.y_pos,  panceloscica.getImage());
                                                System.out.println("PáncélosCica elhelyezve a " + tmpx + " : " + tmpy + " Koordinátára.");
                                                System.out.println("Földműves pozíció jelenleg: " + foldmuves.x_pos + " : " + foldmuves.y_pos);
                                                System.out.println("Ijász pozíció jelenleg: " + ijasz.x_pos + " : " + ijasz.y_pos);
                                                System.out.println("Griff pozíció jelenleg: " + griff.x_pos + " : " + griff.y_pos);
                                                System.out.println("Cica pozíció jelenleg: " + cica.x_pos + " : " + cica.y_pos);
                                                acb.setVisible(false);
                                                grid.setOnMouseClicked(null);
                                            }



                                        }

                                    });

                                }
                            });
                        }
                        //Units end
                        Label manapoints = new Label("Mana: ");
                        manapoints.setLayoutX(0);
                        manapoints.setLayoutY(750);
                        manapoints.setFont(new Font("Cardinal", 30));
                        Label manapointsamount = new Label("0");
                        manapointsamount.setLayoutX(85);
                        manapointsamount.setLayoutY(750);
                        manapointsamount.setFont(new Font("Cardinal", 30));

                        root.getChildren().addAll(manapoints, manapointsamount);
                        //Magics
                        Label Magics = new Label("Varázslatok kiválasztása:");
                        Magics.setLayoutX(0);
                        Magics.setLayoutY(300);
                        Magics.setFont(new Font("Cardinal", 30));
                        root.getChildren().add(Magics);
                        int MagLayy = 400;
                        if (villamcsapasamount != 0){
                            SpecButton VillamcsapasButton = new SpecButton("V");
                            VillamcsapasButton.setLayoutX(0);
                            VillamcsapasButton.setLayoutY(MagLayy);
                            root.getChildren().add(VillamcsapasButton);
                        }
                        if (tuzlabdaamount != 0){
                            SpecButton TuzlabdaButton = new SpecButton("T");
                            TuzlabdaButton.setLayoutX(60);
                            TuzlabdaButton.setLayoutY(MagLayy);
                            root.getChildren().add(TuzlabdaButton);
                        }
                        if (feltamasztasamount != 0){
                            SpecButton FeltamasztasButton = new SpecButton("+");
                            FeltamasztasButton.setLayoutX(120);
                            FeltamasztasButton.setLayoutY(MagLayy);
                            root.getChildren().add(FeltamasztasButton);
                        }
                        if (bonusamount != 0){
                            SpecButton BonusButton = new SpecButton("B");
                            BonusButton.setLayoutX(180);
                            BonusButton.setLayoutY(MagLayy);
                            root.getChildren().add(BonusButton);
                        }
                        if (doublehealamount != 0){
                            SpecButton DoubleHealButton = new SpecButton("H");
                            DoubleHealButton.setLayoutX(240);
                            DoubleHealButton.setLayoutY(MagLayy);
                            root.getChildren().add(DoubleHealButton);
                        }

                        //magics end
                        //Buttons HUD end ------------------------------------------>




                        mainStage.setScene(new Scene(hbox, WIDTH, HEIGHT));
                        //mainStage.setFullScreen(true);

                    }
                });

                // Labels for the game prepreapare menu
                // Gold show
                Label GoldLabel = new Label("Arany:");
                Label GoldAmount = new Label(String.valueOf(Globals.GoldAmount));
                GoldLabel.setLayoutX(50);
                GoldLabel.setLayoutY(100);
                GoldLabel.setFont(new Font("Cardinal", 25));

                GoldAmount.setLayoutX(230);
                GoldAmount.setLayoutY(100);
                GoldAmount.setFont(new Font("Cardinal", 25));
                //Specifications of the Hero
                int Labely = 620;
                Label TamadasLabel = new Label("Támadás:");
                TamadasLabel.setLayoutX(300);
                TamadasLabel.setLayoutY(Labely);
                TamadasLabel.setFont(new Font("Cardinal",20));
                Label TamadasLabelAMount = new Label("1");
                TamadasLabelAMount.setLayoutX(390);
                TamadasLabelAMount.setLayoutY(Labely);
                TamadasLabelAMount.setFont(new Font("Cardinal", 20));
                SpecButton TamadasButtonIncrease = new SpecButton("+");
                TamadasButtonIncrease.setLayoutX(330);
                TamadasButtonIncrease.setLayoutY(Labely + 40);

                TamadasButtonIncrease.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < Globals.priceofTamadas || (Integer.parseInt(TamadasLabelAMount.getText()) == 10)){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - Globals.priceofTamadas) + "");
                            int TamadasValue = Integer.parseInt(TamadasLabelAMount.getText());
                            TamadasLabelAMount.setText("" + (TamadasValue+1)+ "");
                            Globals.priceofTamadas = (int) (Math.ceil(Globals.priceofTamadas *0.1) + Globals.priceofTamadas);
                            System.out.println("Támadás ára:" + Globals.priceofTamadas);

                        }
                    }
                });
                //Tamadas End ---------------->

                Label VedekezesLabel = new Label("Védekezés:");
                VedekezesLabel.setLayoutX(450);
                VedekezesLabel.setLayoutY(Labely);
                VedekezesLabel.setFont(new Font("Cardinal",20));
                Label VedekezesLabelAmount = new Label("1");
                VedekezesLabelAmount.setLayoutX(560);
                VedekezesLabelAmount.setLayoutY(Labely);
                VedekezesLabelAmount.setFont(new Font("Cardinal", 20));
                SpecButton VedekezesButtonIncrease = new SpecButton("+");
                VedekezesButtonIncrease.setLayoutX(480);
                VedekezesButtonIncrease.setLayoutY(Labely + 40);
                VedekezesButtonIncrease.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < Globals.priceofVedekezes || (Integer.parseInt(VedekezesLabelAmount.getText()) == 10)){
                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - Globals.priceofVedekezes) + "");
                            int VedekezesValue = Integer.parseInt(VedekezesLabelAmount.getText());
                            VedekezesLabelAmount.setText("" + (VedekezesValue+1)+ "");
                            Globals.priceofVedekezes = (int) (Math.ceil(Globals.priceofVedekezes *0.1) + Globals.priceofVedekezes);
                            System.out.println("Védekezés ára:" + Globals.priceofVedekezes);
                        }
                    }
                });
                //Vedekezes End ----------------->

                Label VarazseroLabel = new Label("Varázserő:");
                VarazseroLabel.setLayoutX(600);
                VarazseroLabel.setLayoutY(Labely);
                VarazseroLabel.setFont(new Font("Cardinal",20));
                Label VarazseroLabelAmount = new Label("1");
                VarazseroLabelAmount.setLayoutX(700);
                VarazseroLabelAmount.setLayoutY(Labely);
                VarazseroLabelAmount.setFont(new Font("Cardinal", 20));
                SpecButton VarazseroButtonIncrease = new SpecButton("+");
                VarazseroButtonIncrease.setLayoutX(630);
                VarazseroButtonIncrease.setLayoutY(Labely + 40);
                VarazseroButtonIncrease.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < Globals.priceofVarazsero || (Integer.parseInt(VarazseroLabelAmount.getText()) == 10)){
                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - Globals.priceofVarazsero) + "");
                            int VarazseroValue = Integer.parseInt(VarazseroLabelAmount.getText());
                            VarazseroLabelAmount.setText("" + (VarazseroValue+1)+ "");
                            Globals.priceofVarazsero = (int) (Math.ceil(Globals.priceofVarazsero *0.1) + Globals.priceofVarazsero);
                            System.out.println("Varázserő ára:" + Globals.priceofVarazsero);
                        }
                    }
                });
                //Varazsero End ---------------------------->

                Label TudasLabel = new Label("Tudás:");
                TudasLabel.setLayoutX(750);
                TudasLabel.setLayoutY(Labely);
                TudasLabel.setFont(new Font("Cardinal",20));
                Label TudasLabelAmount = new Label("1");
                TudasLabelAmount.setLayoutX(830);
                TudasLabelAmount.setLayoutY(Labely);
                TudasLabelAmount.setFont(new Font("Cardinal", 20));
                SpecButton TudasButtonIncrease = new SpecButton("+");
                TudasButtonIncrease.setLayoutX(780);
                TudasButtonIncrease.setLayoutY(Labely + 40);
                TudasButtonIncrease.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        if (Integer.parseInt(GoldAmount.getText()) < Globals.priceofTudas || (Integer.parseInt(TudasLabelAmount.getText()) == 10)){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - Globals.priceofTudas) + "");
                            int TudasValue = Integer.parseInt(TudasLabelAmount.getText());
                            TudasLabelAmount.setText("" + (TudasValue+1)+ "");
                            Globals.priceofTudas = (int) (Math.ceil(Globals.priceofTudas *0.1) + Globals.priceofTudas);
                            System.out.println("Varázserő ára:" + Globals.priceofTudas);
                        }
                    }
                });
                //Tudas End --------------------------->

                Label MoralLabel = new Label("Morál:");
                MoralLabel.setLayoutX(900);
                MoralLabel.setLayoutY(Labely);
                MoralLabel.setFont(new Font("Cardinal",20));
                Label MoralLabelAmount = new Label("1");
                MoralLabelAmount.setLayoutX(970);
                MoralLabelAmount.setLayoutY(Labely);
                MoralLabelAmount.setFont(new Font("Cardinal", 20));
                SpecButton MoralButtonIncrease = new SpecButton("+");
                MoralButtonIncrease.setLayoutX(930);
                MoralButtonIncrease.setLayoutY(Labely + 40);
                MoralButtonIncrease.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        if (Integer.parseInt(GoldAmount.getText()) < Globals.priceofMoral || (Integer.parseInt(MoralLabelAmount.getText()) == 10)){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - Globals.priceofMoral) + "");
                            int MoralValue = Integer.parseInt(MoralLabelAmount.getText());
                            MoralLabelAmount.setText("" + (MoralValue+1)+ "");
                            Globals.priceofMoral = (int) (Math.ceil(Globals.priceofMoral *0.1) + Globals.priceofMoral);
                            System.out.println("Morál ára:" + Globals.priceofMoral);
                        }
                    }
                });
                // Moral End --------------------------->


                Label SzerencseLabel = new Label("Szerencse:");
                SzerencseLabel.setLayoutX(1050);
                SzerencseLabel.setLayoutY(Labely);
                SzerencseLabel.setFont(new Font("Cardinal",20));
                Label SzerencseLabelAmount = new Label("1");
                SzerencseLabelAmount.setLayoutX(1150);
                SzerencseLabelAmount.setLayoutY(Labely);
                SzerencseLabelAmount.setFont(new Font("Cardinal", 20));
                SpecButton SzerencseButtonIncrease = new SpecButton("+");
                SzerencseButtonIncrease.setLayoutX(1080);
                SzerencseButtonIncrease.setLayoutY(Labely + 40);
                SzerencseButtonIncrease.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        if (Integer.parseInt(GoldAmount.getText()) < Globals.priceofSzerencse || (Integer.parseInt(SzerencseLabelAmount.getText()) == 10)){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - Globals.priceofSzerencse) + "");
                            int SzerencseValue = Integer.parseInt(SzerencseLabelAmount.getText());
                            SzerencseLabelAmount.setText("" + (SzerencseValue+1)+ "");

                            Globals.priceofSzerencse= (int) (Math.ceil(Globals.priceofSzerencse *0.1) + Globals.priceofSzerencse);
                            System.out.println("Szerencse ára:" + Globals.priceofSzerencse);
                        }
                    }
                });
                //  Szerencse End --------------------------->
                root.getChildren().addAll(TamadasLabel, VedekezesLabel, VarazseroLabel, TudasLabel, MoralLabel, SzerencseLabel);
                root.getChildren().addAll(TamadasLabelAMount, VedekezesLabelAmount, VarazseroLabelAmount ,TudasLabelAmount, MoralLabelAmount, SzerencseLabelAmount);
                root.getChildren().addAll(TamadasButtonIncrease, VedekezesButtonIncrease, VarazseroButtonIncrease, TudasButtonIncrease, MoralButtonIncrease, SzerencseButtonIncrease);
                //Specifications of the Hero end
                Label mainLabel = new Label("HARCRA FEL!");
                Label UnitLabel = new Label("VÁLASSZ EGYSÉG(EK)ET:");
                Label MagicLabel = new Label("VÁLASSZ VARÁZSERŐ(KE)T:");

                //Egységek
                Label CurrentUnits = new Label("Összes egység:");
                Label UnitAmount = new Label("0");
                //Foldmuves
                Label Foldmuves = new Label("Földműves: ");
                Label FoldmuvesAmount = new Label("0");
                //Ijasz
                Label Ijasz = new Label("Ijász: ");
                Label IjaszAmount = new Label("0");
                //Sarkany
                Label Sarkany = new Label("Griff: ");
                Label SarkanyAmount = new Label("0");
                //Cica
                Label Cica = new Label("Cica: ");
                Label CicaAmount = new Label("0");
                //Páncélos Cica
                Label ArmouredCica = new Label("Páncélos Cica");
                Label ArmnouredCicaAmount = new Label("0");


                //Magic Labels
                //Tuzlabda label
                Label Tuzlabdalabel = new Label("Tűzlabda:");
                Tuzlabdalabel.setLayoutX(50);
                Tuzlabdalabel.setLayoutY(500);
                Tuzlabdalabel.setFont(new Font("Cardinal", 25));
                Label TuzlabdaAmount = new Label("0");
                TuzlabdaAmount.setLayoutX(230);
                TuzlabdaAmount.setLayoutY(500);
                TuzlabdaAmount.setFont(new Font("Cardinal", 25));

                //Villamcsapaslabel
                Label VillamcsapasLabel = new Label("Villámcsapás:");
                VillamcsapasLabel.setLayoutX(50);
                VillamcsapasLabel.setLayoutY(550);
                VillamcsapasLabel.setFont(new Font("Cardinal", 25));
                Label VillamcsapasAmount = new Label("0");
                VillamcsapasAmount.setLayoutX(230);
                VillamcsapasAmount.setLayoutY(550);
                VillamcsapasAmount.setFont(new Font("Cardinal", 25));

                //Feltamadaslabel
                Label FeltamadasLabel = new Label("Feltámadás:");
                FeltamadasLabel.setLayoutX(50);
                FeltamadasLabel.setLayoutY(600);
                FeltamadasLabel.setFont(new Font("Cardinal", 25));
                Label FeltamadasAmount = new Label("0");
                FeltamadasAmount.setLayoutX(230);
                FeltamadasAmount.setLayoutY(600);
                FeltamadasAmount.setFont(new Font("Cardinal", 25));

                //Bonuslabel
                Label BonusLabel = new Label("Bonus:");
                BonusLabel.setLayoutX(50);
                BonusLabel.setLayoutY(650);
                BonusLabel.setFont(new Font("Cardinal", 25));
                Label BonusAmount = new Label("0");
                BonusAmount.setLayoutX(230);
                BonusAmount.setLayoutY(650);
                BonusAmount.setFont(new Font("Cardinal", 25));

                //Doubleheal label
                Label DoubleHealLabel = new Label("DoubleHeal:");
                DoubleHealLabel.setLayoutX(50);
                DoubleHealLabel.setLayoutY(700);
                DoubleHealLabel.setFont(new Font("Cardinal", 25));
                Label DoubleHealAmount = new Label("0");
                DoubleHealAmount.setLayoutX(230);
                DoubleHealAmount.setLayoutY(700);
                DoubleHealAmount.setFont(new Font("Cardinal", 25));

                root.getChildren().addAll(Tuzlabdalabel, TuzlabdaAmount, VillamcsapasLabel, VillamcsapasAmount, FeltamadasLabel, FeltamadasAmount, BonusLabel, BonusAmount, DoubleHealLabel, DoubleHealAmount);


                //Magic labels prices
                Label VillamcsapasPrice = new Label("60g");
                Label TuzlabdaPrice = new Label("120g");
                Label Feltamasztas = new Label("120g");
                Label BonusPrice = new Label("200g");
                Label DoubleHealPrice = new Label("200g");

                TuzlabdaPrice.setLayoutX(1000);
                TuzlabdaPrice.setLayoutY(160);
                TuzlabdaPrice.setFont(new Font("Cardinal", 20));

                VillamcsapasPrice.setLayoutX(1000);
                VillamcsapasPrice.setLayoutY(260);
                VillamcsapasPrice.setFont(new Font("Cardinal", 20));

                Feltamasztas.setLayoutX(1000);
                Feltamasztas.setLayoutY(360);
                Feltamasztas.setFont(new Font("Cardinal", 20));

                BonusPrice.setLayoutX(1000);
                BonusPrice.setLayoutY(460);
                BonusPrice.setFont(new Font("Cardinal", 20));

                DoubleHealPrice.setLayoutX(1000);
                DoubleHealPrice.setLayoutY(560);
                DoubleHealPrice.setFont(new Font("Cardinal", 20));

                root.getChildren().addAll(TuzlabdaPrice, VillamcsapasPrice, Feltamasztas, BonusPrice, DoubleHealPrice);

                //Magic Labels end prices
                //Magic Labels end

                //Unit Labels prices
                Label FoldmuvesPrice = new Label("2g");
                Label IjaszPrice = new Label("6g");
                Label SarkanyPrice = new Label("15g");
                Label CicaPrice = new Label("20g");
                Label ArmouredCicaPrice = new Label("50g");

                FoldmuvesPrice.setLayoutX(550);
                FoldmuvesPrice.setLayoutY(160);
                FoldmuvesPrice.setFont(new Font("Cardinal", 20));

                IjaszPrice.setLayoutX(550);
                IjaszPrice.setLayoutY(260);
                IjaszPrice.setFont(new Font("Cardinal", 20));

                SarkanyPrice.setLayoutX(550);
                SarkanyPrice.setLayoutY(360);
                SarkanyPrice.setFont(new Font("Cardinal", 20));

                CicaPrice.setLayoutX(550);
                CicaPrice.setLayoutY(460);
                CicaPrice.setFont(new Font("Cardinal", 20));

                ArmouredCicaPrice.setLayoutX(550);
                ArmouredCicaPrice.setLayoutY(560);
                ArmouredCicaPrice.setFont(new Font("Cardinal", 20));

                root.getChildren().addAll(FoldmuvesPrice, IjaszPrice, SarkanyPrice, CicaPrice, ArmouredCicaPrice);
                //Unit Labels prices end

                // Title of the scene
                mainLabel.setLayoutX(250);
                mainLabel.setLayoutY(10);
                mainLabel.setFont(new Font("Cardinal", 50));

                //Unit Label
                UnitLabel.setLayoutX(350);
                UnitLabel.setLayoutY(100);
                UnitLabel.setFont(new Font("Cardinal", 25));
                //Magic Label
                MagicLabel.setLayoutX(800);
                MagicLabel.setLayoutY(100);
                MagicLabel.setFont(new Font("Cardinal", 25));


                //Units
                //Units show
                CurrentUnits.setLayoutX(50);
                CurrentUnits.setLayoutY(150);
                CurrentUnits.setFont(new Font("Cardinal", 25));

                UnitAmount.setLayoutX(230);
                UnitAmount.setLayoutY(150);
                UnitAmount.setFont(new Font("Cardinal", 25));

                //Foldmuves
                Foldmuves.setLayoutX(50);
                Foldmuves.setLayoutY(250);
                Foldmuves.setFont(new Font("Cardinal", 25));

                FoldmuvesAmount.setLayoutX(230);
                FoldmuvesAmount.setLayoutY((250));
                FoldmuvesAmount.setFont(new Font("Cardinal", 25));

                //Ijasz
                Ijasz.setLayoutX(50);
                Ijasz.setLayoutY(300);
                Ijasz.setFont(new Font("Cardinal", 25));

                IjaszAmount.setLayoutX(230);
                IjaszAmount.setLayoutY((300));
                IjaszAmount.setFont(new Font("Cardinal", 25));

                //Sarkany
                Sarkany.setLayoutX(50);
                Sarkany.setLayoutY(350);
                Sarkany.setFont(new Font("Cardinal", 25));

                SarkanyAmount.setLayoutX(230);
                SarkanyAmount.setLayoutY((350));
                SarkanyAmount.setFont(new Font("Cardinal", 25));

                //Cica
                Cica.setLayoutX(50);
                Cica.setLayoutY(400);
                Cica.setFont(new Font("Cardinal", 25));

                CicaAmount.setLayoutX(230);
                CicaAmount.setLayoutY((400));
                CicaAmount.setFont(new Font("Cardinal", 25));

                //Armoured cat
                ArmouredCica.setLayoutX(50);
                ArmouredCica.setLayoutY(450);
                ArmouredCica.setFont(new Font("Cardinal", 25));

                ArmnouredCicaAmount.setLayoutX(230);
                ArmnouredCicaAmount.setLayoutY((450));
                ArmnouredCicaAmount.setFont(new Font("Cardinal", 25));
                //Units end



                //Buttons for the units ---------------------------------------------------------->
                //Földműves gomb
                HeroesOfMightButton FoldmuvesButton = new HeroesOfMightButton("Földm.");
                Tooltip FmTp = new Tooltip();
                FmTp.setText("Sebzés: 1-1, Életerő: 3, Sebesség: 4, Kezdeményezés: 8, Sepciális képesség: nincs");
                FoldmuvesButton.setTooltip(FmTp);
                FoldmuvesButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        startGameButton.setVisible(true);

                        if (Integer.parseInt(GoldAmount.getText()) < 2){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 2) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue+1)+ "");
                            int Foldmuvesvalue = Integer.parseInt(FoldmuvesAmount.getText());
                            FoldmuvesAmount.setText("" + (Foldmuvesvalue+1) + "");
                            foldmuvesAmount++;

                        }
                    }
                });
                FoldmuvesButton.setLayoutX(350);
                FoldmuvesButton.setLayoutY(150);

                //Ijász gomb
                HeroesOfMightButton IjaszButton = new HeroesOfMightButton("Íjász");
                Tooltip ijtp = new Tooltip();
                ijtp.setText("Sebzés: 2-4, Életerő: 7, Sebesség: 4, Kezdeményezés: 9, Sepciális képesség: lövés");
                IjaszButton.setTooltip(ijtp);
                IjaszButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        startGameButton.setVisible(true);
                        if (Integer.parseInt(GoldAmount.getText()) < 6){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 6) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue+1)+ "");
                            int ijaszvalue = Integer.parseInt(IjaszAmount.getText());
                            IjaszAmount.setText("" + (ijaszvalue+1) + "");
                            ijaszAmount++;

                        }
                    }
                });

                IjaszButton.setLayoutX(350);
                IjaszButton.setLayoutY(250);

                //Griff gomb
                HeroesOfMightButton SarkanyButton = new HeroesOfMightButton("Griff");
                Tooltip grtp = new Tooltip();
                grtp.setText("Sebzés: 5-10, Életerő: 30, Sebesség: 7, Kezdeményezés: 15, Sepciális képesség: végtelen visszatámadás");
                SarkanyButton.setTooltip(grtp);
                SarkanyButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        startGameButton.setVisible(true);
                        if (Integer.parseInt(GoldAmount.getText()) < 15){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 15) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue+1)+ "");
                            int Sarkanyvalue = Integer.parseInt(SarkanyAmount.getText());
                            SarkanyAmount.setText("" + (Sarkanyvalue+1) + "");
                            griffAmount++;

                        }
                    }
                });
                SarkanyButton.setLayoutX(350);
                SarkanyButton.setLayoutY(350);

                //Cica gomb
                HeroesOfMightButton CicaButton = new HeroesOfMightButton("Cica");
                Tooltip cicatp = new Tooltip();
                cicatp.setText("Sebzés: 10-20, Életerő: 50, Sebesség: 10, Kezdeményezés: 20, Sepciális képesség: nyávog");
                CicaButton.setTooltip(cicatp);
                CicaButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        startGameButton.setVisible(true);
                        if (Integer.parseInt(GoldAmount.getText()) < 20){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 20) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue+1)+ "");
                            int Cicavalue = Integer.parseInt(CicaAmount.getText());
                            CicaAmount.setText("" + (Cicavalue+1) + "");
                            cicaAmount++;

                        }
                    }
                });
                CicaButton.setLayoutX(350);
                CicaButton.setLayoutY(450);

                //Páncéloscica gomb
                HeroesOfMightButton ArmouredCatButton = new HeroesOfMightButton("P. Cica");
                Tooltip arcicatp = new Tooltip();
                arcicatp.setText("Sebzés: 50-100, Életerő: 100, Sebesség: 3, Kezdeményezés: 50, Sepciális képesség: nyávog, csak hangosabban");
                ArmouredCatButton.setTooltip(arcicatp);
                ArmouredCatButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        startGameButton.setVisible(true);
                        if (Integer.parseInt(GoldAmount.getText()) < 50){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 50) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue+1)+ "");
                            int ArmouredCicavalue = Integer.parseInt(ArmnouredCicaAmount.getText());
                            ArmnouredCicaAmount.setText("" + (ArmouredCicavalue+1) + "");
                            armourdercicaamount++;

                        }
                    }
                });
                ArmouredCatButton.setLayoutX(350);
                ArmouredCatButton.setLayoutY(550);



                //Varázserő Gombok --------------------------------------------->
                //Tűzlabda gomb
                HeroesOfMightButton TuzlabdaButton = new HeroesOfMightButton("TUzL.");
                Tooltip tuzlabdatp = new Tooltip();
                tuzlabdatp.setText("Egy kiválasztott mező körüli 3x3-as területen lévő\n" +
                        "összes (saját, illetve ellenséges) egységre\n" +
                        "(varázserő * 20) sebzés okozása\n");
                TuzlabdaButton.setTooltip(tuzlabdatp);
                TuzlabdaButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < 120){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 120) + "");
                            int tuzvalue = Integer.parseInt(TuzlabdaAmount.getText());
                            TuzlabdaAmount.setText("" + (tuzvalue+1)+ "");
                            tuzlabdaamount++;
                        }
                    }
                });
                TuzlabdaButton.setLayoutX(800);
                TuzlabdaButton.setLayoutY(150);

                //VillamCsapas gomb
                HeroesOfMightButton VillamcsapasButton = new HeroesOfMightButton("Villám");

                Tooltip villamtp = new Tooltip();
                villamtp.setText("Egy kiválasztott ellenséges egységre (varázserő * 30) sebzés okozása");
                VillamcsapasButton.setTooltip(villamtp);
                VillamcsapasButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < 60){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 60) + "");
                            int Villamvalue = Integer.parseInt(VillamcsapasAmount.getText());
                            VillamcsapasAmount.setText("" + (Villamvalue+1)+ "");
                            villamcsapasamount++;
                        }
                    }
                });
                VillamcsapasButton.setLayoutX(800);
                VillamcsapasButton.setLayoutY(250);

                //Feltamasztas gomb
                HeroesOfMightButton FeltamasztasButton = new HeroesOfMightButton("Feltam.");
                Tooltip felttp = new Tooltip();
                felttp.setText("Egy kiválasztott saját egység feltámasztása.\n" +
                        "Maximális gyógyítás mértéke: (varázserő * 50)\n");
                FeltamasztasButton.setTooltip(felttp);
                FeltamasztasButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < 120){
                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 120) + "");
                            int Feltamadasvalue = Integer.parseInt(FeltamadasAmount.getText());
                            FeltamadasAmount.setText("" + (Feltamadasvalue+1)+ "");
                            feltamasztasamount++;
                        }
                    }
                });
                FeltamasztasButton.setLayoutX(800);
                FeltamasztasButton.setLayoutY(350);

                //Megnövel minden traitet, Bonus gomb
                HeroesOfMightButton TraitBonusButton = new HeroesOfMightButton("Bonus");
                Tooltip bonustp = new Tooltip();
                bonustp.setText("Megnövel minden traitet 2-vel.");
                TraitBonusButton.setTooltip(bonustp);
                TraitBonusButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < 200){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 200) + "");
                            int Bonusvalue = Integer.parseInt(BonusAmount.getText());
                            BonusAmount.setText("" + (Bonusvalue+1)+ "");
                            bonusamount++;
                        }
                    }
                });
                TraitBonusButton.setLayoutX(800);
                TraitBonusButton.setLayoutY(450);

                //Double heal spell gomb
                HeroesOfMightButton DoubleHealButton = new HeroesOfMightButton("D. heal");
                Tooltip doublehealtp = new Tooltip();
                doublehealtp.setText("A harcos jelenlegi életerejét hozzáadja kétszer a harcos életerejéhez.");
                DoubleHealButton.setTooltip(doublehealtp);
                DoubleHealButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < 200){
                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 200) + "");
                            int DoublehealValue = Integer.parseInt(DoubleHealAmount.getText());
                            DoubleHealAmount.setText("" + (DoublehealValue+1)+ "");
                            doublehealamount++;
                        }
                    }
                });

                DoubleHealButton.setLayoutX(800);
                DoubleHealButton.setLayoutY(550);


                Image backgroundImage = new Image("grass.png",true);
                root.setBackground(new Background(new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, null, null)));

                root.getChildren().addAll(mainLabel, GoldLabel, GoldAmount, CurrentUnits, UnitAmount, Foldmuves, FoldmuvesAmount, Ijasz, IjaszAmount, Sarkany, SarkanyAmount, Cica, CicaAmount, ArmouredCica, ArmnouredCicaAmount, UnitLabel, MagicLabel); //Labels added
                root.getChildren().addAll(exitButtonFromGame, startGameButton, FoldmuvesButton, IjaszButton, SarkanyButton, CicaButton, ArmouredCatButton, TuzlabdaButton, VillamcsapasButton, FeltamasztasButton, TraitBonusButton, DoubleHealButton); //Buttons added
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
            Globals.GoldAmount = 1300;
        }
        if(Globals.difficulty == 2){

            Globals.GlobalImgView.setImage(mediumImage);
            Globals.GoldAmount = 1000;
        }
        if(Globals.difficulty == 3){

            Globals.GlobalImgView.setImage(hardImage);
            Globals.GoldAmount = 700;
        }
    }

    private void CreateMainLabelText(){
        Label text = new Label("HEROES OF MIGHT");
        text.setLayoutX(350);
        text.setLayoutY(30);
        text.setFont(new Font("Beau Rivage", 70));
        text.setTextFill(Color.web("#7AFF33", 0.8));
        mainPane.getChildren().add(text);
    }

    /*
    public Node getNodeByRowColumnIndex(int rowIndex, int columnIndex){
        Node node = null;
        ObservableList<Node> observableList = grid.getChildren();
        for (Node nd : observableList){
            System.out.println(nd.toString());
            System.out.println(GridPane.getRowIndex(nd));
            if (GridPane.getRowIndex(nd) == rowIndex && GridPane.getColumnIndex(nd) == columnIndex){
                node = nd;
                break;
            }
        }
,
        return node;
    }
     */

    public void addPictureToCell(int col, int row, ImageView img){
        grid.add(img, col, row);
    }


   // public boolean IsCharacterOnCell(int col, int row){

    //}
}
