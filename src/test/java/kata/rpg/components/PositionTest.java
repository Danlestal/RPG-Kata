
package kata.rpg.components;

import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class PositionTest 
{

    @Test(expected = IllegalArgumentException.class)
    public void calculateDistanceNullParameter()
    {
        Position pos = new Position(0,0,0);
        pos.distance(null);
    }

    @Test
    public void calculateDistance()
    {
        Position pos = new Position(0,0,0);
        Position otherPos = new Position(1,1,1);
        assertTrue(pos.distance(otherPos) == 1);
    }
}
