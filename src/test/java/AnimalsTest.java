import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void Animals_InstantiatesAnimalsCorrecttly_true() {
        Animals animal = new Animals("Monkey");
        assertTrue(animal instanceof Animals);
    }

    @Test
    public void getName_InstantiatesWithNameCorrectly() {
        Animals animal = new Animals("Monkey");
        assertEquals("Monkey",animal.getName());
    }
    @Test
    public void equals_returnsTrueIfNamesAreSame_true() {
        Animals animal = new Animals("Monkey");
        Animals animal1 = new Animals("Monkey");
        assertTrue(animal.equals(animal1));
    }
    @Test
    public void save_savesAnimalToDatabase() {
        Animals animal = new Animals("Monkey");
        animal.save();
        assertEquals(animal,Animals.getAllAnimals().get(0));
    }

    @Test
    public void getAllAnimals_GetsAllAnimalsFromDatabase() {
        Animals animal= new Animals("Monkey");
        animal.save();
        Animals animal2 = new Animals("Parrot");
        animal2.save();
        assertTrue(Animals.getAllAnimals().get(0).equals(animal));
        assertTrue(Animals.getAllAnimals().get(1).equals(animal2));
    }

}