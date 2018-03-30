package firstTests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SimpleTest {

    @Test
    public void assertion() {
        assertEquals(1, 2);
    }
}
