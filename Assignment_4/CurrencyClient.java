package Assignment_4;

import javax.swing.*;

public class CurrencyClient {

    private final static String TITLE = "CurrencyClient";
    private final static int EXCHANGE_FROM = 0;
    private final static int EXCHANGE_TO = 1;

    private static int getCurrency() {

        int currency = -1;
        Object input;
        String msg = "Vennligst velg en valuta:";
        String[] currencies = {"Euro", "Svenske kroner", "Amerikanske dollar"};

        input = JOptionPane.showInputDialog(null, msg, TITLE, JOptionPane.QUESTION_MESSAGE, null, currencies, currencies[0]);

        if (input != null) {

            switch (input.toString()) {

                case "Euro":
                    currency = Currency.EUR;
                    break;

                case "Svenske kroner":
                    currency = Currency.SEK;
                    break;

                case "Amerikanske dollar":
                    currency = Currency.USD;
                    break;
            } // end switch()
        } // end if()

        return currency;

    } // getCurrency()

    private static int getExchangeType() {

        int type = -1;
        Object input;
        String msg = "Hva vil du gjøre?";
        String[] currencies = {"Veksle fra norske kroner", "Veksle til norske kroner"};

        input = JOptionPane.showInputDialog(null, msg, TITLE, JOptionPane.QUESTION_MESSAGE, null, currencies, currencies[0]);

        if (input != null) {

            switch (input.toString()) {

                case "Veksle fra norske kroner":
                    type = EXCHANGE_FROM;
                    break;

                case "Veksle til norske kroner":
                    type = EXCHANGE_TO;
                    break;

            } // end switch()
        } // end if()

        return type;

    } // end getExchangeType()

    private static double getValue() {

        double value = -1;
        String input;
        String msg = "Hvor mye vil du veksle?";

        do {

            input = JOptionPane.showInputDialog(null, msg, TITLE, JOptionPane.QUESTION_MESSAGE);

        } while (input != null && input.equals(""));

        if (input != null) {

            value = Double.parseDouble(input);

        } // end if()

        return value;

    } // end getValue()

    private static double exchange(int type, int currency, double value) {

        double[][] EURRates = {
                {Currency.EUR,  1.0},
                {Currency.NOK, 10.5768},
                {Currency.SEK, 10.3688},
                {Currency.USD,  1.1842}
        };

        double[][] NOKRates = {
                {Currency.EUR, 0.09454655472},
                {Currency.NOK,  1.0},
                {Currency.SEK,  0.9802960494},
                {Currency.USD,  0.1119620225}
        };

        double[][] SEKRates = {
                {Currency.EUR, 0.09654466639},
                {Currency.NOK, 1.019102049},
                {Currency.SEK, 1.0},
                {Currency.USD, 0.1143523654}
        };

        double[][] USDRates = {
                {Currency.EUR, 1.1828},
                {Currency.NOK, 8.9499},
                {Currency.SEK, 8.7144},
                {Currency.USD, 1}
        };

        Currency EUR = new Currency("Euro", "EUR", Currency.EUR, EURRates);
        Currency NOK = new Currency("Norske kroner", "NOK", Currency.NOK, NOKRates);
        Currency SEK = new Currency("Svenska kronor", "SEK", Currency.SEK, SEKRates);
        Currency USD = new Currency("U.S. dollars", "USD", Currency.USD, USDRates);

        Currency currencyObject = NOK;

        switch (currency) {
            case Currency.EUR:
                currencyObject = EUR;
                break;

            case Currency.SEK:
                currencyObject = SEK;
                break;

            case Currency.USD:
                currencyObject = USD;
                break;
        }

        double rate;
        double result = -1;

        if (type == EXCHANGE_FROM) {

            rate = NOK.exchangeFrom(currencyObject);
            result = value * rate;

        } else if (type == EXCHANGE_TO) {

            rate = NOK.exchangeTo(currencyObject);
            result = value * rate;
        }

        return result;

    } // end exchange()

    private static void sayHello() {

        String msg = "Velkommen til " + TITLE + "!\n\n"
                     + "Velg om du vil veksle fra eller til norske kroner, hvilken valuta du vil veksle fra, "
                     + "og hvor mye du vil veksle.";

        JOptionPane.showMessageDialog(null, msg, TITLE, JOptionPane.INFORMATION_MESSAGE);

    } // end sayHello()

    private static void sayGoodbye() {

        String msg = "Takk for at du brukte " + TITLE + "!";

        JOptionPane.showMessageDialog(null, msg, TITLE, JOptionPane.INFORMATION_MESSAGE);

    } // end sayGoodbye()

    private static void showResult(int type, int currency, double result) {

        String exchangeStr = "";

        switch (type) {
            case EXCHANGE_FROM:
                exchangeStr = "fra";
                break;

            case EXCHANGE_TO:
                exchangeStr = "til";
                break;
        }

        String currencyStr = "";

        switch (currency) {

            case Currency.EUR:
                currencyStr = "Euro";
                break;

            case Currency.SEK:
                currencyStr = "Svenske kroner";
                break;

            case Currency.USD:
                currencyStr = "Amerikanske dollar";
                break;
        } // end switch()

        String msg = "Resultatet av vekslingen " + exchangeStr + " " + currencyStr + " til NOK er " + result + "\n\n";

        JOptionPane.showMessageDialog(null, msg, TITLE, JOptionPane.INFORMATION_MESSAGE);

    } // end showResult()

    public static void main(String[] args) {

        sayHello();

        int exchangeType;
        int currency = -1;
        double value = -1.0;
        double result;

        boolean userExit = false;

        while (!userExit) {

            exchangeType = getExchangeType();

            if (exchangeType >= 0) {

                currency = getCurrency();

            } else {

                userExit = true;
            }

            if (currency >= 0) {

                value = getValue();

            } else {

                userExit = true;
            }

            if (value >= 0) {

                result = exchange(exchangeType, currency, value);
                showResult(exchangeType, currency, result);

            } else {

                userExit = true;
            }

        } // end while()

        sayGoodbye();

    } // end main()
} // end CurrencyClient
