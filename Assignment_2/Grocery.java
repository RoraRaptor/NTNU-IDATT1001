package Assignment_2;

public class Grocery {
    
    private String brand    = "Unknown";
    private String name     = "Unknown";
    private int    amount   = 1000;
    private String unit     = "gram";
    private double cost     = 0.0;
    private String currency = "NOK";

    Grocery(String brand, String name, int amount, String unit, double cost, String currency) {

        this.brand    = brand;
        this.name     = name;
        this.amount   = amount;
        this.unit     = unit;
        this.cost     = cost;
        this.currency = currency;
    }

    Grocery(String brand, int amount, double cost) {

        this.brand  = brand;
        this.amount = amount;
        this.cost   = cost;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String newBrand) {
        this.brand = newBrand;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int newAmount) {
        this.amount = newAmount;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String newUnit) {
        this.unit = newUnit;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double newCost) {
        this.cost = newCost;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String newCurrency) {
        this.currency = newCurrency;
    }

    /**
     * Check which is cheaper of two Grocery objects.
     * 
     * @param b
     * @return the cost difference between the Grocery objects\. Negative if this is the cheaper Grocery.
     * @throws IllegalArgumentException
     */
    private double compareCostPerAmount(Grocery b) throws IllegalArgumentException {
    
        boolean sameUnit = this.unit.equals(b.getUnit());
        boolean sameCurrency = this.currency.equals(b.getCurrency());

        if (!sameUnit || !sameCurrency) {

            throw new IllegalArgumentException("Cannot compare Cost Per Amount of Groceries with different units or currencies.");
        }

        return (this.cost/this.amount) - (b.getCost()/b.getAmount());
    }

    public String getSummary() {

        return this.brand + "'s product " + this.name + " costs " + this.cost + " " + this.currency + " per " + this.amount + " " + this.unit;
    }

    public static void main(String[] args) {
        
        Grocery a = new Grocery("A", 450, 35.90);
        Grocery b = new Grocery("B", 500, 39.50);

        String intro = "Which brand has the cheapest product?\n\n" + a.getSummary() + "\n\n" + b.getSummary() + ".\n";

        System.out.println(intro);

        double difference = a.compareCostPerAmount(b);

        if (Math.abs(difference) < 0.01) { // A and B's cost are practically the same

            System.out.printf("Brand %s and brand %s cost the same!", a.getBrand(), b.getBrand());

        } else if (difference < 0) { // Brand A is cheaper

            System.out.printf("Brand %s is the cheapest by %.2f %s!", a.getBrand(), difference, a.getCurrency());
        
        } else { // Brand B is cheaper

            System.out.printf("Brand %s is the cheapest by %.2f %s!", b.getBrand(), difference, b.getCurrency());
        }
    }
}