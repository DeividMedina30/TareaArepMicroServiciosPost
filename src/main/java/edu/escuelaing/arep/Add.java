package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Add {

    String respu = "";

    public String enviarpost (String doublep){
        try {
            URL URLEs = new URL("http://localhost:7654"+"/Feed");
            HttpURLConnection conecionG = (HttpURLConnection) URLEs.openConnection();
            conecionG.setRequestMethod("POST");
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
        return respu;
    }

}
