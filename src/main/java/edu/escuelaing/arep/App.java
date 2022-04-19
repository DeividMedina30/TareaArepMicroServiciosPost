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

        post("/postT", (req, res) -> {
            String commentString = req.body();
            System.out.println("entro a postear");
            res.type("application/json");
            return apir.enviarpost(commentString);
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 34000; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}

