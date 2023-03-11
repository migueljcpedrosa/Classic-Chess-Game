import Game.BasicClasses.Pair
import Game.BasicClasses.Position
import Game.BasicClasses.SamePair
import Game.Board
import Pieces.King
import Pieces.Pawn
import Pieces.Piece
import Pieces.PiecesFactory
import org.junit.Test
import spock.lang.Specification

class BoardTesting extends Specification{
    def "testing if PiecesFactory works properly"(){
        given:
        PiecesFactory piecesFactory = new PiecesFactory();
        List<Piece> pieces = new ArrayList<>();
        Board board = new Board();
        SamePair<King> kings = new SamePair(new King(new Position(4,7),true),new King(new Position(4,0),false));

        when:
        piecesFactory.createPieces(pieces, kings);
        List<String> pieces1 = new ArrayList<>();
        List<String> pieces2 = new ArrayList<>();
        for(Piece piece : board.pieces){
            pieces1.add(piece.position.printPos());
        }
        for(Piece piece : pieces){
            pieces2.add(piece.position.printPos());
        }
        Collections.sort(pieces1);
        Collections.sort(pieces2);


        then:
        pieces1 == pieces2;
    }


    def "testing setPieces()"(){
        given:
        Pawn pawn = new Pawn(new Position(5,5),true)
        List<Piece> pieces = new ArrayList<>()
        pieces.add(pawn)
        Board board = new Board()

        when:
        board.setPieces(pieces)

        then:
        pieces == board.pieces
    }


    def "testing getNewGame()"(){
        given:
        Board board = new Board()

        when:
        def assertion = board.getNewGame()

        then:
        !assertion
    }


    /*def "testing geti()"(){
        given:
        Board board = new Board()
        List<Piece> pieces = new ArrayList<>()
        Pawn pawn = new Pawn(new Position(4,1),false)
        pieces.add(pawn)
        board.setPieces(pieces)

        when:
        Pair<Position, Piece> pair = board.geti(new Position(4,1))

        then:
        pair.first() == pawn.getPosition()
    }*/


    def "testing getInPos()"(){
        given:
        Pawn pawn = new Pawn(new Position(6,3),false)
        List<Piece> pieces = new ArrayList<>()
        pieces.add(pawn)
        def board = new Board()
        board.setPieces(pieces)

        when:
        def piece = board.getInPos(new Position(6,3))

        then:
        piece == pawn
    }

    def "testing inPos()"(){
        given:
        Pawn pawn = new Pawn(new Position(7,4),true)
        List<Piece> pieces = new ArrayList<>()
        pieces.add(pawn)
        def board = new Board()
        board.setPieces(pieces)

        when:
        def assertion1 = board.inPos(new Position(7,4))
        def assertion2 = board.inPos(new Position(4,6))

        then:
        assertion1
        !assertion2
    }
}