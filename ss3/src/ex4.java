import java.util.*;
import java.util.stream.Collectors;

public class ex4 {

    record User(String username, String email, String status) {}

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@yahoo.com", "INACTIVE"),
                new User("alice", "alice2@gmail.com", "ACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE")
        );

        // Loại bỏ username trùng
        List<User> uniqueUsers = new ArrayList<>(
                users.stream()
                        .collect(Collectors.toMap(
                                User::username,      // key
                                user -> user,        // value
                                (u1, u2) -> u1       // nếu trùng giữ user đầu
                        ))
                        .values()
        );

        // In kết quả
        uniqueUsers.forEach(System.out::println);
    }
}