package Assignment_6;

import java.util.Random;

public class RandomStatistics {

    public static void main(String[] args) {

        Random random = new Random();
        int[] randomList = new int[10];

        for(int i = 0; i < 1000; i++) {
            randomList[random.nextInt(10)] += 1;
        }

        String result = "Random distribution of numbers in the interval (0, 9):\n"
                + "0: " + randomList[0] + " occurrences.\n"
                + "1: " + randomList[1] + " occurrences.\n"
                + "2: " + randomList[2] + " occurrences.\n"
                + "3: " + randomList[3] + " occurrences.\n"
                + "4: " + randomList[4] + " occurrences.\n"
                + "5: " + randomList[5] + " occurrences.\n"
                + "6: " + randomList[6] + " occurrences.\n"
                + "7: " + randomList[7] + " occurrences.\n"
                + "8: " + randomList[8] + " occurrences.\n"
                + "9: " + randomList[9] + " occurrences.";



        // TODO: Ekstraoppgave; utskrift med stjerner.
    }
}
