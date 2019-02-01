
package kata.rpg.components;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import kata.rpg.Actor;


public class HealingComponentTests 
{

    @Test
    public void healOnlyCanHealAllies()
    {
        Actor target = new Actor();
        String[] firstActorFactions = {"good"};
        FactionComponent.addComponentToActor(target, firstActorFactions);
        HealthComponent.addComponentToActor(target, 1000);


        Actor source = new Actor();
        FactionComponent.addComponentToActor(source, firstActorFactions);
        HealingComponent healingComponent = HealingComponent.addComponentToActor(source, 10);

        
        long result = healingComponent.heal(target);
        assertTrue(result == 10 );
    }

    @Test
    public void healOnlyCanNotHealEnemies()
    {
        Actor target = new Actor();
        String[] firstActorFactions = {"good"};
        FactionComponent.addComponentToActor(target, firstActorFactions);
        HealthComponent.addComponentToActor(target, 1000);


        Actor source = new Actor();
        String[] secondActorFactions = {"bad"};
        FactionComponent.addComponentToActor(source, secondActorFactions);
        HealingComponent healingComponent = HealingComponent.addComponentToActor(source, 10);

        
        long result = healingComponent.heal(target);
        assertTrue(result == 0 );
    }
}