package Pieces;

import Game.*;
import Game.BasicClasses.Pair;
import Game.BasicClasses.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    private boolean moved = false, movedTwice = false;
    public Pawn(Position position, boolean white){
        super(position,white);
        this.pieceFileName= "pieces/pawn.txt";
    }

    
    @Override
    public List<Pair<Position,Piece>> canMove(BoardInterface game){
        List<Pair<Position,Piece>> out = new ArrayList<Pair<Position,Piece>>();
        int move = 1;
        if(white) move = -1;

        if(!game.inPos(this.position.move(0,move))){
            out.add(new Pair(this.position.move(0,move),null));
            if(!moved && game.getInPos(this.position.move(0,2*move))==null){
                out.add(new Pair(this.position.move(0,2*move),null));
            }
        }

        if(game.getInPos(this.position.move(-1,move)) != null && game.getInPos(this.position.move(-1,move)).white != this.white){
            out.add(new Pair(this.position.move(-1,move),game.getInPos(this.position.move(-1,move))));
        }
        if(game.getInPos(this.position.move(1,move)) != null && game.getInPos(this.position.move(1,move)).white != this.white){
            out.add(new Pair(this.position.move(1,move),game.getInPos(this.position.move(1,move))));
        }

        //en passant
        if(game.getInPos(this.position.move(1,0)) != null && game.getInPos(this.position.move(1,0)).white != this.white && game.getInPos(this.position.move(1,0)) instanceof Pawn){
            Pawn pawn = (Pawn) game.getInPos(this.position.move(1,0));
            if(pawn.movedTwice){
                out.add(new Pair(this.position.move(1,move),pawn));
            }
        }
        if(game.getInPos(this.position.move(-1,0)) != null && game.getInPos(this.position.move(-1,0)).white != this.white && game.getInPos(this.position.move(-1,0)) instanceof Pawn){
            Pawn pawn = (Pawn) game.getInPos(this.position.move(-1,0));
            if(pawn.movedTwice){
                out.add(new Pair(this.position.move(-1,move),pawn));
            }
        }

        return(out);
    }
    

    
    @Override
    public void move(Position position){
        if(position.getY()-this.position.getY()==2 || position.getY()-this.position.getY()==-2) movedTwice = true; //en croissant
        this.moved = true;
        super.move(position);
    }

    public void removeMovedTwice(){
        //EN PASSANT
        movedTwice = false;
    }


    public boolean getMovedTwice(){
        return movedTwice;
    }
}
