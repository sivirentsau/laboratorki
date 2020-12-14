package laboratory3;

import product.MilkProduct;

class Yogurt extends MilkProduct {

    private String flavAdd;
    private int vContain;
    private boolean term;
    private String creatorYog;

    public Yogurt(String x, int y, double z, String flavAdd, int vcon, boolean term) {
        super(x, y, z);

        this.flavAdd = flavAdd;
        this.vContain = vcon;
        this.term = term;
    }
    public Yogurt(String x, int y, double z) {
        super(x, y, z);

        this.flavAdd = "undefined";
        this.vContain = 0;
        this.term = false;
    }
    public Yogurt() {
        super();

        this.flavAdd = "undefined";
        this.vContain = 0;
        this.term = false;
    }

    public String getFlavAdd() {
        return flavAdd;
    }
    public int getvContain() {
        return vContain;
    }
    public boolean getTerm() {
        return term;
    }
    public String getCreator() {
        return creatorYog;
    }

    @Override
    public void creator(String creator) {
        this.creatorYog = creator;
    }

    @Override
    public void showSubClass(MilkProduct object) {
        System.out.printf("Йогурт.\n" +
                "Производитель: %s;\n", getCreator());
        super.showSubClass(object);
        System.out.printf("Вкусовая добавка: %s;\n" +
                        "Объём тары: %d;\n" +
                        "Термизированность: " + (getTerm() ? "Да":"Нет") + ";\n",
                getFlavAdd(), getvContain());
        System.out.println("");
    }
}

class Curd extends MilkProduct {
    private float mass;
    private boolean seeds;
    private String creatorCrud;

    public Curd(String x, int y, double z, float m, boolean s) {
        super(x, y, z);

        this.mass = m;
        this.seeds = s;
    }
    public Curd(String x, int y, double z, float m) {
        super(x, y, z);

        this.mass = m;
        this.seeds = false;
    }
    public Curd() {
        super();

        this.mass = 0;
        this.seeds = false;
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

    @Override
    public void creator(String creator) {
        this.creatorCrud = creator;
    }

    @Override
    public void showSubClass(MilkProduct object) {
        System.out.printf("Творог.\n" +
                "Производитель: %s;\n", getCreatorCrud());
        super.showSubClass(object);
        System.out.printf("Масса: %.1f;\n" +
                        "Зернистость: " + (seeds ? "Да":"Нет") + ";\n",
                getMass());
        System.out.println("");
    }
}

class Kefir extends MilkProduct {
    private int vCont;
    private int comboBifid;
    private String creatorKef;

    public Kefir(String x, int y, double z, int vCont, int combo) {
        super(x, y, z);

        this.vCont = vCont;
        this.comboBifid = combo;
    }
    public Kefir(String x, int y, double z) {
        super(x, y, z);

        this.vCont = 0;
        this.comboBifid = 0;
    }
    public Kefir() {
        super();

        this.vCont = 0;
        this.comboBifid = 0;
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

    @Override
    public void creator(String creator) {
        this.creatorKef = creator;
    }

    @Override
    public void showSubClass(MilkProduct object) {
        System.out.printf("Кефир.\n" +
                "Производитель: %s;\n", getCreatorKef());
        super.showSubClass(object);
        System.out.printf("Объём тары: %d;\n" +
                        "Количество бифидобактерий: %d;\n",
                getvCont(), getComboBifid());
        System.out.println("");
    }
}

public class Main {

    public static void main(String[] args) {

        Yogurt yogurt = new Yogurt("01.09.20", 10, 1, "Клубника", 200, true);
        Curd curd = new Curd("12.09.20", 10, 1.2, 20, true);
        Kefir kefir = new Kefir("25.09.20", 10, 2.5, 100, 20);

        yogurt.creator("Danone");
        curd.creator("Простоквашино");
        kefir.creator("Савушкин продукт");

        yogurt.showSubClass(yogurt);
        curd.showSubClass(curd);
        kefir.showSubClass(kefir);

    }

}
