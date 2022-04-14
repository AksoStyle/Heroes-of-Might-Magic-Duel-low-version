package classes;

import classes.Units.*;
import main.kotprog.Globals;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {
    private int tamadas; // az egységek sebzését növeli meg, tulajdonságpontonként 10%-kal.
    private int vedekezes; // az egységeket ért sebzést csökkenti, tulajdonságpontonként 5%-kal.
    private int varazsero; //  a hős által idézett varázslatok erősségét növeli.
    private int tudas; //  a hős maximális mannapontjait növeli, tulajdonságpontonként 10-zel.
    private int moral; //  az egységek kezdeményezését növeli, tulajdonságpontonként 1-gyel.
    private int szerencse; // az egységek kritikus támadásának esélyét növeli, tulajdonságpontonként 5%-kal.
    private final int StartGoldamount = 1000;
    private int goldAmount;

    private int foldmuvesamount;
    private int ijaszamount;
    private int griffamount;
    private int cicaamount;
    private int panceloscicaamount;

    Random rnd = new Random();
    public ArrayList<Unit> enemyUnits = new ArrayList<Unit>();
    Foldmuves enemyfoldmuves = new Foldmuves();
    Ijasz enemyijasz = new Ijasz();
    Griff enenmygriff = new Griff();
    Cica enemycica = new Cica();
    PancelosCica enemypanceloscica = new PancelosCica();


    public Enemy(){
        tamadas = 1;
        vedekezes = 1;
        varazsero = 1;
        tudas = 1;
        moral = 1;
        szerencse = 1;
        foldmuvesamount = 0;
        ijaszamount = 0;
        griffamount = 0;
        cicaamount = 0;
        panceloscicaamount = 0;
    }

    public Enemy(int tamadas, int vedekezes, int varazsero, int tudas, int moral, int szerencse, int foldmuvesamount, int ijaszamount, int griffamount, int cicaamount, int panceloscicaamount) {
        this.goldAmount = StartGoldamount;
        setTamadas(tamadas);
        setVedekezes(vedekezes);
        setVarazsero(varazsero);
        setTudas(tudas);
        setMoral(moral);
        setSzerencse(szerencse);
        setFoldmuvesamount(foldmuvesamount);
        setIjaszamount(ijaszamount);
        setGriffamount(griffamount);
        setCicaamount(cicaamount);
        setPanceloscicaamount(panceloscicaamount);
        if (this.foldmuvesamount > 0){
            enemyUnits.add(enemyfoldmuves);
        }
        if (this.ijaszamount > 0){
            enemyUnits.add(enemyijasz);
        }
        if (this.griffamount > 0){
            enemyUnits.add(enenmygriff);
        }
        if (this.cicaamount > 0){
            enemyUnits.add(enemycica);
        }
        if (this.panceloscicaamount > 0){
            enemyUnits.add(enemypanceloscica);
        }





    }


    //Egységek getter és setter metódusai

    public int getFoldmuvesamount() {
        return foldmuvesamount;
    }

    public void setFoldmuvesamount(int foldmuvesamount) {
        int tmp = this.goldAmount;
        int max = tmp / Globals.priceoffoldmuvesenemy;
        if (tmp < Globals.priceoffoldmuvesenemy){
            foldmuvesamount = 0;
            this.foldmuvesamount = foldmuvesamount;
        }
        else{
            int rndtmp = rnd.nextInt(max)+1;
            tmp -= (rndtmp * Globals.priceoffoldmuvesenemy);
            foldmuvesamount = rndtmp;
            this.goldAmount = tmp;
            this.foldmuvesamount = foldmuvesamount;
        }
    }

    public int getIjaszamount() {
        return ijaszamount;
    }

    public void setIjaszamount(int ijaszamount) {
        int tmp = this.goldAmount;
        int max = tmp / Globals.priceofijaszenemy;
        if (tmp < Globals.priceofijaszenemy){
            ijaszamount = 0;
            this.ijaszamount = ijaszamount;
        }
        else{
            int rndtmp = rnd.nextInt(max)+1;
            tmp -= (rndtmp * Globals.priceofijaszenemy);
            ijaszamount = rndtmp;
            this.goldAmount = tmp;
            this.ijaszamount = ijaszamount;
        }
    }

    public int getGriffamount() {
        return griffamount;
    }

    public void setGriffamount(int griffamount) {
        int tmp = this.goldAmount;
        int max = tmp / Globals.priceofgriffenemy;
        if (tmp < Globals.priceofgriffenemy){
            griffamount = 0;
            this.griffamount = griffamount;
        }
        else{
            int rndtmp = rnd.nextInt(max)+1;
            tmp -= (rndtmp * Globals.priceofgriffenemy);
            griffamount = rndtmp;
            this.goldAmount = tmp;
            this.griffamount = griffamount;
        }
    }

    public int getCicaamount() {
        return cicaamount;
    }

    public void setCicaamount(int cicaamount) {
        int tmp = this.goldAmount;
        int max = tmp / Globals.priceofcicaenemy;

        if (tmp < Globals.priceofcicaenemy){
            cicaamount = 0;
            this.cicaamount = cicaamount;
        }
        else{
            int rndtmp = rnd.nextInt(max)+1;
            tmp -= (rndtmp * Globals.priceofcicaenemy);
            cicaamount = rndtmp;
            this.goldAmount = tmp;
            this.cicaamount = cicaamount;
        }

    }

    public int getPanceloscicaamount() {
        return panceloscicaamount;
    }

    public void setPanceloscicaamount(int panceloscicaamount) {
        int tmp = this.goldAmount;
        int max = tmp / Globals.priceofpanceloscicaenemy;
        if (tmp < Globals.priceofpanceloscicaenemy) {
            panceloscicaamount = 0;
            this.panceloscicaamount = panceloscicaamount;
        }
        else{
            int rndtmp = rnd.nextInt(max)+1;
            tmp -= (rndtmp * Globals.priceofpanceloscicaenemy);
            panceloscicaamount = rndtmp;
            this.goldAmount = tmp;
            this.panceloscicaamount = panceloscicaamount;
        }


    }

    //Tulajdonságok getter és setter metódusai
    public int getTamadas() {
        return tamadas;
    }

    public void setTamadas(int tamadas) {
        int tmp = this.goldAmount;
        for (int i = 0; i < rnd.nextInt(10)+1;i++){

            if (tamadas == 10){
                break;
            }
            tamadas++;
            tmp -= Globals.priceofTamadasenemy;
            Globals.priceofTamadasenemy =  (int) (Math.ceil(Globals.priceofTamadasenemy *0.1) + Globals.priceofTamadasenemy);
        }

        this.goldAmount = tmp;
        this.tamadas = tamadas;
    }

    public int getVedekezes() {
        return vedekezes;
    }

    public void setVedekezes(int vedekezes) {
        int tmp = this.goldAmount;
        for (int i = 0; i < rnd.nextInt(10)+1;i++){

            if (vedekezes == 10){
                break;
            }
            vedekezes++;
            tmp -= Globals.priceofVedekezesenemy;
            Globals.priceofVedekezesenemy =  (int) (Math.ceil(Globals.priceofVedekezesenemy *0.1) + Globals.priceofVedekezesenemy);
        }

        this.goldAmount = tmp;
        this.vedekezes = vedekezes;
    }

    public int getVarazsero() {
        return varazsero;
    }

    public void setVarazsero(int varazsero) {
        int tmp = this.goldAmount;
        for (int i = 0; i < rnd.nextInt(10)+1;i++){

            if (varazsero == 10){
                break;
            }
            varazsero++;
            tmp -= Globals.priceofTudasenemy;
            Globals.priceofVarazseroenemy =  (int) (Math.ceil(Globals.priceofVarazseroenemy *0.1) + Globals.priceofVarazseroenemy);
        }

        this.goldAmount = tmp;
        this.varazsero = varazsero;
    }

    public int getTudas() {
        return tudas;
    }

    public void setTudas(int tudas) {
        int tmp = this.goldAmount;
        for (int i = 0; i < rnd.nextInt(10)+1;i++){

            if (tudas == 10){
                break;
            }
            tudas++;
            tmp -= Globals.priceofTudasenemy;
            Globals.priceofTudasenemy =  (int) (Math.ceil(Globals.priceofTudasenemy *0.1) + Globals.priceofTudasenemy);
        }

        this.goldAmount = tmp;
        this.tudas = tudas;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        int tmp = this.goldAmount;
        for (int i = 0; i < rnd.nextInt(10)+1;i++){

            if (moral == 10){
                break;
            }
            moral++;
            tmp -= Globals.priceofMoralenemy;
            Globals.priceofMoralenemy =  (int) (Math.ceil(Globals.priceofMoralenemy *0.1) + Globals.priceofMoralenemy);
        }

        this.goldAmount = tmp;
        this.moral = moral;
    }

    public int getSzerencse() {
        return szerencse;
    }

    public void setSzerencse(int szerencse) {
        int tmp = this.goldAmount;
        for (int i = 0; i < rnd.nextInt(10)+1;i++){

            if (szerencse == 10){
                break;
            }
            szerencse++;
            tmp -= Globals.priceofSzerencseenemy;
            Globals.priceofSzerencseenemy =  (int) (Math.ceil(Globals.priceofSzerencseenemy *0.1) + Globals.priceofSzerencseenemy);
        }
        this.goldAmount = tmp;
        this.szerencse = szerencse;
    }
    /*
    public static int TraitetNovelRandom(int price, int trait, int howmuch, int goldamount){
        for (int i = 0; i < howmuch;i++){

            if (trait == 10){
                break;
            }
            trait++;
            goldamount -= price;
            price =  (int) (Math.ceil(price *0.1) + price);
            System.out.println("A tulajdonság ára: " + price);
            System.out.println("A tulajdonság értéke: " + trait);
            System.out.println("Ennyi Goldja maradt vissza az ellenfélnek: " + goldamount);
        }
        System.out.println(goldamount);
        return price;
    }
     */

    @Override
    public String toString() {
        return "Az ellenfél tulajdonságai az alábbi módon épülnek fel: \n" +
                "Támadás: " + this.tamadas + "\n" +
                "Védekezés: " + this.vedekezes + "\n" +
                "Varázserő: " + this.varazsero + "\n" +
                "Tudás:" + this.tudas + "\n" +
                "Morál: " + this.moral + "\n" +
                "Szerencse: " + this.szerencse + "\n" +
                "Az ellenfélnek " + this.goldAmount + " Goldja maradt. \n" +
                "Az ellenfél csapata az alábbi módon épül fel: \n" +
                "Földműves: " + this.foldmuvesamount + "\n" +
                "Ijász: " + this.ijaszamount + "\n" +
                "Griff: " + this.griffamount + "\n" +
                "Cica: " + this.cicaamount + "\n" +
                "Páncélos cica: " + this.panceloscicaamount + ".";
    }
}
