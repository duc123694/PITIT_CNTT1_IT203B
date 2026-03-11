import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Ex6Test {

    ex6 service = new ex6();

    // Test ngày sinh trong tương lai -> không cập nhật
    @Test
    void testBirthDateInFuture() {

        User existingUser = new User("user1@gmail.com");
        UserProfile newProfile = new UserProfile("new@gmail.com", LocalDate.now().plusDays(1));

        List<User> users = new ArrayList<>();
        users.add(existingUser);

        User result = service.updateProfile(existingUser, newProfile, users);

        assertNull(result);
    }

    // Test email bị trùng với user khác
    @Test
    void testDuplicateEmail() {

        User existingUser = new User("user1@gmail.com");
        User anotherUser = new User("user2@gmail.com");

        List<User> users = new ArrayList<>();
        users.add(existingUser);
        users.add(anotherUser);

        UserProfile newProfile = new UserProfile("user2@gmail.com", LocalDate.of(2000,1,1));

        User result = service.updateProfile(existingUser, newProfile, users);

        assertNull(result);
    }

    // Test cập nhật hợp lệ
    @Test
    void testUpdateSuccess() {

        User existingUser = new User("user1@gmail.com");

        List<User> users = new ArrayList<>();
        users.add(existingUser);

        UserProfile newProfile = new UserProfile("new@gmail.com", LocalDate.of(2000,1,1));

        User result = service.updateProfile(existingUser, newProfile, users);

        assertNotNull(result);
        assertEquals("new@gmail.com", result.getEmail());
        assertEquals(LocalDate.of(2000,1,1), result.getBirthDate());
    }
}