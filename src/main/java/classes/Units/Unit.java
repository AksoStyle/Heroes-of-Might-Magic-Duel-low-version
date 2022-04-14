package classes.Units;

import javafx.scene.image.ImageView;

public abstract class Unit {
    public String name;
    private int Health;
    private int Damage;
    private int Speed;
    private int Initiation;
    private String Speciality;
    private ImageView image;
    public int x_pos;
    public int y_pos;

    public Unit() {
        Health = 1;
        Damage = 1;
        Speed = 1;
        Initiation = 1;
        Speciality = "";
        x_pos = 20;
        y_pos = 20;
    }
    public Unit(int health, int damage, int speed, int initiation, String speciality) {
        Health = health;
        Damage = damage;
        Speed = speed;
        Initiation = initiation;
        Speciality = speciality;
    }

    public ImageView getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        if (health < 0){
            this.Health = 1;
        }
        else{
            Health = health;
        }

    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        if (damage < 0){
            Damage = 1;
        }
        else{
            Damage = damage;
        }
        Damage = damage;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        if (speed < 0){
            Speed = 1;
        }
        else{
            Speed = speed;
        }

    }

    public int getInitiation() {
        return Initiation;
    }

    public void setInitiation(int initiation) {
        if (initiation < 0){
            Initiation = 1;
        }
        else{
            Initiation = initiation;
        }
    }

    public String getSpeciality() {
        return Speciality;
    }

    public boolean IsLiving(Unit object){
        if (object.Health <= 0){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean DamageUnit(Unit Hero, Unit Enemy){
        Enemy.setHealth(Enemy.getHealth() - Hero.getDamage());
        return true;
    }

    public void CounterAttack(Unit Hero, Unit Enemy){
        if (DamageUnit(Hero, Enemy)){
            DamageUnit(Enemy, Hero);
        }
        if (DamageUnit(Enemy, Hero)){
            DamageUnit(Hero, Enemy);
        }
    }





}
