package main;

import java.util.Scanner;

public class main {

    static String[] pakli = new String[22];
    static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        osszeallit();
        kirak();
        beker();
    }

    private static void osszeallit() {
        String[] szinek = {"P","T","Z","M"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
        
        int index = 0;
        
        for (String szin : szinek) {
            if(szin.equals("M")){
                for (int i = 0; i < 3; i++) {
                    pakli[index] = szin + " " + ertekek[i];
                    index++;
                }
            }else{
                for (int i = 0; i < ertekek.length; i++) {
                    pakli[index] = szin + " " + ertekek[i];
                    index++;
                }
            }
        }
    }
    
    private static void kirak(){
        for (int i = 0; i < pakli.length; i++) {
            System.out.print(pakli[i] + "\t");
            
            if ((i + 1) % 3 == 0){
                System.out.println();
            }
        }
    }
    
    public static int beker() {
        boolean jo;
        int oszlop;
        do {                
                System.out.println("Melyik oszlop (1-3)");
                oszlop = sc.nextInt();
                jo = oszlop >= 1 && oszlop <= 3;
        } while (!jo);
        return oszlop;
        
    }
}
