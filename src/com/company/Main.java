package com.company;

import classes.*;

class YogurtCup extends Yogurt {
//   Construtor

    YogurtCup(String x, int y, double z, String flavAdd, int vcon, boolean term) {
        super(x, y, z, flavAdd, vcon, term, "Стаканчик");
    }

//    Methods

    @Override
    public String GetType() {
        return this.type;
    }

    @Override
    public void print() {
        System.out.printf("Йогурт в стаканчике.\n" +
                "Производитель: %s;\n" +
                "Тип йогурта: %s;\n" +
                "Срок годности: %s;\n" +
                "Количество белка: %d;\n" +
                "Жирность: %.1f;\n" +
                "Вкусовая добавка: %s;\n" +
                "Объём тары: %d;\n" +
                "Термизированность: " + (isTerm() ? "Да":"Нет") + ";\n",
                getCreatorYog(), GetType(), getShelfLife(), getProtAmount(),
                getFatCont(), getFlavAdd(), getvContain());
        System.out.println("");
    }

    @Override
    public void creator() {
        System.out.printf("Данный метод предназначен для переопределения!\n" +
                "Данный метод находится в классе Йогурт в стаканчике.\n");
        System.out.println("");
    }
}

class DrinkYogurt extends Yogurt {
//    Constructor

    DrinkYogurt(String x, int y, double z, String flavAdd, int vcon, boolean term) {
        super(x, y, z, flavAdd, vcon, term, "Питьевой");
    }

//    Methods

    @Override
    public String GetType() {
        return this.type;
    }

    @Override
    public void print() {
        System.out.printf("Питьевой йогурт.\n" +
                        "Производитель: %s;\n" +
                        "Тип йогурта: %s;\n" +
                        "Срок годности: %s;\n" +
                        "Количество белка: %d;\n" +
                        "Жирность: %.1f;\n" +
                        "Вкусовая добавка: %s;\n" +
                        "Объём тары: %d;\n" +
                        "Термизированность: " + (isTerm() ? "Да":"Нет") + ";\n",
                getCreatorYog(), GetType(), getShelfLife(), getProtAmount(),
                getFatCont(), getFlavAdd(), getvContain());
        System.out.println("");
    }

    @Override
    public void creator() {
        System.out.printf("Данный метод предназначен для переопределения!\n" +
                "Данный метод находится в классе Питьевой йогурт.\n");
        System.out.println("");
    }
}

public class Main {

    public static void main(String[] args) {

        Curd curd1 = new Curd("21.01.20", 20, 1.2, 200, true);
        curd1.setCreatorCrud("Савушкин продукт");
        curd1.print();

        Kefir kefir1 = new Kefir("19.02.21", 15, 1.5, 12, 24);
        kefir1.setCreatorKef("Danone");
        kefir1.print();

        YogurtCup cup1 = new YogurtCup("29.03.21", 10, 0.5, "клубника", 20, true);
        cup1.setCreatorYog("Danone");
        cup1.print();
        cup1.creator();

        DrinkYogurt drink1 = new DrinkYogurt("21.09.21", 20, 1.4, "чернослив", 10, true);
        drink1.setCreatorYog("Danone");
        drink1.print();
        drink1.creator();

    }
}
