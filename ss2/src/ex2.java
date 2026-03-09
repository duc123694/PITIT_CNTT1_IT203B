interface PasswordValidate{
    boolean validate(String password);
}
public class ex2 {
    static void main(String[] args) {
        PasswordValidate validate = password -> password.length() >= 8;
        System.out.println(validate.validate("12345678"));
        System.out.println(validate.validate("1234"));
    }
}
