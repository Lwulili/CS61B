import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertFalse(offByOne.equalChars('a', 'a'));
        System.out.println("first test passed");
        assertTrue(offByOne.equalChars('a', 'b'));
        System.out.println("second test passed");
        System.out.println("no test failed");
    }
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
}
