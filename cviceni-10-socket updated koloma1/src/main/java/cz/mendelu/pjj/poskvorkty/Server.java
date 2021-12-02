package cz.mendelu.pjj.poskvorkty;

import cz.mendelu.pjj.poskvorkty.greenfoot.PiskvorkyWorld;

public class Server extends Thread {

    private PiskvorkyWorld piskvorkyWorld;

    public Server(PiskvorkyWorld piskvorkyWorld) {
        this.piskvorkyWorld = piskvorkyWorld;
    }

    @Override
    public void run() {
        /*
        try {
            var gson = new Gson();
            var ss = new ServerSocket(4000);
            System.out.println("Server run on port 4000");
            while (!isInterrupted()) {
                var cs = ss.accept();
                var barva = piskvorkyWorld.getPiskvorky().getAktualniBarva();
                System.out.println("New " + barva + " client accepted: " + cs);
                try ( var w = new OutputStreamWriter(cs.getOutputStream());
                      var r = new BufferedReader(new InputStreamReader(cs.getInputStream()))
                ) {

                    while(!isInterrupted()) {
                        w.write(gson.toJson(piskvorkyWorld.getPiskvorky()));
                        w.write(" > ");
                        w.flush();
                        // 1,2
                        var line = r.readLine().split(",", 2);
                        var x = Integer.parseInt(line[0]);
                        var y = Integer.parseInt(line[1]);
                        System.out.println("Make move: " + Arrays.toString(line));
                        piskvorkyWorld.provedTahAktualnimHracem(x, y);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
