package xuatsac1;

import java.util.List;

public class OrderService {

    private OrderRepository repo;
    private NotificationService notify;

    public OrderService(OrderRepository repo, NotificationService notify) {
        this.repo = repo;
        this.notify = notify;
    }

    public void createOrder(Order order, double finalAmount) {

        repo.save(order);

        notify.send("Đơn hàng " + order.id + " đã tạo");
    }

    public List<Order> getOrders() {
        return repo.findAll();
    }
}
