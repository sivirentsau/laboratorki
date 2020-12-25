package main;

import app.*;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        App app = new App("Прогноз погоды");

        app.setSize(800, 500);
        app.setVisible(true);
        app.setResizable(false);
        app.setLocationRelativeTo(null);
    }
}
