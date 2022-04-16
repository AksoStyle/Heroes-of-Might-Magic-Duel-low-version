package classes.magics;

/**
 * Ez az osztály a Bonus varázslat típusát reprezentálja.
 * A Magics osztályból örököl.
 * Nincsen különb dolga, az értékeink megfelelően reprezenetatív.
 */

public class Bonus extends Magic{
    private final int ar;
    private final int mannakoltseg;
    private final String hatas; //"Megnövel minden traitet 2-vel.";

    public Bonus(){
        this.ar = 200;
        this.mannakoltseg = 200;
        this.hatas = "Megnövel minden traitet 2-vel.";
    }

    @Override
    public int getAr() {
        return ar;
    }

    @Override
    public int getMannakoltseg() {
        return mannakoltseg;
    }

    @Override
    public String getHatas() {
        return hatas;
    }

}
