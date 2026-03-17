package xuatsac1;

import java.util.*;

class Order {
    String id;
    Customer customer;
    List<OrderItem> items = new ArrayList<>();
    double total;

    public Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public void addItem(Product p, int qty) {
        items.add(new OrderItem(p, qty));
    }

    public double calculateTotal() {
        double sum = 0;
        for (OrderItem i : items) {
            sum += i.getTotal();
        }
        total = sum;
        return sum;
    }
}
