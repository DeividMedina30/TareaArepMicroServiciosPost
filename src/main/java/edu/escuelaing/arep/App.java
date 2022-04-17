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
        port(getPort());
        get("/hello", (req, res) -> "Hello post");

        post("/post", (request, response) -> {
            System.out.println("entro a postear");
            response.type("application/json");
            return (request.queryParams("value"));
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}

