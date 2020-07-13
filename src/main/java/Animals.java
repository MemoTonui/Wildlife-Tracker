import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;

public class Animals {

    public String animalname;
    public int id;
    public String location;
    private Timestamp sightingtime;

    public Animals(String animalname,String location) {
        this.animalname = animalname;
        this.location = location;
        this.sightingtime= sightingtime;

    }

    public String getLocation() {
        return location;
    }

    public Timestamp getSightingtime() {
        return sightingtime;
    }

    public String getAnimalname() {
        return animalname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object animal1){
        if (!(animal1 instanceof Animals)) {
            return false;
        } else {
           Animals newAnimal = (Animals) animal1;
            return this.getAnimalname().equals(newAnimal.getAnimalname()) ;
        }
    }

    public void save(String animalname,String location){
        if (location==""|| animalname==""){
            throw new UnsupportedOperationException("Please fill all blanks");
        }
        else {
        try(Connection con =DB.sql2o.open()) {
            String sql = "INSERT INTO animals (animalname,location,sightingtime) VALUES (:animalname,:location,now())";
            this.id = (int) con.createQuery(sql, true).addParameter("animalname", this.animalname).addParameter("location", this.location).executeUpdate().getKey();
        } catch ( NullPointerException ex){
            System.out.println("Null Pointer Caught");
        }
        }

    }
    public static List<Animals> getAllAnimals() {

        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals";
            return con.createQuery(sql).executeAndFetch(Animals.class);
        }


    }

    public void delete(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM animals WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

    public static Animals find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            Animals animals = con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Animals.class);
            return animals;
        }
    }

}
