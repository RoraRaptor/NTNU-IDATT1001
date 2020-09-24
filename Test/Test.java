package Test;

public class Test {

    public static void main(String[] args) {

        String string = "1 2 3, 44   5 6,    7 8 9999";

        String[] splitString = string.split(",");

        for (String subString : splitString) {

            if (subString.matches("^([ ]*[0-9]+[ ]*)+$")) {
                System.out.println("It works");
            } else {
                System.out.println("It doesn't work");
            }
        }
    }
}
