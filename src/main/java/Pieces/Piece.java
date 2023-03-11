package Pieces;

import Game.*;
import Game.BasicClasses.Pair;
import Game.BasicClasses.Position;
import Game.BasicClasses.ReaderChess;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.nio.file.Paths;
import java.util.List;
public abstract class Piece implements PieceInterface{
    protected Position position;
    protected boolean white, moved = false;
    protected String pieceFileName = "pieces/pawn.txt";

    public Piece(Position position, boolean white){
        this.position=position;
        this.white=white;
    }

    public void draw(TextGraphics textGraphics) throws Exception
    {
        int xPos = this.position.getX()* Game.squareLength, yPos = this.position.getY()* Game.squareHeight;
        String filePath = Paths.get(getClass().getClassLoader().getResource(pieceFileName).toURI()).toString();
        ReaderChess readerobj = new ReaderChess(filePath);
        readerobj.fileReadByChar(textGraphics, this.white, xPos, yPos);
    }
    public abstract List<Pair<Position,Piece>> canMove(BoardInterface game);
    public Position getPosition(){
        return(position);
    }
    public void move(Position position){
        this.position=position;
        this.moved = true;
    }

    public boolean getWhite(){
        return this.white;
    }


    public boolean getMoved(){
        return this.moved;
    }
}
