import org.sql2o.Connection;

import java.util.List;

public class Animals {
    public   int rangerId;
    public String animalName;
    public int id;

    public Animals(String animalName,int rangerId) {
        this.animalName = animalName;
        this.rangerId =rangerId;
    }

    public int getRangerId() {
        return rangerId;
    }

    public String getName() {
        return animalName;
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

    public void save(){
        try(Connection con =DB.sql2o.open()) {
            String sql = "INSERT INTO animals (animalName) VALUES (:animalName)";
            this.id = (int) con.createQuery(sql,true).addParameter("animalName",this.animalName).executeUpdate().getKey();

        }

    }
    public static List<Animals> getAllAnimals(){
        String sql= "SELECT * FROM animals";
        try(Connection con =DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Animals.class);
        }

    }

}
