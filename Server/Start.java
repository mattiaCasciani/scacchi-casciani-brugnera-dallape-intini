package Server;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Start {
  Server server = new Server(4000);
        server.ListenClientConnectionRequests();

        while (!server.socket.isClosed()) {

            try {
                System.out.println("Sto aspettando qui."+Server.clients.size()+" Giocatori Connessi.");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
