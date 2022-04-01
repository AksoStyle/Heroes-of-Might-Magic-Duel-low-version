package classes.magics;

public class Magic {
    public int ar;
    public int mannakoltseg;
    public String hatas;


    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getMannakoltseg() {
        return mannakoltseg;
    }

    public void setMannakoltseg(int mannakoltseg) {
        this.mannakoltseg = mannakoltseg;
    }

    public String getHatas() {
        return hatas;
    }

    public void setHatas(String hatas) {
        this.hatas = hatas;
    }

    public Magic(){
        this.ar = 1;
        this.mannakoltseg = 1;
        this.hatas = " ";
    }

    public Magic(int ar, int mannakoltseg, String hatas) {
        this.ar = ar;
        this.mannakoltseg = mannakoltseg;
        this.hatas = hatas;
    }
}