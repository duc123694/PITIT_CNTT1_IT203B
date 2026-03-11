import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ex2Test {
    ex2 validator = new ex2();
    @Test
    void testAgeNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.checkRegistrationAge(-1);
        });
    }

    @Test
    void testAgeUnder18() {
        assertFalse(validator.checkRegistrationAge(16));
    }

    @Test
    void testAgeBoundary18() {
        assertTrue(validator.checkRegistrationAge(18));
    }

    @Test
    void testAgeAbove18() {
        assertTrue(validator.checkRegistrationAge(25));
    }
}