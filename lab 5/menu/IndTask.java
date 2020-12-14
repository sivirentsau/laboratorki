package menu;

import java.io.*;
import clrscr.*;

public class IndTask implements clrscr{
    private String filename;
    private String data = "";
    RandomAccessFile file;
    BufferedReader in;
    int choise;

    public IndTask() throws IOException {
        this.in = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
    }

    public void menu() throws IOException, InterruptedException {
        while(true) {
            clrscr.clrscr();
            printMenu();
            choise = Integer.parseInt(in.readLine());
            switch(choise) {
                case 1: {
                    point1();
                    break;
                }
                case 2: {
                    point1();
                    break;
                }
                case 3: {
                    clrscr.clrscr();
                    point3();
                    break;
                }
                case 4: {
                    clrscr.clrscr();
                    System.exit(0);

                } default: clrscr.clrscr(); System.out.printf("Ooooops!\nВы выбрали пункт меню, который не существует!\nПовторите попытку!");
            }
        }
    }

//    Methods menu

    public void point1() throws IOException, InterruptedException {
        int select;
        while (true) {
            clrscr.clrscr();
            printPoint1();
            select = Integer.parseInt(in.readLine());
            switch(select) {
                case 1:
                {
                    clrscr.clrscr();
                    addTextToFile();
                    menu();
                    break;
                }
                case 2:
                {
                    clrscr.clrscr();
                    addTextToEndOfFile();
                    menu();
                    break;
                }
                case 3:
                {
                    clrscr.clrscr();
                    menu();
                    break;
                } default: System.out.printf("Ooooops!\nВы выбрали пункт меню, который не существует!\nПовторите попытку!"); Runtime.getRuntime().wait();
            }
        }
    }

    public void printPoint1() {
        System.out.printf("1. Записать текст в начало файла.\n" +
                "2. Записать текст в конец файла.\n" +
                "3. Назад.\n " +
                "Ввод: ");
    }

//    Point 1

    public void printMenu() {
        System.out.printf("1. Ввести текст и записать его в файл.\n" +
                "2. Редактировать текст в файле.\n" +
                "3. Прочитать текст из файла и выполнить над ним действия.\n" +
                "4. Выход.\n" +
                "Ввод: ");
    }

    public void addTextToFile() throws IOException{
        while(true) {
            clrscr.clrscr();
            System.out.printf("Введите имя файла с его расширением: ");
            filename = in.readLine();
            if(filename.contains(".txt") || filename.contains(".doc")) {
                break;
            }
        }
        file = new RandomAccessFile(new File(filename), "rw");
        if(file.readLine() != null) {
            while((data = file.readLine()) != null) {
                data = file.readLine();
            }
        }

        String str;
        System.out.printf("Введите строку для добавления в начало файла:");
        str = in.readLine();

        file.seek(0);
        file.writeBytes(str);
        if(data != null) {
            file.seek(0);
            file.writeBytes(data);
        }

        file.close();
        System.out.printf("Ваша строка была успешно записана в начало файла!");
        String str2 = in.readLine();
    }

    public void addTextToEndOfFile() throws IOException {
        while (true) {
            clrscr.clrscr();
            System.out.printf("Введите имя файла с его разрешением: ");
            filename = in.readLine();
            if(filename.contains(".txt") || filename.contains(".doc")) {
                break;
            }
        }
        file = new RandomAccessFile(new File(filename), "rw");

        String str;
        System.out.printf("Введите строку для записи в конец файла: ");
        str = in.readLine();

        file.seek(file.length());
        file.writeBytes(str);

        file.close();
        System.out.printf("Ваша строка была успешно записана в конец файла!");
        String str1 = in.readLine();
    }

//    Point3

    public void point3() throws IOException {
        while(true) {
            clrscr.clrscr();
            System.out.printf("Введите имя файла с расширением, чтобы его прочитать: ");
            filename = in.readLine();
            if(filename.contains(".txt") || filename.contains(".doc")) {
                break;
            }
        }
        file = new RandomAccessFile(filename, "r");
        data = file.readLine();

        file.close();

        data = data.replaceAll("[\\s\\p{Z}]+", " ").trim();

        System.out.printf("Информация из файла:\n" +
                "%s", data);
        String str = in.readLine();
    }

}
