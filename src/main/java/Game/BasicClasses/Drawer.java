package Game.BasicClasses;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextColor;

public class Drawer {
    //public Drawer(){};
    public static void drawRectangle(TextGraphics textGraphics, int xStart, int yStart, int xLen, int yLen, TextColor colour){
        TextColor oldColour = textGraphics.getBackgroundColor();
        textGraphics.setBackgroundColor(colour);
        textGraphics.fillRectangle(new TerminalPosition(xStart,yStart),new TerminalSize(xLen,yLen), ' ');
        textGraphics.setBackgroundColor(oldColour);
    }

    public static void drawBorder(TextGraphics textGraphics,int xStart, int yStart, int xLen, int yLen, TextColor colour){
        TextColor oldColour = textGraphics.getBackgroundColor();
        textGraphics.setBackgroundColor(colour);
        textGraphics.drawRectangle(new TerminalPosition(xStart,yStart),new TerminalSize(xLen,yLen), ' ');
        textGraphics.setBackgroundColor(oldColour);
    }

    public static void drawRectangleWithBorder(TextGraphics textGraphics, int xStart, int yStart, int xLen, int yLen, TextColor colour1, TextColor colour2){
        drawRectangle(textGraphics,xStart,yStart,xLen,yLen,colour1);
        drawBorder(textGraphics,xStart,yStart,xLen,yLen,colour2);
    }
}
