package library.string;

import org.junit.Test;

import static com.library.string.Palindrome.palindrome;
import static org.junit.Assert.*;

public class PalindromeTest {

    @Test
    public void palindromeTest() {
//        assertTrue(palindrome("шалаш"));
        assertFalse(palindrome("ребенок"));
    }
}
