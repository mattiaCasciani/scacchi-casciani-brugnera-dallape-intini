package chess_game.gui;

import ClientSide.Client;
import Messages.Message;
import chess_game.Boards.Board;

import chess_game.Pieces.Team;
import chess_game.Resources.GUI_Configurations;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Table {

    private JFrame gameFrame;
    private BoardPanel boardPanel;
    private Board chessBoard;
    private MainMenu mainMenu;
    private InGameBottomMenu bottomGameMenu;
    private Client client;

    public Table() {
        this.gameFrame = new JFrame("Chess");
        this.gameFrame.setLayout(new BorderLayout());
        this.gameFrame.setSize(GUI_Configurations.OUTER_FRAME_DIMENSION);
        this.mainMenu = new MainMenu();
        this.client = new Client(this);
        this.client.Connect("127.0.0.1", 4000);
        if (this.client.socket == null) {
            JOptionPane.showMessageDialog(null, "Impossibile collegarsi al server");
            System.exit(0);
        }
        createMainMenu();
        this.gameFrame.setVisible(true);
    }
    
    public void createMainMenu(){
        this.mainMenu.getInfoLBL().setText("");
        this.mainMenu.getInfoLBL().setVisible(false);
        this.mainMenu.getPlayBTN().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (client.isPaired == false) {
                    mainMenu.getInfoLBL().setVisible(true);
                    mainMenu.getInfoLBL().setText("Cerco Partita...");
                    mainMenu.getPlayBTN().setEnabled(false);
                    Message msg = new Message(Message.MessageTypes.PAIRING);
                    msg.content = "ESLESME";
                    client.Send(msg);
                }
                if (client.isPaired == true) {
                    mainMenu.getInfoLBL().setText("Partita Trovata");
                    mainMenu.getInfoLBL().setText("Partita sta iniziando...");
                    mainMenu.getPlayBTN().setEnabled(true);
                    mainMenu.getInfoLBL().setText("");
                    mainMenu.getInfoLBL().setVisible(false);
                    createGamePanel();
                }

            }
        });
        this.gameFrame.add(mainMenu, BorderLayout.CENTER);
    }
}
