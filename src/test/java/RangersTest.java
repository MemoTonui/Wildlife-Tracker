import org.junit.Test;

import static org.junit.Assert.*;

public class RangersTest {
    @Test
    public void Rangers_InstantiatesCorrectly_true() {
        Rangers ranger = new Rangers("Linda","linda@linda.com");
        assertTrue(ranger instanceof Rangers);
    }

    @Test
    public void Rangers_InstantiatesWithName_String() {
        Rangers ranger = new Rangers("Linda","linda@linda.com");
        assertEquals("Linda",ranger.getName());
    }

    @Test
    public void Rangers_InstantiatesWithEmail_String() {
        Rangers ranger = new Rangers("Linda","linda@linda.com");
        assertEquals("linda@linda.com",ranger.getEmail());
    }
}