package classes.Units;

import java.util.Random;

public class Griff extends Unit{
    private final String name = "Griff";
    private int Health;
    private int Damage;
    private int Speed;
    private int Initiation;
    private String Speciality;
    Random r = new Random();

    public Griff(){
        Health = 30;
        Damage = r.nextInt(5-10);
        Speed = 7;
        Initiation = 15;
        Speciality = "Infinity Counter";
    }


}
