package xuatsac2;

public class POSFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount() {
        return new PosDiscount();
    }

    public PaymentMethod createPayment() {
        return new CashPayment();
    }

    public NotificationService createNotification() {
        return new PrintNotification();
    }
}
