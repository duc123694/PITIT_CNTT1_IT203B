package gioi2;

class EmailService implements NotificationService {

    @Override
    public void send(String message, String recipient) {
        System.out.println("Gửi email: " + message);
    }
}