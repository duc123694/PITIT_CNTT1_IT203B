package gioi2;

public class Main {

    public static void main(String[] args) {

        // Cấu hình 1
        OrderRepository repo1 = new FileOrderRepository();
        NotificationService notify1 = new EmailService();

        OrderService service1 = new OrderService(repo1, notify1);

        System.out.println("Tạo đơn hàng ORD001");
        service1.createOrder("ORD001");

        System.out.println();

        // Cấu hình 2 (thay implementation)
        OrderRepository repo2 = new DatabaseOrderRepository();
        NotificationService notify2 = new SMSNotification();

        OrderService service2 = new OrderService(repo2, notify2);

        System.out.println("Tạo đơn hàng ORD002");
        service2.createOrder("ORD002");
    }
}