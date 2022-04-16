package classes.magics;

import classes.magics.Magic;

public class VillamCsapas extends Magic {
    private final int ar;
    private final int mannakoltseg;
    public int Sebzes;
    private final String hatas; // "30xsebzes1";

    public VillamCsapas() {
        this.ar = 60;
        this.mannakoltseg = 5;
        Sebzes = 30;
        this.hatas = "30xsebzes1";
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
