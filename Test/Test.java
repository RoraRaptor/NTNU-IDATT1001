package Test;

import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {

        String text = "Dette er en tekst som inneholder noen perioder. Hva er en periode, spør du? " +
                "La meg forklare: En periode er en samling ord, skilt med tegnsetting! Ærlig talt, kan du ønske " +
                "å vite noe mer?";

        text = text.replaceAll("(?i)(?<=\\s)" + Pattern.quote("en") + "(?=\\s)", "Grethe");

        System.out.println(text);
    }
}
