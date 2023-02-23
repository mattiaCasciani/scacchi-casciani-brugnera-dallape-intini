package Server;

import Messages.Message;
import chess_game.Pieces.Team;

public class ClientPairingThread extends Thread {

  SClient client;
  
  public ClientPairingThread(SClient client) {
        this.client = client;
  }
  
  public void run() {}
  
}
