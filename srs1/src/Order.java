import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private List<OrderItem> items;
    private String status;
    private double discount;
    public Order(String id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.status = "PENDING";
        this.discount = 0;
    }
    //Thêm món
    public void addItem(String name, double price, int quantity) {
        OrderItem item = new OrderItem(name, price, quantity);
        items.add(item);
    }
    //Xóa món
    public void removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemName().equals(name)) {
                items.remove(i);
                break;
            }
        }
    }
    //Áp dụng giảm giá
    public void applyDiscount(double percent) {
        this.discount = percent;
    }
    //Tính tổng tiền
    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotal();
        }
        total = total - (total * discount / 100);
        return total;
    }
    //Cập nhật trạng thái
    public void updateStatus(String status) {
        this.status = status;
    }
    //Hiển thị đơn hàng
    public void displayOrder() {
        System.out.println("Order ID: " + id);
        System.out.println("Status: " + status);
        for (OrderItem item : items) {
            System.out.println(
                    item.getItemName() + " x" + item.getQuantity()
            );
        }
        System.out.println("Total: " + calculateTotal());
    }
    public String getId() {
        return id;
    }
}