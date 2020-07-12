import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimals extends Animals {
    private String age;
    private String health;


    public EndangeredAnimals(String animalname,String location,String age,String health) {
        super(animalname,location);
       /* if (animalName == ""||age==""||health==""){
            throw new UnsupportedOperationException("Please Fill in all Blanks");
        }
        else {*/
            this.animalname = animalname;
            this.location = location;
            this.age = age;
            this.health = health;

    }


    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }


    public void save(String animalname,String location,String age,String health){
        try(Connection con =DB.sql2o.open()) {
            String sql = "INSERT INTO endangered (animalname,location,age,health,sightingtime) VALUES (:animalname,:location,:age,:health,now())";
            if (age ==""||animalname==""||location==""||health==""){
                throw new UnsupportedOperationException("Please Fill in all blanks");
            }
            else {
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("animalname",this.animalname)
                    .addParameter("location",this.location)
                    .addParameter("age",this.age)
                    .addParameter("health",this.health)
                    .executeUpdate().getKey();
            }
        }

    }

    public static List<EndangeredAnimals> getAllEndangered(){
        String sql= "SELECT * FROM endangered";
        try(Connection con =DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(EndangeredAnimals.class);
        }

    }

    public static EndangeredAnimals find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM endangered where id=:id";
            EndangeredAnimals endangeredAnimals = con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(EndangeredAnimals.class);
            return endangeredAnimals;
        }
    }

    public void delete(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM endangered WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }




}
