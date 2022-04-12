package classes.magics;

public class Feltamasztas extends Magic{
    private final int ar;
    private final int mannakoltseg;
    private final String hatas;  //"varazserox50felt";

    public Feltamasztas() {
        this.ar = 120;
        this.mannakoltseg = 6;
        this.hatas = "varazserox50felt";
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
