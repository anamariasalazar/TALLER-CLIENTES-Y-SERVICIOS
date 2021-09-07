package edu.escuelaing.arep;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;

public class HttpServer {

    private static final HttpServer _instance = new HttpServer();
    public static HttpServer getInstance(){return _instance;}
    public HttpServer(){}
    public void start(String[] args) throws IOException{

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        boolean running=true;
        while (running) {
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            serverConnection(clientSocket);
        }
        serverSocket.close();
    }

    public void serverConnection(Socket clientSocket) throws IOException {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        ArrayList<String> request = new ArrayList<String>();
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            request.add(inputLine);
            if (!in.ready()) {
                break;
            }
        }
        String UrlStr="";
        if(request.size()>0) {
            UrlStr = request.get(0).split(" ")[1];
        }
        File Taller = new File("public_html/"+UrlStr);

        if((FilenameUtils.isExtension(UrlStr, "html")|| FilenameUtils.isExtension(UrlStr, "css") || FilenameUtils.isExtension(UrlStr, "js"))&& Taller.exists()) {
            outputLine = getResouce(UrlStr);
            out.println(outputLine);

        }else if (!FilenameUtils.getExtension(UrlStr).equals("")&& Taller.exists()){
            outimage(UrlStr,clientSocket.getOutputStream());

        }else {
            outputLine =errorResponse(UrlStr);
            System.out.println(outputLine);
            out.println(outputLine);
        }
        out.close();
        clientSocket.close();
        in.close();
    }

    public String errorResponse(String UrlStr) throws IOException {
        String output = "HTTP/1.1 200 OK\r\nContent - Type: text/html \r\n\r\n";
        output+="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <!-- Required meta tags -->\n" +
                "        <meta charset=\"utf-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "        <title>Services</title>\n" +
                "    </head>" +
                "    <body> " +
                "        <br> <b><big><FONT COLOR=\"black\" size=\"500\"> The requested URL "+UrlStr+" not found  on this server</FONT></big></b>\n" +
                "    </body> ";
        return output;
    }

    public String outimage(String UrlStr, OutputStream output) {
        File file = new File("public_html/"+UrlStr);
        String extension = FilenameUtils.getExtension(UrlStr);
        try {
            BufferedImage image = ImageIO.read(file);
            ByteArrayOutputStream ArrBytes = new ByteArrayOutputStream();
            DataOutputStream writeimg = new DataOutputStream(output);
            ImageIO.write(image, extension, ArrBytes);
            writeimg.writeBytes("HTTP/1.1 200 OK \r\n" + "Content-Type: image/"+extension+" \r\n" + "\r\n");
            writeimg.write(ArrBytes.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return extension;
    }

    public String getResouce(String resourceURL) throws IOException {
        String extension=resourceURL.split("/")[1];
        return RequestResponseDiscText(extension);
    }



    public String RequestResponseDiscText(String extension) throws IOException {

        String val = "public_html/"+extension;
        File archivo = new File(val);
        BufferedReader in = new BufferedReader(new FileReader(archivo));
        String output = "HTTP/1.1 200 OK\r\nContent - Type: text/"+FilenameUtils.getExtension(extension)+"\r\n\r\n", str,res;
        while ((str = in.readLine()) != null) {

            output+=str+"\n";
        }
        return  output;
    }


    public int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }

}
