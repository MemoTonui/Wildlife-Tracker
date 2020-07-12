import org.sql2o.Connection;

import java.util.List;

public class Animals {

    public String animalname;
    public int id;
    public String location;

    public Animals(String animalname,String location) {
        this.animalname = animalname;
        this.location = location;

    }

    public String getLocation() {
        return location;
    }

    public String getName() {
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
            return this.getName().equals(newAnimal.getName()) ;
        }
    }

    public void save(String animalName,String location){
        try(Connection con =DB.sql2o.open()) {
            String sql = "INSERT INTO animals (animalname,location) VALUES (:animalname,:location)";
            this.id = (int) con.createQuery(sql,true).addParameter("animalname",this.animalname).addParameter("location",this.location).executeUpdate().getKey();

        }

    }
    public static List<Animals> getAllAnimals(){
        String sql= "SELECT * FROM animals";
        try(Connection con =DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Animals.class);
        }

    }

    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM animals WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

}
