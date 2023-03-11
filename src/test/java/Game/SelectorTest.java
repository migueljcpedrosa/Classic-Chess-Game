package Game;

import Game.BasicClasses.Position;
import Game.Selector.*;

import static Game.Game.squareHeight;
import static Game.Game.squareLength;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;

class SelectorTest {

    @Test
    void testMove() {
        // Create a Selector object with a test starting position
        Selector selector = new Selector(3);

        // Call the move method with a valid position and verify if it returns true
        assertTrue(selector.move(new Position(4, 4)));

        // Verify that the position of the selector was updated correctly
        assertEquals(new Position(4, 4), selector.getPosition());

        // Call the move method with an invalid position and verify if it returns false
        assertFalse(selector.move(new Position(8, 4)));

        // Verify if the position of the selector was not updated
        assertEquals(new Position(4, 4), selector.getPosition());
    }

    @Test
    void testSelectAndDeselect() {
        // Create a Selector object with a test starting position
        Selector selector = new Selector(3);

        // Call the select method with a position and verify if it updates the selected field correctly
        selector.select(new Position(4, 4));
        assertEquals(new Position(4, 4), selector.getSelected());

        // Call the select method without a position and verify if it updates the selected field correctly
        selector.select();
        assertEquals(new Position(3, 3), selector.getSelected());

        // Call the deselect method and verify if it clears the selected field
        selector.deselect();
        assertNull(selector.getSelected());
    }

    @Test
    void testDraw() {
        // create a mock TextGraphics object to use for testing
        TextGraphics textGraphics = mock(TextGraphics.class);

        // create a Selector object with a test starting position
        Selector selector = new Selector(3);

        // call the draw method with the mock textGraphics
        selector.draw(textGraphics);

        // verify that the fillRectangle and setBackgroundColor methods of the mock textGraphics object were called with the correct parameters
        verify(textGraphics).setBackgroundColor(TextColor.Factory.fromString("#0000aa"));
        verify(textGraphics).fillRectangle(new TerminalPosition(3 * squareLength, 3 * squareHeight), new TerminalSize(squareLength, squareHeight), ' ');
    }

    @Test
    void testCmd(){
        Selector selector = new Selector(3);
        SelectorCommand cmd;
        cmd = new SelectorW();
        cmd.execute(selector);
        assertEquals(selector.getPosition().getY(),2);

        cmd = new SelectorS();
        cmd.execute(selector);
        assertEquals(selector.getPosition().getY(),3);

        cmd = new SelectorA();
        cmd.execute(selector);
        assertEquals(selector.getPosition().getX(),2);

        cmd = new SelectorD();
        cmd.execute(selector);
        assertEquals(selector.getPosition().getX(),3);

        selector.select();

        cmd = new SelectorDeselect();
        cmd.execute(selector);

        assertEquals(selector.getSelected(),null);
    }

}
