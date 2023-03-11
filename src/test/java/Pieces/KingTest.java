package Pieces;

import Game.BasicClasses.Pair;
import Game.BasicClasses.Position;
import Game.TestClasses.TestBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KingTest {
    List<Piece> pieces = new ArrayList<Piece>();
    TestBoard game = new TestBoard();
    @BeforeEach
    void buildPieces(){
        pieces = new ArrayList<Piece>();
        game = new TestBoard();
    }

    @Test
    public void kingPositionsTest(){
        // Test King's movement
        King king = new King(new Position(5,5),false);
        pieces.add(king);

        List<Position> positions = new ArrayList<Position>();
        positions.add(new Position(5,6));
        positions.add(new Position(6,6));
        positions.add(new Position(6,5));
        positions.add(new Position(6,4));
        positions.add(new Position(5,4));
        positions.add(new Position(4,4));
        positions.add(new Position(4,5));
        positions.add(new Position(4,6));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListKing = new ArrayList<String>();
        for(Pair<Position, Piece> pair : king.canMove(game)){
            stringListKing.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListKing);

        assertEquals(stringListPositions, stringListKing);
    }


    @Test
    public void kingCollisionTest(){
        // Test if King recognizes collisions with other pieces
        King king = new King(new Position(4,2),true);
        Bishop bishop = new Bishop(new Position(4,3),true);
        pieces.add(king);
        pieces.add(bishop);

        game.setPieces(pieces);

        List<Position> positions = new ArrayList<Position>();
        positions.add(new Position(3,3));
        positions.add(new Position(3,2));
        positions.add(new Position(3,1));
        positions.add(new Position(4,1));
        positions.add(new Position(5,1));
        positions.add(new Position(5,2));
        positions.add(new Position(5,3));


        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListKing = new ArrayList<String>();
        for(Pair<Position, Piece> pair : king.canMove(game)){
            stringListKing.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListKing);

        assertEquals(stringListPositions, stringListKing);

    }


    @Test
    public void kingMoveTest(){
        King king = new King(new Position(6,3), false);
        pieces.add(king);
        game.setPieces(pieces);

        king.move(new Position(5,3));
        Position position = new Position(5,3);
        assertEquals(position.printPos(), king.getPosition().printPos());
    }
}
