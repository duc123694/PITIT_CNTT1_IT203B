package xuatsac1;

public class FixedDiscount implements DiscountStrategy {
    double amount;

    public FixedDiscount(double amount) {
        this.amount = amount;
    }

    public double apply(double total) {
        return total - amount;
    }
}