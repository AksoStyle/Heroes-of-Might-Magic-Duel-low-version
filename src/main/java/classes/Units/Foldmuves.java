package classes.Units;

import java.util.Random;

public class Foldmuves extends Unit{
    private final String name = "Földműves";
    private int Health;
    private int Damage;
    private int Speed;
    private int Initiation;
    private String Speciality;
    Random r = new Random();

    public Foldmuves(){
        Health = 3;
        Damage = r.nextInt(1-1);
        Speed = 4;
        Initiation = 8;
        Speciality = "None";
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


}
