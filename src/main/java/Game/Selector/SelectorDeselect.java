package Game.Selector;

import Game.Board;
import Game.BoardInterface;

public class SelectorDeselect implements SelectorCommand {
    public void execute(Selector selector){
        selector.deselect();
    }
}
