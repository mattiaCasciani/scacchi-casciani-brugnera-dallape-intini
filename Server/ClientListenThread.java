package Server;

import Messages.Message;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientListenThread extends Thread {
  SClient client;
  
  public ClientListenThread(SClient client) {
        this.client = client;
    }
  
  public void run() {}
}
