package classes.Units;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Cica extends Unit{

    public final String name = "Cica";
    private int Health;
    private int Damage;
    private int Speed;
    private int Initiation;
    private final String Speciality;
    private final String FILE_PATH = "Unit_Cica.png";
    private Image img = new Image(FILE_PATH);
    private final ImageView image = new ImageView(img);
    private int maxHealth;
    Random r = new Random();

    public Cica(){
        Health = 50;
        Damage = r.nextInt(10,21) + 10;
        Speed = 10;
        Initiation = 20;
        Speciality = "Meowing";
        maxHealth = 50;
        image.setFitWidth(55);
        image.setFitHeight(55);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public ImageView getImage() {
        return image;
    }
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return Health;
    }

    @Override
    public void setHealth(int health) {
        Health = health;
    }

    @Override
    public int getDamage() {
        return Damage;
    }

    @Override
    public void setDamage(int damage) {
        Damage = damage;
    }

    @Override
    public int getSpeed() {
        return Speed;
    }

    @Override
    public void setSpeed(int speed) {
        Speed = speed;
    }

    @Override
    public int getInitiation() {
        return Initiation;
    }

    @Override
    public void setInitiation(int initiation) {
        Initiation = initiation;
    }
}
