package Assignment_4;

import java.util.Random;

public class Spiller {

    private String navn;
    private final Random terning = new Random();
    private int poengsum = 0;

    public Spiller() {
        this.navn = "Spiller";
    }

    public Spiller(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPoengsum() {
        return poengsum;
    }

    public void kastTerningen() {

        int poeng = terning.nextInt(6) + 1;

        if (this.poengsum < 100) {

            this.poengsum += poeng;

        } else {

            this.poengsum -= poeng;
        }
    }

    public String toString() {
        return "Spiller: " + this.navn + ", poengsum: " + this.poengsum;
    }

    public static void main(String[] args) {

        Spiller en = new Spiller("Aurora");
        Spiller to = new Spiller("Sanza");

        System.out.println(en + "\n" + to + "\n");

        int runde = 1;
        while (en.getPoengsum() != 100 && to.getPoengsum() !=100) {

            en.kastTerningen();
            to.kastTerningen();

            System.out.println("[Runde " + runde + "] " + en.getNavn() + "s poengsum: " + en.getPoengsum() + ", " + to.getNavn() + "s poengsum: " + to.getPoengsum());
            runde++;
        }

        System.out.println("\nSpillet er over!\n");

        if (en.getPoengsum() == 100) {

            System.out.println("[Vinner!]\n" + en + "\n");

        } else {

            System.out.println("[Taper!]\n" + en + "\n");
        }

        if (to.getPoengsum() == 100) {

            System.out.println("[Vinner!]\n" + to);

        } else {

            System.out.println("[Taper!]\n" + to);
        }
    }
}
