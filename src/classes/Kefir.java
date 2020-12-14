package classes;

import interfaces.*;

public class Kefir implements object, MilkProduct{
    private String shelfLife;
    private int protAmount;
    private double fatCont;
    private int vCont;
    private int comboBifid;
    private String creatorKef;

//    Constructors

    public Kefir(String x, int y, double z, int vCont, int combo) {
        this.shelfLife = x;
        this.protAmount = y;
        this.fatCont = z;
        this.vCont = vCont;
        this.comboBifid = combo;
    }
    public Kefir(String x, int y, double z) {
        this.shelfLife = x;
        this.protAmount = y;
        this.fatCont = z;
        this.vCont = 0;
        this.comboBifid = 0;
    }
    public Kefir() {
        this.shelfLife = "00.00.00";
        this.protAmount = 0;
        this.fatCont = 0;
        this.vCont = 0;
        this.comboBifid = 0;
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
    public int getvCont() {
        return vCont;
    }
    public int getComboBifid() {
        return comboBifid;
    }
    public String getCreatorKef() {
        return creatorKef;
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
    public void setvCont(int vCont) {
        this.vCont = vCont;
    }
    public void setComboBifid(int comboBifid) {
        this.comboBifid = comboBifid;
    }
    public void setCreatorKef(String creatorKef) {
        this.creatorKef = creatorKef;
    }

//    Methods

    @Override
    public void creator() {
        System.out.printf("Данный метод предназначен для переопределения!\n" +
                "Данный метод находится в классе Кефир.\n");
        System.out.println("");
    }

    @Override
    public void print() {
        System.out.printf("Творог.\n" +
                        "Производитель: %s;\n" +
                        "Срок годности: %s;\n" +
                        "Количество белка: %d;\n" +
                        "Жирность: %.1f;\n" +
                "Объём тары: %d;\n" +
                "Количество бифидобактерий: %d;\n",
                getCreatorKef(), getShelfLife(), getProtAmount(),
                getFatCont(), getvCont(), getComboBifid());
        System.out.println("");
    }
}
