package Assignment_4;

public class Currency {

    public static final int EUR = 0;
    public static final int NOK = 1;
    public static final int SEK = 2;
    public static final int USD = 3;

    private final String name;
    private final String codeString;
    private final int code;
    private final double[][] exchangeRates;

    public Currency(String name, String codeString, int code, double[][] exchangeRates) {

        this.name = name;
        this.codeString = codeString;
        this.code = code;
        this.exchangeRates = exchangeRates;
    }

    public String getName() {
        return name;
    }

    public String getCodeString() {
        return codeString;
    }

    public int getCode() {
        return code;
    }

    public double exchangeFrom(Currency c) {

        for (double[] currency : exchangeRates) {

            if (currency[0] == c.code) return currency[1];
        }

        return -1.0;  // Return negative value if there is no exchange rate for the given currency
    }

    public double exchangeTo(Currency c) {

        for (double[] currency : c.exchangeRates) {

            if (currency[0] == code) return currency[1];
        }

        return -1.0;  // Return negative value if there is no exchange rate for the given currency
    }

    public static void main(String[] args) {

        double[][] NOKRates = {
                {Currency.EUR, 0.09454655472},
                {Currency.NOK,  1.0},
                {Currency.SEK,  0.9802960494},
                {Currency.USD,  0.1119620225}
        };
        Currency NOK = new Currency("Norske kroner", "NOK", Currency.NOK, NOKRates);

        double[][] EURRates = {
                {Currency.EUR,  1.0},
                {Currency.NOK, 10.5768},
                {Currency.SEK, 10.3688},
                {Currency.USD,  1.1842}
        };

        Currency EUR = new Currency("Euro", "EUR", Currency.EUR, EURRates);

        double[][] SEKRates = {
                {Currency.EUR, 0.09654466639},
                {Currency.NOK, 1.019102049},
                {Currency.SEK, 1.0},
                {Currency.USD, 0.1143523654}
        };

        Currency SEK = new Currency("Svenska kronor", "SEK", Currency.SEK, SEKRates);

        double[][] USDRates = {
                {Currency.EUR, 1.1828},
                {Currency.NOK, 8.9499},
                {Currency.SEK, 8.7144},
                {Currency.USD, 1}
        };

        Currency USD = new Currency("U.S. dollars", "USD", Currency.USD, USDRates);

        // Check how much it costs to exchange between NOK and EUR
        System.out.printf("You can buy 1.00 NOK for %.2f EUR.\n", NOK.exchangeFrom(EUR));
        System.out.printf("You can buy 1.00 EUR for %.2f NOK.\n", NOK.exchangeTo(EUR));
    }
}
