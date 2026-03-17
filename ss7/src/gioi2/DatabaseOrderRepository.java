package gioi2;

import java.util.ArrayList;
import java.util.List;

class DatabaseOrderRepository implements OrderRepository {

    private List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        orders.add(order);
        System.out.println("Lưu đơn hàng vào database: " + order.id);
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }
}