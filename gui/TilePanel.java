package chess_game.gui;

import ClientSide.Client;
import Messages.Message;
import Messages.MovementMessage;
import chess_game.Boards.Board;
import chess_game.Boards.Tile;
import chess_game.Pieces.Coordinate;
import chess_game.Move.Move;
import chess_game.Pieces.PieceTypes;
import chess_game.Pieces.Team;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import chess_game.Resources.BOARD_Configurations;
import chess_game.Resources.GUI_Configurations;
import chess_game.Utilities.BoardUtilities;
import chess_game.Utilities.MoveUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 *
 */
//This class is the visual version of every Tile class in Board class
public class TilePanel extends JPanel {

    Coordinate coordinate;
    JLabel pieceIcon;

    public TilePanel(BoardPanel boardPanel, Coordinate coord, Board chessBoard, Client client) {
        super(new GridBagLayout());
        this.coordinate = coord;
        pieceIcon = new JLabel();
        this.add(pieceIcon);
        setPreferredSize(new Dimension(BOARD_Configurations.TILE_SIZE, BOARD_Configurations.TILE_SIZE));
        assignTileColor(chessBoard);
        assignTilePieceIcon(chessBoard);
    }
}
