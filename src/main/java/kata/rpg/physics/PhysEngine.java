package kata.rpg.physics;

import kata.rpg.states.GameState;

public class PhysEngine {
    private BroadPhase broadPhase;
    private GameState state;

    public PhysEngine(GameState state, BroadPhase broadPhase){
        this.broadPhase = broadPhase;
        this.state = state;
    }


    public void update(){
        for(Collision collision : this.broadPhase.detectCollisions(state.getPhysicsComponents())) {
            System.out.println(String.format("collides! %s con %s ", collision.getFirstItem(), collision.getSecondItem()));
        }
    }
}