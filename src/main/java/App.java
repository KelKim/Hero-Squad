import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        ProcessBuilder process = new ProcessBuilder();
     Integer port;
     if (process.environment().get("PORT") != null) {
         port = Integer.parseInt(process.environment().get("PORT"));
     } else {
         port = 4567;
     }

    setPort(port);

        get( "/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        // get("/squads/new", (request, response) -> {
        //       Map<String, Object> model = new HashMap<String, Object>();
        //       model.put("template", "templates/squad_form.vtl");
        //       return new ModelAndView(model, layout);
        //     }, new VelocityTemplateEngine());

        post("/squads", (request, response) -> {
              Map<String, Object> model = new HashMap<String, Object>();
              String name = request.queryParams("squadName");
              String description = request.queryParams("description");
              Squad newSquad = new Squad(name, description);
              model.put("template", "templates/squad_success.vtl");
              return new ModelAndView(model, layout);
            }, new VelocityTemplateEngine());

        get("/squads", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("squads", Squad.all());
                model.put("template", "templates/squads.vtl");
                return new ModelAndView(model, layout);
              }, new VelocityTemplateEngine());

        get("/squad_form/new", (request, response) -> {
              Map<String, Object> model = new HashMap<String, Object>();
              model.put("template", "templates/squad_form.vtl");
              return new ModelAndView(model, layout);
            }, new VelocityTemplateEngine());


        get("/squad/:id", (request, response) -> {
                  Map<String, Object> model = new HashMap<String, Object>();
                  Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
                  model.put("squad", squad);
                  model.put("template", "templates/squad.vtl");
                  return new ModelAndView(model, layout);
                }, new VelocityTemplateEngine());

        get("squads/:id/form/new", (request, response) -> {
           Map<String, Object> model = new HashMap<String, Object>();
           Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
           model.put("squad", squad);
           model.put("template", "templates/form.vtl");
           return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());

        get("/heroes", (request,response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         model.put("heroes", Hero.all());
         model.put("template", "templates/heroes.vtl");
         return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());

        post("/heroes", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          String name = request.queryParams("name");
          int age = Integer.parseInt(request.queryParams("age"));
          String power = request.queryParams("power");
          String weakness = request.queryParams("weakness");
          Hero newHero = new Hero(name, age, power, weakness);
          model.put("template", "templates/success.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }
}