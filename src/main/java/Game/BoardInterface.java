package Game;

import Game.BasicClasses.Position;
import Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public interface BoardInterface {
    public List<Piece> pieces = new ArrayList<Piece>();
    public boolean inPos(Position pos);
    public Piece getInPos(Position pos);
}
