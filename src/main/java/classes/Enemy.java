package classes;

public class Enemy {
    private int tamadas; // az egységek sebzését növeli meg, tulajdonságpontonként 10%-kal.
    private int vedekezes; // az egységeket ért sebzést csökkenti, tulajdonságpontonként 5%-kal.
    private int varazsero; //  a hős által idézett varázslatok erősségét növeli.
    private int tudas; //  a hős maximális mannapontjait növeli, tulajdonságpontonként 10-zel.
    private int moral; //  az egységek kezdeményezését növeli, tulajdonságpontonként 1-gyel.
    private int szerencse; // az egységek kritikus támadásának esélyét növeli, tulajdonságpontonként 5%-kal.


    public Enemy(){
        tamadas = 1;
        vedekezes = 1;
        varazsero = 1;
        tudas = 1;
        moral = 1;
        szerencse = 1;
    }

    public Enemy(int tamadas, int vedekezes, int varazsero, int tudas, int moral, int szerencse) {
        this.tamadas = tamadas;
        this.vedekezes = vedekezes;
        this.varazsero = varazsero;
        this.tudas = tudas;
        this.moral = moral;
        this.szerencse = szerencse;
    }

    public int getTamadas() {
        return tamadas;
    }

    public void setTamadas(int tamadas) {

        this.tamadas = tamadas;
    }

    public int getVedekezes() {
        return vedekezes;
    }

    public void setVedekezes(int vedekezes) {
        this.vedekezes = vedekezes;
    }

    public int getVarazsero() {
        return varazsero;
    }

    public void setVarazsero(int varazsero) {
        this.varazsero = varazsero;
    }

    public int getTudas() {
        return tudas;
    }

    public void setTudas(int tudas) {
        this.tudas = tudas;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public int getSzerencse() {
        return szerencse;
    }

    public void setSzerencse(int szerencse) {
        this.szerencse = szerencse;
    }
}
