package Pieces;

import Game.BasicClasses.Pair;

import java.util.ArrayList;
import java.util.List;
import Game.*;
import Game.BasicClasses.Position;

public class Horse extends Piece{
    public Horse(Position position, boolean white){
        super(position,white);
        this.pieceFileName= "pieces/horse.txt";
    }

    @Override
    public List<Pair<Position,Piece>> canMove(BoardInterface game){
        List<Pair<Position,Piece>> out = new ArrayList<Pair<Position,Piece>>();
        int x = this.position.getX(), y = this.position.getY();
        List<Pair<Position,Piece>> possiblePositions = new ArrayList<Pair<Position,Piece>>();

        possiblePositions.add(new Pair(new Position(x+1,y+2),game.getInPos(new Position(x+1,y+2))));
        possiblePositions.add(new Pair(new Position(x-1,y+2),game.getInPos(new Position(x-1,y+2))));
        possiblePositions.add(new Pair(new Position(x+1,y-2),game.getInPos(new Position(x+1,y-2))));
        possiblePositions.add(new Pair(new Position(x-1,y-2),game.getInPos(new Position(x-1,y-2))));

        possiblePositions.add(new Pair(new Position(x+2,y+1),game.getInPos(new Position(x+2,y+1))));
        possiblePositions.add(new Pair(new Position(x-2,y+1),game.getInPos(new Position(x-2,y+1))));
        possiblePositions.add(new Pair(new Position(x+2,y-1),game.getInPos(new Position(x+2,y-1))));
        possiblePositions.add(new Pair(new Position(x-2,y-1),game.getInPos(new Position(x-2,y-1))));

        for(int i = 0; i < 8; i++){
            Position temp = possiblePositions.get(i).first();
            if(temp.getX()<8 && temp.getX()>=0 && temp.getY()<8 && temp.getY()>=0 && (!game.inPos(temp) || game.getInPos(temp).white!=this.white)) out.add(new Pair(temp,game.getInPos(temp)));
        }
        //out.clear();
        return(out);
    }



    @Override
    public void move(Position position){
        super.move(position);
    }


}
