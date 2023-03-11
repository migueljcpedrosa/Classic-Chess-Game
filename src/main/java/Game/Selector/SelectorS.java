package Game.Selector;

import Game.Board;

public class SelectorS implements SelectorCommand{
    public void execute(Selector selector){
        selector.move(0, 1);
    }
}
