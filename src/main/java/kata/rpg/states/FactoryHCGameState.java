package kata.rpg.states;

import kata.lwjgl.graphic.Color;
import kata.lwjgl.graphic.Texture;
import kata.lwjgl.math.Vector2f;
import kata.rpg.Actor;
import kata.rpg.components.BidimensionalPositionComponent;
import kata.rpg.components.RenderComponent;
import kata.rpg.components.RenderData;

public class FactoryHCGameState {


    public static GameState create() { 
        GameState state = new GameState();

        Actor targetActor = new Actor();
        BidimensionalPositionComponent.addComponentToActor(targetActor, new Vector2f(0,0));
        
        Texture texture = Texture.loadTexture("resources/pong.png");
        RenderData data = new RenderData(Color.RED,
                                            texture,
                                            5, 
                                            (200 - 100) / 2,
                                            2,
                                            2);

        RenderComponent.addComponentToActor(targetActor,data);

        state.addActor(targetActor);
        return state;
    }
}