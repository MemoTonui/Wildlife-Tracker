import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        // home page
        get("/",((request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        }),new HandlebarsTemplateEngine());

        //display all rangers
        get("/rangers",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            List<Rangers> rangers =Rangers.getAllRangers() ;
            model.put("rangers",rangers);
            return  new ModelAndView(model,"rangers.hbs");
        },new HandlebarsTemplateEngine());

        //route to filling the form
        get("/form",((request, response) -> {
            Map<String,Object> model = new HashMap<>();
            List<Rangers> rangers =Rangers.getAllRangers() ;
            model.put("rangers",rangers);
            return  new ModelAndView(model,"form.hbs");
        }),new HandlebarsTemplateEngine());

        post("",(request, response) -> {
            Map<String,Object> model = new HashMap<>();


            return new ModelAndView(model,"");
        },new HandlebarsTemplateEngine());

    }
}
