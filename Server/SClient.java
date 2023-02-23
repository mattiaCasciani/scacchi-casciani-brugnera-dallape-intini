package Server;

import Messages.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SClient {

    public Socket socket;
    public ObjectInputStream cInput;
    public ObjectOutputStream cOutput;
    public ClientListenThread clientListenThread;
    public SClient pair;
    public boolean isPaired;
    public boolean isWantToPair = false;
    public ClientPairingThread pairingThread;
  
  public SClient(Socket socket) {}

}
