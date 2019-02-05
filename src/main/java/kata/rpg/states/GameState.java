
package kata.rpg.states;

import java.util.ArrayList;
import java.util.List;

import kata.rpg.Actor;
import kata.rpg.components.RenderComponent;

public class GameState implements State {


    private List<Actor> actorList;

    public GameState() {
        this.actorList =  new ArrayList<Actor>();
    }

    public void addActor(Actor newActor) {
        this.actorList.add(newActor);
    }


    @Override
    public void input() {
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void enter() {
        System.out.println("Iniciando el juego");
    }

    @Override
    public void exit() {
        System.out.println("Finalizando el juego");
    }

    @Override
    public Iterable<RenderComponent> getRenderizableComponents() {
        ArrayList<RenderComponent> result = new ArrayList<RenderComponent>();
        for(Actor actor : this.actorList) {
            RenderComponent component = (RenderComponent) actor.getComponent("RenderComponent");
            if ( component != null ){
                result.add(component);
            }
        }
        return result;
    }



}
