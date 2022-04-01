package classes.Units;

public class Unit {
    public int sebzes;
    public int pancel;

    public int kezdemenyezes;
    public int criticalHit;

    public int getSebzes() {
        return sebzes;
    }
    public void setSebzes(int sebzes) {
        if(sebzes < 1){
            this.sebzes = 1;
        }
        else{
            this.sebzes = sebzes;
        }
    }

    public int getPancel() {
        return pancel;
    }
    public void setPancel(int pancel) {
        if(pancel < 1){
            this.pancel = 1;
        }
        else{
            this.pancel = pancel;
        }
    }

    public int getKezdemenyezes() {
        return kezdemenyezes;
    }
    public void setKezdemenyezes(int kezdemenyezes) {
        if(kezdemenyezes < 1){
            this.kezdemenyezes = 1;
        }
        else{
            this.kezdemenyezes = kezdemenyezes;
        }
    }

    public int getCriticalHit() {
        return criticalHit;
    }
    public void setCriticalHit(int criticalHit) {
        if(criticalHit < 1){
            this.criticalHit = 1;
        }
        else{
            this.criticalHit = criticalHit;
        }
    }

    public Unit(){
        this.sebzes = 1;
        this.pancel = 1;
        this.kezdemenyezes = 1;
        this.criticalHit = 1;
    }


    public Unit(int sebzes, int pancel, int kezdemenyezes, int criticalHit) {
        this.sebzes = sebzes;
        this.pancel = pancel;
        this.kezdemenyezes = kezdemenyezes;
        this.criticalHit = criticalHit;
    }


}
