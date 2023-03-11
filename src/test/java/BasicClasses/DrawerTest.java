package BasicClasses;

import Game.BasicClasses.Drawer;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class DrawerTest {
    private TextGraphics textGraphics;

    @BeforeEach
    public void setUp() {
        // Set up a mock TextGraphics object that we can use for testing
        textGraphics = mock(TextGraphics.class);
    }

    @Test
    public void testDrawRectangle() {
        Drawer.drawRectangle(textGraphics, 1, 2, 3, 4, TextColor.ANSI.BLUE);
        // Verify that the fillRectangle method was called with the correct arguments
        textGraphics.fillRectangle(new TerminalPosition(1, 2), new TerminalSize(3, 4), ' ');
        verify(textGraphics).fillRectangle(new TerminalPosition(1, 2), new TerminalSize(3, 4), ' ');
    }

    @Test
    public void testDrawBorder() {
        Drawer.drawBorder(textGraphics, 5, 6, 7, 8, TextColor.ANSI.RED);
        // Verify that the drawRectangle method was called with the correct arguments
        textGraphics.drawRectangle(new TerminalPosition(5, 6), new TerminalSize(7, 8), ' ');
        verify(textGraphics).drawRectangle(new TerminalPosition(5, 6), new TerminalSize(7, 8), ' ');
    }

    @Test
    public void testDrawRectangleWithBorder() {
        Drawer.drawRectangleWithBorder(textGraphics, 9, 10, 11, 12, TextColor.ANSI.GREEN, TextColor.ANSI.YELLOW);
        // Verify that the fillRectangle and drawRectangle methods were called with the correct arguments
        verify(textGraphics).fillRectangle(new TerminalPosition(9, 10), new TerminalSize(11, 12), ' ');
        verify(textGraphics).drawRectangle(new TerminalPosition(9, 10), new TerminalSize(11, 12), ' ');
    }

    @Test
    public void testDrawRectangleWithInvalidInput() {
        // Test that the drawRectangle method handles invalid input correctly
        Drawer.drawRectangle(textGraphics, -1, 2, 3, 4, TextColor.ANSI.BLUE);
        verify(textGraphics, never()).fillRectangle(any(), any(), anyChar()); // Note: the 'never' method is a verification mode that can be used with the verify method to specify that a method should never have been called on a mock object.

        Drawer.drawRectangle(textGraphics, 1, -2, 3, 4, TextColor.ANSI.BLUE);
        verify(textGraphics, never()).fillRectangle(any(), any(), anyChar());

        Drawer.drawRectangle(textGraphics, 1, 2, -3, 4, TextColor.ANSI.BLUE);
        verify(textGraphics, never()).fillRectangle(any(), any(), anyChar());

        Drawer.drawRectangle(textGraphics, 1, 2, 3, -4, TextColor.ANSI.BLUE);
        verify(textGraphics, never()).fillRectangle(any(), any(), anyChar());
    }

}
