package cz.mendelu.pjj.poskvorkty;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;

public class Server extends Thread{
    private final Piskvorky piskvorky;


    public Server(Piskvorky piskvorky) {
        this.piskvorky = piskvorky;
    }

    @Override
    public void run() {

        try {
            var gson = new Gson();

            var ss = new ServerSocket(4000);
            System.out.println("Start listen on port 4000.");
            while(!isInterrupted()){
                var client = ss.accept();
                try(var w = new OutputStreamWriter(client.getOutputStream());
                    var r = new InputStreamReader(client.getInputStream())){

                    w.write(gson.toJson(piskvorky));
                    w.flush();
                }

            }
        }catch (IOException e ){
            e.printStackTrace();
        }

    }
}
