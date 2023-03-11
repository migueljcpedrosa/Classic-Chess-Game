package Game;

import Game.BasicClasses.*;
import Game.Selector.*;
import Pieces.*;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyStroke;

import java.nio.file.Paths;
import java.util.List;

import static Game.Game.squareHeight;
import static Game.Game.squareLength;

public class Board implements BoardInterface{


    public boolean gameOver = false, newGame = false;
    public List<Pair<Position,Piece>> locations = null;
    private SamePair<Selector> selectors = new SamePair(new Selector(7),new Selector(0)); //QUERO GUARDAR A ULTIMA POSICAO DO BRANCO SEPARADO DA ULTIMA POSICAO DO PRETO
    private SamePair<King> kings = new SamePair(new King(new Position(4,7),true),new King(new Position(4,0),false));
    private boolean whiteTurn = true;

    public Board(){
        pieces.clear();
        PiecesFactory pf = new PiecesFactory();
        pf.createPieces(pieces,kings);
    }

    public void setPieces(List<Piece> list){
        pieces.clear();
        pieces.addAll(list);
    }

    public boolean getNewGame(){
        return this.newGame;
    }

    public boolean getTurn(){
        return this.whiteTurn;
    }

    private Pair<Position,Piece> geti(Position position){
        for(int i = 0; i < locations.size(); i++){
            if(locations.get(i).first().equals(position)) return new Pair<Position, Piece>(locations.get(i).first(),locations.get(i).second());
        }
        return null;
    }

    public Piece getInPos(Position pos){
        for (int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).getPosition().equals(pos)) return pieces.get(i);
        }
        return null;
    }
    public boolean inPos(Position pos){
        return(getInPos(pos)!=null);
    }

    public void removePawnMovedTwice(){
        Piece piece;
        for(int i = 0; i < pieces.size(); i++){
            piece = pieces.get(i);
            if(piece instanceof Pawn && piece.getWhite()==whiteTurn){
                ((Pawn) piece).removeMovedTwice();
                makeQueen((Pawn) piece);
            }
        }
    }
    public void makeQueen(Pawn piece){
        if(piece.getPosition().getY()==0 || piece.getPosition().getY()==7){
            pieces.add(new Queen(piece.getPosition(), piece.getWhite()));
            pieces.remove(piece);
        }
    }

    public void draw(TextGraphics tGraphics) throws Exception{

        tGraphics.setBackgroundColor(TextColor.Factory.fromString("#6b9680")); //Cor dos quadrados "brancos" do tabuleiro
        tGraphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(squareLength*8,squareHeight*8),' ');
        tGraphics.setBackgroundColor(TextColor.Factory.fromString("#d2d48e")); //Cor dos quadrados "pretos" do tabuleiro

        for(int i = 0; i < (squareLength*10); i+=(squareLength*2)){
            tGraphics.fillRectangle(new TerminalPosition(i,squareHeight*0), new TerminalSize(squareLength,squareHeight),' ');
            tGraphics.fillRectangle(new TerminalPosition(i,squareHeight*2), new TerminalSize(squareLength,squareHeight),' ');
            tGraphics.fillRectangle(new TerminalPosition(i,squareHeight*4), new TerminalSize(squareLength,squareHeight),' ');
            tGraphics.fillRectangle(new TerminalPosition(i,squareHeight*6), new TerminalSize(squareLength,squareHeight),' ');
        }

        for(int i = squareLength; i < (squareLength*10); i+=(squareLength*2)){
            tGraphics.fillRectangle(new TerminalPosition(i,squareHeight*1), new TerminalSize(squareLength,squareHeight),' ');
            tGraphics.fillRectangle(new TerminalPosition(i,squareHeight*3), new TerminalSize(squareLength,squareHeight),' ');
            tGraphics.fillRectangle(new TerminalPosition(i,squareHeight*5), new TerminalSize(squareLength,squareHeight),' ');
            tGraphics.fillRectangle(new TerminalPosition(i,squareHeight*7), new TerminalSize(squareLength,squareHeight),' ');
        }




        if(locations!=null) for (int j = 0; j < locations.size(); j++){
            TextColor colourBorder = TextColor.Factory.fromString("#000000");
            if(locations.get(j).second()!=null)
            {
                if(locations.get(j).second() instanceof King) tGraphics.setBackgroundColor(TextColor.Factory.fromString("#702963"));
                else if(locations.get(j).second().getWhite()==whiteTurn) tGraphics.setBackgroundColor(TextColor.Factory.fromString("#8c2d19"));
                else tGraphics.setBackgroundColor(TextColor.Factory.fromString("#ff0000"));
            }
            else
            {
                tGraphics.setBackgroundColor(TextColor.Factory.fromString("#4444aa"));
            }
            tGraphics.fillRectangle(new TerminalPosition(locations.get(j).first().getX()*squareLength,locations.get(j).first().getY()*squareHeight), new TerminalSize(squareLength,squareHeight),' ');
            Drawer.drawBorder(tGraphics,locations.get(j).first().getX()*squareLength,locations.get(j).first().getY()*squareHeight, squareLength, squareHeight, colourBorder);
        }

        if(!gameOver) selectors.get(whiteTurn).draw(tGraphics);

        for(int i = 0; i < pieces.size(); i++){
            pieces.get(i).draw(tGraphics);
        }

        if(gameOver){
            this.drawFinalScreen(tGraphics,!whiteTurn);
        }

    }
    public void drawFinalScreen(TextGraphics textGraphics, boolean winner) throws Exception
    {
        int xPos = 3*Game.squareLength - 65, yPos = 3* Game.squareHeight + 20;
        String filePath;
        if(winner) filePath = Paths.get(getClass().getClassLoader().getResource("endText/whiteWins.txt").toURI()).toString();
        else filePath = Paths.get(getClass().getClassLoader().getResource("endText/blackWins.txt").toURI()).toString();
        ReaderChess readerobj = new ReaderChess(filePath);
        readerobj.fileReadByChar(textGraphics, true, xPos, yPos);
    }

    public void processInput(KeyStroke key){
        SelectorCommand cmd = null;
        if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'x') Game.run = false;
        if(!gameOver) {
            if ((key.getKeyType() == KeyType.Character && key.getCharacter() == 'w') || key.getKeyType() == KeyType.ArrowUp)
                cmd = new SelectorW();
            else if ((key.getKeyType() == KeyType.Character && key.getCharacter() == 'a') || key.getKeyType() == KeyType.ArrowLeft)
                cmd = new SelectorA();
            else if ((key.getKeyType() == KeyType.Character && key.getCharacter() == 's') || key.getKeyType() == KeyType.ArrowDown)
                cmd = new SelectorS();
            else if ((key.getKeyType() == KeyType.Character && key.getCharacter() == 'd') || key.getKeyType() == KeyType.ArrowRight)
                cmd = new SelectorD();
            else if (key.getKeyType() == KeyType.Escape) {
                cmd = new SelectorDeselect();
                this.locations=null;
            }
            else if ((key.getKeyType() == KeyType.Enter || (key.getKeyType() == KeyType.Character && key.getCharacter() == ' ')) && selectors.get(whiteTurn).getSelected() == null) {
                if (this.getInPos(selectors.get(whiteTurn).getPosition()) != null && this.getInPos(selectors.get(whiteTurn).getPosition()).getWhite() == this.getTurn()) {
                    selectors.get(whiteTurn).select();
                    this.locations = this.getInPos(selectors.get(whiteTurn).getSelected()).canMove(this);

                }
                else {
                    selectors.get(whiteTurn).deselect();
                    this.locations = null;
                }
            }
            else if ((key.getKeyType() == KeyType.Enter || (key.getKeyType() == KeyType.Character && key.getCharacter() == ' ')) && this.geti(selectors.get(whiteTurn).getPosition()) != null) {

                Piece piece = this.geti(selectors.get(whiteTurn).getPosition()).second();

                if (piece != null) {
                    if (piece.getWhite() != whiteTurn) {
                        pieces.remove(piece); //MATAR PEÇA
                    } else {
                        if (piece.getPosition().getX() == 0) piece.move(piece.getPosition().move(3, 0));
                        else piece.move(piece.getPosition().move(-2, 0));
                    }
                }
                this.removePawnMovedTwice();
                this.getInPos(selectors.get(whiteTurn).getSelected()).move(selectors.get(whiteTurn).getPosition());
                locations = null;
                if (this.getInPos(selectors.get(whiteTurn).getPosition()) instanceof Pawn) {
                    this.makeQueen((Pawn) this.getInPos(selectors.get(whiteTurn).getPosition()));
                }

                if(!pieces.contains(kings.get(!whiteTurn))) gameOver = true;

                selectors.get(whiteTurn).deselect();

                whiteTurn = !whiteTurn;

            }
            if(cmd!=null) cmd.execute(selectors.get(whiteTurn));
        }
        else if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'r'){
            this.newGame=true;
        }
    }


}
