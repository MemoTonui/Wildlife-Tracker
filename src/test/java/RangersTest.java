import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangersTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

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
    @Test
    public void equals_returnsTrueIfNameAndEmailAreSame_true() {
        Rangers ranger = new Rangers("Linda","linda@linda.com");
        Rangers ranger2 = new Rangers("Linda","linda@linda.com");
        assertTrue(ranger.equals(ranger2));
    }

    @Test
    public void save_InsertsRangerIntoDatabase_true() {
        Rangers ranger = new Rangers("Linda","linda@linda.com");
        ranger.save();
        assertTrue(Rangers.getALlRangers.get(0).equals(ranger));
    }
}