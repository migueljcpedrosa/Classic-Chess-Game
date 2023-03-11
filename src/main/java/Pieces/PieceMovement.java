package Pieces;

import Game.BasicClasses.Pair;
import Game.BasicClasses.Position;
import Game.BoardInterface;

import java.util.ArrayList;
import java.util.List;

public class PieceMovement {
    public static List<Pair<Position,Piece>> addList(List<Pair<Position,Piece>> l1, List<Pair<Position,Piece>> l2){
        List<Pair<Position,Piece>> out = new ArrayList<Pair<Position,Piece>>(l1);
        for(int i = 0; i < l2.size(); i++){
            out.add(l2.get(i));
        }
        return out;
    }

    public static List<Pair<Position,Piece>> normalMovement(BoardInterface game, int x, int y, Piece piece){
        List<Pair<Position,Piece>> out = new ArrayList<Pair<Position,Piece>>();
        Position startPos = piece.getPosition();
        Position newPos = startPos.move(x,y);
        while(newPos.isValid() && !game.inPos(newPos)){
            out.add(new Pair(newPos,null));
            newPos = newPos.move(x,y);
        }
        if(newPos.isValid() && game.getInPos(newPos).white != piece.getWhite()) out.add(new Pair(newPos,game.getInPos(newPos)));
        return out;
    }
    public static List<Pair<Position,Piece>> getMovement(BoardInterface game, Rook rook){
        List<Pair<Position,Piece>> out = new ArrayList<Pair<Position,Piece>>(), temp = new ArrayList<Pair<Position,Piece>>();

        temp = PieceMovement.normalMovement(game,1,0,rook);
        out = PieceMovement.addList(out,temp);
        temp = PieceMovement.normalMovement(game,-1,0,rook);
        out = PieceMovement.addList(out,temp);
        temp = PieceMovement.normalMovement(game,0,1,rook);
        out = PieceMovement.addList(out,temp);
        temp = PieceMovement.normalMovement(game,0,-1,rook);
        out = PieceMovement.addList(out,temp);

        return out;
    }

    public static List<Pair<Position,Piece>> getMovement(BoardInterface game, Bishop bishop){
        List<Pair<Position,Piece>> out = new ArrayList<Pair<Position,Piece>>(), temp = new ArrayList<Pair<Position,Piece>>();

        temp = PieceMovement.normalMovement(game,1,1,bishop);
        out = PieceMovement.addList(out,temp);
        temp = PieceMovement.normalMovement(game,-1,1,bishop);
        out = PieceMovement.addList(out,temp);
        temp = PieceMovement.normalMovement(game,1,-1,bishop);
        out = PieceMovement.addList(out,temp);
        temp = PieceMovement.normalMovement(game,-1,-1,bishop);
        out = PieceMovement.addList(out,temp);

        return out;
    }
}
