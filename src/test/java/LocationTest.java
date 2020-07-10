import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    @Test
    public void Location_InstantiatesLocationCorrextly_true() {
        Location loc = new Location("Zone A");
        assertTrue(loc instanceof Location);
    }

    @Test
    public void getName_InstantiatesWithLocationName() {
        Location loc = new Location("Zone A");
        assertEquals("Zone A",loc.getName());
    }

}