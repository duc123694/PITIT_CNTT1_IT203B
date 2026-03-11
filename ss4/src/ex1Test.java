import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ex1Test{

    ex1 validator = new ex1();

    @Test
    void testUsernameNull() {
        assertFalse(validator.isValidUsername(null));
    }

    @Test
    void testUsernameTooShort() {
        assertFalse(validator.isValidUsername("abc"));
    }

    @Test
    void testUsernameTooLong() {
        assertFalse(validator.isValidUsername("abcdefghijklmnopqrstuv"));
    }

    @Test
    void testUsernameValid() {
        assertTrue(validator.isValidUsername("abc123"));
    }
}