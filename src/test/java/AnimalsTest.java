import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void Animals_InstantiatesAnimalsCorrecttly_true() {
        Animals animal = new Animals("Monkey",1);
        assertTrue(animal instanceof Animals);
    }

    @Test
    public void getName_InstantiatesWithNameCorrectly() {
        Animals animal = new Animals("Monkey",1);
        assertEquals("Monkey",animal.getName());
    }
    @Test
    public void equals_returnsTrueIfNamesAreSame_true() {
        Animals animal = new Animals("Monkey",1);
        Animals animal1 = new Animals("Monkey",1);
        assertTrue(animal.equals(animal1));
    }
    @Test
    public void save_savesAnimalToDatabase() {
        Animals animal = new Animals("Monkey",1);
        animal.save();
        assertEquals(animal,Animals.getAllAnimals().get(0));
    }

    @Test
    public void getAllAnimals_GetsAllAnimalsFromDatabase() {
        Animals animal= new Animals("Monkey",1);
        animal.save();
        Animals animal2 = new Animals("Parrot",1);
        animal2.save();
        assertTrue(Animals.getAllAnimals().get(0).equals(animal));
        assertTrue(Animals.getAllAnimals().get(1).equals(animal2));
    }
    @Test
    public  void getId_InstantiatesWithRangerId_Int(){
        Animals animal = new Animals("Owl", 1);
        animal.save();
        assertEquals(1,animal.getRangerId());
    }

}