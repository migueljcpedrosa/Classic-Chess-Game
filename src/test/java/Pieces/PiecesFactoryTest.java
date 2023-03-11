package Pieces;

import Game.BasicClasses.Position;
import Game.BasicClasses.SamePair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiecesFactoryTest {
    @Test
    public void testCreatePieces() {
        // Create a PiecesFactory instance
        PiecesFactory factory = new PiecesFactory();

        // Create a list to hold the pieces
        List<Piece> pieces = new ArrayList<>();

        // Create a pair of kings
        SamePair<King> kings = new SamePair<>(new King(new Position(4, 7), true),
                new King(new Position(4, 0), false));

        // Call the createPieces method
        factory.createPieces(pieces, kings);

        // Verify that the correct number of pieces was created
        assertEquals(32, pieces.size());

        // Verify that the 8 white pawns are in the correct positions
        for (int i = 0; i < 16; i+=2) {
            assertEquals(Pawn.class, pieces.get(i).getClass());
            assertEquals(true, pieces.get(i).getWhite());
            assertEquals(new Position(i/2, 6), pieces.get(i).getPosition());
        }

        // Verify that the 8 black pawns are in the correct positions
        for (int i = 1; i < 16; i+=2) {
            assertEquals(Pawn.class, pieces.get(i).getClass());
            assertEquals(false, pieces.get(i).getWhite());
            assertEquals(new Position((i-1)/2, 1), pieces.get(i).getPosition());
        }

        // Verify that the remaining pieces are in the correct positions and have the correct colors
        assertEquals(Rook.class, pieces.get(16).getClass());
        assertEquals(true, pieces.get(16).getWhite());
        assertEquals(new Position(0, 7), pieces.get(16).getPosition());

        assertEquals(Horse.class, pieces.get(17).getClass());
        assertEquals(true, pieces.get(17).getWhite());
        assertEquals(new Position(1, 7), pieces.get(17).getPosition());

        assertEquals(Bishop.class, pieces.get(18).getClass());
        assertEquals(true, pieces.get(18).getWhite());
        assertEquals(new Position(2, 7), pieces.get(18).getPosition());

        assertEquals(Queen.class, pieces.get(19).getClass());
        assertEquals(true, pieces.get(19).getWhite());
        assertEquals(new Position(3, 7), pieces.get(19).getPosition());

        assertEquals(King.class, pieces.get(20).getClass());
        assertEquals(true, pieces.get(20).getWhite());
    }
}

