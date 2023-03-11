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

public class HorseTest {
    List<Piece> pieces = new ArrayList<Piece>();
    TestBoard game = new TestBoard();
    @BeforeEach
    void buildPieces(){
        pieces = new ArrayList<Piece>();
        game = new TestBoard();
    }

    @Test
    public void horsePositionsTest(){
        // Test Horse's movement
        Horse horse = new Horse(new Position(1,0),false);
        Pawn pawn1 = new Pawn(new Position(0,1),false);
        Pawn pawn2 = new Pawn(new Position(1,1),false);
        Pawn pawn3 = new Pawn(new Position(2,1),false);
        Pawn pawn4 = new Pawn(new Position(3,1),false);
        Pawn pawn5 = new Pawn(new Position(4,1),false);


        pieces.add(horse);
        pieces.add(pawn1);
        pieces.add(pawn2);
        pieces.add(pawn3);
        pieces.add(pawn4);
        pieces.add(pawn5);

        game.setPieces(pieces);

        List<Position> positions = new ArrayList<Position>();

        positions.add(new Position(2,2));
        positions.add(new Position(0,2));

        //positions.add(new Position(0,1));
        //positions.add(new Position(4,1));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListHorse = new ArrayList<String>();
        for(Pair<Position, Piece> pair: horse.canMove(game)){
            stringListHorse.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListHorse);

        assertEquals(stringListPositions, stringListHorse);
    }

    @Test
    public void horseCollisionTest(){
        // Test if Horse recognizes collisions with other pieces
        Horse horse = new Horse(new Position(4,2),true);
        Bishop bishop = new Bishop(new Position(2,1),true);
        pieces.add(horse);
        pieces.add(bishop);

        game.setPieces(pieces);

        List<Position> positions = new ArrayList<Position>();
        positions.add(new Position(6,3));
        positions.add(new Position(6,1));
        positions.add(new Position(2,3));
        positions.add(new Position(5,4));
        positions.add(new Position(3,4));
        positions.add(new Position(5,0));
        positions.add(new Position(3,0));

        List<String> stringListPositions = new ArrayList<String>();
        for(Position position : positions){
            stringListPositions.add(position.printPos());
        }

        List<String> stringListHorse = new ArrayList<String>();
        for(Pair<Position, Piece> pair : horse.canMove(game)){
            stringListHorse.add(pair.first().printPos());
        }

        Collections.sort(stringListPositions);
        Collections.sort(stringListHorse);

        assertEquals(stringListPositions, stringListHorse);
    }


    @Test
    public void horseMoveTest(){
        Horse horse = new Horse(new Position(5,2), true);
        pieces.add(horse);
        game.setPieces(pieces);

        horse.move(new Position(3,3));
        Position position = new Position(3,3);
        assertEquals(position.printPos(), horse.getPosition().printPos());
    }
}
