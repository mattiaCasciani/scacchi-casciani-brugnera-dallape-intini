package ClientSide;

import Messages.Message;
import chess_game.Pieces.Team;
import chess_game.gui.MainMenu;
import chess_game.gui.Table;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client { 
    public Socket socket;
    public ObjectInputStream sInput;
    public ObjectOutputStream sOutput;
    private Team team = Team.NOCOLOR;
    public boolean isPaired = false;
    public String serverIP;
    public int serverPort;
    public ClientListenThread listenThread;
    public Table game;
    
     public Client(Table game) {
        this.game = game;
    }
    
    public void Connect(String serverIP, int port) {
        try {
            System.out.println("Connessione al server");
            this.serverIP = serverIP;
            this.serverPort = port;
            this.socket = new Socket(this.serverIP, this.serverPort);
            System.out.println("Connessione");
            sOutput = new ObjectOutputStream(this.socket.getOutputStream());
            sInput = new ObjectInputStream(this.socket.getInputStream());
            listenThread = new ClientListenThread(this);
            this.listenThread.start();
        } catch (IOException ex) {
            System.out.println("Non riesco a connettermi.");
        }
    }
    
    public void Stop() {
        if (this.socket != null) {

            try {
                this.socket.close();
                this.sOutput.flush();
                this.sOutput.close();
                this.sInput.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void Send(Object message) {
        
    }
    
}


