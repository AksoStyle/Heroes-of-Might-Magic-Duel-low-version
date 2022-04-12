package classes.Units;

import java.util.Random;

public class PancelosCica extends Unit{
    private final String name = "Cica";
    private int Health;
    private int Damage;
    private int Speed;
    private int Initiation;
    private String Speciality;
    Random r = new Random();

    public PancelosCica(){
        Health = 100;
        Damage = r.nextInt(50-100);
        Speed = 3;
        Initiation = 50;
        Speciality = "Meowing louder";
    }
}
