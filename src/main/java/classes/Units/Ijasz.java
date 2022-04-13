package classes.Units;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Ijasz extends Unit{
    public final String name = "Ijász";
    private int Health;
    private int Damage;
    private int Speed;
    private int Initiation;
    private String Speciality;
    private final String FILE_PATH  = "Unit_Archer.png";
    private Image img = new Image(FILE_PATH);
    private final ImageView image = new ImageView(img);
    Random r = new Random();

    public Ijasz(){
        Health = 7;
        Damage = r.nextInt(2,5) + 1;
        Speed = 4;
        Initiation = 9;
        Speciality = "Shoot";
        image.setFitWidth(55);
        image.setFitHeight(55);
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

    @Override
    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }



}

