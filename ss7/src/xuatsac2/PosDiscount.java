package xuatsac2;

public class PosDiscount implements DiscountStrategy {

    public double applyDiscount(double amount) {
        System.out.println("Giảm giá thành viên 5%");
        return amount * 0.95;
    }
}
