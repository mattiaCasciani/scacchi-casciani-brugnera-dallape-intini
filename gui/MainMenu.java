package chess_game.gui;

import javax.swing.JButton;
import javax.swing.JLabel;


public class MainMenu extends javax.swing.JPanel {
    private javax.swing.JButton exitBTN;
    private javax.swing.JLabel infoLBL;
    private javax.swing.JButton playBTN;
  
    public MainMenu() {
        initComponents();
    }
    
    public JButton getExitBTN() {
        return exitBTN;
    }

   
    public JLabel getInfoLBL() {
        return infoLBL;
    }

    public JButton getPlayBTN() {
        return playBTN;
    }
    
    private void playBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playBTNActionPerformed

    private void exitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBTNActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBTNActionPerformed
    
}
