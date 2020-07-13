import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB{

    //public static Sql2o sql2o =new Sql2o("jdbc:postgresql://localhost:5432/wildlifetracker", "tonui", "chepkemoi1999.");
    public  static  Sql2o sql2o = new Sql2o("postgresql://fmxnigckrhbeli:4d4b52348b6097398409e2cf56a49840cc0c0fe502909404ab8668ff34bc5595@ec2-34-225-162-157.compute-1.amazonaws.com:5432/d1uscsdjn4eh6f","fmxnigckrhbeli","4d4b52348b6097398409e2cf56a49840cc0c0fe502909404ab8668ff34bc5595");

}
