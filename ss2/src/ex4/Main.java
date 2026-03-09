package ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Vu"));
        users.add(new User("Nam"));
        users.add(new User("Vuong"));

        Function<User,String> getName = User::getUsername;

        Consumer<String> print = System.out::println;

        Supplier<User> creatUser = User::new;

        for (User u :users){
            print.accept(getName.apply(u));
        }
        User newUser = creatUser.get();
        print.accept(newUser.getUsername());

    }
}
