package Pieces;

import Game.BasicClasses.Pair;

import java.util.ArrayList;
import java.util.List;
import Game.*;
import Game.BasicClasses.Position;

public class Rook extends Piece{
    public Rook(Position position, boolean white){
        super(position,white);
        this.pieceFileName= "pieces/rook.txt";
    }
    private boolean moved = false;

    @Override
    public List<Pair<Position,Piece>> canMove(BoardInterface game){
        return PieceMovement.getMovement(game,this);
    }

    @Override
    public void move(Position position){
        moved = true;
        super.move(position);
    }
}
