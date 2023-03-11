package BasicClasses;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import Game.BasicClasses.ReaderChess;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class ReaderChessTest {

    @Test
    void testFileReadByChar() throws Exception {
        // create a mock TextGraphics object to use for testing
        TextGraphics textGraphics = mock(TextGraphics.class);

        // create a ReaderChess object with a sample filename
        String filePath = Paths.get(getClass().getClassLoader().getResource("pieces/pawn.txt").toURI()).toString();
        ReaderChess reader = new ReaderChess(filePath);

        // call the fileReadByChar method with the mock textGraphics and test values for the white and xPos/yPos parameters
        reader.fileReadByChar(textGraphics, true, 5, 10);
    }
}
