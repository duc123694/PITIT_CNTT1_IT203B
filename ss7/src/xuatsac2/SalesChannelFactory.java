package xuatsac2;

interface SalesChannelFactory {

    DiscountStrategy createDiscount();

    PaymentMethod createPayment();

    NotificationService createNotification();
}
