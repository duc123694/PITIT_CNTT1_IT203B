import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ex4Test {
    ex4 validator = new ex4();
    @Test
    void testPasswordNull() {
        assertEquals("Yếu", validator.evaluatePasswordStrength(null));
    }
    @Test
    void testPasswordTooShort() {
        assertEquals("Yếu", validator.evaluatePasswordStrength("Ab1@"));
    }
    @Test
    void testPasswordOnlyLower() {
        assertEquals("Yếu", validator.evaluatePasswordStrength("abcdefgh"));
    }
    @Test
    void testPasswordMedium() {
        assertEquals("Trung bình", validator.evaluatePasswordStrength("Abcdef12"));
    }
    @Test
    void testPasswordStrong() {
        assertEquals("Mạnh", validator.evaluatePasswordStrength("Abcd1234@"));
    }
}