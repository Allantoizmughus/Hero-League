import models.Hero;
import models.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //get:display homepage
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/home.hbs" );
            return new ModelAndView(model, "home.hbs");
        }, new HandlebarsTemplateEngine());

        //get:display hero form
        get("/hero-form", (request, response)->{
            Map<String, Object> model=new HashMap<>();
            //model.put("template", "templates/hero-form.hbs");
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());


        //post:process hero page
        get("/hero",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            List<Hero> hero = Hero.getAll();
            model.put("hero",hero);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());


//         //new hero
//        get("/hero",(request,response)->{
//            Map<String, Object> model=new HashMap<>();
//            String name=request.queryParams("name");
//            int age=Integer.parseInt(request.queryParams("age"));
//            String power=request.queryParams("power");
//            String weakness=request.queryParams("weakness");
//            String yourTeam=request.queryParams("yourTeam");
//            model.put("name",name);
//            model.put("age",age);
//            model.put("power",power);
//            model.put("weakness",weakness);
//            model.put("yourTeam",yourTeam);
//            model.put("template","templates/hero.hbs");
//            return new ModelAndView(model, "hero.hbs");
//
//        },new HandlebarsTemplateEngine());

        //get:display team form

        get("/team-form", (request, response)->{
            Map<String, Object> model=new HashMap<>();
            return new ModelAndView(model, "team-form.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
