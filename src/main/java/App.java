import java.util.HashMap;
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

        //get:display team form


    }
}
