import org.junit.rules.ExternalResource;
import org.sql2o.*;

class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlifetracker_test", "tonui", "chepkemoi1999.");
 /* DB.sql2o= new Sql2o("\n" +
          "postgresql://ckfonjjyjfzcej:60da36f2af3127359c301237886f769c65e2d9443ba84482c1bf7603ad3ac170@ec2-54-234-44-238.compute-1.amazonaws.com:5432/db2vs3787u0itd","ckfonjjyjfzcej","60da36f2af3127359c301237886f769c65e2d9443ba84482c1bf7603ad3ac170");
    }*/}

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteRangersQuery = "DELETE FROM rangers *;";
            con.createQuery(deleteRangersQuery).executeUpdate();
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
            String deleteEndangeredAnimalsQuery = "DELETE FROM endangered *;";
            con.createQuery(deleteEndangeredAnimalsQuery).executeUpdate();
        }
    }

}