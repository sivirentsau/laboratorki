package app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Timer;

import objectWeather.Weather;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class App extends JFrame {
//   Приложение

    private JFrame win1, win2, win2_1, win3, win4, win5;
    private JButton add, del, change, sort, find, back, create, ex, show;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane pane;
    private JComboBox time, day, DAY_F, TIME_F;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, err, TOWN, DAY, TIME, DESCRIPTION1, DESCRIPTION2;
    private JTextField town, t, rains, Vw, P, TOWN_F;
    private Object Day, Time;

//----------------------------------------------------------

//    Блок вкладки "Удалить"

    private JButton delete = new JButton("Удалить");

//----------------------------------------------------------

//    Блок вкладки "Изменить"

    private JButton giveChange = new JButton("Изменить");
    private JButton Changing = new JButton("Внести");

//----------------------------------------------------------

//    Блок вкладки "Отсортировать"

    private JRadioButton r1 = new JRadioButton("По температуре", true),
            r2 = new JRadioButton("По осадкам", false),
            r3 = new JRadioButton("По Скорости ветра", false),
            r4 = new JRadioButton("По Давлению", false),
            r5 = new JRadioButton("По городу", false);

    private int k = 1;

    private ButtonGroup group = new ButtonGroup();

    private JButton sorting = new JButton("Сортировать");

//----------------------------------------------------------

    private String[] days = {
            "Пн", "Вт",
            "Ср", "Чт",
            "Пт", "Сб",
            "Вс"
    };
    private String[] times = {
            "Утро", "День", "Вечер", "Ночь"
    };

    private String[] columnNames = {
            "Город",
            "День недели",
            "Время суток",
            "Температура",
            "Осадки",
            "Скорость ветра",
            "Давление"
    };

    CreateActionListener CREATE = new CreateActionListener();

//    Работа с файлами XLS

    private String fileName = "D://Education//OOOP//Exercises//TheWeather.xls";
    private File file = new File(fileName);

    private FileInputStream input;
    private FileOutputStream out;

    private Workbook writeBook;
    private Sheet writeBookSheet;

    private HSSFWorkbook readBook;
    private HSSFSheet readBookSheet;

    private List<Weather> readWeather = new ArrayList<Weather>();
    private List<Weather> writeWeather = new ArrayList<Weather>();

    private Weather[] readWriteWeather = new Weather[80 * 80];
    private int rowNum = 0;

//    Конструкторы

    public App(String str) throws IOException {
        super(str);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        if (!file.exists()) {
            writeBook = new HSSFWorkbook();
            writeBookSheet = writeBook.createSheet("TheWeather");

            Row writeRow = writeBookSheet.createRow(0);
            Cell writeCell;

            writeCell = writeRow.createCell(0);
            writeCell.setCellValue("Город");

            writeCell = writeRow.createCell(1);
            writeCell.setCellValue("День недели");

            writeCell = writeRow.createCell(2);
            writeCell.setCellValue("Время суток");

            writeCell = writeRow.createCell(3);
            writeCell.setCellValue("Температура");

            writeCell = writeRow.createCell(4);
            writeCell.setCellValue("Осадки");

            writeCell = writeRow.createCell(5);
            writeCell.setCellValue("Скорость ветра");

            writeCell = writeRow.createCell(6);
            writeCell.setCellValue("Давление");

            writeBook.write(new FileOutputStream(file));
            writeBook.close();
        }

        win1 = new JFrame("Прогноз погоды. Добавить");
        win2 = new JFrame("Прогноз погоды. Найти");
        win2_1 = new JFrame("Прогноз погоды. Таблица");
        win3 = new JFrame("Прогноз погоды. Удалить");
        win4 = new JFrame("Прогноз погоды. Изменить");
        win5 = new JFrame("Прогноз погоды. Сортировка");

        add = new JButton("Добавить");
        create = new JButton("Внести данные");
        del = new JButton("Удалить");
        change = new JButton("Изменить");
        sort = new JButton("Сортировать");
        find = new JButton("Найти");
        back = new JButton("Назад");
        ex = new JButton("Выход");
        show = new JButton("Показать");

        l1 = new JLabel("Прогноз погоды");
        l2 = new JLabel("Город:");
        l3 = new JLabel("Температура:");
        l4 = new JLabel("Осадки:");
        l5 = new JLabel("Скорость ветра:");
        l6 = new JLabel("Давление:");
        l7 = new JLabel("День недели:");
        l8 = new JLabel("Время суток:");
        TOWN = new JLabel("Город");
        DAY = new JLabel("День");
        TIME = new JLabel("Время");
        DESCRIPTION1 = new JLabel();
        DESCRIPTION2 = new JLabel();

        TOWN_F = new JTextField();

        err = new JLabel();

        town = new JTextField();
        t = new JTextField();
        rains = new JTextField();
        Vw = new JTextField();
        P = new JTextField();

        time = new JComboBox(times);
        day = new JComboBox(days);
        TIME_F = new JComboBox(times);
        DAY_F = new JComboBox(days);

        table = new JTable();

        setLayout(null);

        add(add);
        add(del);
        add(change);
        add(sort);
        add(find);
        add(ex);

        add(l1);

        add.setSize(120, 25);
        add.setLocation(330, 115);
        del.setSize(120, 25);
        del.setLocation(330, 165);
        change.setSize(120, 25);
        change.setLocation(330, 215);
        sort.setSize(120, 25);
        sort.setLocation(330, 265);
        find.setSize(120, 25);
        find.setLocation(330, 315);
        ex.setSize(120, 25);
        ex.setLocation(330, 365);

        l1.setSize(200, 25);
        l1.setLocation(293, 50);
        l1.setFont(l1.getFont().deriveFont(24.0f));

        add.addActionListener(new AddActionListener());
        del.addActionListener(new DelActionListener());
        change.addActionListener(new ChangeActionListener());
        sort.addActionListener(new SortActionListener());
        find.addActionListener(new FindActionListener());
        ex.addActionListener(new ExActionListener());
    }

// Ошибка

    public class HideErr extends TimerTask {
        @Override
        public void run() {
            win1.setVisible(false);
            err.setText(null);
            win1.setVisible(true);
        }
    }

//  Выход из приложения

    public class ExActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == ex) {
                System.exit(0);
            }
        }
    }

//    Вернуться назад

    public class BackActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                win1.dispose();
                town.setText(null);
                day.setSelectedItem("Пн");
                time.setSelectedItem("Утро");
                t.setText(null);
                rains.setText(null);
                Vw.setText(null);
                P.setText(null);

                win2.dispose();
                TOWN_F.setText(null);
                DAY_F.setSelectedItem("Пн");
                TIME_F.setSelectedItem("Утро");

                win3.dispose();

                win4.dispose();

                win5.dispose();
                r1.setSelected(true);
                r2.setSelected(false);
                r3.setSelected(false);
                r4.setSelected(false);
                r5.setSelected(false);

                create.removeActionListener(CREATE);
                setVisible(true);
            }
        }
    }

//    Добавить запись в таблицу

    public class AddActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == add) {

                setVisible(false);

                win1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                win1.setSize(800, 500);
                win1.setVisible(true);
                win1.setResizable(false);
                win1.setLocationRelativeTo(null);

                win1.setLayout(null);

                win1.add(create);
                win1.add(back);

                win1.add(l2);
                win1.add(l3);
                win1.add(l4);
                win1.add(l5);
                win1.add(l6);
                win1.add(l7);
                win1.add(l8);

                win1.add(town);
                win1.add(day);
                win1.add(time);
                win1.add(t);
                win1.add(rains);
                win1.add(Vw);
                win1.add(P);

                create.setSize(150, 25);
                create.setLocation(200, 400);
                back.setSize(150, 25);
                back.setLocation(450, 400);

                l2.setSize(200, 25);
                l2.setLocation(250, 70);
                l7.setSize(200, 25);
                l7.setLocation(250, 105);
                l8.setSize(200, 25);
                l8.setLocation(250, 140);
                l3.setSize(200, 25);
                l3.setLocation(250, 175);
                l4.setSize(200, 25);
                l4.setLocation(250, 210);
                l5.setSize(200, 25);
                l5.setLocation(250, 245);
                l6.setSize(200, 25);
                l6.setLocation(250, 280);

                town.setSize(100, 25);
                town.setLocation(450, 70);
                day.setSize(100, 25);
                day.setLocation(450, 105);
                time.setSize(100, 25);
                time.setLocation(450, 140);
                t.setSize(100, 25);
                t.setLocation(450, 175);
                rains.setSize(100, 25);
                rains.setLocation(450, 210);
                Vw.setSize(100, 25);
                Vw.setLocation(450, 245);
                P.setSize(100, 25);
                P.setLocation(450, 280);

                create.addActionListener(new CreateActionListener());
                back.addActionListener(new BackActionListener());

            }
        }

    }

//    Создать запись в таблице

    public class CreateActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == create) {
                if (town.getText().equals("") || t.getText().equals("") || rains.getText().equals("") || Vw.getText().equals("") || P.getText().equals("")) {
                    win1.add(err);

                    err.setText("Ошибка! Все поля должны быть заполнены!");
                    err.setForeground(Color.RED);
                    err.setSize(300, 25);
                    err.setLocation(375, 40);

                    Timer error = new Timer();
                    error.schedule(new HideErr(), 4000);
                } else {

                    readWriteWeather[Weather.node] = new Weather(town.getText(),
                            day.getSelectedItem(),
                            time.getSelectedItem(),
                            t.getText(),
                            rains.getText(),
                            Vw.getText(),
                            P.getText());

                    writeWeather.add(readWriteWeather[Weather.node]);

                    try {
                        input = new FileInputStream(fileName);
                        writeBook = new HSSFWorkbook(input);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    writeBookSheet = writeBook.getSheet("TheWeather");

                    Row writeRow;
                    Cell writeCell;
                    writeRow = writeBookSheet.createRow(writeBookSheet.getLastRowNum() + 1);

                    writeCell = writeRow.createCell(0);
                    writeCell.setCellValue(writeWeather.get(Weather.node).getTown());

                    writeCell = writeRow.createCell(1);
                    writeCell.setCellValue(writeWeather.get(Weather.node).getDayW().toString());

                    writeCell = writeRow.createCell(2);
                    writeCell.setCellValue(writeWeather.get(Weather.node).getTime().toString());

                    writeCell = writeRow.createCell(3);
                    writeCell.setCellValue(writeWeather.get(Weather.node).getT());

                    writeCell = writeRow.createCell(4);
                    writeCell.setCellValue(writeWeather.get(Weather.node).getRains());

                    writeCell = writeRow.createCell(5);
                    writeCell.setCellValue(writeWeather.get(Weather.node).getVw());

                    writeCell = writeRow.createCell(6);
                    writeCell.setCellValue(writeWeather.get(Weather.node).getP());

                    Weather.node++;

                    try {
                        file.createNewFile();
                        out = new FileOutputStream(file);
                        writeBook.write(out);
                        writeBook.close();
                        out.flush();
                        out.close();
                        input.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    clearFields();

                    win1.add(err);

                    err.setText("Данные успешно записаны!");
                    err.setForeground(Color.GREEN);
                    err.setSize(300, 25);
                    err.setLocation(415, 40);

                    Timer error = new Timer();
                    error.schedule(new HideErr(), 4000);
                }

            }
        }

        public void clearFields() {
            town.setText(null);
            day.setSelectedItem("Пн");
            time.setSelectedItem("Утро");
            t.setText(null);
            rains.setText(null);
            Vw.setText(null);
            P.setText(null);
        }

    }

//    Поиск информации в таблице

    public class FindActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == find) {
                setVisible(false);

                win2.setLayout(null);
                win2.setVisible(true);
                win2.setDefaultCloseOperation(0);
                win2.setSize(new Dimension(800, 500));
                win2.setResizable(false);
                win2.setLocationRelativeTo(null);

                win2.add(show);
                win2.add(back);

                win2.add(TOWN_F);
                win2.add(DAY_F);
                win2.add(TIME_F);
                win2.add(TOWN);
                win2.add(DAY);
                win2.add(TIME);

                win2.add(DESCRIPTION1);
                win2.add(DESCRIPTION2);

                TOWN_F.setSize(50, 25);
                TOWN_F.setLocation(285, 119);
                DAY_F.setSize(50, 25);
                DAY_F.setLocation(390, 119);
                TIME_F.setSize(60, 25);
                TIME_F.setLocation(500, 119);

                TOWN.setSize(60, 25);
                TOWN.setLocation(235, 119);
                DAY.setSize(40, 25);
                DAY.setLocation(355, 119);
                TIME.setSize(50, 25);
                TIME.setLocation(450, 119);

                DESCRIPTION1.setSize(400, 25);
                DESCRIPTION1.setLocation(225, 150);
                DESCRIPTION2.setSize(400, 25);
                DESCRIPTION2.setLocation(270, 170);

                DESCRIPTION1.setText("Введите название города, выберите день и время для того,");
                DESCRIPTION2.setText("чтобы показать таблицу прогноза погоды.");

                show.setSize(150, 25);
                show.setLocation(200, 250);
                back.setSize(150, 25);
                back.setLocation(450, 250);

                back.addActionListener(new BackActionListener());
                show.addActionListener(new ShowActionListener());

            }
        }
    }

//    Вывод значений в таблицу приложения из таблицы Excel

    public class ShowActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == show) {
                if (TOWN_F.getText().equals("")) {
                    win1.add(err);

                    err.setText("Ошибка! Заполните поле \"Город\"");
                    err.setForeground(Color.RED);
                    err.setSize(300, 25);
                    err.setLocation(375, 40);

                    Timer error = new Timer();
                    error.schedule(new HideErr(), 4000);
                } else {
                    try {
                        input = new FileInputStream(file);
                        readBook = new HSSFWorkbook(input);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    readBookSheet = readBook.getSheet("TheWeather");

                    for (int i = 0; i < readBookSheet.getLastRowNum(); i++) {
                        Row readRow = readBookSheet.getRow(i + 1);

                        readWriteWeather[i] = new Weather(readRow.getCell(0).toString(),
                                readRow.getCell(1),
                                readRow.getCell(2),
                                readRow.getCell(3).toString(),
                                readRow.getCell(4).toString(),
                                readRow.getCell(5).toString(),
                                readRow.getCell(6).toString());
                    }

                    String town = TOWN_F.getText().trim();
                    Day = DAY_F.getSelectedItem();
                    Time = TIME_F.getSelectedItem();

                    int i = 10 * 10;
                    int j = 7;

                    int r = 0;

                    String[][] notes = new String[i][j];

                    for (Weather Weatherr : readWriteWeather) {
                        if (Weatherr == null) break;
                        if (Weatherr.getTown().equals(town) && Weatherr.getTime().toString().trim().equals(Time) && Weatherr.getDayW().toString().trim().equals(Day)) {
                            notes[r][0] = Weatherr.getTown();
                            notes[r][1] = Weatherr.getDayW().toString();
                            notes[r][2] = Weatherr.getTime().toString();
                            notes[r][3] = Weatherr.getT();
                            notes[r][4] = Weatherr.getRains();
                            notes[r][5] = Weatherr.getVw();
                            notes[r][6] = Weatherr.getP();
                        }
                    }

                    String[][] notesAdapt = ReSizeArr(notes, j, i);

                    if (tableModel == null) {
                        tableModel = new DefaultTableModel(notesAdapt, columnNames);
                    } else {
                        while (tableModel.getRowCount() >= 1) {
                            tableModel.removeRow(0);
                        }

                        String[] Row = new String[7];

                        for (int k = 0; k < 7; k++) {
                            Row[k] = notesAdapt[0][k];
                        }

                        tableModel.addRow(Row);
                    }

                    table = new JTable(tableModel);
                    pane = new JScrollPane(table);

                    win2_1.getContentPane().add(pane);
                    win2_1.setPreferredSize(new Dimension(800, 200));
                    win2_1.setVisible(false);
                    win2_1.pack();
                    win2_1.setLocationRelativeTo(null);
                    win2_1.setVisible(true);

                    try {
                        readBook.close();
                        input.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        }

        String[][] ReSizeArr(String[][] array, int columns, int rows) {
            int i = 0;
            for (int k = 0; k < rows; k++) {
                if (array[k][0] == null) {
                    break;
                } else {
                    i++;
                }
            }

            String[][] notes = new String[i][columns];

            for (int k = 0; k < i; k++) {
                notes[k][0] = array[k][0];
                notes[k][1] = array[k][1];
                notes[k][2] = array[k][2];
                notes[k][3] = array[k][3];
                notes[k][4] = array[k][4];
                notes[k][5] = array[k][5];
                notes[k][6] = array[k][6];
            }

            return notes;
        }
    }

//    Удалить информацию из таблицы

    public class DelActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == del) {
                setVisible(false);

                win3.setLayout(null);

                win3.setVisible(true);
                win3.setDefaultCloseOperation(0);
                win3.setSize(new Dimension(800, 500));
                win3.setResizable(false);
                win3.setLocationRelativeTo(null);

                win3.add(delete);
                win3.add(back);

                win3.add(TOWN_F);
                win3.add(DAY_F);
                win3.add(TIME_F);
                win3.add(TOWN);
                win3.add(DAY);
                win3.add(TIME);

                win3.add(DESCRIPTION1);
                win3.add(DESCRIPTION2);

                TOWN_F.setSize(50, 25);
                TOWN_F.setLocation(285, 119);
                DAY_F.setSize(50, 25);
                DAY_F.setLocation(390, 119);
                TIME_F.setSize(60, 25);
                TIME_F.setLocation(500, 119);

                TOWN.setSize(60, 25);
                TOWN.setLocation(235, 119);
                DAY.setSize(40, 25);
                DAY.setLocation(355, 119);
                TIME.setSize(50, 25);
                TIME.setLocation(450, 119);

                DESCRIPTION1.setSize(400, 25);
                DESCRIPTION1.setLocation(225, 150);
                DESCRIPTION2.setSize(400, 25);
                DESCRIPTION2.setLocation(250, 170);

                DESCRIPTION1.setText("Введите название города, выберите день и время для того,");
                DESCRIPTION2.setText("чтобы удалить запись из таблицы прогноза погоды.");

                delete.setSize(150, 25);
                delete.setLocation(200, 250);
                back.setSize(150, 25);
                back.setLocation(450, 250);

                back.addActionListener(new BackActionListener());
                delete.addActionListener(new DeleteActionListener());
            }
        }
    }

    public class DeleteActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == delete) {
                if (TOWN_F.getText().equals("")) {
                    win1.add(err);

                    err.setText("Ошибка! Заполните поле \"Город\"");
                    err.setForeground(Color.RED);
                    err.setSize(300, 25);
                    err.setLocation(375, 40);

                    Timer error = new Timer();
                    error.schedule(new HideErr(), 4000);
                } else {
                    try {
                        input = new FileInputStream(file);
                        readBook = new HSSFWorkbook(input);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    readBookSheet = readBook.getSheet("TheWeather");

                    readWeather = null;

                    readWeather = new ArrayList<Weather>();

                    for (int i = 0; i < readBookSheet.getLastRowNum(); i++) {
                        Row readRow = readBookSheet.getRow(i + 1);

                        readWeather.add(new Weather(readRow.getCell(0).toString(),
                                readRow.getCell(1),
                                readRow.getCell(2),
                                readRow.getCell(3).toString(),
                                readRow.getCell(4).toString(),
                                readRow.getCell(5).toString(),
                                readRow.getCell(6).toString()));
                    }

                    for (int i = 0; i < readBookSheet.getLastRowNum(); i++) {
                        Row readRow = readBookSheet.getRow(i + 1);

                        readBookSheet.removeRow(readRow);
                    }

                    String town = TOWN_F.getText().trim();
                    Day = DAY_F.getSelectedItem();
                    Time = TIME_F.getSelectedItem();

                    for (int i = 0; i < readWeather.size(); i++) {
                        if (readWeather.get(i).getTown().equals(town) && readWeather.get(i).getTime().toString().trim().equals(Time) && readWeather.get(i).getDayW().toString().trim().equals(Day)) {
                            readWeather.remove(i);
                        }
                    }

                    Row writeRow;
                    Cell writeCell;

                    for (int i = 0; i < readWeather.size(); i++) {
                        writeRow = readBookSheet.createRow(i + 1);

                        writeCell = writeRow.createCell(0);
                        writeCell.setCellValue(readWeather.get(i).getTown());

                        writeCell = writeRow.createCell(1);
                        writeCell.setCellValue(readWeather.get(i).getDayW().toString());

                        writeCell = writeRow.createCell(2);
                        writeCell.setCellValue(readWeather.get(i).getTime().toString());

                        writeCell = writeRow.createCell(3);
                        writeCell.setCellValue(readWeather.get(i).getT());

                        writeCell = writeRow.createCell(4);
                        writeCell.setCellValue(readWeather.get(i).getRains());

                        writeCell = writeRow.createCell(5);
                        writeCell.setCellValue(readWeather.get(i).getVw());

                        writeCell = writeRow.createCell(6);
                        writeCell.setCellValue(readWeather.get(i).getP());
                    }

                    try {
                        out = new FileOutputStream(file);
                        readBook.write(out);
                        readBook.close();
                        out.flush();
                        out.close();
                        input.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        }
    }

//    Изменить данные в таблице

    public class ChangeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == change) {
                setVisible(false);

                win4.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                win4.setSize(800, 500);
                win4.setVisible(true);
                win4.setResizable(false);
                win4.setLocationRelativeTo(null);

                win4.setLayout(null);

                win4.add(giveChange);
                win4.add(back);

                win4.add(l2);
                win4.add(l3);
                win4.add(l4);
                win4.add(l5);
                win4.add(l6);
                win4.add(l7);
                win4.add(l8);

                win4.add(town);
                win4.add(day);
                win4.add(time);
                win4.add(t);
                win4.add(rains);
                win4.add(Vw);
                win4.add(P);

                giveChange.setSize(150, 25);
                giveChange.setLocation(200, 400);
                back.setSize(150, 25);
                back.setLocation(450, 400);

                l2.setSize(200, 25);
                l2.setLocation(250, 70);
                l7.setSize(200, 25);
                l7.setLocation(250, 105);
                l8.setSize(200, 25);
                l8.setLocation(250, 140);
                l3.setSize(200, 25);
                l3.setLocation(250, 175);
                l4.setSize(200, 25);
                l4.setLocation(250, 210);
                l5.setSize(200, 25);
                l5.setLocation(250, 245);
                l6.setSize(200, 25);
                l6.setLocation(250, 280);

                town.setSize(100, 25);
                town.setLocation(450, 70);
                day.setSize(100, 25);
                day.setLocation(450, 105);
                time.setSize(100, 25);
                time.setLocation(450, 140);
                t.setSize(100, 25);
                t.setLocation(450, 175);
                rains.setSize(100, 25);
                rains.setLocation(450, 210);
                Vw.setSize(100, 25);
                Vw.setLocation(450, 245);
                P.setSize(100, 25);
                P.setLocation(450, 280);

                back.addActionListener(new BackActionListener());
                giveChange.addActionListener(new GivChaActionListener());
            }
        }
    }

    public class GivChaActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == giveChange) {
                try {
                    input = new FileInputStream(file);
                    readBook = new HSSFWorkbook(input);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                readBookSheet = readBook.getSheet("TheWeather");

                Row row;
                Cell cell;

                String TownComp = town.getText().trim();
                String DayComp = day.getSelectedItem().toString();
                String TimeComp = time.getSelectedItem().toString();

                for (int i = 0; i < readBookSheet.getLastRowNum(); i++) {
                    row = readBookSheet.getRow(i+1);

                    if (TownComp.equals(row.getCell(0).toString()) && DayComp.equals(row.getCell(1).toString()) && TimeComp.equals(row.getCell(2).toString())) {
                        cell = row.getCell(3);
                        cell.setCellValue(t.getText());

                        cell = row.getCell(4);
                        cell.setCellValue(rains.getText());

                        cell = row.getCell(5);
                        cell.setCellValue(Vw.getText());

                        cell = row.getCell(6);
                        cell.setCellValue(P.getText());

                        break;
                    }
                }

                try {
                    out = new FileOutputStream(file);
                    readBook.write(out);
                    readBook.close();
                    out.flush();
                    out.close();
                    input.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

//    Отсортировать данные в таблице

    public class SortActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == sort) {
                setVisible(false);

                win5.setLayout(null);

                win5.setVisible(true);
                win5.setDefaultCloseOperation(0);
                win5.setSize(new Dimension(800, 500));
                win5.setResizable(false);
                win5.setLocationRelativeTo(null);

                win5.add(back);
                win5.add(sorting);

                win5.add(r1);
                win5.add(r2);
                win5.add(r3);
                win5.add(r4);
                win5.add(r5);

                r1.setSize(300, 25);
                r1.setLocation(325, 120);
                r2.setSize(200, 25);
                r2.setLocation(325, 155);
                r3.setSize(200, 25);
                r3.setLocation(325, 190);
                r4.setSize(200, 25);
                r4.setLocation(325, 225);
                r5.setSize(200, 25);
                r5.setLocation(325, 260);

                group.add(r1);
                group.add(r2);
                group.add(r3);
                group.add(r4);
                group.add(r5);

                sorting.setSize(150, 25);
                sorting.setLocation(200, 400);
                back.setSize(150, 25);
                back.setLocation(450, 400);

                back.addActionListener(new BackActionListener());
                r1.addActionListener(new SortingActionListener());
                r2.addActionListener(new SortingActionListener());
                r3.addActionListener(new SortingActionListener());
                r4.addActionListener(new SortingActionListener());
                r5.addActionListener(new SortingActionListener());
                sorting.addActionListener(new DoSortActionListener());

            }
        }
    }

    public class SortingActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == r1) {
                k = 1;
            }
            if(e.getSource() == r2) {
                k = 2;
            }
            if(e.getSource() == r3) {
                k = 3;
            }
            if(e.getSource() == r4) {
                k = 4;
            }
            if(e.getSource() == r5) {
                k = 5;
            }
        }
    }

    public class DoSortActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == sorting) {
                try {
                    input = new FileInputStream(file);
                    readBook = new HSSFWorkbook(input);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                readBookSheet = readBook.getSheet("TheWeather");

                readWeather = null;

                readWeather = new ArrayList<Weather>();

                for (int i = 0; i < readBookSheet.getLastRowNum(); i++) {
                    Row readRow = readBookSheet.getRow(i + 1);

                    readWeather.add(new Weather(readRow.getCell(0).toString(),
                            readRow.getCell(1),
                            readRow.getCell(2),
                            readRow.getCell(3).toString(),
                            readRow.getCell(4).toString(),
                            readRow.getCell(5).toString(),
                            readRow.getCell(6).toString()));
                }

                for (int i = 0; i < readBookSheet.getLastRowNum(); i++) {
                    Row readRow = readBookSheet.getRow(i + 1);

                    readBookSheet.removeRow(readRow);
                }

                if (k == 1) {
                    Collections.sort(readWeather, new Comparator<Weather>() {
                        @Override
                        public int compare(Weather o1, Weather o2) {
                            int t1 = Integer.valueOf(o1.getT());
                            int t2 = Integer.valueOf(o2.getT());
                            return t1 - t2;
                        }
                    });
                } else if (k == 2) {
                    Collections.sort(readWeather, new Comparator<Weather>() {
                        @Override
                        public int compare(Weather o1, Weather o2) {
                            int r1 = Integer.valueOf(o1.getRains());
                            int r2 = Integer.valueOf(o2.getRains());
                            return r1 - r2;
                        }
                    });
                } else if (k == 3) {
                    Collections.sort(readWeather, new Comparator<Weather>() {
                        @Override
                        public int compare(Weather o1, Weather o2) {
                            int Vw1 = Integer.valueOf(o1.getVw());
                            int Vw2 = Integer.valueOf(o2.getVw());
                            return Vw1 - Vw2;
                        }
                    });
                } else if (k == 4) {
                    Collections.sort(readWeather, new Comparator<Weather>() {
                        @Override
                        public int compare(Weather o1, Weather o2) {
                            int p1 = Integer.valueOf(o1.getP());
                            int p2 = Integer.valueOf(o2.getP());
                            return p1 - p2;
                        }
                    });
                } else {
                    Collections.sort(readWeather, new Comparator<Weather>() {
                        @Override
                        public int compare(Weather o1, Weather o2) {
                            String Town1 = o1.getTown();
                            String Town2 = o2.getTown();
                            return Town1.compareTo(Town2);
                        }
                    });
                }

                Row writeRow;
                Cell writeCell;

                for (int i = 0; i < readWeather.size(); i++) {
                    writeRow = readBookSheet.createRow(i + 1);

                    writeCell = writeRow.createCell(0);
                    writeCell.setCellValue(readWeather.get(i).getTown());

                    writeCell = writeRow.createCell(1);
                    writeCell.setCellValue(readWeather.get(i).getDayW().toString());

                    writeCell = writeRow.createCell(2);
                    writeCell.setCellValue(readWeather.get(i).getTime().toString());

                    writeCell = writeRow.createCell(3);
                    writeCell.setCellValue(readWeather.get(i).getT());

                    writeCell = writeRow.createCell(4);
                    writeCell.setCellValue(readWeather.get(i).getRains());

                    writeCell = writeRow.createCell(5);
                    writeCell.setCellValue(readWeather.get(i).getVw());

                    writeCell = writeRow.createCell(6);
                    writeCell.setCellValue(readWeather.get(i).getP());
                }

                try {
                    out = new FileOutputStream(file);
                    readBook.write(out);
                    readBook.close();
                    out.flush();
                    out.close();
                    input.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}


