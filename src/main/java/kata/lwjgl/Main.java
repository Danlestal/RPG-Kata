
package kata.lwjgl;

import kata.lwjgl.core.Game;
import kata.lwjgl.core.FixedTimestepGame;

/**
 * The main class creates a fixed timestep game and starts it.
 *
 * @author Heiko Brumme
 */
public class Main {

    /**
     * Main function.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new FixedTimestepGame();
        game.start();
    }

}
