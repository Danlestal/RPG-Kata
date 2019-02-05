
package kata.rpg;
import kata.rpg.graphics.Renderer;
import kata.rpg.states.State;



public class SceneRender {

    private final Renderer renderer;
    private final State state;

    public SceneRender(Renderer renderer, State state){
        this.renderer = renderer;
        this.state = state;
    }

    public void render(float alpha) {
        renderer.clear();
        renderer.begin();
        renderer.render(this.state, alpha);
        renderer.end();
    }

    public boolean isClosing(){
        return renderer.isClosing();
    }

    public void dispose(){
        renderer.dispose();
    }
}