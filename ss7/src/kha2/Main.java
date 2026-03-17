package kha2;

public class Main {
    public static void main(String[] args) {

        double total = 1000000;

        // PercentageDiscount 10%
        OrderCalculator c1 = new OrderCalculator(new PercentageDiscount(10));
        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng PercentageDiscount 10%");
        System.out.println("Số tiền sau giảm: " + (int)c1.caculate(total));

        System.out.println();

        // FixedDiscount
        OrderCalculator c2 = new OrderCalculator(new FixedDiscount(50000));
        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng FixedDiscount 50.000");
        System.out.println("Số tiền sau giảm: " + (int)c2.caculate(total));

        System.out.println();

        // NoDiscount
        OrderCalculator c3 = new OrderCalculator(new NoDiscount());
        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng NoDiscount");
        System.out.println("Số tiền sau giảm: " + (int)c3.caculate(total));

        System.out.println();

        // HolidayDiscount (không sửa code cũ)
        OrderCalculator c4 = new OrderCalculator(new HolidayDiscount());
        System.out.println("Thêm HolidayDiscount 15% (không sửa code cũ)");
        System.out.println("Số tiền sau giảm: " + (int)c4.caculate(total));
    }
}