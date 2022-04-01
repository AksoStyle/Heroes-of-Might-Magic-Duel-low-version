package classes;

public class Hero {
    private int tamadas;
    private int vedekezes;
    private int varazsero;
    private int tudas;
    private int moral;
    private int szerencse;
    public int mana;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if(mana < 1){
            this.mana = 1;
        }
        else{
            this.mana = mana;
        }
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
        if (vedekezes < 1){
            this.vedekezes = 1;
        }
        else{
            this.vedekezes = vedekezes;

        }
    }

    public int getVarazsero() {
        return varazsero;
    }

    public void setVarazsero(int varazsero) {
        if (varazsero < 1){
            this.varazsero = 1;
        }
        else{
            this.varazsero = varazsero;

        }
    }

    public int getTudas() {
        return tudas;
    }

    public void setTudas(int tudas) {
        if (tudas < 1){
            this.tudas = 1;
        }
        else{
            this.tudas = tudas;

        }
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        if (moral < 1){
            this.moral = 1;
        }
        else{
            this.moral = moral;

        }
    }

    public int getSzerencse() {
        return szerencse;
    }

    public void setSzerencse(int szerencse) {
        if (szerencse < 1){
            this.szerencse = 1;
        }
        else{
            this.szerencse = szerencse;

        }
    }

    public Hero(){
        this.tamadas = 1;
        this.vedekezes = 1;
        this.varazsero = 1;
        this.tudas = 1;
        this.moral = 1;
        this.szerencse = 1;
        this.mana = 1;
    }

    public Hero(int tamadas, int vedekezes, int varazsero, int tudas, int moral, int szerencse, int mana) {
        this.tamadas = tamadas;
        this.vedekezes = vedekezes;
        this.varazsero = varazsero;
        this.tudas = tudas;
        this.moral = moral;
        this.szerencse = szerencse;
        this.mana = mana;
    }


}
