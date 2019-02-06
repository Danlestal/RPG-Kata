package kata.rpg.graphics;
import kata.rpg.states.State;

public interface Renderer {

    public void init();
    public void begin();
    public void render(State state, float alpha);
    public void end();
    public void clear();

    public void dispose();
    public boolean isClosing();
}