package main.kotprog;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Globals {
    public static Stage primaryStage;
    public static int difficulty = 1;
    public static ImageView GlobalImgView = new ImageView();
    public static int GoldAmount = 1300;
    public static int GoldAmountofEnemy = 1000;

    public static int priceofTamadas = 5;
    public static int priceofVedekezes = 5;
    public static int priceofVarazsero = 5;
    public static int priceofTudas = 5;
    public static int priceofMoral = 5;
    public static int priceofSzerencse = 5;

    public static int priceofTamadasenemy = 5;
    public static int priceofVedekezesenemy = 5;
    public static int priceofVarazseroenemy = 5;
    public static int priceofTudasenemy = 5;
    public static int priceofMoralenemy = 5;
    public static int priceofSzerencseenemy = 5;

    public static int RandomTraitetNovel(int price, int trait, int howmuch, int goldamount){
        for (int i = 0; i < howmuch;i++){
            trait++;
            goldamount -= price;
            price =  (int) (Math.ceil(price *0.1) + price);
            System.out.println(price);
        }
        return price;
    }


}
