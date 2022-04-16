package classes.Units;

/**
 * Ez az osztály a PáncélosCica osztályt reprezentálja, A unit osztályból örököl.
 * Az osztálynak van: életereje, sebzése, sebessége, kezdeményezése, specialitása, maximum élete illetve egy képe, mely
 * reprezentálja a unitet.
 */
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;

public class PancelosCica extends Unit{
    public final String name = "Cica";
    private int Health;
    private int Damage;
    private int Speed;
    private int Initiation;
    private String Speciality;
    private final String FILE_PATH  = "Unit_PancelosCica.png";
    private Image img = new Image(FILE_PATH);
    private final ImageView image = new ImageView(img);
    private int maxHealth;
    Random r = new Random();

    public PancelosCica(){
        Health = 100;
        Damage = r.nextInt(50,101);
        Speed = 3;
        Initiation = 50;
        maxHealth = 100;
        Speciality = "Meowing louder";
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
