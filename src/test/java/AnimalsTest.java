import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class AnimalsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Animals_InstantiatesAnimalsCorrecttly_true() {
        Animals animal = new Animals("Monkey", "Zone A");
        assertTrue(animal instanceof Animals);
    }

    @Test
    public void getName_InstantiatesWithNameCorrectly() {
        Animals animal = new Animals("Monkey", "Zone A");
        assertEquals("Monkey", animal.getAnimalname());
    }

    @Test
    public void getLocation_InstantiatesWithLocationCorrectly() {
        Animals animal = new Animals("Monkey", "Zone A");
        assertEquals("Zone A", animal.getLocation());
    }

    @Test
    public void equals_returnsTrueIfNamesAreSame_true() {
        Animals animal = new Animals("Monkey", "Zone A");
        Animals animal1 = new Animals("Monkey", "Zone A");
        assertTrue(animal.equals(animal1));
    }

    @Test
    public void save_savesAnimalToDatabase() {
        Animals animal = new Animals("Monkey", "Zone A");
        animal.save("Monkey", "Zone A");
        assertEquals(animal, Animals.getAllAnimals().get(0));
    }

    @Test
    public void getAllAnimals_GetsAllAnimalsFromDatabase() {
        Animals animal = new Animals("Monkey", "Zone A");
        animal.save("Monkey", "Zone A");
        Animals animal2 = new Animals("Parrot", "Zone A");
        animal2.save("Monkey", "Zone A");
        assertTrue(Animals.getAllAnimals().get(0).equals(animal));
        assertTrue(Animals.getAllAnimals().get(1).equals(animal2));
    }

    @Test
    public void delete_deletesAnima_true() {
        Animals animal = new Animals("Monkey", "Zone A");
        animal.save("Monkey", "Zone A");
        animal.delete(animal.getId());
        assertEquals(0, Animals.getAllAnimals().size());
    }

    @Test
    public void save_recordsTimeOfRecordInDatabase() {
        Animals animal = new Animals("Monkey", "Zone A");
        animal.save("Monkey", "Zone A");
        Timestamp savedSight = Animals.find(animal.getId()).getSightingtime();
        Timestamp rightNow = new Timestamp(new Date().getTime());
        assertEquals(rightNow.getDay(), savedSight.getDay());
    }

    @Test
    public void find_returnsCorrectAnimal_true() {
        Animals animal = new Animals("Monkey", "Zone A");
        animal.save("Monkey", "Zone A");
        Animals found =Animals.find(animal.getId());
        assertEquals(animal,found);
    }
}