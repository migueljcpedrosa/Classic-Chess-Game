package Pieces;

import Game.BasicClasses.Pair;

import java.util.ArrayList;
import java.util.List;
import Game.*;
import Game.BasicClasses.Position;

public class King extends Piece{
    public King(Position position, boolean white){
        super(position,white);
        this.pieceFileName= "pieces/king.txt";
    }

    @Override
    public List<Pair<Position,Piece>> canMove(BoardInterface game){
        List<Pair<Position,Piece>> out = new ArrayList<Pair<Position,Piece>>();
        int x = this.position.getX(), y = this.position.getY();
        if(x-1>=0 && y-1>=0 && (!game.inPos(this.position.move(-1,-1)) || game.getInPos(this.position.move(-1,-1)).white!=this.white)){
            out.add(new Pair(this.position.move(-1,-1), game.getInPos(this.position.move(-1,-1))));
        }
        if(x-1>=0 && (!game.inPos(this.position.move(-1,0)) || game.getInPos(this.position.move(-1,0)).white!=this.white)){
            out.add(new Pair(this.position.move(-1,-0), game.getInPos(this.position.move(-1,0))));
        }
        if(y-1>=0 && (!game.inPos(this.position.move(0,-1)) || game.getInPos(this.position.move(0,-1)).white!=this.white)){
            out.add(new Pair(this.position.move(0,-1), game.getInPos(this.position.move(0,-1))));
        }
        if(x+1<8 && y-1>=0 && (!game.inPos(this.position.move(1,-1)) || game.getInPos(this.position.move(1,-1)).white!=this.white)){
            out.add(new Pair(this.position.move(1,-1), game.getInPos(this.position.move(1,-1))));
        }
        if(x-1>=0 && y+1<8 && (!game.inPos(this.position.move(-1,1)) || game.getInPos(this.position.move(-1,1)).white!=this.white)){
            out.add(new Pair(this.position.move(-1,1), game.getInPos(this.position.move(-1,1))));
        }
        if(x+1<8 && y+1<8 && (!game.inPos(this.position.move(1,1)) || game.getInPos(this.position.move(1,1)).white!=this.white)){
            out.add(new Pair(this.position.move(1,1), game.getInPos(this.position.move(1,1))));
        }
        if(y+1<8 && (!game.inPos(this.position.move(0,1)) || game.getInPos(this.position.move(0,1)).white!=this.white)){
            out.add(new Pair(this.position.move(0,1), game.getInPos(this.position.move(0,1))));
        }
        if(x+1<8 && (!game.inPos(this.position.move(1,0)) || game.getInPos(this.position.move(1,0)).white!=this.white)){
            out.add(new Pair(this.position.move(1,0), game.getInPos(this.position.move(1,0))));
        }
        int back = 7;
        if(!white) back = 0;
        Piece piece = game.getInPos(new Position(0,back));
        if(piece != null && piece instanceof Rook && piece.white == this.white && !piece.moved && !this.moved
        && game.getInPos(new Position(1,back))==null && game.getInPos(new Position(2,back)) == null && game.getInPos(new Position(3,back))==null) out.add(new Pair(this.position.move(-2,0),game.getInPos(this.position.move(-4,0))));
        piece = game.getInPos(new Position(7,back));
        if(piece != null && piece instanceof Rook && piece.white == this.white && !piece.moved && !this.moved && game.getInPos(new Position(6,back))==null && game.getInPos(new Position(5,back))==null) out.add(new Pair(this.position.move(2,0),game.getInPos(this.position.move(3,0))));
        return(out);
    }



    @Override
    public void move(Position position){
        super.move(position);
    }


}
