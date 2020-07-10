import org.junit.rules.ExternalResource;
import org.sql2o.*;

class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlifetracker_test", "", "");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteRangersQuery = "DELETE FROM rangers *;";
            con.createQuery(deleteRangersQuery).executeUpdate();
        }
    }

}