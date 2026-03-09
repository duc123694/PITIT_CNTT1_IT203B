package ex6;

public class Main {
    static void main(String[] args) {
        User user = new User("Duc");
        UserProcessor processor = UserUtils::convert;
        String resuit = processor.process(user);
        System.out.println(resuit);
    }

}
