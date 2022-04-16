package classes.magics;
/**
 * Ez az osztály a DoubleHeal varázslat típusát reprezentálja.
 * A Magics osztályból örököl.
 * Nincsen különb dolga, az értékeink megfelelően reprezenetatív.
 */

import classes.Units.Unit;

public class DoubleHeal extends Magic{
    private final int ar;
    private final int mannakoltseg;
    private final String hatas;

    public DoubleHeal(){
        this.ar = 200;
        this.mannakoltseg = 20;
        this.hatas = "Megnöveli egy unit életerejét az életerejének kétszeresével";
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

    public void healelUnitot(Unit egység){

    }
}
