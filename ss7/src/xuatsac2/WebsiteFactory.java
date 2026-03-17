package xuatsac2;

public class WebsiteFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount() {
        return new WebDiscount();
    }

    public PaymentMethod createPayment() {
        return new CreditCardPayment();
    }

    public NotificationService createNotification() {
        return new EmailNotification();
    }
}
