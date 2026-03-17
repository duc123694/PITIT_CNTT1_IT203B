package xuatsac1;

public class PercentageDiscount implements DiscountStrategy {
    double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double apply(double total) {
        return total - total * percent / 100;
    }
}
