package Pieces;

import Game.BasicClasses.Pair;
import Game.BasicClasses.Position;


import java.util.ArrayList;
import java.util.List;
import Game.*;

public class Bishop extends Piece{
    public Bishop(Position position, boolean white){
        super(position,white);
        this.pieceFileName= "pieces/bishop.txt";
    }

    @Override
    public List<Pair<Position,Piece>> canMove(BoardInterface game){
        return PieceMovement.getMovement(game,this);
    }

    @Override
    public void move(Position position){
        super.move(position);
    }


}
