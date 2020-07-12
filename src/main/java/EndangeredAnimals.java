import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimals extends Animals {

  /*  public static final String ILL="Ill";
    public static final String HEALTHY="Healthy";
    public static final String OKAY="Okay";
    public static final String NEW_BORN= "newborn";
    public static final String YOUNG= "young";
    public static final String ADULT = "adult";*/
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


    public void save(String animalName,String location,String age,String health){
        try(Connection con =DB.sql2o.open()) {
            String sql = "INSERT INTO endangered (animalname,location,age,health) VALUES (:animalname,:location,:age,:health)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("animalname",this.animalname)
                    .addParameter("location",this.location)
                    .addParameter("age",this.age)
                    .addParameter("health",this.health)
                    .executeUpdate().getKey();

        }

    }

    public static List<EndangeredAnimals> getAllEndangered(){
        String sql= "SELECT * FROM endangered";
        try(Connection con =DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(EndangeredAnimals.class);
        }

    }




}
