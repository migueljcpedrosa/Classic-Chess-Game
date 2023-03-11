import Game.Game;

import java.io.IOException;
import java.net.URISyntaxException;

public class Application {

    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.run();
        }
        catch(Exception e){

        }
    }

}
