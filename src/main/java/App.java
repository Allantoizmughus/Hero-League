import models.Hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class App {


    public static void main(String[] args) {
        staticFileLocation("/public");
        Hero.setUpNewHero1();
        Hero.setUpNewHero2();

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

         //new hero
        get("new/hero",(request,response)->{
            Map<String, Object> model=new HashMap<>();
            String name=request.queryParams("name");
            Integer age=Integer.parseInt(request.queryParams("age"));
            String power=request.queryParams("power");
            String weakness=request.queryParams("weakness");
            Hero createHero=new Hero(name,age,power,weakness);
            request.session().attribute("item",name);
            model.put("item",request.session().attribute("item"));
            model.put("createHero",createHero);
            return new ModelAndView(model, "success.hbs");
        },new HandlebarsTemplateEngine());

        //find single hero
        get("/new/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfHero = Integer.parseInt(req.params(":id"));
            Hero foundHero = Hero.find(idOfHero);
            model.put("hero",foundHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get:display team form

        get("/team", (request, response)->{
            Map<String, Object> model=new HashMap<>();
            return new ModelAndView(model, "team-form.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
