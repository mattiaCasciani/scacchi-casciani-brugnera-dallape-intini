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
    
    public void createGamePanel(){
        this.gameFrame.remove(mainMenu);
        this.chessBoard = new Board();
        this.boardPanel = new BoardPanel(this.chessBoard, this.client);
        this.bottomGameMenu = new InGameBottomMenu();

        if(this.client.getTeam().toString() == "black"){
            this.bottomGameMenu.getPlayersColorLBL().setText("Il tuo colore è il nero");
        }else{
            this.bottomGameMenu.getPlayersColorLBL().setText("Il tuo colore è il bianco");
        }


        if(this.client.getTeam() == Team.WHITE)
        {
            this.bottomGameMenu.getTurnLBL().setText("GIOCA!");
            this.bottomGameMenu.getTurnLBL().setForeground(Color.GREEN);
        }
        else
        {
            this.bottomGameMenu.getTurnLBL().setText("Turno dell'avversario");
            this.bottomGameMenu.getTurnLBL().setForeground(Color.RED);
        }    
        this.gameFrame.add(boardPanel);
        this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
        this.gameFrame.add(this.bottomGameMenu, BorderLayout.PAGE_END);

        this.gameFrame.setVisible(true);
    }
    
    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public InGameBottomMenu getBottomGameMenu() {
        return bottomGameMenu;
    }

    public void setBottomGameMenu(InGameBottomMenu bottomGameMenu) {
        this.bottomGameMenu = bottomGameMenu;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public JFrame getGameFrame() {
        return gameFrame;
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public void setBoardPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    public Board getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(Board chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void setGameFrame(JFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

}
