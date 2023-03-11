package Game.Selector;

import Game.Board;

public class SelectorA implements SelectorCommand{
    public void execute(Selector selector){
        selector.move(-1,0);
    }
}
