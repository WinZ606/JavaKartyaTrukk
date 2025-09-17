package main;
import java.util.Scanner;
public class JavaKartyazas {
    static final Scanner SC = new Scanner(System.in);
    static String[] pakli = new String[21];
    
    public static void main(String[] args) {
        indito();
    }
    
    private static void indito() {
        osszeallit();
        for (int i = 0; i < 3; i++) {
            kirak();
            int oszlop = beker();
            kever(oszlop);
        }
        melyikVolt();
    }
    
    private static void osszeallit() {
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
        int index = 0;
        for (String szin : szinek) {
            if (szin.equals("M")) {
                for (int i = 0; i < 3; i++) {
                    pakli[index++] = szin + "_" + ertekek[i];
                }
            } else {
                for (String ertek : ertekek) {
                    pakli[index++] = szin + "_" + ertek;
                }
            }
        }
    }
    
    private static void kirak() {
        System.out.println("\nKártyák oszlopokban:");
        System.out.println("1. oszlop\t2. oszlop\t3. oszlop");
        for (int sor = 0; sor < 7; sor++) {
            for (int oszlop = 0; oszlop < 3; oszlop++) {
                System.out.print(pakli[sor * 3 + oszlop] + "\t\t");
            }
            System.out.println();
        }
    }
    
    private static int beker() {
        boolean jo;
        int oszlop;
        do {
            System.out.print("\nMelyik oszlopban van a gondolt kártya (1-3): ");
            oszlop = SC.nextInt();
            jo = oszlop >= 1 && oszlop <= 3;
        } while (!jo);
        return oszlop;
    }
    
    private static void kever(int oszlop) {
        String[] uj = new String[21];
        
        String[] oszlop1 = new String[7];
        String[] oszlop2 = new String[7];
        String[] oszlop3 = new String[7];
        
        for (int i = 0; i < 7; i++) {
            oszlop1[i] = pakli[i * 3];
            oszlop2[i] = pakli[i * 3 + 1];
            oszlop3[i] = pakli[i * 3 + 2];
        }
        
        int index = 0;
        switch (oszlop) {
            case 1 -> {
                for (int i = 0; i < 7; i++) uj[index++] = oszlop2[i];
                for (int i = 0; i < 7; i++) uj[index++] = oszlop1[i];
                for (int i = 0; i < 7; i++) uj[index++] = oszlop3[i];
            }
            case 2 -> {
                for (int i = 0; i < 7; i++) uj[index++] = oszlop1[i];
                for (int i = 0; i < 7; i++) uj[index++] = oszlop2[i];
                for (int i = 0; i < 7; i++) uj[index++] = oszlop3[i];
            }
            case 3 -> {
                for (int i = 0; i < 7; i++) uj[index++] = oszlop1[i];
                for (int i = 0; i < 7; i++) uj[index++] = oszlop3[i];
                for (int i = 0; i < 7; i++) uj[index++] = oszlop2[i];
            }
        }
        for (int i = 0; i < pakli.length; i++) {
            pakli[i] = uj[i];
        }
    }
         
    private static void melyikVolt() {
        System.out.println("\n A gondolt kártya: " + pakli[10]);
    }
}