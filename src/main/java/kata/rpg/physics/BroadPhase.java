package kata.rpg.physics;

import kata.rpg.components.PhysicsComponent;

import java.util.List;

public interface BroadPhase {
    List<Collision> detectCollisions(PhysicsComponent[] physComponents);
}