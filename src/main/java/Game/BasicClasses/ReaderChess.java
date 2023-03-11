package Game.BasicClasses;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReaderChess {
    private String filename;

    public ReaderChess(String filename) {
        this.filename = filename;
    }

    public void fileReadByChar(TextGraphics textGraphics, boolean white, int xPos, int yPos) throws Exception {
        int counterX = 0;
        int counterY = 0;
        TextColor blackColor = TextColor.Factory.fromString("#000000");
        TextColor whiteColor = TextColor.Factory.fromString("#ffffff");
        if (!white) {
            blackColor = TextColor.Factory.fromString("#ffffff");
            whiteColor = TextColor.Factory.fromString("#000000");
        }
        File f = new File(filename);     //Creation of File Descriptor for input file
        FileReader fr = new FileReader(f);   //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr);  //Creation of BufferedReader object
        int c = 0;


        while ((c = br.read()) != -1)         //Read char by Char
        {
            counterX++;
            char character = (char) c;          //converting integer to char
            if (character == 'x') {
                textGraphics.setBackgroundColor(blackColor);
                textGraphics.drawRectangle(new TerminalPosition(counterX + xPos, counterY + yPos), new TerminalSize(1, 1), ' ');
            } else if (character == 'e') {
                textGraphics.setBackgroundColor(whiteColor);
                textGraphics.drawRectangle(new TerminalPosition(counterX + xPos, counterY + yPos), new TerminalSize(1, 1), ' ');
            }

            if (character == '\n') {
                counterX = 0;
                counterY++;
            }
        }
    }

}