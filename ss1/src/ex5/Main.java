package ex5;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        try {
            user.setAge(-3);
            System.out.println("Tuổi: " + user.getAge());
        } catch (InvalidAgeException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}