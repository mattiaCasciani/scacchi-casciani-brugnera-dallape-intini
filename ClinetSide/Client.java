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
}
