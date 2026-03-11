import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ex5Test {

    ex5 service = new ex5();

    // ADMIN có toàn quyền
    @Test
    void testAdminCanDoAll() {
        User admin = new User(Role.ADMIN);

        assertTrue(service.canPerformAction(admin, Action.DELETE_USER));
        assertTrue(service.canPerformAction(admin, Action.LOCK_USER));
        assertTrue(service.canPerformAction(admin, Action.VIEW_PROFILE));
    }

    // MODERATOR không được DELETE_USER
    @Test
    void testModeratorCannotDeleteUser() {
        User mod = new User(Role.MODERATOR);

        assertFalse(service.canPerformAction(mod, Action.DELETE_USER));
    }

    // MODERATOR được LOCK_USER
    @Test
    void testModeratorCanLockUser() {
        User mod = new User(Role.MODERATOR);

        assertTrue(service.canPerformAction(mod, Action.LOCK_USER));
    }

    // MODERATOR được VIEW_PROFILE
    @Test
    void testModeratorCanViewProfile() {
        User mod = new User(Role.MODERATOR);

        assertTrue(service.canPerformAction(mod, Action.VIEW_PROFILE));
    }

    // USER chỉ được VIEW_PROFILE
    @Test
    void testUserCanViewProfile() {
        User user = new User(Role.USER);

        assertTrue(service.canPerformAction(user, Action.VIEW_PROFILE));
    }

    // USER không được LOCK_USER
    @Test
    void testUserCannotLockUser() {
        User user = new User(Role.USER);

        assertFalse(service.canPerformAction(user, Action.LOCK_USER));
    }

    // USER không được DELETE_USER
    @Test
    void testUserCannotDeleteUser() {
        User user = new User(Role.USER);

        assertFalse(service.canPerformAction(user, Action.DELETE_USER));
    }
}