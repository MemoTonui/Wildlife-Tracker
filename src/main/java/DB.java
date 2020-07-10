import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB{

    public static Sql2o sql2o =new Sql2o("jdbc:postgresql://localhost:5432/wildlifetracker", "tonui", "chepkemoi1999.");

}
