import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB{

    //public static Sql2o sql2o =new Sql2o("jdbc:postgresql://localhost:5432/wildlifetracker", "tonui", "chepkemoi1999.");
    public  static  Sql2o sql2o = new Sql2o("postgresql://hzvvthfcsmalzf:289ea6330a6ea403eb1523e0009c506f4cf5f2ff0cfaf5982df291feb3e9cb25@ec2-54-234-44-238.compute-1.amazonaws.com:5432/ddqa0cs8bsqd5b","hzvvthfcsmalzf","289ea6330a6ea403eb1523e0009c506f4cf5f2ff0cfaf5982df291feb3e9cb25");

}
