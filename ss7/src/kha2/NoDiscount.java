package kha2;

public class NoDiscount implements DiscountStrategy{
//Ko giảm giá
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount;
    }
}
