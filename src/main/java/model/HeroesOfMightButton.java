package model;
/**
 * A HerroesofMightButton osztály egy gomb elkészítéséért felelős osztály.
 * Ezt az osztály példányosítva könnyebben lehet létrehozni ilyen típusú gombot.
 */

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HeroesOfMightButton extends Button{
    private final String FONT_PATH = "src/main/java/model/resources/kenvector_future.ttf";
    private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('yellow_button_pressed.png');";
    private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('yellow_button.png');";

    public HeroesOfMightButton(String text){
        setText(text);
        setButtonFont();
        setPrefWidth(190);
        setPrefHeight(49);
        setStyle(BUTTON_FREE_STYLE);
        initializeButtonListeners();
    }

    /**
     * A gomb szövegének típusát állítjuk be, illetve azt, hogy milyen legyen a gomb kinézete.
     */
    private void setButtonFont(){
        try{
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
        } catch (FileNotFoundException e){
            setFont(Font.font("Verdana", 23));
        }
    }

    /**
     * A gomb lenyomásának stílusa ezen metóduson belül játszódik le.
     */
    private void setButtonPressedStyle(){
        setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4); // the pressed button image height is 4 pixels smaller than the released one
    }

    /**
     * A gomb eleresztésének stílusa.
     */
    private void setButtonReleasedStyle(){
        setStyle(BUTTON_FREE_STYLE);
        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4); //the same happens here as I mentioned above

    }

    /**
     * Listeners a gomb(ok)nak.
     * Lenyomás, elengedés. (egy shadow effect).
     */
    private void initializeButtonListeners(){


        setOnMousePressed(event -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                setButtonPressedStyle();
            }
        });

        setOnMouseReleased(event -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                setButtonReleasedStyle();
            }
        });


        setOnMouseEntered(event -> setEffect(new DropShadow()));

        setOnMouseExited(event -> setEffect(null));

    }


    /*
    private void PathFound(){
        String directoryPath = "src/main/java/model/resources/kenvector_future.ttf";
        File file = new File(directoryPath);

        if(file.isFile()){
            System.out.println("File is a file");
        }
        else{
            System.out.println("it s not a file");
        }
    }

     */
}
