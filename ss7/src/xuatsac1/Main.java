package xuatsac1;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static List<Product> products = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {

        OrderRepository repo = new FileOrderRepository();
        NotificationService notify = new EmailNotification();

        OrderService service = new OrderService(repo, notify);

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem đơn hàng");
            System.out.println("5. Tính doanh thu");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Mã: ");
                    String id = sc.nextLine();

                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    System.out.print("Giá: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    products.add(new Product(id, name, price, "General"));

                    System.out.println("Đã thêm sản phẩm " + id);
                    break;

                case 2:
                    System.out.print("Tên: ");
                    String cname = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    customers.add(new Customer(cname, email, phone));

                    System.out.println("Đã thêm khách hàng");
                    break;

                case 3:

                    Customer c = customers.get(0);
                    Product p = products.get(0);

                    Order order = new Order("ORD001", c);
                    order.addItem(p, 1);

                    double total = order.calculateTotal();

                    DiscountStrategy discount = new PercentageDiscount(10);
                    double finalAmount = discount.apply(total);

                    InvoiceGenerator invoice = new InvoiceGenerator();
                    invoice.printInvoice(order, finalAmount);

                    service.createOrder(order, finalAmount);

                    break;

                case 4:

                    for (Order o : service.getOrders()) {
                        System.out.println(o.id + " - " + o.customer.name +
                                " - " + (int)o.total);
                    }

                    break;

                case 5:

                    double revenue = 0;

                    for (Order o : service.getOrders()) {
                        revenue += o.total;
                    }

                    System.out.println("Tổng doanh thu: " + (int)revenue);

                    break;

                case 0:
                    return;
            }
        }
    }
}