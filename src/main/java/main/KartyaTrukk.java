package main;
import java.util.Scanner;

class KartyaTrukk {
    private Pakli pakli;
    private final static Scanner SC = new Scanner(System.in);
    
    public KartyaTrukk() {
        pakli = new Pakli();
        indit();
    }
    
    private void indit() {
        for (int i = 0; i < 3; i++) {
            pakli.kirak();
            int oszlop = melyik();
            pakli.kever(oszlop);
        }
        pakli.ezVolt();
    }
    
    private int melyik() {
        boolean jo;
        int oszlop;
        do {
            System.out.print("\nMelyik oszlopban van a gondolt kártya (1-3): ");
            oszlop = SC.nextInt();
            jo = oszlop >= 1 && oszlop <= 3;
        } while (!jo);
        return oszlop;
    }
}