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

public class QueenTest {
    List<Piece> pieces = new ArrayList<Piece>();
    TestBoard game = new TestBoard();
    @BeforeEach
    void buildPieces(){
        pieces = new ArrayList<Piece>();
        game = new TestBoard();
    }

    @Test
    public void queenPositionsTest(){
        // Test Queen's movement
        Queen queen = new Queen(new Position(4,7),true);
        pieces.add(queen);

        List<Position> positions = new ArrayList<Position>();
        positions.add(new Position(3,7));
        positions.add(new Position(2,7));
        positions.add(new Position(1,7));
        positions.add(new Position(0,7));
        positions.add(new Position(5,7));
        positions.add(new Position(6,7));
        positions.add(new Position(7,7));
        positions.add(new Position(4,6));
        positions.add(new Position(4,5));
        positions.add(new Position(4,4));
        positions.add(new Position(4,3));
        positions.add(new Position(4,2));
        positions.add(new Position(4,1));
        positions.add(new Position(4,0));
        positions.add(new Position(3,6));
        positions.add(new Position(2,5));
        positions.add(new Position(1,4));
        positions.add(new Position(0,3));
        positions.add(new Position(5,6));
        positions.add(new Position(6,5));
        positions.add(new Position(7,4));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListQueen = new ArrayList<String>();
        for(Pair<Position, Piece> pair : queen.canMove(game)){
            stringListQueen.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListQueen);

        assertEquals(stringListPositions, stringListQueen);
    }

    @Test
    public void queenCollisionTest(){
        // Test if Queen recognizes collisions with other pieces
        Queen queen = new Queen(new Position(5,3),false);
        Rook rook = new Rook(new Position(3,5),false);
        pieces.add(queen);
        pieces.add(rook);

        game.setPieces(pieces);

        List<Position> positions = new ArrayList<Position>();
        positions.add(new Position(5,2));
        positions.add(new Position(5,1));
        positions.add(new Position(5,0));
        positions.add(new Position(5,4));
        positions.add(new Position(5,5));
        positions.add(new Position(5,6));
        positions.add(new Position(5,7));
        positions.add(new Position(0,3));
        positions.add(new Position(1,3));
        positions.add(new Position(2,3));
        positions.add(new Position(3,3));
        positions.add(new Position(4,3));
        positions.add(new Position(6,3));
        positions.add(new Position(7,3));
        positions.add(new Position(6,4));
        positions.add(new Position(7,5));
        positions.add(new Position(6,2));
        positions.add(new Position(7,1));
        positions.add(new Position(4,4));
        positions.add(new Position(4,2));
        positions.add(new Position(3,1));
        positions.add(new Position(2,0));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListQueen = new ArrayList<String>();
        for(Pair<Position, Piece> pair : queen.canMove(game)){
            stringListQueen.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListQueen);

        assertEquals(stringListPositions, stringListQueen);
    }


    @Test
    public void queenMoveTest(){
        Queen queen = new Queen(new Position(5,3), false);
        pieces.add(queen);
        game.setPieces(pieces);

        queen.move(new Position(7,2));
        Position position = new Position(7,2);
        assertEquals(position.printPos(), queen.getPosition().printPos());
    }
}
