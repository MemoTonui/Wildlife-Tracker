import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
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
            String animalname = request.queryParams("animalname");
            String location = request.queryParams("location");
            String age= request.queryParams("age");
            String health = request.queryParams("health");
           EndangeredAnimals endangered = new EndangeredAnimals(animalname,location,age,health);
            endangered.save(animalname,location,age,health);
            model.put("endangered",endangered);
            response.redirect("/endangered");
            return  null;
        },new HandlebarsTemplateEngine());

        get("/endangered",((request, response) -> {
            Map<String,Object> model = new HashMap<>();
            List<EndangeredAnimals> endangeredAnimals = EndangeredAnimals.getAllEndangered();
            model.put("endangered",endangeredAnimals);
            return  new ModelAndView(model,"endangered.hbs");
        }),new HandlebarsTemplateEngine());

        get("/animals/new",((request, response) -> {
            Map<String,Object> model = new HashMap<>();
            List<Rangers> rangers =Rangers.getAllRangers() ;
            model.put("rangers",rangers);
            return new ModelAndView(model,"form.hbs");
        }),new HandlebarsTemplateEngine());

        get("/endangered/new",((request, response) -> {
            Map<String,Object> model = new HashMap<>();
            List<Rangers> rangers =Rangers.getAllRangers() ;
            model.put("rangers",rangers);
            return new ModelAndView(model,"form.hbs");
        }),new HandlebarsTemplateEngine());

        get("/animals/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int animalToDelete = Integer.parseInt(req.params(":id"));
            Animals.find(animalToDelete).delete(animalToDelete);
            res.redirect("/animals");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/endangered/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int endangeredToDelete = Integer.parseInt(req.params(":id"));
            EndangeredAnimals.find(endangeredToDelete).delete(endangeredToDelete);
            res.redirect("/endangered");
            return null;
        }, new HandlebarsTemplateEngine());





    }
}
