package main;

class Pakli {
    private Lap[] lapok;
    
    public Pakli() {
        lapok = new Lap[21];
        feltolt();
    }
    
    private void feltolt() {
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
        int index = 0;
        
        for (String szin : szinek) {
            if (szin.equals("M")) {
                for (int i = 0; i < 3; i++) {
                    lapok[index++] = new Lap(szin + "_" + ertekek[i]);
                }
            } else {
                for (String ertek : ertekek) {
                    lapok[index++] = new Lap(szin + "_" + ertek);
                }
            }
        }
    }
    
    public void kirak() {
        System.out.println("\nKártyák oszlopokban:");
        System.out.println("1. oszlop\t2. oszlop\t3. oszlop");
        for (int sor = 0; sor < 7; sor++) {
            for (int oszlop = 0; oszlop < 3; oszlop++) {
                System.out.print(lapok[sor * 3 + oszlop].getLeiras() + "\t");
            }
            System.out.println();
        }
    }
    
    public void kever(int oszlop) {
        Lap[] uj = new Lap[21];
        
        Lap[] oszlop1 = new Lap[7];
        Lap[] oszlop2 = new Lap[7];
        Lap[] oszlop3 = new Lap[7];
        
        // Oszlopok szétválasztása
        for (int i = 0; i < 7; i++) {
            oszlop1[i] = lapok[i * 3];
            oszlop2[i] = lapok[i * 3 + 1];
            oszlop3[i] = lapok[i * 3 + 2];
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
        
        for (int i = 0; i < lapok.length; i++) {
            lapok[i] = uj[i];
        }
    }
    
    public void ezVolt() {
        System.out.println("\n A gondolt kártya: " + lapok[10].getLeiras());
    }
}