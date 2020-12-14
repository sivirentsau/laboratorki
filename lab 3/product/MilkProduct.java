package product;

public class MilkProduct {

    protected String shelfLife;
    protected int protAmount;
    protected double fatCont;

    public MilkProduct(String x, int y, double z) {
        this.shelfLife = x;
        this.protAmount = y;
        this.fatCont = z;
    }

    public MilkProduct() {
        this.shelfLife = "00.00.00";
        this.protAmount = 0;
        this.fatCont = 0;
    }

    public String getShelfLife() {
        return shelfLife;
    }
    public int getProtAmount() {
        return protAmount;
    }
    public double getFatCont() {
        return fatCont;
    }

    public void creator(String creator) {
        System.out.printf("Данный метод предназначен для переопределения в других классах.");
    }
    public void showSubClass(MilkProduct object) {
        System.out.printf("Срок годности: %s;\n" +
                "Количество белка: %d;\n" +
                "Жирность: %.1f;\n",
                getShelfLife(), getProtAmount(), getFatCont());
    }

}


