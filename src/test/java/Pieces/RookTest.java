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

public class RookTest {
    List<Piece> pieces = new ArrayList<Piece>();
    TestBoard game = new TestBoard();
    @BeforeEach
    void buildPieces(){
        pieces = new ArrayList<Piece>();
        game = new TestBoard();
    }

    @Test
    public void rookPositionsTest(){
        // Test Rook's movement
        Rook rook = new Rook(new Position(0,0),false);
        pieces.add(rook);

        List<Position> positions = new ArrayList<Position>();

        for(int i = 1;i < 8;i++){
            positions.add(new Position(0,rook.getPosition().getY() + i));
            positions.add(new Position(rook.getPosition().getX() + i,0));
        }

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListRook = new ArrayList<String>();
        for(Pair<Position, Piece> pair: rook.canMove(game)){
            stringListRook.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListRook);

        assertEquals(stringListPositions, stringListRook);
    }

    @Test
    public void rookCollisionTest(){
        // Test if Rook recognizes collisions with other pieces
        Rook rook = new Rook(new Position(4,3),true);
        Bishop bishop = new Bishop(new Position(4,4),true);
        pieces.add(rook);
        pieces.add(bishop);

        game.setPieces(pieces);

        List<Position> positions = new ArrayList<Position>();
        positions.add(new Position(4,0));
        positions.add(new Position(4,1));
        positions.add(new Position(4,2));
        positions.add(new Position(0,3));
        positions.add(new Position(1,3));
        positions.add(new Position(2,3));
        positions.add(new Position(3,3));
        positions.add(new Position(5,3));
        positions.add(new Position(6,3));
        positions.add(new Position(7,3));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListRook = new ArrayList<String>();
        for(Pair<Position, Piece> pair : rook.canMove(game)){
            stringListRook.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListRook);

        assertEquals(stringListPositions, stringListRook);

    }


    @Test
    public void rookMoveTest(){
        Rook rook = new Rook(new Position(7,4), true);
        pieces.add(rook);
        game.setPieces(pieces);

        rook.move(new Position(7,7));
        Position position = new Position(7,7);

        assertEquals(position.printPos(), rook.getPosition().printPos());
    }
}
