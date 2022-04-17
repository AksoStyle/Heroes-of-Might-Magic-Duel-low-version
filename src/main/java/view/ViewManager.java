package view;
/**
 * Pár szó a kódolásban:
 * Most először használtam JavaFx-et, előtte még sosem.
 * Az időm nagy része inkább a kutatásra ment el, állandó Yotubue tutorialok nézegetése,
 * illetve StackoverFlow olvasása, hogy megérthessem, mi hogyan funkcionál.
 *
 * Maga a Java nyelv sem volt túl ismert előtte, mert inkább használtam más nyelveket.
 * A kód kinézete, rendezetlensége önmagáért beszél, ez volt életem első nagy projektja, amelynek
 * érdekében hetekig készültem kora reggeltől késő hajnalig alvás nélkül.
 *
 * A kód felkerült Githubra és privát repositoryba, amint már teljes egészében használható lesz,
 * s minden funkció megtalálható lesz benne, akkor fogom publikusan közzétenni.
 *
 * A kód futtatásának érdekében az Application class-t kell futtatni.
 *
 *
 * Ez az osztály tartalmaz gyakorlatilag mindent a játék felépítésével kapcsolatban.
 * Ebbe az osztályba lett importálva minden különböző osztály, ami a játékban szerepel.
 * A játék logikájának megvalósítását tartalmazza nagy részben.
 * A teljes Front-end itt található ezen osztályon belül.
 *
 * @author Faragó Ákos - TTIK - Mérnökinformatika - kötelező program
 */

import classes.Enemy;
import classes.Hero;
import classes.Units.*;
import classes.magics.*;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
import javafx.util.Duration;
import main.kotprog.Game;
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

    private ArrayList<SpecButton> specButtons;
    private Pane root3;

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

    private Label FoldmuvesAmount;
    private Label IjaszAmount;
    private Label SarkanyAmount;
    private Label CicaAmount;
    private Label ArmnouredCicaAmount;


    private Label TamadasLabelAMount;
    private Label VedekezesLabelAmount;
    private Label VarazseroLabelAmount;
    private Label TudasLabelAmount;
    private Label MoralLabelAmount;
    private Label SzerencseLabelAmount;
    private Label manapointsamount;
    private Label MannaAmount;
    private Label Magics;
    private Label Units;

    private Label YouWon;


    private SpecButton VillamcsapasButton;
    private SpecButton TuzlabdaButton;
    private SpecButton FeltamasztasButton;
    private SpecButton BonusButton;
    private SpecButton DoubleHealButton;

    private Label VillamcsapasAmount;
    private Label TuzlabdaAmount;
    private Label FeltamadasAmount;
    private Label BonusAmount;
    private Label DoubleHealAmount;



    private Enemy randomenemy;
    private Hero hero;
    private Game game;
    private VillamCsapas villamCsapas;
    private Tuzlabda tuzlabda;
    private Feltamasztas feltamasztas;
    private Bonus bonus;
    private DoubleHeal doubleHeal;

    private final static int MENU_BUTTONS_START_X = WIDTH / 6;
    private final static int MENU_BUTTONS_START_Y = 150;

    List<HeroesOfMightButton> menuButtons;
    Foldmuves foldmuves = new Foldmuves();
    Ijasz ijasz = new Ijasz();
    Griff griff = new Griff();
    Cica cica = new Cica();
    PancelosCica panceloscica = new PancelosCica();

    public ViewManager() {
        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButton();
        createBackground();
        CreateMainLabelText();
        mainPane.getChildren().add(Globals.GlobalImgView);

        Units = new Label("Egységek kiválasztása:");
        VillamcsapasButton = new SpecButton("V");
        TuzlabdaButton = new SpecButton("T");
        FeltamasztasButton = new SpecButton("F");
        BonusButton = new SpecButton("B");
        DoubleHealButton = new SpecButton("D");
        Magics = new Label("Elérhető varázslatok");

        VillamcsapasAmount = new Label("0");
        TuzlabdaAmount = new Label("0");
        FeltamadasAmount = new Label("0");
         BonusAmount = new Label("0");
        DoubleHealAmount = new Label("0");
        manapointsamount = new Label("");
        specButtons = new ArrayList<>();
        root3 = new Pane();
        hero = new Hero();
        randomenemy = new Enemy(1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0);
        game = new Game(hero, randomenemy, new GridPane());
        FoldmuvesAmount = new Label();
        IjaszAmount = new Label();
        SarkanyAmount = new Label();
        CicaAmount = new Label();
        ArmnouredCicaAmount = new Label();

        TamadasLabelAMount = new Label();
        VedekezesLabelAmount = new Label();
        VarazseroLabelAmount = new Label();
        TudasLabelAmount = new Label();
        MoralLabelAmount = new Label();
        SzerencseLabelAmount = new Label();

        villamCsapas = new VillamCsapas();
        tuzlabda = new Tuzlabda();
        feltamasztas = new Feltamasztas();
        bonus = new Bonus();
        doubleHeal = new DoubleHeal();

        YouWon = new Label("");

        MannaAmount = new Label();


    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void addMenuButton(HeroesOfMightButton button) {
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 150);
        menuButtons.add(button);
        mainPane.getChildren().add(button);
    }

    /**
     * Gombok létrehozására alkalmas metódusé.
     * Jelen esetben négy féle gomb jön létre a menüben.
     */
    private void createButton() {
        createStartButton();
        createModeButton();
        createHowToButton();
        createExitButton();
    }

    //start --> game starts and getting ready to be played
    private void createStartButton() {
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
                        if (button == ButtonType.YES) {
                            Globals.primaryStage.setScene(menu);
                        } else {
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
                        //Hero unitok megadása

                        addherotoherounits(game.getHos());
                        hero.setTudas(Integer.parseInt(TudasLabelAmount.getText()));
                        hero.setTamadas(Integer.parseInt(TamadasLabelAMount.getText()));
                        hero.setVedekezes(Integer.parseInt(VedekezesLabelAmount.getText()));
                        hero.setVarazsero(Integer.parseInt(VarazseroLabelAmount.getText()));
                        hero.setMoral(Integer.parseInt(MoralLabelAmount.getText()));
                        hero.setSzerencse(Integer.parseInt(SzerencseLabelAmount.getText()));
                        hero.setMana(hero.getTudas() * 10);


                        //enemy unitok
/**
 * Ellenséges egységek random elhelyezése a térképen. Abban az esetben,
 * ha az ellenséges egység x-y koordinátája megegyezik egy másik egységével, újat generál, s ha már nem,
 * akkor helyezi el az egységet a térképen.
 */
                        System.out.println(randomenemy);

                        for (int i = 0; i < randomenemy.enemyUnits.size(); i++) {
                            Random rnd = new Random();

                            do {
                                randomenemy.enemyUnits.get(i).x_pos = rnd.nextInt(10, 12);
                                randomenemy.enemyUnits.get(i).y_pos = rnd.nextInt(0, 10);

                            } while (getNodeByRowColumnIndex(randomenemy.enemyUnits.get(i).x_pos, randomenemy.enemyUnits.get(i).y_pos));
                            game.grid.add(randomenemy.enemyUnits.get(i).getImage(), randomenemy.enemyUnits.get(i).x_pos, randomenemy.enemyUnits.get(i).y_pos);
                            System.out.println("Az ellenséges " + randomenemy.enemyUnits.get(i).getName() + ", Pozíciója: X: " + randomenemy.enemyUnits.get(i).x_pos + ", Y: " + randomenemy.enemyUnits.get(i).y_pos);

                        }


                        // save menu
                        Scene menu = Globals.primaryStage.getScene();
                        ;

                        // save menu end
                        // bg image
                        /**
                         * Háttér kép
                         */
                        Image backgroundImage = new Image("grass.png", true);
                        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
                        root3.setBackground(new Background(background));
                        // bg image end

                        game.grid.setAlignment(Pos.CENTER_RIGHT);
                        HBox hbox = new HBox(root3, game.grid);
                        hbox.setBackground(new Background(background));


                        /**
                         * A térkép létrehozása 12*10 cellából.
                         */
                        int rows = 10;

                        int columns = 12;

                        for (int i = 0; i < columns; i++) {
                            ColumnConstraints column = new ColumnConstraints(55);
                            game.grid.getColumnConstraints().add(column);

                        }
                        for (int i = 0; i < rows; i++) {
                            RowConstraints row = new RowConstraints(55);
                            game.grid.getRowConstraints().add(row);
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

                        game.grid.setStyle("-fx-grid-lines-visible: true");


                        //Buttons-Labels -  HUD ---------------------------------------------->
                        //Units

                        Units.setLayoutX(0);
                        Units.setLayoutY(0);
                        Units.setFont(new Font("Cardinal", 30));
                        root3.getChildren().add(Units);
                        /**
                         * Ha vásároltunk Földművest, abban az esetben megjelenik egy gomb a játék elején "F" betűvel.
                         * A gombra kattintva elhelyezhetjük a pálya bal oldalán (első kettős cellában) az egységet.
                         */
                        if (foldmuvesAmount != 0) {
                            SpecButton fmb = new SpecButton("F");
                            specButtons.add(fmb);
                            fmb.setLayoutX(0);
                            fmb.setLayoutY(100);
                            root3.getChildren().add(fmb);
                            fmb.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {

                                    game.grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {

                                            if (mouseEvent.getY() > 675 || mouseEvent.getY() < 125) {
                                                return;
                                            }
                                            int tmpy = (int) Math.floor((mouseEvent.getY() - 125) / 55);
                                            int tmpx = (int) Math.floor(mouseEvent.getX() / 55);
                                            foldmuves.x_pos = tmpx;
                                            foldmuves.y_pos = tmpy;
                                            if (foldmuves.x_pos == ijasz.x_pos && foldmuves.y_pos == ijasz.y_pos) {
                                                return;
                                            }
                                            if (foldmuves.x_pos == griff.x_pos && foldmuves.y_pos == griff.y_pos) {
                                                return;
                                            }
                                            if (foldmuves.x_pos == cica.x_pos && foldmuves.y_pos == cica.y_pos) {
                                                return;
                                            }
                                            if (foldmuves.x_pos == panceloscica.x_pos && foldmuves.y_pos == panceloscica.y_pos) {
                                                return;
                                            }
                                            if (tmpx < 2) {

                                                addPictureToCell(foldmuves.x_pos, foldmuves.y_pos, foldmuves.getImage());

                                                System.out.println("Földműves elhelyezve a " + foldmuves.x_pos + " : " + foldmuves.y_pos + " Koordinátára.");

                                                fmb.setVisible(false);
                                                specButtons.remove(fmb);
                                                IsPlayerReadyToStart();
                                                game.grid.setOnMouseClicked(null);
                                            }


                                        }

                                    });

                                }
                            });


                        }
                        /**
                         * Ha vásároltunk Ijászt, abban az esetben megjelenik egy gomb a játék elején "I" betűvel.
                         * A gombra kattintva elhelyezhetjük a pálya bal oldalán (első kettős cellában) az egységet.
                         */
                        if (ijaszAmount != 0) {
                            SpecButton ijb = new SpecButton("I");
                            specButtons.add(ijb);
                            ijb.setLayoutX(55);
                            ijb.setLayoutY(100);
                            root3.getChildren().add(ijb);
                            ijb.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {

                                    game.grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {

                                            if (mouseEvent.getY() > 675 || mouseEvent.getY() < 125) {
                                                return;
                                            }
                                            int tmpy = (int) Math.floor((mouseEvent.getY() - 125) / 55);
                                            int tmpx = (int) Math.floor(mouseEvent.getX() / 55);
                                            ijasz.x_pos = tmpx;
                                            ijasz.y_pos = tmpy;
                                            if (ijasz.x_pos == foldmuves.x_pos && ijasz.y_pos == foldmuves.y_pos) {
                                                return;
                                            }
                                            if (ijasz.x_pos == griff.x_pos && ijasz.y_pos == griff.y_pos) {
                                                return;
                                            }
                                            if (ijasz.x_pos == cica.x_pos && ijasz.y_pos == cica.y_pos) {
                                                return;
                                            }
                                            if (ijasz.x_pos == panceloscica.x_pos && ijasz.y_pos == panceloscica.y_pos) {
                                                return;
                                            }
                                            if (tmpx < 2) {

                                                addPictureToCell(ijasz.x_pos, ijasz.y_pos, ijasz.getImage());

                                                System.out.println("Ijász elhelyezve a " + tmpx + " : " + tmpy + " Koordinátára.");

                                                ijb.setVisible(false);
                                                specButtons.remove(ijb);
                                                IsPlayerReadyToStart();
                                                game.grid.setOnMouseClicked(null);
                                            }


                                        }

                                    });

                                }
                            });
                        }
                        /**
                         * Ha vásároltunk Griffet, abban az esetben megjelenik egy gomb a játék elején "G" betűvel.
                         * A gombra kattintva elhelyezhetjük a pálya bal oldalán (első kettős cellában) az egységet.
                         */
                        if (griffAmount != 0) {
                            SpecButton gb = new SpecButton("G");
                            specButtons.add(gb);
                            gb.setLayoutX(110);
                            gb.setLayoutY(100);
                            root3.getChildren().add(gb);
                            gb.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {

                                    game.grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {

                                            if (mouseEvent.getY() > 675 || mouseEvent.getY() < 125) {
                                                return;
                                            }
                                            int tmpy = (int) Math.floor((mouseEvent.getY() - 125) / 55);
                                            int tmpx = (int) Math.floor(mouseEvent.getX() / 55);
                                            griff.x_pos = tmpx;
                                            griff.y_pos = tmpy;
                                            if (griff.x_pos == foldmuves.x_pos && griff.y_pos == foldmuves.y_pos) {
                                                return;
                                            }
                                            if (griff.x_pos == ijasz.x_pos && griff.y_pos == ijasz.y_pos) {
                                                return;
                                            }
                                            if (griff.x_pos == cica.x_pos && griff.y_pos == cica.y_pos) {
                                                return;
                                            }
                                            if (griff.x_pos == panceloscica.x_pos && griff.y_pos == panceloscica.y_pos) {
                                                return;
                                            }
                                            if (tmpx < 2) {

                                                addPictureToCell(griff.x_pos, griff.y_pos, griff.getImage());

                                                System.out.println("Griff elhelyezve a " + tmpx + " : " + tmpy + " Koordinátára.");

                                                gb.setVisible(false);
                                                specButtons.remove(gb);
                                                IsPlayerReadyToStart();
                                                game.grid.setOnMouseClicked(null);
                                            }


                                        }

                                    });

                                }
                            });
                        }

                        /**
                         * Ha vásároltunk cicát, abban az esetben megjelenik egy gomb a játék elején "C" betűvel.
                         * A gombra kattintva elhelyezhetjük a pálya bal oldalán (első kettős cellában) az egységet.
                         */
                        if (cicaAmount != 0) {
                            SpecButton cb = new SpecButton("C");
                            specButtons.add(cb);
                            cb.setLayoutX(165);
                            cb.setLayoutY(100);
                            root3.getChildren().add(cb);
                            cb.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {

                                    game.grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {

                                            if (mouseEvent.getY() > 675 || mouseEvent.getY() < 125) {
                                                return;
                                            }
                                            int tmpy = (int) Math.floor((mouseEvent.getY() - 125) / 55);
                                            int tmpx = (int) Math.floor(mouseEvent.getX() / 55);
                                            cica.x_pos = tmpx;
                                            cica.y_pos = tmpy;
                                            if (cica.x_pos == foldmuves.x_pos && cica.y_pos == foldmuves.y_pos) {
                                                return;
                                            }
                                            if (cica.x_pos == ijasz.x_pos && cica.y_pos == ijasz.y_pos) {
                                                return;
                                            }
                                            if (cica.x_pos == griff.x_pos && cica.y_pos == griff.y_pos) {
                                                return;
                                            }
                                            if (cica.x_pos == panceloscica.x_pos && cica.y_pos == panceloscica.y_pos) {
                                                return;
                                            }
                                            if (tmpx < 2) {

                                                addPictureToCell(cica.x_pos, cica.y_pos, cica.getImage());

                                                System.out.println("Cica elhelyezve a " + tmpx + " : " + tmpy + " Koordinátára.");

                                                cb.setVisible(false);
                                                specButtons.remove(cb);
                                                IsPlayerReadyToStart();
                                                game.grid.setOnMouseClicked(null);
                                            }


                                        }

                                    });

                                }
                            });
                        }

                        /**
                         * Ha vásároltunk Páncéloscicát, abban az esetben megjelenik egy gomb a játék elején "P" betűvel.
                         * A gombra kattintva elhelyezhetjük a pálya bal oldalán (első kettős cellában) az egységet.
                         */
                        if (armourdercicaamount != 0) {
                            SpecButton acb = new SpecButton("P");
                            specButtons.add(acb);
                            acb.setLayoutX(220);
                            acb.setLayoutY(100);
                            root3.getChildren().add(acb);
                            acb.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {

                                    game.grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {

                                            if (mouseEvent.getY() > 675 || mouseEvent.getY() < 125) {
                                                return;
                                            }
                                            int tmpy = (int) Math.floor((mouseEvent.getY() - 125) / 55);
                                            int tmpx = (int) Math.floor(mouseEvent.getX() / 55);
                                            panceloscica.x_pos = tmpx;
                                            panceloscica.y_pos = tmpy;
                                            if (panceloscica.x_pos == foldmuves.x_pos && panceloscica.y_pos == foldmuves.y_pos) {
                                                return;
                                            }
                                            if (panceloscica.x_pos == ijasz.x_pos && panceloscica.y_pos == ijasz.y_pos) {
                                                return;
                                            }
                                            if (panceloscica.x_pos == griff.x_pos && panceloscica.y_pos == griff.y_pos) {
                                                return;
                                            }
                                            if (panceloscica.x_pos == cica.x_pos && cica.y_pos == panceloscica.y_pos) {
                                                return;
                                            }
                                            if (tmpx < 2) {

                                                addPictureToCell(panceloscica.x_pos, panceloscica.y_pos, panceloscica.getImage());
                                                System.out.println("PáncélosCica elhelyezve a " + tmpx + " : " + tmpy + " Koordinátára.");

                                                acb.setVisible(false);
                                                specButtons.remove(acb);
                                                IsPlayerReadyToStart();
                                                game.grid.setOnMouseClicked(null);
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
                        manapointsamount = new Label("" + hero.getMana() + "");
                        manapointsamount.setLayoutX(85);
                        manapointsamount.setLayoutY(750);
                        manapointsamount.setFont(new Font("Cardinal", 30));

                        root3.getChildren().addAll(manapoints, manapointsamount);


                        //Magics ----------------------------------------------------->
                        Magics.setVisible(false);
                        Magics.setLayoutX(0);
                        Magics.setLayoutY(300);
                        Magics.setFont(new Font("Cardinal", 30));
                        root3.getChildren().add(Magics);
                        int MagLayy = 400;

                        /**
                         * A gombra kattintva tudunk Tűzlabda Villámcsapás varázslatot használni, melynek következtében egy ellenséges karaktert kiválasztva az megsebződik 20* hős varázserővel.
                         * Ha nincs elég mana, kilép az Actionből.
                         */
                        if (villamcsapasamount != 0) {
                            VillamcsapasButton.setVisible(false);
                            VillamcsapasAmount.setVisible(false);
                            VillamcsapasAmount.setLayoutX(20);
                            VillamcsapasAmount.setLayoutY(MagLayy+40);
                            VillamcsapasButton.setLayoutX(0);
                            VillamcsapasButton.setLayoutY(MagLayy);
                            VillamcsapasButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    game.grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent event) {
                                            if (Integer.parseInt(manapointsamount.getText()) < 5) {
                                                System.out.println("Nincs elég mana!");
                                                game.grid.setOnMouseClicked(null);
                                                VillamcsapasButton.setOnAction(null);
                                            }
                                            if (event.getY() > 675 || event.getY() < 125) {
                                                return;
                                            }
                                            int tmpy = (int) Math.floor((event.getY() - 125) / 55);
                                            int tmpx = (int) Math.floor(event.getX() / 55);
                                            for(Unit hero : game.getHos().getUnits()) {
                                                if (hero.x_pos == tmpx && hero.y_pos == tmpy) {
                                                    System.out.println("Nem tudsz villámcsapást küldeni saját egységre!");
                                                    game.grid.setOnMouseClicked(null);
                                                }
                                            }

                                            for (Unit en : randomenemy.enemyUnits){
                                                        if (en.x_pos== tmpx && en.y_pos== tmpy){
                                                            VillamcsapasAmount.setText("" + (Integer.parseInt(VillamcsapasAmount.getText()) - 1));
                                                            manapointsamount.setText("" + (Integer.parseInt(manapointsamount.getText()) - villamCsapas.getMannakoltseg()));
                                                            System.out.println("Enemy unit found");
                                                            en.setHealth(en.getHealth()-hero.getVarazsero() * villamCsapas.Sebzes);
                                                            System.out.println("Enemy" + en.getName() +  " health: " + en.getHealth() );
                                                            if (en.getHealth()<=0){
                                                                System.out.println("Enemy unit killed");
                                                                game.grid.getChildren().remove(en.getImage());

                                                                randomenemy.enemyUnits.remove(en);
                                                                DoesHeroWin();
                                                                break;
                                                            }
                                                        }
                                            }

                                            if (VillamcsapasAmount.getText().equals("0")){
                                                VillamcsapasAmount.setVisible(false);
                                                VillamcsapasButton.setVisible(false);
                                            }

                                        }
                                    });
                                }
                            });

                            root3.getChildren().addAll(VillamcsapasButton, VillamcsapasAmount);
                        }
                        /**
                         * A gombra kattintva tudunk Tűzlabda varázslatot használni, mellyel egy koordinátára kattintva egy tűzlabdát dobunk egy 3x3-as koordinátára. A koordinátán belül sebződik az ellenfél
                         * Ha nincs elég mana, kilép az Actionből.
                         */

                        if (tuzlabdaamount != 0) {
                            TuzlabdaButton.setVisible(false);
                            TuzlabdaAmount.setVisible(false);
                            TuzlabdaAmount.setLayoutX(80);
                            TuzlabdaAmount.setLayoutY(MagLayy+40);
                            TuzlabdaButton.setLayoutX(60);
                            TuzlabdaButton.setLayoutY(MagLayy);
                            TuzlabdaButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    game.grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent event) {
                                            if (Integer.parseInt(manapointsamount.getText()) < 9) {
                                                System.out.println("Nincs elég mana!");
                                                game.grid.setOnMouseClicked(null);
                                                TuzlabdaButton.setOnAction(null);
                                            }
                                            TuzlabdaAmount.setText(Integer.parseInt("" + TuzlabdaAmount.getText()) - 1 + "");
                                            if (event.getY() > 675 || event.getY() < 125) {
                                                return;
                                            }
                                            int tmpy = (int) Math.floor((event.getY() - 125) / 55);
                                            int tmpx = (int) Math.floor(event.getX() / 55);
                                            int balatlo_x = tmpx - 1;
                                            int balatlo_y = tmpy - 1;
                                            int high_x = tmpx ;
                                            int high_y = tmpy-1 ;
                                            int jobbatlo_x = tmpx + 1;
                                            int jobbatlo_y = tmpy - 1;
                                            int right_x = tmpx + 1;
                                            int right_y = tmpy;
                                            int jobbalsoatlo_x = tmpx + 1;
                                            int jobbalsoatlo_y = tmpy + 1;
                                            int bottom_x = tmpx;
                                            int bottom_y = tmpy + 1;
                                            int balalsoatlo_x = tmpx - 1;
                                            int balalsoatlo_y = tmpy + 1;
                                            int left_x = tmpx - 1;
                                            int left_y = tmpy;

                                            for (Unit en : randomenemy.enemyUnits) {
                                                if (
                                                        (en.x_pos == tmpx && en.y_pos == tmpy)
                                                                ||
                                                                (en.x_pos == balatlo_x && en.y_pos == balatlo_y)
                                                                ||
                                                                (en.x_pos == high_x && en.y_pos == high_y)
                                                                ||
                                                                (en.x_pos == jobbatlo_x && en.y_pos == jobbatlo_y)
                                                                ||
                                                                (en.x_pos == right_x && en.y_pos == right_y)
                                                                ||
                                                                (en.x_pos == jobbalsoatlo_x && en.y_pos == jobbalsoatlo_y)
                                                                ||
                                                                (en.x_pos == bottom_x && en.y_pos == bottom_y)
                                                                ||
                                                                (en.x_pos == balalsoatlo_x && en.y_pos == balalsoatlo_y)
                                                                ||
                                                                (en.x_pos == left_x && en.y_pos == left_y)) {
                                                    en.setHealth(en.getHealth()- (hero.getVarazsero() * tuzlabda.Sebzes));
                                                    if (en.getHealth() <= 0) {
                                                        game.grid.getChildren().remove(en.getImage());
                                                    }
                                                }
                                            }
                                            hero.setMana(hero.getMana() - 6);
                                            manapointsamount.setText("" + hero.getMana() + "");
                                            if (TuzlabdaAmount.getText().equals("0")){
                                                TuzlabdaAmount.setVisible(false);
                                                TuzlabdaButton.setVisible(false);
                                            }
                                            CheckenemyUnits();
                                            DoesHeroWin();
                                        }
                                    });
                                }
                            });


                            root3.getChildren().addAll(TuzlabdaButton, TuzlabdaAmount);
                        }
                        /**
                         * A gombra kattintva tudunk Feltámasztás varázslatot végezni, melynek következében egy saját egységre kattintva megnöveljük annak életerejét 50*a hős varázserejének értékével.
                         * Ha az életereje nagyobb lesz, mint az egység maximum életereje, akkor a maximum életerőt kapja meg.
                         * Ha nincs elég mana, kilép az Actionből.
                         */
                        if (feltamasztasamount != 0) {
                            FeltamasztasButton.setVisible(false);
                            FeltamadasAmount.setVisible(false);
                            FeltamadasAmount.setLayoutX(140);
                            FeltamadasAmount.setLayoutY(MagLayy+40);
                            FeltamasztasButton.setLayoutX(120);
                            FeltamasztasButton.setLayoutY(MagLayy);
                            FeltamasztasButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    game.grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent event) {
                                            if (Integer.parseInt(manapointsamount.getText()) < 6) {
                                                System.out.println("Nincs elég mana!");
                                                game.grid.setOnMouseClicked(null);
                                                FeltamasztasButton.setOnAction(null);
                                            }
                                            FeltamadasAmount.setText(Integer.parseInt("" + FeltamadasAmount.getText()) - 1 + "");
                                            if (event.getY() > 675 || event.getY() < 125) {
                                                return;
                                            }
                                            int tmpy = (int) Math.floor((event.getY() - 125) / 55);
                                            int tmpx = (int) Math.floor(event.getX() / 55);

                                            for(Unit un : hero.getUnits()){
                                                if (un.x_pos == tmpx && un.y_pos == tmpy) {
                                                    un.setHealth(un.getHealth() + (hero.getVarazsero() * 50));
                                                    System.out.println("A " + un.getName() + " egység életereje: " + un.getHealth());
                                                    System.out.println(un.getMaxHealth());
                                                    if (un.getHealth() > un.getMaxHealth()) {
                                                        un.setHealth(un.getMaxHealth());
                                                        System.out.println("Maximum életerő!");
                                                        System.out.println("A " + un.getName() + " egység életereje: " + un.getHealth());
                                                    }
                                                    break;
                                                }
                                            }
                                            // mana levonása
                                            hero.setMana(hero.getMana() - 6);
                                            manapointsamount.setText("" + hero.getMana() + "");
                                            if (FeltamadasAmount.getText().equals("0")){
                                                FeltamadasAmount.setVisible(false);
                                                FeltamasztasButton.setVisible(false);
                                            }

                                        }
                                    });
                                }
                            });
                            root3.getChildren().addAll(FeltamasztasButton, FeltamadasAmount);
                        }
                        /**
                         * A gombra kattintva tudunk Bonus varázslatot használni, melynek következtében a hős minden tulajdonsága kettővel nő.
                         * Ha már elérte a 9 vagy 10-et (mely a mximum), akkor nem tudjuk használni ezt a varázslatot.
                         * Ha nincs elég mana, kilép az Actionből.
                         */
                        if (bonusamount != 0) {
                            BonusButton.setVisible(false);
                            BonusAmount.setVisible(false);
                            BonusAmount.setLayoutX(200);
                            BonusAmount.setLayoutY(MagLayy+40);
                            BonusButton.setLayoutX(180);
                            BonusButton.setLayoutY(MagLayy);

                            BonusButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    if ( hero.getTamadas() < 9  &&
                                         hero.getVedekezes() < 9 &&
                                         hero.getVarazsero() < 9 &&
                                         hero.getTudas() < 9 &&
                                         hero.getMoral() < 9 &&
                                         hero.getSzerencse() < 9 &&
                                         hero.getMana() >= 10 ){
                                         bonusamount--;
                                         BonusAmount.setText(Integer.parseInt("" + BonusAmount.getText()) - 1 + "");
                                            hero.setMana(hero.getMana() - 10);
                                            manapointsamount.setText("" + hero.getMana() + "");
                                            if (hero.getTamadas() <= 8) {
                                                hero.setTamadas(hero.getTamadas() + 2);
                                            }
                                            if (hero.getVedekezes() <= 8) {
                                                hero.setVedekezes(hero.getVedekezes() + 2);
                                            }
                                            if (hero.getVarazsero() <= 8) {
                                                hero.setVarazsero(hero.getVarazsero() + 2);
                                            }
                                            if (hero.getTudas() <= 8) {
                                                hero.setTudas(hero.getTudas() + 2);
                                            }
                                            if(hero.getMoral()<=8){
                                                hero.setMoral(hero.getMoral()+2);
                                            }
                                            if(hero.getSzerencse()<=8){
                                                hero.setSzerencse(hero.getSzerencse()+2);
                                            }
                                        if (BonusAmount.getText().equals("0")){
                                            BonusAmount.setVisible(false);
                                            BonusButton.setVisible(false);
                                        }
                                            System.out.println(hero);
                                        }
                                    else{
                                        System.out.println("Nincs elég manád, vagy már van traited maximum értéken!");
                                    }

                                }


                            });
                            root3.getChildren().addAll(BonusButton, BonusAmount);
                        }
                        /**
                         * A gombra kattintva tudunk DoubleHeal varázslatot használni, ha van megfelelő mennyiségű manánk. A DoubleHeal következtében minden játékos életereje kétszeresére nő.
                         */
                        if (doublehealamount != 0) {
                            DoubleHealButton.setVisible(false);
                            DoubleHealAmount.setVisible(false);
                            DoubleHealAmount.setLayoutX(260);
                            DoubleHealAmount.setLayoutY(MagLayy+40);
                            DoubleHealButton.setLayoutX(240);
                            DoubleHealButton.setLayoutY(MagLayy);
                            DoubleHealButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    if (hero.getMana() >= 10) {
                                        DoubleHealAmount.setText(Integer.parseInt("" + DoubleHealAmount.getText()) - 1 + "");
                                        hero.setMana(hero.getMana() - 10);
                                        manapointsamount.setText(""+hero.getMana());
                                        for (Unit un : hero.getUnits()){
                                            un.setHealth(un.getHealth()*2);
                                            System.out.println("A " + un.getName()+" egységnek "+un.getHealth() + "-re nőtt az életereje!");
                                        }
                                    }
                                    if (DoubleHealAmount.getText().equals("0")){
                                        DoubleHealAmount.setVisible(false);
                                        DoubleHealButton.setVisible(false);
                                    }
                                }
                            });
                            root3.getChildren().addAll(DoubleHealButton, DoubleHealAmount);
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
                /**
                 * A gombra kattintva tudunk venni Támadás szintet. Egyszerre csak egyet, s az ára növekszik mnindig 10%-val.
                 */
                int Labely = 620;
                Label TamadasLabel = new Label("Támadás:");
                TamadasLabel.setLayoutX(300);
                TamadasLabel.setLayoutY(Labely);
                TamadasLabel.setFont(new Font("Cardinal", 20));
                TamadasLabelAMount = new Label("1");
                TamadasLabelAMount.setLayoutX(390);
                TamadasLabelAMount.setLayoutY(Labely);
                TamadasLabelAMount.setFont(new Font("Cardinal", 20));
                SpecButton TamadasButtonIncrease = new SpecButton("+");
                TamadasButtonIncrease.setLayoutX(330);
                TamadasButtonIncrease.setLayoutY(Labely + 40);

                TamadasButtonIncrease.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < Globals.priceofTamadas || (Integer.parseInt(TamadasLabelAMount.getText()) == 10)) {

                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - Globals.priceofTamadas) + "");
                            int TamadasValue = Integer.parseInt(TamadasLabelAMount.getText());
                            TamadasLabelAMount.setText("" + (TamadasValue + 1) + "");
                            Globals.priceofTamadas = (int) (Math.ceil(Globals.priceofTamadas * 0.1) + Globals.priceofTamadas);


                        }
                    }
                });
                //Tamadas End ---------------->
/**
 * A gombra kattintva tudunk venni Védekezés szintet. Egyszerre csak egyet, s az ára növekszik mnindig 10%-val.
 */
                Label VedekezesLabel = new Label("Védekezés:");
                VedekezesLabel.setLayoutX(450);
                VedekezesLabel.setLayoutY(Labely);
                VedekezesLabel.setFont(new Font("Cardinal", 20));
                VedekezesLabelAmount = new Label("1");
                VedekezesLabelAmount.setLayoutX(560);
                VedekezesLabelAmount.setLayoutY(Labely);
                VedekezesLabelAmount.setFont(new Font("Cardinal", 20));
                SpecButton VedekezesButtonIncrease = new SpecButton("+");
                VedekezesButtonIncrease.setLayoutX(480);
                VedekezesButtonIncrease.setLayoutY(Labely + 40);
                VedekezesButtonIncrease.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < Globals.priceofVedekezes || (Integer.parseInt(VedekezesLabelAmount.getText()) == 10)) {
                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - Globals.priceofVedekezes) + "");
                            int VedekezesValue = Integer.parseInt(VedekezesLabelAmount.getText());
                            VedekezesLabelAmount.setText("" + (VedekezesValue + 1) + "");
                            Globals.priceofVedekezes = (int) (Math.ceil(Globals.priceofVedekezes * 0.1) + Globals.priceofVedekezes);

                        }
                    }
                });
                //Vedekezes End ----------------->
/**
 * A gombra kattintva tudunk venni Varázserő szintet. Egyszerre csak egyet, s az ára növekszik mnindig 10%-val.
 */
                Label VarazseroLabel = new Label("Varázserő:");
                VarazseroLabel.setLayoutX(600);
                VarazseroLabel.setLayoutY(Labely);
                VarazseroLabel.setFont(new Font("Cardinal", 20));
                VarazseroLabelAmount = new Label("1");
                VarazseroLabelAmount.setLayoutX(700);
                VarazseroLabelAmount.setLayoutY(Labely);
                VarazseroLabelAmount.setFont(new Font("Cardinal", 20));
                SpecButton VarazseroButtonIncrease = new SpecButton("+");
                VarazseroButtonIncrease.setLayoutX(630);
                VarazseroButtonIncrease.setLayoutY(Labely + 40);
                VarazseroButtonIncrease.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < Globals.priceofVarazsero || (Integer.parseInt(VarazseroLabelAmount.getText()) == 10)) {
                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - Globals.priceofVarazsero) + "");
                            int VarazseroValue = Integer.parseInt(VarazseroLabelAmount.getText());
                            VarazseroLabelAmount.setText("" + (VarazseroValue + 1) + "");
                            Globals.priceofVarazsero = (int) (Math.ceil(Globals.priceofVarazsero * 0.1) + Globals.priceofVarazsero);

                        }
                    }
                });
                //Varazsero End ---------------------------->
/**
 * A gombra kattintva tudunk venni Tudás szintet. Egyszerre csak egyet, s az ára növekszik mnindig 10%-val.
 */
                Label TudasLabel = new Label("Tudás:");
                TudasLabel.setLayoutX(750);
                TudasLabel.setLayoutY(Labely);
                TudasLabel.setFont(new Font("Cardinal", 20));
                TudasLabelAmount = new Label("1");
                TudasLabelAmount.setLayoutX(830);
                TudasLabelAmount.setLayoutY(Labely);
                TudasLabelAmount.setFont(new Font("Cardinal", 20));
                SpecButton TudasButtonIncrease = new SpecButton("+");
                TudasButtonIncrease.setLayoutX(780);
                TudasButtonIncrease.setLayoutY(Labely + 40);
                TudasButtonIncrease.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        if (Integer.parseInt(GoldAmount.getText()) < Globals.priceofTudas || (Integer.parseInt(TudasLabelAmount.getText()) == 10)) {

                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - Globals.priceofTudas) + "");
                            int TudasValue = Integer.parseInt(TudasLabelAmount.getText());
                            TudasLabelAmount.setText("" + (TudasValue + 1) + "");
                            Globals.priceofTudas = (int) (Math.ceil(Globals.priceofTudas * 0.1) + Globals.priceofTudas);

                        }
                    }
                });
                //Tudas End --------------------------->
/**
 * A gombra kattintva tudunk venni Morál szintet. Egyszerre csak egyet, s az ára növekszik mnindig 10%-val.
 */
                Label MoralLabel = new Label("Morál:");
                MoralLabel.setLayoutX(900);
                MoralLabel.setLayoutY(Labely);
                MoralLabel.setFont(new Font("Cardinal", 20));
                MoralLabelAmount = new Label("1");
                MoralLabelAmount.setLayoutX(970);
                MoralLabelAmount.setLayoutY(Labely);
                MoralLabelAmount.setFont(new Font("Cardinal", 20));
                SpecButton MoralButtonIncrease = new SpecButton("+");
                MoralButtonIncrease.setLayoutX(930);
                MoralButtonIncrease.setLayoutY(Labely + 40);
                MoralButtonIncrease.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        if (Integer.parseInt(GoldAmount.getText()) < Globals.priceofMoral || (Integer.parseInt(MoralLabelAmount.getText()) == 10)) {

                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - Globals.priceofMoral) + "");
                            int MoralValue = Integer.parseInt(MoralLabelAmount.getText());
                            MoralLabelAmount.setText("" + (MoralValue + 1) + "");
                            Globals.priceofMoral = (int) (Math.ceil(Globals.priceofMoral * 0.1) + Globals.priceofMoral);

                        }
                    }
                });
                // Moral End --------------------------->
                /**
                 * A gombra kattintva tudunk venni Szerencse szintet. Egyszerre csak egyet, s az ára növekszik mnindig 10%-val.
                 */

                Label SzerencseLabel = new Label("Szerencse:");
                SzerencseLabel.setLayoutX(1050);
                SzerencseLabel.setLayoutY(Labely);
                SzerencseLabel.setFont(new Font("Cardinal", 20));
                SzerencseLabelAmount = new Label("1");
                SzerencseLabelAmount.setLayoutX(1150);
                SzerencseLabelAmount.setLayoutY(Labely);
                SzerencseLabelAmount.setFont(new Font("Cardinal", 20));
                SpecButton SzerencseButtonIncrease = new SpecButton("+");
                SzerencseButtonIncrease.setLayoutX(1080);
                SzerencseButtonIncrease.setLayoutY(Labely + 40);
                SzerencseButtonIncrease.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        if (Integer.parseInt(GoldAmount.getText()) < Globals.priceofSzerencse || (Integer.parseInt(SzerencseLabelAmount.getText()) == 10)) {

                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - Globals.priceofSzerencse) + "");
                            int SzerencseValue = Integer.parseInt(SzerencseLabelAmount.getText());
                            SzerencseLabelAmount.setText("" + (SzerencseValue + 1) + "");

                            Globals.priceofSzerencse = (int) (Math.ceil(Globals.priceofSzerencse * 0.1) + Globals.priceofSzerencse);

                        }
                    }
                });
                //  Szerencse End --------------------------->
                root.getChildren().addAll(TamadasLabel, VedekezesLabel, VarazseroLabel, TudasLabel, MoralLabel, SzerencseLabel);
                root.getChildren().addAll(TamadasLabelAMount, VedekezesLabelAmount, VarazseroLabelAmount, TudasLabelAmount, MoralLabelAmount, SzerencseLabelAmount);
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
                FoldmuvesAmount = new Label("0");
                //Ijasz
                Label Ijasz = new Label("Ijász: ");
                IjaszAmount = new Label("0");
                //Sarkany
                Label Sarkany = new Label("Griff: ");
                SarkanyAmount = new Label("0");
                //Cica
                Label Cica = new Label("Cica: ");
                CicaAmount = new Label("0");
                //Páncélos Cica
                Label ArmouredCica = new Label("Páncélos Cica");
                ArmnouredCicaAmount = new Label("0");


                //Magic Labels
                //Tuzlabda label
                Label Tuzlabdalabel = new Label("Tűzlabda:");
                Tuzlabdalabel.setLayoutX(50);
                Tuzlabdalabel.setLayoutY(500);
                Tuzlabdalabel.setFont(new Font("Cardinal", 25));
                TuzlabdaAmount.setLayoutX(230);
                TuzlabdaAmount.setLayoutY(500);
                TuzlabdaAmount.setFont(new Font("Cardinal", 25));

                //Villamcsapaslabel
                Label VillamcsapasLabel = new Label("Villámcsapás:");
                VillamcsapasLabel.setLayoutX(50);
                VillamcsapasLabel.setLayoutY(550);
                VillamcsapasLabel.setFont(new Font("Cardinal", 25));
                VillamcsapasAmount.setLayoutX(230);
                VillamcsapasAmount.setLayoutY(550);
                VillamcsapasAmount.setFont(new Font("Cardinal", 25));

                //Feltamadaslabel
                Label FeltamadasLabel = new Label("Feltámadás:");
                FeltamadasLabel.setLayoutX(50);
                FeltamadasLabel.setLayoutY(600);
                FeltamadasLabel.setFont(new Font("Cardinal", 25));
                FeltamadasAmount.setLayoutX(230);
                FeltamadasAmount.setLayoutY(600);
                FeltamadasAmount.setFont(new Font("Cardinal", 25));

                //Bonuslabel
                Label BonusLabel = new Label("Bonus:");
                BonusLabel.setLayoutX(50);
                BonusLabel.setLayoutY(650);
                BonusLabel.setFont(new Font("Cardinal", 25));

                BonusAmount.setLayoutX(230);
                BonusAmount.setLayoutY(650);
                BonusAmount.setFont(new Font("Cardinal", 25));

                //Doubleheal label
                Label DoubleHealLabel = new Label("DoubleHeal:");
                DoubleHealLabel.setLayoutX(50);
                DoubleHealLabel.setLayoutY(700);
                DoubleHealLabel.setFont(new Font("Cardinal", 25));
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
                /**
                 * A gombra kattintva vehetünk Földművest.
                 */
                HeroesOfMightButton FoldmuvesButton = new HeroesOfMightButton("Földm.");
                Tooltip FmTp = new Tooltip();
                FmTp.setText("Sebzés: 1-1, Életerő: 3, Sebesség: 4, Kezdeményezés: 8, Sepciális képesség: nincs");
                FoldmuvesButton.setTooltip(FmTp);
                FoldmuvesButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        startGameButton.setVisible(true);

                        if (Integer.parseInt(GoldAmount.getText()) < 2) {

                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 2) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue + 1) + "");
                            int Foldmuvesvalue = Integer.parseInt(FoldmuvesAmount.getText());
                            FoldmuvesAmount.setText("" + (Foldmuvesvalue + 1) + "");
                            foldmuvesAmount++;

                        }
                    }
                });

                FoldmuvesButton.setLayoutX(350);
                FoldmuvesButton.setLayoutY(150);

                //Ijász gomb
                /**
                 * A gombra kattintva vehetünk Íjászt.
                 */
                HeroesOfMightButton IjaszButton = new HeroesOfMightButton("Íjász");
                Tooltip ijtp = new Tooltip();
                ijtp.setText("Sebzés: 2-4, Életerő: 7, Sebesség: 4, Kezdeményezés: 9, Sepciális képesség: lövés");
                IjaszButton.setTooltip(ijtp);
                IjaszButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        startGameButton.setVisible(true);
                        if (Integer.parseInt(GoldAmount.getText()) < 6) {

                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 6) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue + 1) + "");
                            int ijaszvalue = Integer.parseInt(IjaszAmount.getText());
                            IjaszAmount.setText("" + (ijaszvalue + 1) + "");
                            ijaszAmount++;

                        }
                    }
                });


                IjaszButton.setLayoutX(350);
                IjaszButton.setLayoutY(250);

                //Griff gomb
                /**
                 * A gombra kattintva vehetünk Griffet.
                 */
                HeroesOfMightButton SarkanyButton = new HeroesOfMightButton("Griff");
                Tooltip grtp = new Tooltip();
                grtp.setText("Sebzés: 5-10, Életerő: 30, Sebesség: 7, Kezdeményezés: 15, Sepciális képesség: végtelen visszatámadás");
                SarkanyButton.setTooltip(grtp);
                SarkanyButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        startGameButton.setVisible(true);
                        if (Integer.parseInt(GoldAmount.getText()) < 15) {

                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 15) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue + 1) + "");
                            int Sarkanyvalue = Integer.parseInt(SarkanyAmount.getText());
                            SarkanyAmount.setText("" + (Sarkanyvalue + 1) + "");
                            griffAmount++;

                        }
                    }
                });

                SarkanyButton.setLayoutX(350);
                SarkanyButton.setLayoutY(350);

                //Cica gomb
                /**
                 * A gombra kattintva vehetünk cicát.
                 */
                HeroesOfMightButton CicaButton = new HeroesOfMightButton("Cica");
                Tooltip cicatp = new Tooltip();
                cicatp.setText("Sebzés: 10-20, Életerő: 50, Sebesség: 10, Kezdeményezés: 20, Sepciális képesség: nyávog");
                CicaButton.setTooltip(cicatp);
                CicaButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        startGameButton.setVisible(true);
                        if (Integer.parseInt(GoldAmount.getText()) < 20) {

                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 20) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue + 1) + "");
                            int Cicavalue = Integer.parseInt(CicaAmount.getText());
                            CicaAmount.setText("" + (Cicavalue + 1) + "");
                            cicaAmount++;

                        }
                    }
                });

                CicaButton.setLayoutX(350);
                CicaButton.setLayoutY(450);

                //Páncéloscica gomb
                /**
                 * A gombra kattintva vehetünk Páncélos cicát.
                 */
                HeroesOfMightButton ArmouredCatButton = new HeroesOfMightButton("P. Cica");
                Tooltip arcicatp = new Tooltip();
                arcicatp.setText("Sebzés: 50-100, Életerő: 100, Sebesség: 3, Kezdeményezés: 50, Sepciális képesség: nyávog, csak hangosabban");
                ArmouredCatButton.setTooltip(arcicatp);
                ArmouredCatButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        startGameButton.setVisible(true);
                        if (Integer.parseInt(GoldAmount.getText()) < 50) {

                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 50) + "");
                            int unitvalue = Integer.parseInt(UnitAmount.getText());
                            UnitAmount.setText("" + (unitvalue + 1) + "");
                            int ArmouredCicavalue = Integer.parseInt(ArmnouredCicaAmount.getText());
                            ArmnouredCicaAmount.setText("" + (ArmouredCicavalue + 1) + "");
                            armourdercicaamount++;

                        }
                    }
                });

                ArmouredCatButton.setLayoutX(350);
                ArmouredCatButton.setLayoutY(550);


                //Varázserő Gombok --------------------------------------------->
                //Tűzlabda gomb
                /**
                 * A gombar kattintva vásárolhatunk Tűzlabda varázslatot.
                 */
                HeroesOfMightButton TuzlabdaButton = new HeroesOfMightButton("TUzL.");
                Tooltip tuzlabdatp = new Tooltip();
                tuzlabdatp.setText("Egy kiválasztott mező körüli 3x3-as területen lévő\n" +
                        "összes (saját, illetve ellenséges) egységre\n" +
                        "(varázserő * 20) sebzés okozása\n");
                TuzlabdaButton.setTooltip(tuzlabdatp);
                TuzlabdaButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < 120) {

                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 120) + "");
                            int tuzvalue = Integer.parseInt(TuzlabdaAmount.getText());
                            TuzlabdaAmount.setText("" + (tuzvalue + 1) + "");
                            tuzlabdaamount++;
                        }
                    }
                });
                TuzlabdaButton.setLayoutX(800);
                TuzlabdaButton.setLayoutY(150);

                /**
                 * A gombar kattintva vásárolhatunk villámcsapás varázslatot.
                 */
                HeroesOfMightButton VillamcsapasButton = new HeroesOfMightButton("Villám");

                Tooltip villamtp = new Tooltip();
                villamtp.setText("Egy kiválasztott ellenséges egységre (varázserő * 30) sebzés okozása");
                VillamcsapasButton.setTooltip(villamtp);
                VillamcsapasButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < 60) {

                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 60) + "");
                            int Villamvalue = Integer.parseInt(VillamcsapasAmount.getText());
                            VillamcsapasAmount.setText("" + (Villamvalue + 1) + "");
                            villamcsapasamount++;
                        }
                    }
                });
                VillamcsapasButton.setLayoutX(800);
                VillamcsapasButton.setLayoutY(250);

                /**
                 * A gombra kattintva vásárolhatunk feltámasztás varázslatot, felette maradva a kurzorral kiírja, mit is tehetünk a varázslattal.
                 */
                HeroesOfMightButton FeltamasztasButton = new HeroesOfMightButton("Feltam.");
                Tooltip felttp = new Tooltip();
                felttp.setText("Egy kiválasztott saját egység feltámasztása.\n" +
                        "Maximális gyógyítás mértéke: (varázserő * 50)\n");
                FeltamasztasButton.setTooltip(felttp);
                FeltamasztasButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < 120) {
                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 120) + "");
                            int Feltamadasvalue = Integer.parseInt(FeltamadasAmount.getText());
                            FeltamadasAmount.setText("" + (Feltamadasvalue + 1) + "");
                            feltamasztasamount++;
                        }
                    }
                });
                FeltamasztasButton.setLayoutX(800);
                FeltamasztasButton.setLayoutY(350);


                HeroesOfMightButton TraitBonusButton = new HeroesOfMightButton("Bonus");
                Tooltip bonustp = new Tooltip();
                bonustp.setText("Megnövel minden traitet 2-vel.");
                TraitBonusButton.setTooltip(bonustp);
                TraitBonusButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (Integer.parseInt(GoldAmount.getText()) < 200) {

                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 200) + "");
                            int Bonusvalue = Integer.parseInt(BonusAmount.getText());
                            BonusAmount.setText("" + (Bonusvalue + 1) + "");
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
                        if (Integer.parseInt(GoldAmount.getText()) < 200) {
                        } else {
                            int gvalue = Integer.parseInt(GoldAmount.getText());
                            GoldAmount.setText("" + (gvalue - 200) + "");
                            int DoublehealValue = Integer.parseInt(DoubleHealAmount.getText());
                            DoubleHealAmount.setText("" + (DoublehealValue + 1) + "");
                            doublehealamount++;
                        }
                    }
                });

                DoubleHealButton.setLayoutX(800);
                DoubleHealButton.setLayoutY(550);


                Image backgroundImage = new Image("grass.png", true);
                root.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, null, null)));

                root.getChildren().addAll(mainLabel, GoldLabel, GoldAmount, CurrentUnits, UnitAmount, Foldmuves, FoldmuvesAmount, Ijasz, IjaszAmount, Sarkany, SarkanyAmount, Cica, CicaAmount, ArmouredCica, ArmnouredCicaAmount, UnitLabel, MagicLabel); //Labels added
                root.getChildren().addAll(exitButtonFromGame, startGameButton, FoldmuvesButton, IjaszButton, SarkanyButton, CicaButton, ArmouredCatButton, TuzlabdaButton, VillamcsapasButton, FeltamasztasButton, TraitBonusButton, DoubleHealButton); //Buttons added
                Globals.primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
            }


        });
        addMenuButton(startButton);
    }

    /**
     * Ez a metódus létrehozza a MODE menüt, melyben ki tudjuk választani, hogy milyen nehézségi szinten szeretnénk játszani.
     * A megfelelő gombra kattintva pedig beállítódik a játék nehézségi szintje.
     *
     */
    private void createModeButton() {
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
                mediumButton.setLayoutY(MENU_BUTTONS_START_Y + 150);
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
                hardButton.setLayoutY(MENU_BUTTONS_START_Y + 300);
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
                Image backgroundImage = new Image("grass.png", true);
                root.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, null, null)));
                Globals.primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
            }
        });
        addMenuButton(ModeButton);
    }

    /**
     * Ezen metódus elkészíti a HOW TO gombot, mely létrehoz egy új Scene-t, melyen látható a játék leírása/útmutatója.
     *
     */
    private void createHowToButton() {
        HeroesOfMightButton HowToButton = new HeroesOfMightButton("HOW TO");
        HowToButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Scene menu = Globals.primaryStage.getScene();
                SpecButton backButton = new SpecButton("x");
                backButton.setLayoutX(0);
                backButton.setLayoutY(0);
                backButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                    Globals.primaryStage.setScene(menu);
                    }
                });
                Pane root = new Pane();
                Image backgroundImage = new Image("grass.png", true);
                root.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, null, null)));
                Text text = new Text("A játék főmenüjében 4 menüpont található. Play, Mode, How to illetve egy Exit. Mielőtt a Play gombra kattintunk,\n" +
                                        "először a Mode menüt keressük meg, ahol kiválasztjuk, hogy milyen nehézségi szinten szeretnénk játszani. Ez be-\n" +
                                        "-folyásolja, hogy mennyi aranyat tudunk felhasználni a játék során. Könnyű mód esetén 1300, közepes mód esetén \n" +
                                        "1000, míg nehéz módon 700 aranyat tudunk felhasználni. Miután választottunk nehézségi szintet, a főmenüben meg-\n" +
                                        "jelenik egy kép aszerint, milyen módban vagyunk. Ezután a Play gombra kattintva egy menübe érkezünk, ahol megte-\n" +
                                        "-hetjük az alapvető vásárlásokat. Ezen menüpont alatt tudjuk kiválasztani, milyen egységből mennyit szeretnénk \n" +
                                        "magunkkal vinni a csatába, milyen varázslatot szeretnénk alkalmazni a játék során, illetve növelhetjük a tulaj-\n" +
                                        "-donság pontjainkat, melyeknek a játék során vannak befolyásaik bizonyos cselekedetekkel. (Melyről szó esik a kö-\n" +
                                        "-telező program PDF-ben). Amint válaszotttunk már egy egységet is, akkor megjelenik a jobb felső sarokban egy start\n" +
                                        " gomb, melyre kattintva egy új képernyőre érünk, ahol egy 12*10-es tábla helyezkedik el többnyire a tábla közepétől \n" +
                                        " jobbra. Bal oldalt látható pár gomb, melyek reprezentálják, hogy milyen egységeket vettünk. F, mint Földműves, I,\n" +
                                        " mint Íjász, G, mint Griff C, mint Cica illetve P, mint Páncéloscica. Amely gombra kattintunk, azt a karaktert helyez-\n" +
                                        "-hetjük el a térképen, azonban a térkép csak a balt lévő első kettő oszlopába helyezhetünk egységet. Amint erre a képer-\n" +
                                        "-nyőre értünk, megjelenik az ellefnél minden egysége, melyet magának választott ki a játék során. Miután minden egysé-\n" +
                                        "-günket elhelyeztük a térképen, a játék elkezdődik. A konzolra kiíródik az ellenfél minden adata, hogyan vásárolt be\n" +
                                        " magának. Minden esetben egy-egy utasítás sorozat kiíródik a konzolra, azonban ez nem befolyásolja a játékot. Egy \n" +
                                        "saját egységre kattintás után egy másik mezőbe kattintva léphetünk egy megadott egységgel. Miután a játék elkezdődött,\n" +
                                        " megjelennek a megvásárolt varázslatok gombok formájában:T, mint Tűzlabda, V, mint Villámcsapás, F, mint Feltámasztás, \n" +
                                        "B, mint Bonus illetve D, mint DoubleHeal. " +
                                        "\nA játékot meg lehet nyerni jelenleg, ha varázslatokat veszünk (pl Tűzlabdát, vagy Villámcsapást), és a varázserőt maximumra\n" +
                                        "növeljük. Miután minden ellenséges egység meghalt, a játék kiírja, hogy YOU WIN, majd 5 másodperc után bezárja az\n" +
                                        " ablakot. A játék még nem teljes, hiányosak benne funkciók." );
                text.setLayoutX(100);
                text.setLayoutY(100);
                text.setFont(new Font(20));
                root.getChildren().add(text);
                root.getChildren().add(backButton);
                Globals.primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));

            }
        });
        addMenuButton(HowToButton);
    }

    /**
     * Ez a metódus egy kilépés gombot generál. Annak lenyomásával bezárja a játékot.
     */
    private void createExitButton() {
        HeroesOfMightButton ExitButton = new HeroesOfMightButton("EXIT");
        ExitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainStage.close();
            }
        });
        addMenuButton(ExitButton);
    }

    /**
     * Ezen metódus a háttér beállítását végzi.
     */
    private void createBackground() {
        Image backgroundImage = new Image("grass.png", true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }

    /**
     * Ezen metódus segítségével állítjuk be, hogy milyen szinten vagyunk, s a szerint állít be egy képet a főmenüben, illetve állítja be az arany értéket, amelyet használhatunk nehézségi szint serint a játékban.
     */
    private void setDifficultyBackground() {
        Image easyImage = new Image("easy.png");
        Image mediumImage = new Image("medium.png");
        Image hardImage = new Image("hard.png");
        Globals.GlobalImgView.setFitHeight(400);
        Globals.GlobalImgView.setFitWidth(400);
        Globals.GlobalImgView.setLayoutX(600);
        Globals.GlobalImgView.setLayoutY(250);

        if (Globals.difficulty == 1) {
            Globals.GlobalImgView.setImage(easyImage);
            Globals.GoldAmount = 1300;
        }
        if (Globals.difficulty == 2) {
            Globals.GlobalImgView.setImage(mediumImage);
            Globals.GoldAmount = 1000;
        }
        if (Globals.difficulty == 3) {
            Globals.GlobalImgView.setImage(hardImage);
            Globals.GoldAmount = 700;
        }
    }

    /**
     * Ez a metódus létrehozza a fő menüben lévő címet.
     * Paramétere nincs, visszatérési értéke sincs.
     */
    private void CreateMainLabelText() {
        Label text = new Label("HEROES OF MIGHT");
        text.setLayoutX(350);
        text.setLayoutY(30);
        text.setFont(new Font("Beau Rivage", 50));
        text.setTextFill(Color.web("#000000", 0.8));
        mainPane.getChildren().add(text);
    }

    /**
     * Ez a metódus egy ellenőrzési szempont, mellyel megvizsgáljuk ,hogy a megadott cella tartalmaz-e egy megadott objektumot, vagy sem. Ha tartalmaz bizonyos objektumot, akkor igazzal térünk vissza, ellenkező esetben hamissal.
     * @param rowIndex sor index
     * @param columnIndex oszlop index
     * @return
     */
    public boolean getNodeByRowColumnIndex(int rowIndex, int columnIndex) {
        ObservableList<Node> observableList = game.grid.getChildren();
        for (Node nd : observableList) {

            if (GridPane.getRowIndex(nd) == rowIndex && GridPane.getColumnIndex(nd) == columnIndex && GridPane.getRowIndex(nd) != null && GridPane.getColumnIndex(nd) != null) {
                System.out.println(nd.toString());
                return true;
            }
        }
        return false;
    }

    /*
    public ImageView getNodeByRowColumnIndex2(int rowIndex, int columnIndex) {

        ObservableList<Node> observableList = game.grid.getChildren();
        for (Node nd : observableList){

            if (GridPane.getRowIndex(nd) != null && GridPane.getColumnIndex(nd) != null && GridPane.getRowIndex(nd) == rowIndex && GridPane.getColumnIndex(nd) == columnIndex ){
                //System.out.println(nd.toString());
                return (ImageView) nd;
            }
        }
        return null;
    }

     */

    /**
     * Ez a metódus hozzáadja a megadott hős képét a megfelelő cellába.
     *
     * @param col oszlop
     * @param row sor
     * @param img hős kép
     */
    public void addPictureToCell(int col, int row, ImageView img) {
        game.grid.add(img, col, row);
    }


    /**
     * Ez a metódus tovább adja az előkészített egységeket, melyeket vásároltunk a hős osztályban lévő hősnek.     *
     * @param hero egy Hero osztályt kell megadnunk, hogy melyik hősnek adunk hozzá egységet.
     */
    public void addherotoherounits(Hero hero) {
        if (Integer.parseInt(FoldmuvesAmount.getText()) > 0) {
            if (Integer.parseInt(FoldmuvesAmount.getText()) > 0) {
                foldmuves.unitamount = Integer.parseInt(FoldmuvesAmount.getText());
                foldmuves.setDamage(foldmuves.getDamage() * foldmuves.unitamount);
                foldmuves.setHealth(foldmuves.getHealth() * foldmuves.unitamount);
                hero.getUnits().add(foldmuves);
            }

            if (Integer.parseInt(IjaszAmount.getText()) > 0) {

                ijasz.unitamount = Integer.parseInt(IjaszAmount.getText());
                ijasz.setDamage(ijasz.getDamage() * ijasz.unitamount);
                ijasz.setHealth(ijasz.getHealth() * ijasz.unitamount);
                hero.getUnits().add(ijasz);
            }

            if (Integer.parseInt(SarkanyAmount.getText()) > 0) {

                griff.unitamount = Integer.parseInt(SarkanyAmount.getText());
                griff.setDamage(griff.getDamage() * griff.unitamount);
                griff.setHealth(griff.getHealth() * griff.unitamount);
                hero.getUnits().add(griff);
            }
            if (Integer.parseInt(CicaAmount.getText()) > 0) {

                cica.unitamount = Integer.parseInt(CicaAmount.getText());
                cica.setDamage(cica.getDamage() * cica.unitamount);
                cica.setHealth(cica.getHealth() * cica.unitamount);
                hero.getUnits().add(cica);
            }
            if (Integer.parseInt(ArmnouredCicaAmount.getText()) > 0) {

                panceloscica.unitamount = Integer.parseInt(ArmnouredCicaAmount.getText());
                panceloscica.setDamage(panceloscica.getDamage() * panceloscica.unitamount);
                panceloscica.setHealth(panceloscica.getHealth() * panceloscica.unitamount);
                hero.getUnits().add(panceloscica);

            }
        }
    }

    /**
     * Ez a metódus ellenőrzi, hogy a játékos készen áll-e a játékra. Amint az összes egységet elhelyezte, abban a pillanatban elkezdődik a játék, s egy saját egységre kattintva
     * már lehet is mozdítani az egységet, megjelennek a megvásárolt varázserők, melyeket fel lehet használni.
     * Nincs paramétere, sem visszatérési értéke.
     */
    public void IsPlayerReadyToStart() {
        if (specButtons.size() == 0) {
            Units.setVisible(false);
            Magics.setVisible(true);
            VillamcsapasAmount.setVisible(true);
            VillamcsapasButton.setVisible(true);
            TuzlabdaAmount.setVisible(true);
            TuzlabdaButton.setVisible(true);
            FeltamadasAmount.setVisible(true);
            FeltamasztasButton.setVisible(true);
            BonusButton.setVisible(true);
            BonusAmount.setVisible(true);
            DoubleHealButton.setVisible(true);
            DoubleHealAmount.setVisible(true);
            game.StartGame();
            DoesHeroWin();
        }
    }

    /**
     * Ez a metódus ellenőrzi, hgoy a játékos megnyerte-e már a játékot, s ha igen, kiírja a pálya közepére, hogy "YOU WIN!", majd 5 másodperc múlva bezárja magát.
     * Nincs paramétere, sem visszatérési értéke.
     */
    public void DoesHeroWin(){
        if(randomenemy.enemyUnits.size() == 0){
            YouWon.setText("YOU WON!");
            YouWon.setVisible(true);
            YouWon.setFont(new Font("Arial", 100));
            YouWon.setLayoutX(500);
            YouWon.setLayoutY(300);
            root3.getChildren().add(YouWon);
            PauseTransition delay = new PauseTransition(Duration.seconds(5));
            delay.setOnFinished(event ->  mainStage.close() );
            delay.play();
        }
    }

    /**
     * Ez a metódus ellenőrzi, hogy az ellenséges egységben halt-e meg valaki, s ha igen, akkor az ellenfél listájából kiveszi a megfelelő egységet, illetve a pályáról leveszi az egységnek a képét.
     *  Nincs paramétere, sem visszatérési értéke.
     *
     */
    public void CheckenemyUnits(){
        for(Unit un : randomenemy.enemyUnits){
            if(un.getHealth() <= 0){
                System.out.println(un.getName() + " Elhalálozott!");
                randomenemy.enemyUnits.remove(un);
                game.grid.getChildren().remove(un.getImage());
                break;
            }
        }
    }



}

