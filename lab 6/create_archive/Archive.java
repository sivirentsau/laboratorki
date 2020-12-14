package create_archive;

import app.*;

public class Archive {

    public static void main(String[] args) {

        Application app = new Application("Создание базы данных бумаг/книг");

        app.setSize(565, 400);
        app.setVisible(true);
        app.setResizable(false);
        app.setLocationRelativeTo(null);

    }

}
