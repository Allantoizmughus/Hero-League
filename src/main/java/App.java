import models.Hero;
import models.Team;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
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
        Hero.setUpNewHero1();
        Hero.setUpNewHero2();
        Team.setUpNewTeam1();
        Team.setUpNewTeam2();

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
            ArrayList<Hero> hero = Hero.getAllInstances();
            model.put("hero",hero);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

         //new hero-create hero
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

        //process and display heroes
        post("/new/hero",(request,response)->{
            Map<String, Object> model=new HashMap<>();
            String name=request.queryParams("teamName");
            Integer age=Integer.parseInt(request.queryParams("age"));
            String power=request.queryParams("power");
            String weakness=request.queryParams("weakness");
            Hero newHero=new Hero(name,age,power,weakness);
            request.session().attribute("item",name);
            model.put("item",request.session().attribute("item"));
            model.put("newHero",newHero);
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
        get("/team-form", (request, response)->{
            Map<String, Object> model=new HashMap<>();
            return new ModelAndView(model, "team-form.hbs");
        }, new HandlebarsTemplateEngine());

        //display teams/team page
        get("/team",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Team> teams = Team.getInstances();
            model.put("teams",teams);
            ArrayList<Hero> members = Hero.getAllInstances();
            model.put("heros",members);
            Team newTeam = Team.findById(1);
            model.put("allTeamMembers", newTeam.getHeros());
            return new ModelAndView(model, "team.hbs");
        }, new HandlebarsTemplateEngine());

        //create a team and display
        post("/team/new",(request,response)-> {
            Map<String, Object> model = new HashMap<>();
            String teamName = request.queryParams("name");
            Integer max_size = Integer.parseInt(request.queryParams("max_size"));
            String cause = request.queryParams("cause");
            Team newTeam = new Team(teamName,cause,max_size);
            request.session().attribute("item",teamName);
            model.put("item",request.session().attribute("item"));
            return new ModelAndView(model,"success2.hbs");
        }, new HandlebarsTemplateEngine());

        //get hero by id
        get("/new/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfHero = Integer.parseInt(req.params(":id"));
            Hero foundHero = Hero.find(idOfHero);
            model.put("hero",foundHero);
            return new ModelAndView(model, "herolist.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
