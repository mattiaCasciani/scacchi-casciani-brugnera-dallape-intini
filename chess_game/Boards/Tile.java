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
    
    public Piece getPiece() {return this.piece;}
    
    public void setPiece(Piece p){this.piece = p;}
    
    public Coordinate getCoordinate() {return this.coordinate;}
    
    public void setCoordinate(int x, int y){
        this.coordinate.setX(x);
        this.coordinate.setY(y);
    }
    
    public void setCoordinate(Coordinate coordinate){this.coordinate = coordinate;}

    public boolean hasPiece(){return this.piece != null;}

    @Override
    public String toString() {
        return coordinate.toString() + " Piece "+ ((hasPiece() ? piece.toString() : "Empty"));
    }
}
