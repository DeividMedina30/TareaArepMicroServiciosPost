package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Add {

    String respu = "";

    public String enviarpost (String usuario, String comentario){
        try {
            URL URLEs = new URL("http://localhost:7654"+"/Feed?"+"user="+usuario+"%body="+comentario);
            System.out.println(URLEs);
            HttpURLConnection conecionG = (HttpURLConnection) URLEs.openConnection();
            conecionG.setRequestMethod("GET");
            if (conecionG.getResponseCode() != 200) {
                throw new RuntimeException("Fallo");
            }
            InputStreamReader in = new InputStreamReader(conecionG.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                respu =  output;
            }

            conecionG.disconnect();

        } catch (Exception e) {
            System.out.println("Error al conectar");
        }
        System.out.println(respu);
        return respu;
    }

}
