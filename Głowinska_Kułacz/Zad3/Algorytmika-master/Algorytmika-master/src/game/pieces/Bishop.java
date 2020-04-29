package game.pieces;

import game.Board;
import game.Game;
import game.Movement;
import game.Position;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color, "bishop");
    }

    @Override
    public boolean isValidMovement(Game game, Movement movement) {
        if (Math.abs(movement.getRowOffset()) != Math.abs(movement.getColOffset())) {
            return false;
        }
        Board board = game.getBoard();
/////FIXME   z użyciem wyrażeń warunkowych aby uniknąć wspomnianej w prezentacji "ściany ifów" /////////
/////FIXME   poruszamy się w górę lub dół - plus lub minus 1
        for (int i = 1; i < Math.abs(movement.getRowOffset()); i++) {
            int kolumna = (movement.getColOffset() < 0 ? -1 : 1) * i;
            int wiersz = (movement.getRowOffset() < 0 ? -1 : 1 ) * i;
            Position test = new Position(movement.getOriginRow() + wiersz, movement.getOriginCol() + kolumna);
            if (!(board.at(test) instanceof None)){
                return false;
            }
        }
        return false;
    }
}