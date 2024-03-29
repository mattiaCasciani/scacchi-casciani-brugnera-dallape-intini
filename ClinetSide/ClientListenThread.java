package ClientSide;

import Messages.Message;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ClientSide.*;
import Messages.MovementMessage;
import chess_game.Boards.Board;
import chess_game.Move.Move;
import chess_game.Pieces.PieceTypes;
import chess_game.Pieces.Team;
import chess_game.Player.Player;
import java.awt.Color;
import javax.swing.JOptionPane;

public class ClientListenThread extends Thread {
    Client client;
    
    public ClientListenThread(Client client) {
        this.client = client;
    }
    
    public void run() {while (!this.client.socket.isClosed()) {

            try {

                Message msg = (Message) (this.client.sInput.readObject());
                switch (msg.type) {
                    case START:
                        Team serverChosenTeam = (Team) msg.content;
                        this.client.setTeam(serverChosenTeam);
                        break;
                    case PAIRING:
                        this.client.isPaired = true;
                        this.client.game.getMainMenu().getPlayBTN().setEnabled(true);
                        this.client.game.getMainMenu().getPlayBTN().setText("Start Game");
                        this.client.game.getMainMenu().getInfoLBL().setText("Matched. Click To Start Game");
                        break;
                    case MOVE:

                        MovementMessage movement = (MovementMessage) msg.content;
                        Board board = this.client.game.getChessBoard();
                        Player player = board.getCurrentPlayer();
                        Move move = new Move(board, board.getTile(movement.currentCoordinate), board.getTile(movement.destinationCoordinate));
                        player.makeMove(board, move);
                        this.client.game.getBoardPanel().updateBoardGUI(this.client.game.getChessBoard());
                        if (move.hasKilledPiece()) {
                            if (move.getKilledPiece().getType() == PieceTypes.KING) {
                                Team winnerTeam;
                                winnerTeam = (move.getKilledPiece().getTeam() == Team.BLACK) ? Team.WHITE : Team.BLACK;
                                JOptionPane.showMessageDialog(null, "Winner: " + winnerTeam.toString());
                                Message message = new Message(Message.MessageTypes.END);
                                message.content = null;
                                client.Send(message);
                                break;
                            }
                        }
                        board.changeCurrentPlayer();
                        this.client.game.getBottomGameMenu().getTurnLBL().setText("Your Turn");
                        this.client.game.getBottomGameMenu().getTurnLBL().setForeground(Color.GREEN);
                        break;
                    case CHECK:
                        Team checkStateTeam = (Team) msg.content;
                        JOptionPane.showMessageDialog(null, "Check state for team: " + checkStateTeam.toString());
                        break;

                    case LEAVE:
                        JOptionPane.showMessageDialog(null, "Enemy left. Returning to the Menu.");
                        this.client.game.getGameFrame().remove(this.client.game.getBoardPanel());
                        this.client.game.createMainMenu();
                }

            } catch (IOException ex) {
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                System.out.println("Girilen class bulunamadı");
            }
        }
    }
}
