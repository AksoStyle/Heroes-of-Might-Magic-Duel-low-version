package classes.magics;

public class Tuzlabda extends Magic{
    private final int ar;
    private final int mannakoltseg;
    private final String hatas;//"3x3_20sebzes";

    public Tuzlabda() {
        this.ar = 120;
        this.mannakoltseg = 9;
        this.hatas = "3x3_20sebzes";
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
