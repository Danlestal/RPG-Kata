
package kata.lwjgl.core;

/**
 * This class contains the implementation for a fixed timestep game loop.
 *
 * @author Heiko Brumme
 */
public class FixedTimestepGame extends Game {

    @Override
    public void gameLoop() {
        float delta;
        float accumulator = 0f;
        float interval = 1f / TARGET_UPS;
        float alpha;

        while (running) {
            /* Check if game should close */
            if (window.isClosing()) {
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

            /* Update window to show the new screen */
            window.update();

            /* Synchronize if v-sync is disabled */
            if (!window.isVSyncEnabled()) {
                sync(TARGET_FPS);
            }
        }
    }

}
