package Pieces;

import Game.BasicClasses.SamePair;
import Game.BasicClasses.Position;

import java.util.List;

public class PiecesFactory {
    public PiecesFactory(){}
    public void createPieces(List<Piece> pieces, SamePair<King> kings) {

        for(int i = 0; i < 8; i++) {
            pieces.add(new Pawn(new Position(i, 6), true));
            pieces.add(new Pawn(new Position(i, 1), false));
        }

        pieces.add(new Rook(new Position(0, 7), true));
        pieces.add(new Horse(new Position(1, 7), true));
        pieces.add(new Bishop(new Position(2, 7), true));
        pieces.add(new Queen(new Position(3, 7), true));
        pieces.add(kings.get(true));//KING
        pieces.add(new Bishop(new Position(5, 7), true));
        pieces.add(new Horse(new Position(6, 7), true));
        pieces.add(new Rook(new Position(7, 7), true));

        pieces.add(new Rook(new Position(0, 0), false));
        pieces.add(new Horse(new Position(1, 0), false));
        pieces.add(new Bishop(new Position(2, 0), false));
        pieces.add(new Queen(new Position(3, 0), false));
        pieces.add(kings.get(false));//KING
        pieces.add(new Bishop(new Position(5, 0), false));
        pieces.add(new Horse(new Position(6, 0), false));
        pieces.add(new Rook(new Position(7, 0), false));
    }
}
