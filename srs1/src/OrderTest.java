import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    // Test tạo đơn hàng
    @Test
    void testCreateOrder() {
        Order order = new Order("O01");
        assertNotNull(order);
    }
    // Test thêm món vào đơn
    @Test
    void testAddItem() {
        Order order = new Order("O01");
        order.addItem("Burger", 50000, 2);
        double total = order.calculateTotal();
        assertEquals(100000, total);
    }
    // Test tính tổng tiền nhiều món
    @Test
    void testCalculateTotal() {
        Order order = new Order("O01");
        order.addItem("Burger", 50000, 2);
        order.addItem("Coca", 10000, 1);
        double total = order.calculateTotal();
        assertEquals(110000, total);
    }
    // Test giảm giá
    @Test
    void testApplyDiscount() {
        Order order = new Order("O01");
        order.addItem("Burger", 50000, 2);
        order.applyDiscount(10);
        double total = order.calculateTotal();
        assertEquals(90000, total);
    }

}