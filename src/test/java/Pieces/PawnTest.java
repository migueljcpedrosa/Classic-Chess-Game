package Pieces;

import Game.BasicClasses.Pair;
import Game.BasicClasses.Position;
import Game.TestClasses.TestBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
    List<Piece> pieces = new ArrayList<>();
    TestBoard game = new TestBoard();
    @BeforeEach
    void buildPieces(){
        pieces = new ArrayList<>();
        game = new TestBoard();
    }

    @Test
    public void pawnMoveTest(){
        // Test Pawn's movement
        Pawn pawn = new Pawn(new Position(0,6), true);
        pieces.add(pawn);

        game.setPieces(pieces);

        pawn.move(new Position(0,5));

        assertEquals(pawn.getPosition(), new Position(0,5));
        assertEquals(game.getInPos(new Position(0,5)),pawn);
        assertNull(game.getInPos(new Position(0,6)));
        assertTrue(pawn.getMoved());
    }

    @Test
    public void testMoveForward(){
        Pawn pawn = new Pawn(new Position(0,6),true);
        pieces.add(pawn);
        List<Position> positions= new ArrayList<Position>();

        positions.add(new Position(0, 5));
        positions.add(new Position(0, 4));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListPawn = new ArrayList<String>();
        for(Pair<Position, Piece> pair : pawn.canMove(game)){
            stringListPawn.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListPawn);

        assertEquals(stringListPositions, stringListPawn);
    }

    @Test
    public void testMoveForwardTwoTimes(){
        Pawn pawn = new Pawn(new Position(0,6),true);
        pieces.add(pawn);

        game.setPieces(pieces);

        List<Position> positions= new ArrayList<Position>();

        pawn.move(new Position(0,4));
        game.getInPos(pawn.getPosition()).move(new Position(0,4));

        positions.add(new Position(0,3));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListPawn = new ArrayList<String>();
        for(Pair<Position, Piece> pair : pawn.canMove(game)){
            stringListPawn.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListPawn);

        assertEquals(stringListPositions, stringListPawn);
    }

    @Test
    public void testMoveForwardIntoPiece() {
        // Test if Pawn recognizes collisions with other pieces
        Pawn pawn1 = new Pawn(new Position(0, 6), true), pawn2 = new Pawn(new Position(0, 4), true);
        pieces.add(pawn1);
        pieces.add(pawn2);
        game.setPieces(pieces);
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(0, 5));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListPawn = new ArrayList<String>();
        for(Pair<Position, Piece> pair : pawn1.canMove(game)){
            stringListPawn.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListPawn);

        assertEquals(stringListPositions, stringListPawn);

    }


    @Test
    public void pawnEatTest(){
        Pawn pawn1 = new Pawn(new Position(5,6), true);
        Pawn pawn2 = new Pawn(new Position(4,5), false);
        pieces.add(pawn1);
        pieces.add(pawn2);
        game.setPieces(pieces);

        List<Position> positions = new ArrayList<>();
        positions.add(new Position(5,5));
        positions.add(new Position(5,4));
        positions.add(new Position(4,5));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListPawn = new ArrayList<String>();
        for(Pair<Position, Piece> pair : pawn1.canMove(game)){
            stringListPawn.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListPawn);

        assertEquals(stringListPositions, stringListPawn);
    }


    @Test
    public void pawnMovedTwiceTest(){
        Pawn pawn = new Pawn(new Position(5,1), false);
        pieces.add(pawn);
        game.setPieces(pieces);

        pawn.move(new Position(5,3));
        pawn.removeMovedTwice();
        assertFalse(pawn.getMovedTwice());
    }
}

