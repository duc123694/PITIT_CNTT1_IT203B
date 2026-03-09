@FunctionalInterface
interface Authenticatable {
    String getPassword();
    default boolean isAuthenticated() {
        return getPassword() != null && !getPassword().isEmpty();
    }
    static String encrypt(String rawPassword) {
        return "ENC_" + rawPassword;
    }
}

public class ex3 {
    public static void main(String[] args) {
        Authenticatable user = () -> "123456";
        System.out.println(user.isAuthenticated());
        System.out.println(Authenticatable.encrypt("123456"));
    }
}