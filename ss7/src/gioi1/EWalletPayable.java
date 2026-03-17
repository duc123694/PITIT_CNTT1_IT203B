package gioi1;

interface EWalletPayable extends PaymentMethod {
    void processEWallet(double amount);
}