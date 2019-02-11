package kata.rpg.physics;

import java.util.List;

import kata.rpg.components.PhysicsComponent;
import kata.rpg.states.GameState;

public class PhysEngine {
    private BroadPhase broadPhase;
    private GameState state;

    public PhysEngine(GameState state, BroadPhase broadPhase){
        this.broadPhase = broadPhase;
        this.state = state;
    }

    public void update(){
        PhysicsComponent[] rigidBodies = state.getPhysicsComponents();
        for(Collision collision : this.broadPhase.detectCollisions(rigidBodies)){
            
        }

    }

}