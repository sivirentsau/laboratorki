package clrscr;

public interface clrscr {

    static void clrscr() {
        for(int i = 0; i < 80*300; i++) {
            System.out.println("\b");
        }
    }

}
