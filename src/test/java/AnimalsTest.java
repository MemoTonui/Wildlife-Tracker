import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void Animals_InstantiatesAnimalsCorrecttly_true() {
        Animals animal = new Animals("Monkey","Zone A");
        assertTrue(animal instanceof Animals);
    }

    @Test
    public void getName_InstantiatesWithNameCorrectly() {
        Animals animal = new Animals("Monkey","Zone A");
        assertEquals("Monkey",animal.getName());
    }
    @Test
    public void equals_returnsTrueIfNamesAreSame_true() {
        Animals animal = new Animals("Monkey","Zone A");
        Animals animal1 = new Animals("Monkey","Zone A");
        assertTrue(animal.equals(animal1));
    }
    @Test
    public void save_savesAnimalToDatabase() {
        Animals animal = new Animals("Monkey","Zone A");
        animal.save("Monkey","Zone A");
        assertEquals(animal,Animals.getAllAnimals().get(0));
    }

    @Test
    public void getAllAnimals_GetsAllAnimalsFromDatabase() {
        Animals animal= new Animals("Monkey","Zone A");
        animal.save("Monkey","Zone A");
        Animals animal2 = new Animals("Parrot","Zone A");
        animal2.save("Monkey","Zone A");
        assertTrue(Animals.getAllAnimals().get(0).equals(animal));
        assertTrue(Animals.getAllAnimals().get(1).equals(animal2));
    }

    @Test
    public void delete_deletesPerson_true() {
        Animals animal= new Animals("Monkey","Zone A");
        animal.save("Monkey","Zone A");
        animal.delete();
        assertEquals(0, Animals.getAllAnimals().size());
    }

}