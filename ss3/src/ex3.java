import java.util.List;
import java.util.Optional;

public class ex3 {
    record Users(String usename,String email,String status){}

    static class UserRepostory{
        List<Users> users = List.of(
                new ex3.Users("mai", "mai@gmail.com", "ACTIVE"),
                new ex3.Users("dan", "dan@yahoo.com", "INACTIVE"),
                new ex3.Users("lan", "lan@gmail.com", "ACTIVE")
        );
        Optional<Users> findUserByUsername(String username){
            return users.stream().filter(user -> user.usename().equals(username)).findFirst();
        }
    }

    static void main(String[] args) {
        UserRepostory repo = new UserRepostory();
        repo.findUserByUsername("dan").ifPresentOrElse(users -> System.out.println("Welcome "+users.usename()),
                () -> System.out.println("Guest login"));
    }
}
