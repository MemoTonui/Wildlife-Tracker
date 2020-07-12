import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        DB.sql2o.open();

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

        post("/animals",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            String animalname=request.queryParams("animalname");
            String location = request.queryParams("location");
            Animals animals = new Animals(animalname,location);
            animals.save(animalname,location);
            model.put("animals",animals);
            response.redirect("/animals");
            return  null;
        },new HandlebarsTemplateEngine());

        get("/animals",((request, response) -> {
            Map<String,Object> model = new HashMap<>();
            List<Animals> animals =Animals.getAllAnimals();
            model.put("animals",animals);
            return  new ModelAndView(model,"animals.hbs");
        }),new HandlebarsTemplateEngine());

        post("/endangered",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            String animalname=request.queryParams("animalname");
            String location = request.queryParams("location");
            String age= request.queryParams("age");
            String health = request.queryParams("health");
           EndangeredAnimals endangered = new EndangeredAnimals(animalname,location,age,health);
            endangered.save(animalname,location,age,health);
            response.redirect("/endangered");
            return  null;
        },new HandlebarsTemplateEngine());

        get("/endangered",((request, response) -> {
            Map<String,Object> model = new HashMap<>();
            List<EndangeredAnimals> endangeredAnimals = EndangeredAnimals.getAllEndangered();
            model.put("endangered",endangeredAnimals);
            return  new ModelAndView(model,"endangered.hbs");
        }),new HandlebarsTemplateEngine());



    }
}
