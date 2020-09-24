package Assignment_7;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SimpleTextEditor {

    private String text;

    public SimpleTextEditor (String inputString) {

        if (inputString != null) {

            text = inputString;

        } else {

            throw new IllegalArgumentException("NewString can not be null.");
        }
    }

    private static String[] getWords(String inputText) {

        // Split generally on white space and punctuation
        String[] splitString = inputText.split("[\\s,;:_-]+");
        ArrayList<String> newStrings = new ArrayList<>();

        for (String subString : splitString) {

            // Check that the substring isn't a dot-separated acronym
            if (!subString.matches("([a-zA-ZæøåÆØÅ][.]){2,}")) {

                // Remove dots that shouldn't be there.
                String dotLessString = subString.replace(".", "");

                newStrings.add(dotLessString);

            } else {

                newStrings.add(subString);
            }
        }

        return newStrings.toArray(new String[0]);
    }

    private String[] getPeriods() {

        return text.split("[.!:?]");
    }

    public int countWords() {
        return getWords(text).length;
    }

    public static int countWords(String inputText) {
        return getWords(inputText).length;
    }

    public double getAverageWordLength() {

        String[] words = getWords(text);

        int i = 0;
        double wordLengthSum = 0;

        for (String word : words) {

            wordLengthSum += word.length();
            i++;
        }

        return wordLengthSum / i;
    }

    public double getAverageWordCountPerPeriod() {

        String[] periods = getPeriods();

        int i = 0;
        double wordCountSum = 0;

        for (String period : periods) {

            wordCountSum += countWords(period);
            i++;
        }

        return wordCountSum / i;

    }

    public void replaceWord(String target, String replacementString) {

        text = text.replaceAll("(?i)(?<=\\s)" + Pattern.quote(target) + "(?=[\\s,.!?;:])", replacementString);
    }

    public String getText() {
        return text;
    }

    public String getUpperCaseText() {
        return text.toUpperCase();
    }

    @Override
    public String toString() {
        return text;
    }

    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter text: ");
//        String testString = in.nextLine();
//        System.out.println("Enter search string: ");
//        String searchString = in.nextLine();
//        System.out.println("Enter replacement string: ");
//        String replacementString = in.nextLine();

        String testString = "Dette er en tekst som inneholder noen perioder. Hva er en periode, spør du? " +
                "La meg forklare: En periode er en samling ord, skilt med tegnsetting! Ærlig talt, kan du ønske " +
                "å vite noe mer?";

        String searchString = "en";
        String replacementString = "Grethe";

        SimpleTextEditor test = new SimpleTextEditor(testString);

        System.out.println("Hvor mange ord er det i teksten? - " + test.countWords());
        System.out.println("Hva er gjennomsnittlig ordlengde? - " + test.getAverageWordLength());
        System.out.println("Hva er gjennomsnittlig antall ord per periode? - " + test.getAverageWordCountPerPeriod());
        test.replaceWord(searchString, replacementString);
        System.out.println("\n" + test + "\n");
        System.out.println(test.getText() + "\n");
        System.out.println(test.getUpperCaseText() + "\n");
    }
}
