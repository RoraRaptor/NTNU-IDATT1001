package Assignment_6;

import java.util.Scanner;

public class TextAnalyzer {

    private String text;
    private int[] distribution = new int[30];
    private static final char[] alphabet= {'A', 'B', 'C', 'D', 'E', 'F', 'G',
                                           'H', 'I', 'J', 'K', 'L', 'M', 'N',
                                           'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                                           'V', 'W', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'};

    public TextAnalyzer(String text) {
        if (text != null) {
            this.text = text.toUpperCase();
        } else {
            this.text = "";
        }

        for (int i = 0; i < this.text.length(); i++) {  // Iterate over the string

            char character = this.text.charAt(i);

            if (character >= 65 && character <= 90) {

                distribution[character - 65] += 1;

            } else if (character == 198) {  // Æ

                distribution[26] += 1;

            } else if (character == 216) {  // Ø

                distribution[27] += 1;

            } else if (character == 197) {  // Å

                distribution[28] += 1;

            } else {

                distribution[29] += 1;
            }
        }
    }

    public static void main(String[] args) {

        // TODO: Write client helper class and use it to finish this task in the assignment

        // Read text from user

        // Do all the things

        // Ask user if they want to go again

        // Repeat or exit

        Scanner in = new Scanner(System.in);

        boolean keepGoing = true;

        System.out.println("Enter a text to be analyzed.");
        String input = in.nextLine();

        while (keepGoing) {

            System.out.println("Enter a letter of your choice.");
            char letter = in.next("\\w").toUpperCase().charAt(0);
            in.nextLine();  // Consumes leftover newline from previous statement

            TextAnalyzer analyzer = new TextAnalyzer(input);

            // Do analysis

            System.out.println("Amount of different letters:");
            int[] distribution = analyzer.getLetterDistribution();

            for (int i = 0; i < distribution.length; i++) {
                System.out.printf("%c: %d\n", TextAnalyzer.alphabet[i], distribution[i]);
            }

            System.out.println("\n\nTotal number of letters:");
            System.out.println(analyzer.getLetterTotal());

            System.out.println("\n\nPercentage of non-letters:");
            System.out.println(analyzer.getNonLetterPercentage());

            System.out.println("\n\nThe amount of letter " + letter);
            System.out.println(analyzer.getLetterAmount(letter));

            System.out.println("\n\nMost popular letters:");
            System.out.println(analyzer.getMostFrequent());

            System.out.println("\n\nEnter a new text to analyze or nothing to quit..");
            input = in.nextLine();

            System.out.println(); // Extra space

            if (input.equals("")) keepGoing = false;

        }
    }

    public String getText() {
        return text;
    }

    public int[] getLetterDistribution() {

        int[] result = new int[29];

        for (int i = 0; i < result.length; i++) {  // Make a new array excluding the non-letter character count

            result[i] = distribution[i];
        }

        return result;
    }

    public int getCharacterTotal() {

        int characters = 0;

        for (int i = 0; i < distribution.length; i++) {

            characters += distribution[i];
        }

        return characters;
    }

    public int getLetterTotal() {

        int letter = 0;

        for (int i = 0; i < distribution.length - 1; i++) {  // Add all elements except non-letters

            letter += distribution[i];
        }

        return letter;
    }

    public float getLetterPercentage() {

        float total = 0;
        float letters = 0;

        for (int i = 0; i < distribution.length; i++) {

            if (i < 29) {  // If the index is related to a letter, sum the count
                letters += distribution[i];
            }

            total += distribution[i];  // Count the total amount of characters
        }

        return letters / total;  // Return the percentage in the interval (0, 1)
    }

    public float getNonLetterPercentage() {

        float total = 0;
        float nonLetters = distribution[29];  // The amount of characters that are not letters

        for (int i = 0; i < distribution.length; i++) {  // Count the total amount of characters

            total += distribution[i];
        }

        return nonLetters / total;  // Return the percentage in the interval (0, 1)
    }

    public int getLetterAmount(char letter) {

        int result = -1;  // Indicates non-letter if character not matched

        if (letter >= 65 && letter <= 90) {  // Uppercase letters

            result = distribution[letter - 65];  // Get the count at the index equivalent of the character

        } else if (letter == 'Æ') {  // Æ

            result = distribution[26];  // Get the count at the index equivalent of the character

        } else if (letter == 'Ø') {  // Ø

            result = distribution[27];  // Get the count at the index equivalent of the character

        } else if (letter == 'Å') {  // Å

            result = distribution[28];  // Get the count at the index equivalent of the character

        }

        return result;
    }

    public char[] getMostFrequent() {

        char[] tempList = new char[distribution.length - 1];  // Enough space for all combinations of equally frequent letters

        int highestFrequency = 0;

        for (int i = 0; i < tempList.length; i++) {  // Find the highest frequency of characters

            if (distribution[i] > highestFrequency) {
                highestFrequency = distribution[i];
            }
        }

        int resultIndex = 0;

        for (int i = 0; i < tempList.length; i++) {  // Store the characters that have the highest frequency in a temporary list

            if (distribution[i] == highestFrequency) {

                if (i < 26) {

                    tempList[resultIndex] = (char) (i + 65);  // Storing the character equivalent to the index value
                    resultIndex++;

                } else if (i == 26) {

                    tempList[resultIndex] = 'Æ';
                    resultIndex++;

                } else if (i == 27) {

                    tempList[resultIndex] = 'Ø';
                    resultIndex++;

                } else if (i == 28) {

                    tempList[resultIndex] = 'Å';
                    resultIndex++;
                }
            }
        }

        char[] result = new char[resultIndex];  // New list at a more appropriate length

        for (int i = 0 ; i < result.length; i++) {  // Store characters in resultList
            result[i] = tempList[i];
        }

        return result;
    }
}
