package gioi1;

class CreditCardPayment implements CardPayable {

    @Override
    public void processCard(double amount) {
        System.out.println("Xử lý thanh toán thẻ tín dụng: " + (int)amount + " - Thành công");
    }
}
