package person;

import java.io.*;

public class Person {
    private String surname;
    private int age;
    private String sex;

    public Person() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "utf-8"));

        System.out.printf("\nВведите фамилию: ");
        this.surname = input.readLine();
        System.out.printf("Введите возраст: ");
        this.age = Integer.parseInt(input.readLine());
        System.out.printf("Введите пол: ");
        this.sex = input.readLine();
    }

    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public String getSex() {
        return sex;
    }

    public void Input() throws IOException {
        File f1 = new File("D://Education//OOOP//Exercises//Лабораторная работа №4//Person.doc");

        try {
            boolean file = f1.createNewFile();
            if(file) {
                System.out.printf("File created successfuly!");
            }
        } catch (IOException ex) {
            System.out.printf("Error!\n Mistake is" + ex.getMessage());
        }

        FileWriter writer = new FileWriter(f1, true);

        writer.append("\nФамилия: " + getSurname() + ";\nВозраст: " +
                this.age + ";\nПол: " + getSex() + ";\n");

        writer.flush();
        writer.close();
    }

    public static void Output() throws IOException {
        File f2 = new File("D://Education//OOOP//Exercises//Лабораторная работа №4//Person.doc");

        FileReader reader = new FileReader(f2);
        char buf[];
        int num;
        buf = new char[1];

        do {
          num = reader.read(buf);
          System.out.print(buf[0]);
        } while(num == 1);

        reader.close();
    }

    public static void avrg(Person[] person) throws IOException {
        int avrg = 0;

        for(int i = 0; i < person.length; i++) {
            avrg += person[i].getAge();
        }

        File f1 = new File("D://Education//OOOP//Exercises//Лабораторная работа №4//Person.doc");
        FileWriter writer = new FileWriter(f1, true);

        writer.append("\nСредний возраст: " + avrg/person.length + "\n");

        writer.flush();
        writer.close();
    }

    public static void isMen(Person[] person) throws IOException{
        int com = 0;

        for(int i = 0; i < person.length; i++) {
            if(person[i].getSex().contains("Муж") || person[i].getSex().contains("муж")) {
                com++;
            }
        }

        File f1 = new File("D://Education//OOOP//Exercises//Лабораторная работа №4//Person.doc");
        FileWriter writer = new FileWriter(f1, true);

        writer.append("\nКоличество мужчин: " + com + "\n");

        writer.flush();
        writer.close();
    }

}
