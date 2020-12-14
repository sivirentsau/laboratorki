package classes;

import interfaces.*;

public abstract class Yogurt implements object, MilkProduct {
    public String shelfLife;
    public int protAmount;
    public double fatCont;
    public String flavAdd;
    public int vContain;
    public boolean term;
    public String creatorYog;
    public String type;

//    Constructors

    public Yogurt(String x, int y, double z, String flavAdd, int vcon, boolean term, String type) {
        this.shelfLife = x;
        this.protAmount = y;
        this.fatCont = z;
        this.flavAdd = flavAdd;
        this.vContain = vcon;
        this.term = term;
        this.type = type;
    }
    public Yogurt(String x, int y, double z, String type) {
        this.shelfLife = x;
        this.protAmount = y;
        this.fatCont = z;
        this.flavAdd = "undefined";
        this.vContain = 0;
        this.term = false;
        this.type = type;
    }
    public Yogurt() {
        this.shelfLife = "00.00.00";
        this.protAmount = 0;
        this.fatCont = 0;
        this.flavAdd = "undefined";
        this.vContain = 0;
        this.term = false;
        this.type = "undefined";
    }

//    Getters

    public String getShelfLife() {
        return shelfLife;
    }
    public int getProtAmount() {
        return protAmount;
    }
    public double getFatCont() {
        return fatCont;
    }
    public String getFlavAdd() {
        return flavAdd;
    }
    public int getvContain() {
        return vContain;
    }
    public boolean isTerm() {
        return term;
    }
    public String getCreatorYog() {
        return creatorYog;
    }
    public String getType() {
        return type;
    }

//    Setters


    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }
    public void setProtAmount(int protAmount) {
        this.protAmount = protAmount;
    }
    public void setFatCont(double fatCont) {
        this.fatCont = fatCont;
    }
    public void setFlavAdd(String flavAdd) {
        this.flavAdd = flavAdd;
    }
    public void setvContain(int vContain) {
        this.vContain = vContain;
    }
    public void setTerm(boolean term) {
        this.term = term;
    }
    public void setCreatorYog(String creatorYog) {
        this.creatorYog = creatorYog;
    }
    public void setType(String type) {
        this.type = type;
    }

//    Methods

    public abstract String GetType();

}
