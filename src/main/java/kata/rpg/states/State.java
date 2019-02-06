
package kata.rpg.states;
import kata.rpg.Game;
import kata.rpg.components.RenderComponent;


public interface State {

    public void input();

    public default void update() {
        update(1f / Game.TARGET_UPS);
    }

    public void update(float delta);

    public Iterable<RenderComponent> getRenderizableComponents();

    public void enter();

    public void exit();
}
