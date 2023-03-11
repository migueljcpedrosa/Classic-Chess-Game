package Game.TestClasses;

import Game.BoardInterface;
import Game.BasicClasses.Position;
import Pieces.Piece;

import java.util.List;

public class TestBoard implements BoardInterface {
    public TestBoard(){
        pieces.clear();
    }
    public boolean inPos(Position pos){
        for (int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).getPosition().equals(pos)) return true;
        }
        return false;
    }

    public Piece getInPos(Position pos){
        for (int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).getPosition().equals(pos)) return pieces.get(i);
        }
        return null;
    }




    //alterações X

    public void setPieces(List<Piece> list){
        for(Piece piece : list){
            pieces.add(piece);
        }
    }
}
