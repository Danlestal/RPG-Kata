package kata.rpg.physics;

import kata.lwjgl.math.Vector2f;

public class BoundingBox {
    public Vector2f min;
    public Vector2f max;

    public Boolean collides(BoundingBox another) {

        float d1x = another.min.x - this.max.x;
        float d1y = another.min.y - this.max.y;
        float d2x = another.min.x - this.max.x;
        float d2y = another.min.y - this.max.y;

        if (d1x > 0.0f || d1y > 0.0f)
            return false;

        if (d2x > 0.0f || d2y > 0.0f)
            return false;

        return true;

    }
}
