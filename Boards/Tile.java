package chess_game.Boards;

import chess_game.Pieces.Coordinate;
import chess_game.Pieces.Piece;


public class Tile implements java.io.Serializable{
    private Piece piece;
    private Coordinate coordinate;

    public Tile(Coordinate coordinate, Piece piece) {
        this.setPiece(piece);
        this.setCoordinate(coordinate);
    }
}
