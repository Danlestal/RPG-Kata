
package kata.lwjgl.game;

import org.lwjgl.glfw.GLFW;
import kata.lwjgl.graphic.Color;
import kata.lwjgl.graphic.Texture;
import kata.lwjgl.math.Vector2f;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_UP;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static kata.lwjgl.state.GameState.*;

/**
 * This class represents a paddle for pong.
 *
 * @author Heiko Brumme
 */
public class Paddle extends Entity {

    private final boolean player;

    public Paddle(Color color, Texture texture, float x, float y, float speed, boolean player) {
        super(color, texture, x, y, speed, 20, 100, 0, 0);

        this.player = player;
    }

    /**
     * Handles input of the paddle.
     *
     * @param entity Only needed for the AI
     */
    @Override
    public void input(Entity entity) {
        direction = new Vector2f();
        if (player) {
            /* Player input */
            long window = GLFW.glfwGetCurrentContext();
            if (glfwGetKey(window, GLFW_KEY_UP) == GLFW_PRESS) {
                direction.y = 1f;
            }
            if (glfwGetKey(window, GLFW_KEY_DOWN) == GLFW_PRESS) {
                direction.y = -1f;
            }
        } else {
            /* AI */
            float ballCenter = entity.getY() + entity.getHeight() / 2f;
            float paddleCenter = position.y + this.height / 2f;

            if (ballCenter > paddleCenter) {
                direction.y = 1f;
            }
            if (ballCenter < paddleCenter) {
                direction.y = -1f;
            }
        }
    }

    /**
     * Checks if the paddle collided with the game border.
     *
     * @param gameHeight Height of the game field
     *
     * @return Direction constant of the collision
     */
    public int checkBorderCollision(int gameHeight) {
        if (position.y < 0) {
            position.y = 0;
            return COLLISION_BOTTOM;
        }
        if (position.y > gameHeight - this.height) {
            position.y = gameHeight - this.height;
            return COLLISION_TOP;
        }
        return NO_COLLISION;
    }

}
