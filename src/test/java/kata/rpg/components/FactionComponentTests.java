
package kata.rpg.components;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import kata.rpg.Actor;


public class FactionComponentTests 
{

    @Test
    public void actorsNotAllied()
    {
        Actor firstActor = new Actor();
        Actor secondActor = new Actor();

        String[] firstActorFactions = {"good"};
        FactionComponent firstFactionComponent = FactionComponent.addComponentToActor(firstActor, firstActorFactions);

        String[] secondActorFactions = {"bad"};
        FactionComponent.addComponentToActor(secondActor, secondActorFactions);

        assertFalse(firstFactionComponent.isAllied(secondActor));
    }

    @Test
    public void actorsAreAllied()
    {
        Actor firstActor = new Actor();
        Actor secondActor = new Actor();

        String[] firstActorFactions = {"good"};
        FactionComponent firstFactionComponent = FactionComponent.addComponentToActor(firstActor, firstActorFactions);

        String[] secondActorFactions = {"good", "chaotic"};
        FactionComponent.addComponentToActor(secondActor, secondActorFactions);

        assertTrue(firstFactionComponent.isAllied(secondActor));
    }

}