package Pieces;

import Game.BasicClasses.Pair;

import Game.*;
import Game.BasicClasses.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{
    private Rook rook;
    private Bishop bishop;
    public Queen(Position position, boolean white){
        super(position,white);
        this.bishop = new Bishop(this.position,this.white);
        this.rook = new Rook(this.position,this.white);
        this.pieceFileName = "pieces/queen.txt";
    }

    @Override
    public List<Pair<Position,Piece>> canMove(BoardInterface game){
        return PieceMovement.addList(this.bishop.canMove(game),this.rook.canMove(game));
    }

    @Override
    public void move(Position position){
        rook.move(position);
        bishop.move(position);
        super.move(position);
    }


}
