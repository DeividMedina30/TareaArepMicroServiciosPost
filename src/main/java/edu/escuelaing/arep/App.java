package edu.escuelaing.arep;


import com.google.gson.Gson;

import static spark.Spark.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Add apir = new Add();
        port(getPort());
        get("/hello", (req, res) -> "Hello post");

        get("/postT", (req, res) -> {
            String UserString = req.queryParams("user");
            String BodyString = req.queryParams("body");
            System.out.println("entro a postear");
            System.out.println(UserString);
            System.out.println(BodyString);
            res.type("application/json");
            return apir.enviarpost(UserString, BodyString);
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 34000; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}

