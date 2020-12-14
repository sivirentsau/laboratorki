package com.company;

import person.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Person[] person = new Person[3];

        for(int i = 0; i < 3; i++) {
            person[i] = new Person();
        }

        for(int i = 0; i < 3; i++) {
            person[i].Input();
        }
        Person.avrg(person);
        Person.isMen(person);
        Person.Output();
    }

}
