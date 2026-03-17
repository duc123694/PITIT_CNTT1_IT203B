package kha2;

public class OrderCalculator {
    private DiscountStrategy discountStrategy;
    public  OrderCalculator(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }
    double caculate(double totalAmount){
        return discountStrategy.applyDiscount(totalAmount);
    }
}
