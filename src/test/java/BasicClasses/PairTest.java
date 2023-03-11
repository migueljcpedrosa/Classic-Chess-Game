package BasicClasses;

import Game.BasicClasses.Pair;
import Game.BasicClasses.Position;
import Game.TestClasses.TestBoard;
import Pieces.Bishop;
import Pieces.Pawn;
import Pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairTest{
    @Test
    public void testFirstMethod() {
        Pair<String, Integer> pair = new Pair<>("hello", 123);
        assertEquals("hello", pair.first());
    }

    @Test
    public void testSecondMethod() {
        Pair<String, Integer> pair = new Pair<>("hello", 123);
        assertEquals(123, pair.second());
    }
}