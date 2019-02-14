package kata.rpg.physics;

import java.util.ArrayList;
import java.util.List;

import kata.rpg.components.PhysicsComponent;



public class NaiveBroadPhase implements BroadPhase {
    @Override
    public List<Collision> detectCollisions(PhysicsComponent[] physComponents) {

        List<Collision> result = new ArrayList<Collision>();

        for (int i = 0; i < physComponents.length -1; i++)
        {
            BoundingBox firstBox = physComponents[i].getBoundingBox();
            for (int e = i + 1; e < physComponents.length; e++)
            {
                BoundingBox secondBox = physComponents[e].getBoundingBox();
                if (firstBox.collides(secondBox)){
                    result.add(new Collision(physComponents[i], physComponents[e]));
                }
            }
        }

        return result;
    }

}