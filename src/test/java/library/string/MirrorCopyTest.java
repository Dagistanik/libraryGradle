package library.string;


import org.junit.Test;

import static com.library.string.MirrorCopy.mirror;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MirrorCopyTest {
    @Test
    public void mirrorTest(){
        assertEquals(mirror("abc"), "cba");
        assertNotEquals(mirror("abc"), "caa");
    }
}
