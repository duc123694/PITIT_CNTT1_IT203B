import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ex3Test {
    ex3 validator = new ex3();
    @Test
    void testEmailNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.processEmail(null);
        });
    }
    @Test
    void testEmailNoAt() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.processEmail("abcgmail.com");
        });
    }
    @Test
    void testEmailNoDomain() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.processEmail("abc@");
        });
    }
    @Test
    void testEmailValid() {
        assertEquals("abc@gmail.com", validator.processEmail("ABC@GMAIL.COM"));
    }
}