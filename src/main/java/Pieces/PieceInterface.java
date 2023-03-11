package Pieces;

import Game.BasicClasses.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public interface PieceInterface {
    public void draw(TextGraphics textGraphics) throws Exception;
    public Position getPosition();
    public void move(Position position);
    public boolean getWhite();
}
