package classes;

import interfaces.*;

public class Curd implements object, MilkProduct{
    private String shelfLife;
    private int protAmount;
    private double fatCont;
    private float mass;
    private boolean seeds;
    private String creatorCrud;

//    Constructors

     public Curd(String x, int y, double z, float m, boolean s) {
        this.shelfLife = x;
        this.protAmount = y;
        this.fatCont = z;
        this.mass = m;
        this.seeds = s;
    }
    public Curd(String x, int y, double z, float m) {
        this.shelfLife = x;
        this.protAmount = y;
        this.fatCont = z;
        this.mass = m;
        this.seeds = false;
    }
    public Curd() {
        this.shelfLife = "00.00.00";
        this.protAmount = 0;
        this.fatCont = 0;
        this.mass = 0;
        this.seeds = false;
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
    public float getMass() {
        return mass;
    }
    public boolean isSeeds() {
        return seeds;
    }
    public String getCreatorCrud() {
        return creatorCrud;
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
    public void setMass(float mass) {
        this.mass = mass;
    }
    public void setSeeds(boolean seeds) {
        this.seeds = seeds;
    }
    public void setCreatorCrud(String creatorCrud) {
        this.creatorCrud = creatorCrud;
    }

//    Methods

    @Override
    public void print() {
        System.out.printf("Творог.\n" +
                "Производитель: %s;\n" +
                "Срок годности: %s;\n" +
                "Количество белка: %d;\n" +
                "Жирность: %.1f;\n" +
                "Масса: %.1f;\n" +
                "Зернистость: " + (seeds ? "Да":"Нет" + ";\n"),
                getCreatorCrud(), getShelfLife(), getProtAmount(),
                getFatCont(), getMass(), isSeeds());
        System.out.println("");
    }

    @Override
    public void creator() {
        System.out.printf("Данный метод предназначен для переопределения!\n" +
                "Данный метод находится в классе Творог.\n");
        System.out.println("");
    }
}
