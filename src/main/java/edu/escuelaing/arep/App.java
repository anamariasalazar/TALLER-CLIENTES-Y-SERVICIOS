package edu.escuelaing.arep;

import edu.escuelaing.arep.HttpServer;

import java.io.IOException;

public class App {
    public static void main(String[] args){
        HttpServer httpServer = new HttpServer();
        try {
            httpServer.start(args);

        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
