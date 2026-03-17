package xuatsac2;

public class WebDiscount implements DiscountStrategy {

    public double applyDiscount(double amount) {
        System.out.println("Áp dụng giảm giá 10% cho đơn hàng website");
        return amount * 0.9;
    }
}