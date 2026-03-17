package kha2;

public class PercentageDiscount implements DiscountStrategy{
    //Giảm theo %
    private double percent;

    public  PercentageDiscount(double percent){
        this.percent = percent;
    }
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount = (totalAmount * percent /100);
    }
}
