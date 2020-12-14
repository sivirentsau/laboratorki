package app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Application extends JFrame {
    int k;
    static int c = 0;
    Object boxA, boxB, boxC;
    File file = new File("D://Education//OOOP//Exercises//GUI_6//Documents(books).txt");
    ButtonGroup bg;
    JComboBox box_1, box_2, box_3;
    static JButton add, del, show, back;
    static JTextField textName, textAuthor;
    static JTextArea textDescription, showText;
    static JLabel l1, l2, l3, l4, l5;
    static JRadioButton flag1, flag2;

    static String[] box1 = {
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
        "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
        "31"
    };

    static String[] box2 = {
            "Январь", "Февраль", "Март", "Апрель", "Май",
            "Июнь", "Июль", "Август", "Сентябрь", "Октябрь",
            "Ноябрь", "Декабрь"
    };

    static String[] box3 = {
        "2000", "2001", "2002", "2003", "2004", "2005",
        "2006", "2007", "2008", "2009", "2010", "2011",
        "2012", "2013", "2014", "2015", "2016", "2017",
        "2018", "2019", "2020"
    };

    public Application(String str) {
        super(str);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add = new JButton("Добавить");
        del = new JButton("Очистить");
        show = new JButton("Показать");
        back = new JButton("Назад");

        textName = new JTextField();
        textAuthor = new JTextField();
        textDescription = new JTextArea();
        showText = new JTextArea();

        l1 = new JLabel("Название документа(книги):");
        l2 = new JLabel("Автор(если это книга):");
        l3 = new JLabel("Описание документа(книги):");
        l4 = new JLabel("Дата внесения документа(книги):");
        l5 = new JLabel("Информация из базы данных");

        box_1 = new JComboBox(box1);
        box_2 = new JComboBox(box2);
        box_3 = new JComboBox(box3);

        flag1 = new JRadioButton("Книга");
        flag2 = new JRadioButton("Документ");

        bg = new ButtonGroup();
        bg.add(flag1);
        bg.add(flag2);

        setLayout(null);
        add.setSize(100, 25);
        add.setLocation(100, 300);
        del.setSize(100, 25);
        del.setLocation(220, 300);
        show.setSize(100, 25);
        show.setLocation(340, 300);
        back.setSize(100, 25);
        back.setLocation(100, 300);

        textName.setSize(250, 30);
        textName.setLocation(260, 25);
        textAuthor.setSize(250, 30);
        textAuthor.setLocation(260, 65);
        textDescription.setSize(250, 70);
        textDescription.setLocation(260, 105);
        box_1.setSize(75, 25);
        box_1.setLocation(260, 185);
        box_2.setSize(75, 25);
        box_2.setLocation(345, 185);
        box_3.setSize(75, 25);
        box_3.setLocation(435, 185);

        l1.setSize(250, 25);
        l1.setLocation(50, 25);
        l2.setSize(250, 25);
        l2.setLocation(50, 65);
        l3.setSize(250, 25);
        l3.setLocation(50, 105);
        l4.setSize(250, 25);
        l4.setLocation(50, 185);

        flag1.setSize(100, 25);
        flag1.setLocation(125, 240);
        flag2.setSize(100, 25);
        flag2.setLocation(325, 240);

        add(add);
        add(del);
        add(show);

        add(textName);
        add(textAuthor);
        add(textDescription);
        add(box_1);
        add(box_2);
        add(box_3);

        add(l1);
        add(l2);
        add(l3);
        add(l4);

        add(flag1);
        add(flag2);

        add.addActionListener(new AddActionListener());
        del.addActionListener(new DelActionListener());
        show.addActionListener(new ShowActionListener());
        back.addActionListener(new BackActionListener());

        flag1.addActionListener(new FlagActionListener());
        flag2.addActionListener(new FlagActionListener());

        box_1.addActionListener(new BoxActionListener());
        box_2.addActionListener(new BoxActionListener());
        box_3.addActionListener(new BoxActionListener());
    }

    public class AddActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if(!file.exists()) {
                    file.createNewFile();
                }
                FileWriter out = new FileWriter(file, true);

                try {
                    String text1 = textName.getText();
                    String text2 = textAuthor.getText();
                    String area1 = textDescription.getText();

                    c++;
                    out.write((k == 1 ? "Книга ":"Документ ") + c + "\n");
                    out.write("Название: " + text1 + ";\n");
                    out.write("Автор: " + (k == 1 ? text2 : " - ") + ";\n");
                    out.write("Описание: " + area1 + ";\n");
                    out.write("Дата записи: " + boxA + "." + boxB + "." + boxC + ";\n\n");
                } finally {
                    out.close();
                    textName.setText(null);
                    textAuthor.setText(null);
                    textDescription.setText(null);
                }
            } catch(IOException err) {
                throw new RuntimeException(err);
            }
        }
    }

    public class DelActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == del) {
                textName.setText(null);
                textAuthor.setText(null);
                textDescription.setText(null);
                showText.setText(null);
            }
        }
    }

    public class FlagActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            k = 0;
            if(e.getSource() == flag1) {
                k++;
            }
            if(e.getSource() == flag2) {
                k--;
            }
        }
    }

    public class BoxActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == box_1) {
                boxA = box_1.getSelectedItem();
            }
            if(e.getSource() == box_2) {
                boxB = box_2.getSelectedItem();
            }
            if(e.getSource() == box_3) {
                boxC = box_3.getSelectedItem();
            }
        }
    }

    public class ShowActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == show) {
                remove(add);

                remove(textName);
                remove(textAuthor);
                remove(textDescription);
                remove(box_1);
                remove(box_2);
                remove(box_3);

                remove(l1);
                remove(l2);
                remove(l3);
                remove(l4);

                remove(flag1);
                remove(flag2);

                setVisible(false);

                add(l5);
                add(showText);
                add(back);

                l5.setSize(200, 25);
                l5.setLocation(25, 5);

                showText.setSize(500, 260);
                showText.setLocation(25, 30);

                setVisible(true);

                try {
                    showInfo();
                } catch (IOException e1) {
                    System.out.print(e1.getMessage());
                }
            }
        }
    }

    public void showInfo() throws IOException {
        File file1 = new File("D://Education//OOOP//Exercises//GUI_6//Documents(books).txt");
        FileReader in = new FileReader(file1);
        char[] buffer = new char[1];
        char[] data = new char[100*100];
        int size = 0;
        int num;
        do{
            num = in.read(buffer);
            data[size] = buffer[0];
            size++;
        }while (num == 1);

        for(int i = 0; i < size; i++) {
            showText.append(String.valueOf(data[i]));
        }
    }

    public class BackActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == back) {

                remove(showText);
                remove(l5);
                remove(back);

                setVisible(false);

                add(add);

                add(textName);
                add(textAuthor);
                add(textDescription);
                add(box_1);
                add(box_2);
                add(box_3);

                add(l1);
                add(l2);
                add(l3);
                add(l4);

                add(flag1);
                add(flag2);

                setVisible(true);
            }
        }
    }

}
