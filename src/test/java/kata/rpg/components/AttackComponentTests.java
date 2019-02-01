
package kata.rpg.components;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.mockito.Matchers.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import kata.rpg.Actor;
import kata.rpg.ActorHelper;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ActorHelper.class)
public class AttackComponentTests 
{

    @Test
    public void dealDamageErrorAttackerSameThanTarget()
    {
        Actor targetActor = new Actor();
        AttackComponent component = AttackComponent.addComponentToActor(targetActor, 1, 10);
        long damageDealt = component.dealDamage(targetActor);
        assertTrue(damageDealt == 0);
    }

    @Test
    public void dealDamageErrorOutOfRange()
    {

        Actor attacker = new Actor();
        Actor targetActor = new Actor();

        PowerMockito.mockStatic(ActorHelper.class);
        Mockito.when(ActorHelper.distance(any(Actor.class), any(Actor.class))).thenReturn((double) 2);

        AttackComponent component = AttackComponent.addComponentToActor(attacker, 1, 10);
        long damageDealt = component.dealDamage(targetActor);
        assertTrue(damageDealt == 0);
    }

    @Test
    public void dealDamageErrorAreAllies()
    {
        Actor attacker = new Actor();
        Actor targetActor = new Actor();

        PowerMockito.mockStatic(ActorHelper.class);
        Mockito.when(ActorHelper.distance(any(Actor.class), any(Actor.class))).thenReturn((double) 1);
        Mockito.when(ActorHelper.checkAlliance(any(Actor.class), any(Actor.class))).thenReturn(true);

        AttackComponent component = AttackComponent.addComponentToActor(attacker, 2, 10);
        long damageDealt = component.dealDamage(targetActor);
        assertTrue(damageDealt == 0);
    }

    @Test
    public void dealDamageTargetWithoutHealth()
    {
        Actor attacker = new Actor();
        Actor targetActor = new Actor();

        PowerMockito.mockStatic(ActorHelper.class);
        Mockito.when(ActorHelper.distance(any(Actor.class), any(Actor.class))).thenReturn((double) 1);
        Mockito.when(ActorHelper.checkAlliance(any(Actor.class), any(Actor.class))).thenReturn(false);


        AttackComponent component = AttackComponent.addComponentToActor(attacker, 2, 10);

        long damageDealt = component.dealDamage(targetActor);
        assertTrue(damageDealt == 0);
    }

    @Test
    public void dealDamageNoLevelDifference()
    {
        Actor attacker = new Actor();
        Actor targetActor = new Actor();
        HealthComponent.addComponentToActor(targetActor, 1000);


        PowerMockito.mockStatic(ActorHelper.class);
        Mockito.when(ActorHelper.distance(any(Actor.class), any(Actor.class))).thenReturn((double) 1);
        Mockito.when(ActorHelper.checkAlliance(any(Actor.class), any(Actor.class))).thenReturn(false);


        AttackComponent component = AttackComponent.addComponentToActor(attacker, 2, 10);

        long damageDealt = component.dealDamage(targetActor);
        assertTrue(damageDealt == -10);
    }

    @Test
    public void dealDamageLevelDifferencePlus5()
    {
        Actor attacker = new Actor();
        LevelComponent.addComponentToActor(attacker, 10);
        
        Actor targetActor = new Actor();
        HealthComponent.addComponentToActor(targetActor, 1000);
        LevelComponent.addComponentToActor(targetActor, 1);



        PowerMockito.mockStatic(ActorHelper.class);
        Mockito.when(ActorHelper.distance(any(Actor.class), any(Actor.class))).thenReturn((double) 1);
        Mockito.when(ActorHelper.checkAlliance(any(Actor.class), any(Actor.class))).thenReturn(false);


        AttackComponent component = AttackComponent.addComponentToActor(attacker, 2, 10);

        long damageDealt = component.dealDamage(targetActor);
        assertTrue(damageDealt == -15);
    }

    @Test
    public void dealDamageLevelDifferenceMinus5()
    {
        Actor attacker = new Actor();
        LevelComponent.addComponentToActor(attacker, 1);
        Actor targetActor = new Actor();
        LevelComponent.addComponentToActor(targetActor, 10);
        HealthComponent.addComponentToActor(targetActor, 1000);

        PowerMockito.mockStatic(ActorHelper.class);
        Mockito.when(ActorHelper.distance(any(Actor.class), any(Actor.class))).thenReturn((double) 1);
        Mockito.when(ActorHelper.checkAlliance(any(Actor.class), any(Actor.class))).thenReturn(false);


        AttackComponent component = AttackComponent.addComponentToActor(attacker, 2, 10);

        long damageDealt = component.dealDamage(targetActor);
        assertTrue(damageDealt == -5);
    }


}
