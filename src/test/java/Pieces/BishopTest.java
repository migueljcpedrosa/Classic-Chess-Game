package Pieces;

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

import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {
    List<Piece> pieces = new ArrayList<Piece>();
    TestBoard game = new TestBoard();
    @BeforeEach
    void buildPieces(){
        pieces = new ArrayList<Piece>();
        game = new TestBoard();
    }

    @Test
    public void bishopPositionsTest(){
        // Test Bishop's movement
        Bishop bishop = new Bishop(new Position(2,7), true);

        pieces.add(bishop);

        List<Position> positions= new ArrayList<Position>();

        positions.add(new Position(1,6));
        positions.add(new Position(0,5));
        positions.add(new Position(3,6));
        positions.add(new Position(4,5));
        positions.add(new Position(5,4));
        positions.add(new Position(6,3));
        positions.add(new Position(7,2));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListBishop = new ArrayList<String>();
        for(Pair<Position, Piece> pair : bishop.canMove(game)){
            stringListBishop.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListBishop);

        assertEquals(stringListPositions, stringListBishop);

    }


    @Test
    public void bishopCollisionTest(){
        // Test if Bishop recognizes collisions with other pieces
        Bishop bishop = new Bishop(new Position(2,7),true);

        Pawn pawn = new Pawn(new Position(5,4),true);

        pieces.add(bishop);
        pieces.add(pawn);

        game.setPieces(pieces);

        List<Position> positions = new ArrayList<Position>();

        positions.add(new Position(1,6));
        positions.add(new Position(0,5));
        positions.add(new Position(3,6));
        positions.add(new Position(4,5));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListBishop = new ArrayList<String>();
        for(Pair<Position, Piece> pair : bishop.canMove(game)){
            stringListBishop.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListBishop);

        assertEquals(stringListPositions, stringListBishop);
    }

    @Test
    public void bishopEatTest1(){
        Bishop bishop = new Bishop(new Position(2,7),true);

        Pawn pawn = new Pawn(new Position(5,4),false);

        pieces.add(bishop);
        pieces.add(pawn);

        game.setPieces(pieces);

        List<Position> positions = new ArrayList<Position>();

        positions.add(new Position(1,6));
        positions.add(new Position(0,5));
        positions.add(new Position(3,6));
        positions.add(new Position(4,5));
        positions.add(new Position(5,4));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListBishop = new ArrayList<String>();
        for(Pair<Position, Piece> pair : bishop.canMove(game)){
            stringListBishop.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListBishop);

        assertEquals(stringListPositions, stringListBishop);
    }


    @Test
    public void bishopEatTest2(){
        Bishop bishop = new Bishop(new Position(5,5),true);

        Pawn pawn = new Pawn(new Position(3,3),false);

        pieces.add(bishop);
        pieces.add(pawn);

        game.setPieces(pieces);

        List<Position> positions = new ArrayList<Position>();

        positions.add(new Position(6,6));
        positions.add(new Position(7,7));
        positions.add(new Position(6,4));
        positions.add(new Position(7,3));
        positions.add(new Position(4,6));
        positions.add(new Position(3,7));
        positions.add(new Position(4,4));
        positions.add(new Position(3,3));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListBishop = new ArrayList<String>();
        for(Pair<Position, Piece> pair : bishop.canMove(game)){
            stringListBishop.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListBishop);

        assertEquals(stringListPositions, stringListBishop);
    }


    @Test
    public void bishopEatTest3(){
        Bishop bishop = new Bishop(new Position(5,5),true);

        Pawn pawn = new Pawn(new Position(7,7),false);

        pieces.add(bishop);
        pieces.add(pawn);

        game.setPieces(pieces);

        List<Position> positions = new ArrayList<Position>();

        positions.add(new Position(6,6));
        positions.add(new Position(7,7));
        positions.add(new Position(6,4));
        positions.add(new Position(7,3));
        positions.add(new Position(4,6));
        positions.add(new Position(3,7));
        positions.add(new Position(4,4));
        positions.add(new Position(3,3));
        positions.add(new Position(2,2));
        positions.add(new Position(1,1));
        positions.add(new Position(0,0));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListBishop = new ArrayList<String>();
        for(Pair<Position, Piece> pair : bishop.canMove(game)){
            stringListBishop.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListBishop);

        assertEquals(stringListPositions, stringListBishop);
    }


    @Test
    public void bishopEatTest4(){
        Bishop bishop = new Bishop(new Position(3,4),true);

        Pawn pawn = new Pawn(new Position(1,6),false);

        pieces.add(bishop);
        pieces.add(pawn);

        game.setPieces(pieces);

        List<Position> positions = new ArrayList<Position>();

        positions.add(new Position(2,3));
        positions.add(new Position(1,2));
        positions.add(new Position(0,1));
        positions.add(new Position(4,3));
        positions.add(new Position(5,2));
        positions.add(new Position(6,1));
        positions.add(new Position(7,0));
        positions.add(new Position(4,5));
        positions.add(new Position(5,6));
        positions.add(new Position(6,7));
        positions.add(new Position(2,5));
        positions.add(new Position(1,6));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListBishop = new ArrayList<String>();
        for(Pair<Position, Piece> pair : bishop.canMove(game)){
            stringListBishop.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListBishop);

        assertEquals(stringListPositions, stringListBishop);
    }


    @Test
    public void bishopMoveTest(){
        Bishop bishop = new Bishop(new Position(4,5), false);
        pieces.add(bishop);
        game.setPieces(pieces);
        bishop.move(new Position(6,3));
        Position position = new Position(6,3);
        assertEquals(position.printPos(), bishop.getPosition().printPos());
    }
}
