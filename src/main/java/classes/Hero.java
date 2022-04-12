package classes;

public class Hero {
    private int tamadas; // az egységek sebzését növeli meg, tulajdonságpontonként 10%-kal.
    private int vedekezes; // az egységeket ért sebzést csökkenti, tulajdonságpontonként 5%-kal.
    private int varazsero; //  a hős által idézett varázslatok erősségét növeli.
    private int tudas; //  a hős maximális mannapontjait növeli, tulajdonságpontonként 10-zel.
    private int moral; //  az egységek kezdeményezését növeli, tulajdonságpontonként 1-gyel.
    private int szerencse; // az egységek kritikus támadásának esélyét növeli, tulajdonságpontonként 5%-kal.
    private int mana; // A hős manája, mellyel varázserőt tud használni


    public Hero(){
        this.tamadas = 1;
        this.vedekezes = 1;
        this.varazsero = 1;
        this.tudas = 1;
        this.moral = 1;
        this.szerencse = 1;
        this.mana = 10;
    }

    public Hero(int tamadas, int vedekezes, int varazsero, int tudas, int moral, int szerencse) {
        setTamadas(tamadas);
        setVedekezes(vedekezes);
        setVarazsero(varazsero);
        setTudas(tudas);
        setMoral(moral);
        setSzerencse(szerencse);
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
            this.mana = 1;
        }
        else{
            this.mana = mana;
        }
    }

    @Override
    public String toString() {
        return "A Hős támadási pontja: " + tamadas + ", Védekezése: " + vedekezes + ", Varázsereje: " + varazsero + ", Tudása: " + tudas + ", Morálja: " + moral + ", Szerencséje: " + szerencse + ".";
    }


}
