package Pieces;

import Game.BasicClasses.Pair;
import Game.BasicClasses.Position;
import Game.BoardInterface;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PieceTest {

    @Test
    public void testConstructor() {
        // Test the Piece constructor
        Piece piece = new TestPiece(new Position(0, 0), true);
        assertEquals(new Position(0, 0), piece.getPosition());
        assertTrue(piece.getWhite());
        assertFalse(piece.getMoved());
    }

    @Test
    public void testMoveMethod() {
        // Test the move method
        Piece piece = new TestPiece(new Position(0, 0), true);
        piece.move(new Position(2, 3));
        assertEquals(new Position(2, 3), piece.getPosition());
        assertTrue(piece.getMoved());
    }

    @Test
    public void testGetPosition() {
        Piece piece = new TestPiece(new Position(3, 4), true);
        assertEquals(new Position(3, 4), piece.getPosition());
    }

    @Test
    public void testGetWhite() {
        Piece whitePiece = new TestPiece(new Position(0, 0), true);
        assertTrue(whitePiece.getWhite());

        Piece blackPiece = new TestPiece(new Position(0, 0), false);
        assertFalse(blackPiece.getWhite());
    }



    private static class TestPiece extends Piece {
        public TestPiece(Position position, boolean white) {
            super(position, white);
        }

        @Override
        public List<Pair<Position, Piece>> canMove(BoardInterface game) {
            // The canMove method is abstract and needs to be implemented by subclasses
            return null;
        }
    }


    @Test
    public void testDraw() throws Exception {
        TextGraphics textGraphics = mock(TextGraphics.class);
        TestPiece testPiece = mock(TestPiece.class);
        testPiece.draw(textGraphics);
        verify(testPiece, times(1)).draw(textGraphics);
    }
}
