package Game.Selector;

import Game.BasicClasses.Drawer;
import Game.BasicClasses.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import static Game.Game.squareHeight;
import static Game.Game.squareLength;

public class Selector {
    private Position position, selected = null;

    public Selector(int y){
        this.position=new Position(3,y);
    }

    public Position getPosition() {
        return position;
    }

    public Position getSelected() {
        return selected;
    }

    public boolean move(Position position){
        if(position.isValid()){
            this.position=position;
            return true;
        }
        return false;
    }

    public boolean move(int x, int y){
        Position position = new Position(this.position.getX()+x,this.position.getY()+y);
        return(this.move(position));
    }

    public void select(Position position){
        this.selected=position;
    }

    public void select(){
        this.select(this.position);
    }

    public void deselect(){
        this.selected=null;
    }

    public void draw(TextGraphics textGraphics){
        TextColor OldColour = textGraphics.getBackgroundColor();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#0000aa"));
        TextColor colourBorder = TextColor.Factory.fromString("#000000");
        textGraphics.fillRectangle(new TerminalPosition(this.position.getX()*squareLength,this.position.getY()*squareHeight), new TerminalSize(squareLength,squareHeight),' ');
        Drawer.drawBorder(textGraphics,this.position.getX()*squareLength,this.position.getY()*squareHeight, squareLength, squareHeight, colourBorder);
        if(this.selected!=null){
            textGraphics.setBackgroundColor(TextColor.Factory.fromString("#aabb00"));
            textGraphics.fillRectangle(new TerminalPosition(this.selected.getX()*squareLength,this.selected.getY()*squareHeight), new TerminalSize(squareLength,squareHeight),' ');
            Drawer.drawBorder(textGraphics,this.selected.getX()*squareLength,this.selected.getY()*squareHeight, squareLength, squareHeight, colourBorder);
        }
        textGraphics.setBackgroundColor(OldColour);
    }



}
