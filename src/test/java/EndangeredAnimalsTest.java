import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalsTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void EndangeredAnimals_InstantiatesWithName() {
        EndangeredAnimals animal = new EndangeredAnimals("Owl", "Zone A","young","ill");
        assertEquals("Owl",animal.getAnimalname());
    }

    @Test
    public void EndangeredAnimals_InstantiatesWithAge() {
        EndangeredAnimals animal = new EndangeredAnimals("Owl", "Zone A","young","ill");
        assertEquals("young",animal.getAge());
    }
    @Test
    public void EndangeredAnimals_InstantiatesWithHealth() {
        EndangeredAnimals animal = new EndangeredAnimals("Owl", "Zone A","young","ill");
        assertEquals("ill",animal.getHealth());
    }
    @Test
    public void save_savesAnimalToDatabase() {
        EndangeredAnimals animalen = new EndangeredAnimals("Owl", "Zone A","young","ill");
        animalen.save("Monkey","Zone A","Young","healthy");
        assertEquals(animalen,EndangeredAnimals.getAllEndangered().get(0));
    }
    @Test
    public void delete_removesAnimalFromDatabase() {
        EndangeredAnimals animalen = new EndangeredAnimals("Owl", "Zone A","young","ill");
        animalen.save("Monkey","Zone A","Young","healthy");
        animalen.delete(animalen.getId());
        assertEquals(0, EndangeredAnimals.getAllEndangered().size());
    }
    @Test
    public void find_returnsCorrectAnimal_true() {
        EndangeredAnimals animalen = new EndangeredAnimals("Owl", "Zone A","young","ill");
        animalen.save("Monkey","Zone A","Young","healthy");
        EndangeredAnimals found = EndangeredAnimals.find(animalen.getId());
        assertEquals(animalen,found);
    }
}
