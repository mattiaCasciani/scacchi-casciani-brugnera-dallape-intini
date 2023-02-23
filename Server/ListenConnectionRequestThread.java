package Server;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListenConnectionRequestThread extends Thread {
  private Server server;
  
  public ListenConnectionRequestThread(Server server) {
        this.server = server;
    }
  
  public void run() {
        while (!this.server.socket.isClosed()) {
            try {
                Socket nSocket = this.server.socket.accept();
                SClient nClient = new SClient(nSocket);
                nClient.Listen();
                server.clients.add(nClient);
                
            } catch (IOException ex) {
                System.out.println("Errore.");
            }
        }
    }
}
