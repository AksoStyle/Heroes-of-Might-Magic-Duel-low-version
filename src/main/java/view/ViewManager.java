package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.kotprog.Globals;
import main.kotprog.Map;
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
        CreateMainLabelText();
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
                VBox vbox = new VBox();
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
                startGameButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {


                        Map gamemap = new Map();

                        gamemap.gamemapstart();
                    }
                });

                // Labels for the game prepreapare menu
                Label mainLabel = new Label("HARCRA FEL!");
                Label UnitLabel = new Label("VÁLASSZ EGYSÉG(EK)ET:");
                Label MagicLabel = new Label("VÁLASSZ VARÁZSERŐ(KE)T:");
                Label GoldLabel = new Label("Arany:");
                Label GoldAmount = new Label(String.valueOf(Globals.GoldAmount));
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
                // Gold show
                GoldLabel.setLayoutX(50);
                GoldLabel.setLayoutY(100);
                GoldLabel.setFont(new Font("Cardinal", 25));

                GoldAmount.setLayoutX(230);
                GoldAmount.setLayoutY(100);
                GoldAmount.setFont(new Font("Cardinal", 25));

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
                        if (Integer.parseInt(GoldAmount.getText()) < 2){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 2) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue+1)+ "");
                            int Foldmuvesvalue = Integer.parseInt(FoldmuvesAmount.getText());
                            FoldmuvesAmount.setText("" + (Foldmuvesvalue+1) + "");
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
                        if (Integer.parseInt(GoldAmount.getText()) < 6){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 6) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue+1)+ "");
                            int ijaszvalue = Integer.parseInt(IjaszAmount.getText());
                            IjaszAmount.setText("" + (ijaszvalue+1) + "");
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
                        if (Integer.parseInt(GoldAmount.getText()) < 15){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 15) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue+1)+ "");
                            int Sarkanyvalue = Integer.parseInt(SarkanyAmount.getText());
                            SarkanyAmount.setText("" + (Sarkanyvalue+1) + "");
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
                        if (Integer.parseInt(GoldAmount.getText()) < 20){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 20) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue+1)+ "");
                            int Cicavalue = Integer.parseInt(CicaAmount.getText());
                            CicaAmount.setText("" + (Cicavalue+1) + "");
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
                        if (Integer.parseInt(GoldAmount.getText()) < 50){

                        }
                        else{
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 50) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue+1)+ "");
                            int ArmouredCicavalue = Integer.parseInt(ArmnouredCicaAmount.getText());
                            ArmnouredCicaAmount.setText("" + (ArmouredCicavalue+1) + "");
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


}
