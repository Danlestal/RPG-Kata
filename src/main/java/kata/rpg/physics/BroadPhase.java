package kata.rpg.physics;

import java.util.List;

import kata.rpg.components.PhysicsComponent;

public interface BroadPhase {
    public List<Collision> detectCollisions(PhysicsComponent[] rigidBodies);
}