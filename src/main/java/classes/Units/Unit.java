package classes.Units;

public class Unit {
    private int Health;
    private int Damage;
    private int Speed;
    private int Initiation;
    private String Speciality;

    public Unit(){
        Health = 1;
        Damage = 1;
        Speed = 1;
        Initiation = 1;
        Speciality = "";
    }
    public Unit(int health, int damage, int speed, int initiation, String speciality) {
        Health = health;
        Damage = damage;
        Speed = speed;
        Initiation = initiation;
        Speciality = speciality;
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

}
