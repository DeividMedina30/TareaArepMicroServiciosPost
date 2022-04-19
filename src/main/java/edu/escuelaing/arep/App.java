package edu.escuelaing.arep;


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
            System.out.println("entro a postear");
            res.type("application/json");
            return apir.enviarpost(req.queryParams("value"));
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 34000; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}

