package classes.Units;

import java.util.Random;

public class Cica extends Unit{

    private final String name = "Cica";
    private int Health;
    private int Damage;
    private int Speed;
    private int Initiation;
    private String Speciality;
    Random r = new Random();

    public Cica(){
        Health = 50;
        Damage = r.nextInt(10-20);
        Speed = 10;
        Initiation = 20;
        Speciality = "Meowing";
    }
}
