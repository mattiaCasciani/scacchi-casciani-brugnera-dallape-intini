package chess_game.gui;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;


public class InGameBottomMenu extends javax.swing.JPanel {

    public DefaultListModel killedPiecesListModel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> killedPiecesLIST;
    private javax.swing.JLabel playersColorLBL;
    private javax.swing.JLabel turnLBL;
  
  
    public InGameBottomMenu() {
        initComponents();
        killedPiecesListModel = new DefaultListModel();
        killedPiecesLIST.setModel(killedPiecesListModel);
    }
    
    public JLabel getPlayersColorLBL() {
        return playersColorLBL;
    }

    public JList<String> getKilledPiecesLIST() {
        return killedPiecesLIST;
    }

    public void setKilledPiecesLIST(JList<String> killedPiecesLIST) {
        this.killedPiecesLIST = killedPiecesLIST;
    }

    public JLabel getTurnLBL() {
        return turnLBL;
    }

    public void setTurnLBL(JLabel turnLBL) {
        this.turnLBL = turnLBL;
    }
}
