package gioi1;

class MomoPayment implements EWalletPayable {

    @Override
    public void processEWallet(double amount) {
        System.out.println("Xử lý thanh toán MoMo: " + (int)amount + " - Thành công");
    }
}
