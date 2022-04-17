package main.kotprog;
/**
 * A game osztály felel tulajdonképpen a karakter mozgaztásáért, támadásáért, counter-támadásért.
 * Tulajdonképpen a játék elindítása is itt van, mivel addig nem lehet egységet mozgatni, míg nincs lehelyezve az
 * összes egység, melyet vásároltunk.
 * Ezek közül csak a mozgatás van megvalósítva.
 *
 */

import classes.Enemy;
import classes.Hero;
import classes.Units.Unit;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import view.ViewManager;

public class Game {
private Hero hos;
private Enemy enemy;
public GridPane grid;
private Unit selectedunit;



private boolean flagForSelectUnit = true;
public boolean isWin = false;

    public Game(Hero hos, Enemy enemy, GridPane grid) {
        this.hos = hos;
        this.enemy = enemy;
        this.grid = grid;

        selectedunit = null;

    }



    /*
    public void KaraktertMozgat(int x_from, int y_from, int x_to, int y_to ) {
        ImageView img = removePictureFromCell(x_from, y_from);
        addPictureToCell(x_to, y_to, img);
        //for ()

    }


     */
    public void addPictureToCell(int col, int row, ImageView img ){
        grid.add(img, col, row);
    }

    public void removePictureFromCell(int row, int col){
        System.out.println(row);
        System.out.println(col);
        ImageView img = getNodeByRowColumnIndex(row, col);
        grid.getChildren().remove(img);
        }

    public void StartGame() {
        System.out.println("StartGame");

            //SelectUnit();
                grid.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if(!flagForSelectUnit){
                            return;
                        }
                        System.out.println("Clicked");
                        if (mouseEvent.getY() > 675 || mouseEvent.getY() < 125) {
                            return;
                        }
                        int tmpy = (int) Math.floor((mouseEvent.getY() - 125) / 55);
                        int tmpx = (int) Math.floor(mouseEvent.getX() / 55);
                        System.out.println(tmpx + " : " + tmpy);
                        if (getNodeByRowColumnIndex(tmpy, tmpx) != null) {
                            for (Unit un : hos.getUnits()) {
//                                System.out.println(un.x_pos+ " : " + un.y_pos);
                                if (un.x_pos == tmpx && un.y_pos == tmpy) {
                                    selectedunit = un;
                                    flagForSelectUnit = false;
                                }
                            }
                        }
                        if (selectedunit == null) {
                            System.out.println("Nincs kiválasztva unit");
                            return;
                        }

                        System.out.println("Kiválasztott unit: " + selectedunit.getName());
                    }
                });
                //MoveUnit();
                grid.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if(flagForSelectUnit){
                            return;
                        }
                        if (mouseEvent.getY() > 675 || mouseEvent.getY() < 125) {
                            return;
                        }
                        int tmpy = (int) Math.floor((mouseEvent.getY() - 125) / 55);
                        int tmpx = (int) Math.floor(mouseEvent.getX() / 55);
                        System.out.println(tmpx + " : " + tmpy);
                        for(Unit un : enemy.enemyUnits) {
                            if (getNodeByRowColumnIndex(tmpy, tmpx) == un.getImage() &&
                                    (selectedunit.x_pos == tmpx - 1 && selectedunit.y_pos == tmpy) ||
                                    (selectedunit.x_pos == tmpx + 1 && selectedunit.y_pos == tmpy) ||
                                    (selectedunit.x_pos == tmpx     && selectedunit.y_pos == tmpy - 1) ||
                                    (selectedunit.x_pos == tmpx     && selectedunit.y_pos == tmpy + 1 ||
                                    (selectedunit.x_pos == tmpx - 1 && selectedunit.y_pos == tmpy - 1) ||
                                    (selectedunit.x_pos == tmpx + 1 && selectedunit.y_pos == tmpy + 1) ||
                                    (selectedunit.x_pos == tmpx - 1 && selectedunit.y_pos == tmpy + 1) ||
                                    (selectedunit.x_pos == tmpx + 1 && selectedunit.y_pos == tmpy - 1))) {
                                un.setHealth(un.getHealth() - selectedunit.getDamage());
                                System.out.println("A " + un.getName() + " életereje: " + un.getHealth()  +", ennyi sebzést szenvedett el: " + selectedunit.getDamage());
                                if (un.getHealth() <= 0) {
                                    System.out.println("A " + un.getName() + " meghalt");
                                    grid.getChildren().remove(un.getImage());
                                    enemy.enemyUnits.remove(un);
                                    flagForSelectUnit = true;
                                    break;
                                }

                            }
                            if (selectedunit.getName().equals("Ijász") && getNodeByRowColumnIndex(tmpy, tmpx) == un.getImage()) {
                                un.setHealth(un.getHealth() - selectedunit.getDamage());
                                System.out.println("A " + un.getName() + " életereje: " + un.getHealth()  +", ennyi sebzést szenvedett el: " + selectedunit.getDamage());
                                if (un.getHealth() <= 0) {
                                    System.out.println("A " + un.getName() + " meghalt");
                                    grid.getChildren().remove(un.getImage());
                                    enemy.enemyUnits.remove(un);
                                    flagForSelectUnit = true;
                                    break;
                                }
                            }

                        }


                        if (getNodeByRowColumnIndex(tmpy, tmpx) == null) {
                            int maxmozgas = selectedunit.getSpeed();
                            int selectedunit_x = selectedunit.x_pos;
                            int selectedunit_y = selectedunit.y_pos;
                            if (selectedunit_x + maxmozgas >= tmpx && selectedunit_x - maxmozgas <= tmpx ||
                                    selectedunit_y + maxmozgas >= tmpy && selectedunit_y - maxmozgas <= tmpy) {
                                selectedunit.x_pos = tmpx;
                                selectedunit.y_pos = tmpy;
                                grid.getChildren().remove(selectedunit.getImage());
                                addPictureToCell(selectedunit.x_pos, selectedunit.y_pos, selectedunit.getImage());
                                flagForSelectUnit = true;
                            } else {
                                System.out.println("Túl messze van a kiválasztott cellától");
                            }
                        } else {
                            System.out.println("A kiválasztott cella foglalt");
                        }
                    }
                });
            }



    public ImageView getNodeByRowColumnIndex(int rowIndex, int columnIndex){

        ObservableList<Node> observableList = grid.getChildren();
        for (Node nd : observableList){

            if (GridPane.getRowIndex(nd) != null && GridPane.getColumnIndex(nd) != null && GridPane.getRowIndex(nd) == rowIndex && GridPane.getColumnIndex(nd) == columnIndex ){
                //System.out.println(nd.toString());
                return (ImageView) nd;
            }
        }
        return null;
    }

    public Hero getHos() {
        return hos;
    }


}


