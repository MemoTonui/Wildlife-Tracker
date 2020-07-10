import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalsTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void EndangeredAnimals_InstantiatesWithName() {
        EndangeredAnimals animal = new EndangeredAnimals("Owl", 1,"young","ill");
        assertEquals("Owl",animal.getName());
    }

    @Test
    public void EndangeredAnimals_InstantiatesWithRangerId() {
        EndangeredAnimals animal = new EndangeredAnimals("Owl", 1,"young","ill");
        assertEquals(1,animal.getRangerId());
    }

    @Test
    public void EndangeredAnimals_InstantiatesWithAge() {
        EndangeredAnimals animal = new EndangeredAnimals("Owl", 1,"young","ill");
        assertEquals("young",animal.getAge());
    }
    @Test
    public void EndangeredAnimals_InstantiatesWithHealth() {
        EndangeredAnimals animal = new EndangeredAnimals("Owl", 1,"young","ill");
        assertEquals("ill",animal.getHealth());
    }
}