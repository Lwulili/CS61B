import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void testOffByN() {
        CharacterComparator cc = new OffByN(3);
        assertTrue(cc.equalChars('a', 'd'));
        System.out.println("first test passed");
        assertFalse(cc.equalChars('a', 'b'));
        System.out.println("second test passed");
        System.out.println("All tests passed");
    }
}
