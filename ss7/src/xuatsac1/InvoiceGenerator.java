package xuatsac1;

public class InvoiceGenerator {

    public void printInvoice(Order order, double finalAmount) {

        System.out.println("=== HÓA ĐƠN ===");
        System.out.println("Khách: " + order.customer.name);

        for (OrderItem i : order.items) {
            System.out.println(i.product.name + " - SL: " + i.quantity +
                    " - Đơn giá: " + (int)i.product.price +
                    " - Thành tiền: " + (int)i.getTotal());
        }

        System.out.println("Tổng tiền: " + (int)order.total);
        System.out.println("Cần thanh toán: " + (int)finalAmount);
    }
}
