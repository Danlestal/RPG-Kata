
package kata.rpg.physics;

import kata.lwjgl.math.Vector2f;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)

public class BoundingBoxTests
{

    @Test
    public void collidesShouldCollideExactlyInTheBorder()
    {
        BoundingBox first = new BoundingBox(new Vector2f(0,0), 20);
        BoundingBox second = new BoundingBox(new Vector2f(20,20), 20);
        assertTrue(first.collides(second));
    }


    @Test
    public void collidesShouldCollide()
    {
        BoundingBox first = new BoundingBox(new Vector2f(0,0), 20);
        BoundingBox second = new BoundingBox(new Vector2f(15,20), 20);
        assertTrue(first.collides(second));
    }

    @Test
    public void collidesShouldNotCollide_ERROR()
    {
        BoundingBox first = new BoundingBox(new Vector2f(386,287), 10);
        BoundingBox second = new BoundingBox(new Vector2f(100,100), 10);
        assertFalse(first.collides(second));
    }
}
