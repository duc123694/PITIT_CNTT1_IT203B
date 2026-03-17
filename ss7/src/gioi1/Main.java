package gioi1;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        // COD
        PaymentMethod cod = new CODPayment();
        processor.processPayment(cod, 500000);

        // Thẻ tín dụng
        PaymentMethod card = new CreditCardPayment();
        processor.processPayment(card, 1000000);

        // Ví MoMo
        PaymentMethod momo = new MomoPayment();
        processor.processPayment(momo, 750000);

        System.out.println("Kiểm tra LSP:");

        // Thay thế CreditCardPayment bằng MomoPayment
        PaymentMethod payment = new MomoPayment();
        processor.processPayment(payment, 750000);
    }
}
