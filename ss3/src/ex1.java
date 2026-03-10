import java.util.List;

public class ex1 {
    record User(String username,String email,String status){}

    static void main(String[] args) {
        List<User> users = List.of(
                new User("nam","nam@gmail.com","active"),
                new User("long","long@gmail.com","active"),
                new User("hoàng","hoang@gmail.com","active")
        );
        users.forEach(user -> System.out.println(user.username() +"-"+ user.status()));
    }
}
