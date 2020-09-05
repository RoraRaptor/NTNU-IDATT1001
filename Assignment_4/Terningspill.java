package Assignment_4;

import java.util.Scanner;

public class Terningspill {
    private final Spiller en = new Spiller();
    private final Spiller to = new Spiller();

    private boolean spillRunde() {

        en.kastTerningen();
        to.kastTerningen();

        if (en.getPoengsum() == 100 || to.getPoengsum() == 100) {

            return true; // Noen har vunnet
        }

        return false; // Ingen har vunnet enda
    }

    public static void main(String[] args) {

        Terningspill spill = new Terningspill();

        System.out.println("Velkommen til Terningspill!");
        System.out.println("Målet med spillet er å nå 100 poeng. Hver runde kastes en seks-sidet terning automatisk, "
                         + "og poengene summeres opp. Når en av spillerne har nådd 100 poeng avsluttes spillet.\n");

        Scanner in = new Scanner(System.in);
        System.out.print("Hva heter spiller 1? (Trykk [enter] for å fortsette uten navn): ");
        String navn1 = in.nextLine();

        if (!navn1.equals("")) {
            spill.en.setNavn(navn1);
        }

        System.out.println("\n.." + spill.en.getNavn() + " registrert!");

        System.out.print("Hva heter spiller 2? (Trykk [enter] for å fortsette uten navn): ");
        String navn2 = in.nextLine();

        if (!navn1.equals("")) {
            spill.to.setNavn(navn2);
        }

        System.out.println("\n.." + spill.to.getNavn() + " registrert!");

        System.out.println("Spillet er klart til å begynne! Trykk [enter] for å sette i gang:");
        in.nextLine();

        boolean fortsett = true;

        while (fortsett) {

            int runde = 1;
            while (!spill.spillRunde()) {
                System.out.println("[Runde " + runde + "] " + spill.en.getNavn() + "s poengsum: " + spill.en.getPoengsum() + ", " + spill.to.getNavn() + "s poengsum: " + spill.to.getPoengsum());
                runde++;
            }

            System.out.println("\nSpillet er over!\n");

            if (spill.en.getPoengsum() == 100) {

                System.out.println("[Vinner!]\n" + spill.en + "\n");

            } else {

                System.out.println("[Taper!]\n" + spill.en + "\n");
            }

            if (spill.to.getPoengsum() == 100) {

                System.out.println("[Vinner!]\n" + spill.to);

            } else {

                System.out.println("[Taper!]\n" + spill.to);
            }

            System.out.print("\nSpill igjen? (Trykk [enter] for å fortsette, eller skriv \"q\" for å avslutte): ");
            String input = in.nextLine();

            fortsett = input.equals("");
        }

        System.out.println("\nTakk for at dere spilte Terningspill!");
    }
}
