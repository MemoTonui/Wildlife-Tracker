import org.sql2o.*;
import java.net.URI;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DB{
    private static URI dbUri;
    public static Sql2o sql2o;
     static Logger logger =  LoggerFactory.getLogger(DB.class);


    static {

        try {
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI("postgres://localhost:5432/wildlifetracker");
            } else {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            }
            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? null : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? null : dbUri.getUserInfo().split(":")[1];
            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
        } catch (URISyntaxException e ) {
            logger.error("Unable to connect to database.");
        }
    }

    //public static Sql2o sql2o =new Sql2o("jdbc:postgresql://localhost:5432/wildlifetracker", "tonui", "chepkemoi1999.");
   // public  static  Sql2o sql2o = new Sql2o("jdbc:postgresql://fmxnigckrhbeli:4d4b52348b6097398409e2cf56a49840cc0c0fe502909404ab8668ff34bc5595@ec2-34-225-162-157.compute-1.amazonaws.com:5432/d1uscsdjn4eh6f","fmxnigckrhbeli","4d4b52348b6097398409e2cf56a49840cc0c0fe502909404ab8668ff34bc5595");

}
