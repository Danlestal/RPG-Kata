
package kata.rpg;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.opengl.GL;
import kata.rpg.graphics.LWJGLRenderer;
import kata.rpg.states.GameState;
import kata.lwjgl.core.Timer;


public class Game {

    public static final int TARGET_FPS = 75;
    public static final int TARGET_UPS = 30;

    protected boolean running;
    protected Timer timer;
    protected SceneRender sceneRenderer;
    protected GameState state;

    public Game() {
    }

    public void start() {
        init();
        gameLoop();
        dispose();
    }


    public void dispose() {
        sceneRenderer.dispose();
    }

    public void init() {
        // Start the render
        LWJGLRenderer renderer = new LWJGLRenderer();
        renderer.init();

        // Load a game level
        state = new GameState();
        state.enter();

        sceneRenderer = new SceneRender(renderer, state);

        timer = new Timer();
        timer.init();
        
        running = true;
        
    }

    public void gameLoop() {
        float delta;
        float accumulator = 0f;
        float interval = 1f / TARGET_UPS;
        float alpha;

        while (running) {
            /* Check if game should close */
            if (sceneRenderer.isClosing()) {
                running = false;
            }

            /* Get delta time and update the accumulator */
            delta = timer.getDelta();
            accumulator += delta;

            /* Handle input */
            input();

            /* Update game and timer UPS if enough time has passed */
            while (accumulator >= interval) {
                update();
                timer.updateUPS();
                accumulator -= interval;
            }

            /* Calculate alpha value for interpolation */
            alpha = accumulator / interval;

            /* Render game and update timer FPS */
            render(alpha);
            timer.updateFPS();
            /* Update timer */
            timer.update();

            
        }
    }

    /**
     * Handles input.
     */
    public void input() {
        state.input();
    }

    /**
     * Updates the game (fixed timestep).
     */
    public void update() {
        state.update();
    }

    /**
     * Updates the game (variable timestep).
     *
     * @param delta Time difference in seconds
     */
    public void update(float delta) {
        state.update(delta);
    }

    /**
     * Renders the game (with interpolation).
     *
     * @param alpha Alpha value, needed for interpolation
     */
    public void render(float alpha) {
        sceneRenderer.render(alpha);
    }

    /**
     * Synchronizes the game at specified frames per second.
     *
     * @param fps Frames per second
     */
    public void sync(int fps) {
        double lastLoopTime = timer.getLastLoopTime();
        double now = timer.getTime();
        float targetTime = 1f / fps;

        while (now - lastLoopTime < targetTime) {
            Thread.yield();

            /* This is optional if you want your game to stop consuming too much
             * CPU but you will loose some accuracy because Thread.sleep(1)
             * could sleep longer than 1 millisecond */
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }

            now = timer.getTime();
        }
    }

    /**
     * Determines if the OpenGL context supports version 3.2.
     *
     * @return true, if OpenGL context supports version 3.2, else false
     */
    public static boolean isDefaultContext() {
        return GL.getCapabilities().OpenGL32;
    }

}
