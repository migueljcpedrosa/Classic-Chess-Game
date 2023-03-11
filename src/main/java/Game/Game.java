package Game;


import Pieces.*;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Game{

    public static final int squareHeight = 32, squareLength = squareHeight*2, letterSize = 2;
    private TerminalSize terminalSize = new TerminalSize(squareLength*8, squareHeight*8);
    private DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
    private Terminal terminal;
    private Screen screen;
    static public boolean run = true;
    private Board board = new Board();


    private AWTTerminalFontConfiguration loadFont() throws Exception
    {

        URL resource = getClass().getClassLoader().getResource("ComicMono.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        Font loadedFont = font.deriveFont(Font.PLAIN,letterSize);
        //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //ge.registerFont(font);

        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public Game() throws IOException{
    }

    /*public void resetGame(){
        this.board = new Board();
    }*/


    public void run() throws Exception {

        terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        AWTTerminalFontConfiguration fontCfg = loadFont();
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontCfg);
        terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen();
        screen.doResizeIfNecessary();

        while(run){
            this.draw();
            KeyStroke key = screen.readInput();
            this.processKey(key);

            if(this.board.getNewGame()){
                board = new Board();
            }

        }
        screen.close();
    }

    public void processKey(KeyStroke key){
        board.processInput(key);
    }

    public void draw() throws Exception {

        screen.clear();

        TextGraphics tGraphics = screen.newTextGraphics();
        tGraphics.setBackgroundColor(TextColor.Factory.fromString("#ffffff")); //Cor dos quadrados "brancos" do tabuleiro
        tGraphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(squareLength*10,squareHeight*10),' ');
        board.draw(tGraphics);

        screen.refresh();
    }


}
