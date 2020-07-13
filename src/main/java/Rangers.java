import org.sql2o.Sql2o;

import org.sql2o.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rangers {

    private  String email;
    private  String name;
    private int id;


    public Rangers(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    //Checks if two names and their email addresses are similar
    @Override
    public boolean equals(Object ranger2){
        if (!(ranger2 instanceof Rangers)) {
            return false;
        } else {
            Rangers newRanger = (Rangers) ranger2;
            return this.getName().equals(newRanger.getName()) &&
                    this.getEmail().equals(newRanger.getEmail());
        }
    }

    //Method For Saving into Database
    public  void  save(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO rangers(name, email) VALUES (:name,:email)";
            this.id= (int) con.createQuery(sql,true).addParameter("name",this.name).addParameter("email",this.email).executeUpdate().getKey();
        }
    }

    //Method For getting all rangers
    public static List<Rangers> getAllRangers() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM rangers";
            return con.createQuery(sql).executeAndFetch(Rangers.class);
        }


    }


}
