package chess_game.Boards;

import chess_game.Pieces.*;
import chess_game.Player.Player;
import chess_game.Resources.*;
import chess_game.Utilities.BoardUtilities;

public class Board implements java.io.Serializable{
    private final Tile[][] tiles;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;
    private Tile chosenTile = null;
    
    public Board() {
        whitePlayer = new Player(Team.WHITE);
        blackPlayer = new Player(Team.BLACK);
        currentPlayer = whitePlayer;
        tiles = BoardUtilities.createStandartBoardTiles();

    }
    
    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Tile getChosenTile() {
        return chosenTile;
    }
    
    public boolean hasChosenTile(){return false}
}
