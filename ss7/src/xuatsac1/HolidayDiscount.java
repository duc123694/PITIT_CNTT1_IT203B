package xuatsac1;

public class HolidayDiscount implements DiscountStrategy {
    public double apply(double total) {
        return total - total * 0.15;
    }
}
