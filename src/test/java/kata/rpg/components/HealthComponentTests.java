
package kata.rpg.components;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import org.junit.Test;


public class HealthComponentTests 
{

    @Test
    public void updateHealthMaxReached()
    {
        HealthComponent component = new HealthComponent(10);
        component.updateHealth(-11);
        assertTrue(component.getHealth() == 0);
        component.updateHealth(15);
        assertTrue(component.getHealth() == 10);
    }

    @Test
    public void isAlive()
    {
        HealthComponent component = new HealthComponent(10);
        assertTrue(component.isAlive());
        component.updateHealth(-11);
        assertFalse(component.isAlive());
    }
}