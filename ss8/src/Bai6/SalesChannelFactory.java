package Bai6;

public interface SalesChannelFactory {
    Discount createDiscount();
    Payment createPayment();
    Notify createNotify();
}