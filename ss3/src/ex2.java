import java.util.List;

public class ex2 {
    record Users(String username, String email, String status) {}

    static void main(String[] args) {
        List<Users> users = List.of(
                new Users("alice", "alice@gmail.com", "ACTIVE"),
                new Users("bob", "bob@yahoo.com", "INACTIVE"),
                new Users("charlie", "charlie@gmail.com", "ACTIVE")
        );
        users.stream().filter(user ->  user.email().endsWith("@gmail.com")).map(Users::username).forEach(System.out::println);

    }
}
