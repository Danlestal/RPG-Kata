
package kata.rpg.components;

import kata.lwjgl.math.Vector2f;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class BidimensionalPositionComponentTests
{

    @Test
    public void getHeading_test1()
    {
        BidimensionalPositionComponent component = new BidimensionalPositionComponent(new Vector2f(0,0));
        Heading heading = component.getHeading(new Vector2f(-2, -1));
        assertTrue(heading == Heading.LEFT);
    }

    @Test
    public void getHeading_test2()
    {
        BidimensionalPositionComponent component = new BidimensionalPositionComponent(new Vector2f(0,0));
        Heading heading = component.getHeading(new Vector2f(1,5));
        assertTrue(heading == Heading.UP);
    }

    @Test
    public void getHeading_test3()
    {
        BidimensionalPositionComponent component = new BidimensionalPositionComponent(new Vector2f(0,0));
        Heading heading = component.getHeading(new Vector2f(4,-2));
        assertTrue(heading == Heading.RIGHT);
    }

    @Test
    public void getHeading_test4()
    {
        BidimensionalPositionComponent component = new BidimensionalPositionComponent(new Vector2f(0,0));
        Heading heading = component.getHeading(new Vector2f(1,-2));
        assertTrue(heading == Heading.DOWN);
    }
}
