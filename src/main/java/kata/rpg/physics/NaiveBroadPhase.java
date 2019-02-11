package kata.rpg.physics;

import java.util.ArrayList;
import java.util.List;

import kata.rpg.components.PhysicsComponent;



public class NaiveBroadPhase implements BroadPhase {
    public List<Collision> detectCollisions(PhysicsComponent[] physComponent) {

        List<Collision> result = new ArrayList<Collision>();

        for (int i = 0; i < physComponent.length; i++)
        {
            BoundingBox firstBox = physComponent[i].getBoundingBox();
            for (int e = i; e < physComponent.length; e++)
            {
                BoundingBox secondBox = physComponent[e].getBoundingBox();
                if (firstBox.collides(secondBox)){
                    result.add(new Collision(physComponent[i], physComponent[e]));
                }
            }
        }

        return result;

    }
}