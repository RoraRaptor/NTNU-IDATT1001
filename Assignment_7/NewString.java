package Assignment_7;

import java.util.ArrayList;

public class NewString {

    private final String string;

    public NewString(String inputString) {

        if (inputString != null) {

            string = inputString;

        } else {

            throw new IllegalArgumentException("NewString can not be null.");
        }
    }

    public String getAcronym() {

        // Get words separated by punctuation and whitespace

        String[] words = getWords();

        StringBuilder acronym = new StringBuilder();

        for (String word : words) {
            acronym.append(word.charAt(0)).append(".");
        }

        return acronym.toString();
    }

    // String input to deal with non-ASCII characters
    public String removeChar(String charToRemove) {

        // Break string into parts by removing all instances of charToRemove
        String[] tempStrings = string.split(charToRemove);

        StringBuilder newString = new StringBuilder();

        // Glue the string back together
        for (String element : tempStrings) {

            newString.append(element);
        }

        // Return string with all instances of charToRemove removed, easy as that!
        return newString.toString();
    }

    private String[] getWords() {

        // Split generally on white space and punctuation
        String[] splitString = string.split("[\\s,;:!?_-]+");
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


    public static void main(String[] args) {

        String testString = "Klassen String inneholder mange metoder. Vi skal nå lage noen flere.";

        NewString test = new NewString(testString);

        System.out.println(test.getAcronym());
        System.out.println(test.removeChar("n"));
    }
}
