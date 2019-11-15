import models.Computer;
import models.Player;
import models.Rps;
import org.apache.log4j.BasicConfigurator;
import spark.ModelAndView;

import java.util.HashMap;

import static spark.Spark.*;

public class Main {
    public static Player game_play;
    public static Rps play;

    public static void main(String[] args) {
        BasicConfigurator.configure();
        staticFileLocation("/public");
        get("/hello", (req, res) ->
                "Hello World"
        );


        get("/", (req, res) -> {
            return new ModelAndView(new HashMap(), "templates/index.vtl");
        }, new VelocityTemplateEngine());


        post("/names", (req, res) ->{
            String name = req.queryParams("name");
            System.out.println(name);
            game_play = new Player(name);
            res.redirect("/display");
            return null;
        }
        );


        get("/display", (req, res) -> {
            HashMap game = new HashMap();
            game.put("game", game_play);
            System.out.println("****************************************************************");
            System.out.println(game);
            System.out.println(game.get("game"));
            System.out.println(game_play.name());
            System.out.println("****************************************************************");

            return new ModelAndView(game, "templates/display.vtl");
        }, new VelocityTemplateEngine());

        post("/'/play-choice", (req, res) ->{
                    HashMap game = new HashMap();
                    game.put("game", game_play);
            String choice = req.queryParams("choice");
            System.out.println(choice);
            play = new Rps(new Computer(), choice);
            return new ModelAndView(game, "templates/playchoice.vtl");
        }, new VelocityTemplateEngine());

        get("/end", (req, res) -> {
            HashMap game = new HashMap();
            game.put("game", game_play);

            return new ModelAndView(game, "templates/end.vtl");
        }, new VelocityTemplateEngine());



    }
}
