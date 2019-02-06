
package kata.rpg.states;

import java.util.ArrayList;
import java.util.List;

import kata.lwjgl.graphic.Color;
import kata.lwjgl.graphic.Texture;
import kata.lwjgl.math.Vector2f;
import kata.rpg.Actor;
import kata.rpg.components.BidimensionalPositionComponent;
import kata.rpg.components.RenderComponent;
import kata.rpg.components.RenderData;

public class GameState implements State {


    private List<Actor> actorList;

    public GameState() {
        this.actorList =  new ArrayList<Actor>();
    }

    @Override
    public void input() {
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void enter() {
        // Esto son recursos estaticos*/
        Texture texture = Texture.loadTexture("resources/pong.png");
        texture.bind();

        /* Ctes de juego
        float speed = 250f;
        playerScore = 0;
        opponentScore = 0;
        gameWidth = width;
        gameHeight = height;
        */

        // Actores*/
        Actor targetActor = new Actor();
        BidimensionalPositionComponent.addComponentToActor(targetActor, new Vector2f(400, 300));
        RenderData data = new RenderData(Color.BLACK,
                                            texture,
                                            20, 
                                            100,
                                            0,
                                            0);
        this.actorList.add(targetActor);

        RenderComponent.addComponentToActor(targetActor,data);
        
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
