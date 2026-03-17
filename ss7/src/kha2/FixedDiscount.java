package kha2;

public class FixedDiscount implements DiscountStrategy{
    //Giảm phần cố định
    private double amount;
    public FixedDiscount(double amount){
        this.amount = amount;
    }
    @Override
    public double applyDiscount(double totalAmount) {
        return 0;
    }
}
