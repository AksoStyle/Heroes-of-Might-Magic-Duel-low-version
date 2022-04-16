package classes;

import classes.Units.Unit;

import java.util.ArrayList;

public class Hero {
    private int tamadas; // az egységek sebzését növeli meg, tulajdonságpontonként 10%-kal.
    private int vedekezes; // az egységeket ért sebzést csökkenti, tulajdonságpontonként 5%-kal.
    private int varazsero; //  a hős által idézett varázslatok erősségét növeli.
    private int tudas; //  a hős maximális mannapontjait növeli, tulajdonságpontonként 10-zel.
    private int moral; //  az egységek kezdeményezését növeli, tulajdonságpontonként 1-gyel.
    private int szerencse; // az egységek kritikus támadásának esélyét növeli, tulajdonságpontonként 5%-kal.
    private int mana; // A hős manája, mellyel varázserőt tud használni

    private int Villamcsapas;
    private int Tuzlabda;
    private int Feltamasztas;
    private int bonus;
    private int Doubleheal;
    private ArrayList<Unit> units; // a hős egységei

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }





    public Hero(){
        this.tamadas = 1;
        this.vedekezes = 1;
        this.varazsero = 1;
        this.tudas = 1;
        this.moral = 1;
        this.szerencse = 1;
        this.mana = 10;
        this.Villamcsapas = 0;
        this.Tuzlabda = 0;
        this.Feltamasztas = 0;
        this.bonus = 0;
        this.Doubleheal = 0;

        units = new ArrayList<>();
    }

    public Hero(int tamadas, int vedekezes, int varazsero, int tudas, int moral, int szerencse) {
        setTamadas(tamadas);
        setVedekezes(vedekezes);
        setVarazsero(varazsero);
        setTudas(tudas);
        setMoral(moral);
        setSzerencse(szerencse);
        units = new ArrayList<>();
    }

    public int getTamadas() {
        return tamadas;
    }

    public void setTamadas(int tamadas) {
        if(tamadas < 0){
            this.tamadas = 1;
        }
        else{
            this.tamadas = tamadas;
        }

    }

    public int getVedekezes() {
        return vedekezes;
    }

    public void setVedekezes(int vedekezes) {
        if(vedekezes < 0){
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
        if(varazsero < 0){
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
        if(tudas < 0){
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
        if(moral < 0){
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
        if(szerencse < 0){
            this.szerencse = 1;
        }
        else{
            this.szerencse = szerencse;
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if(mana < 0){
            this.mana = 10;
        }
        else{
            this.mana = mana;
        }
    }

    public int getVillamcsapas() {
        return Villamcsapas;
    }

    public void setVillamcsapas(int villamcsapas) {
        Villamcsapas = villamcsapas;
    }

    public int getTuzlabda() {
        return Tuzlabda;
    }

    public void setTuzlabda(int tuzlabda) {
        Tuzlabda = tuzlabda;
    }

    public int getFeltamasztas() {
        return Feltamasztas;
    }

    public void setFeltamasztas(int feltamasztas) {
        Feltamasztas = feltamasztas;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getDoubleheal() {
        return Doubleheal;
    }

    public void setDoubleheal(int doubleheal) {
        Doubleheal = doubleheal;
    }

    @Override
    public String toString() {
        return "A Hős támadási pontja: " + tamadas +
                ", Védekezése: " + vedekezes +
                ", Varázsereje: " + varazsero +
                ", Tudása: " + tudas +
                ", Morálja: " + moral +
                ", Szerencséje: " + szerencse +
                ", Manája: " + mana +
                "";
    }


}
