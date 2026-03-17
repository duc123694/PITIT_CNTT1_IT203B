package gioi1;

interface CardPayable extends PaymentMethod {
    void processCard(double amount);
}