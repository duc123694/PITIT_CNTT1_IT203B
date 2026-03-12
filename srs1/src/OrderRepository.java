import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
    //Thêm đơn
    public void add(Order order) {
        orders.add(order);
    }
    //Tìm đơn theo ID
    public Order findById(String id) {

        for (Order o : orders) {

            if (o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }
    //Hiển thị tất cả đơn
    public void display() {
        for (Order o : orders) {
            o.displayOrder();
            System.out.println("----------------");
        }

    }
}