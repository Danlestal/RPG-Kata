package kata.rpg.physics;

import kata.lwjgl.math.Vector2f;

public class BoundingBox {
    public Vector2f min;
    public Vector2f max;

    public BoundingBox(Vector2f min, Vector2f max){
        this.min = min;
        this.max = max;
    }

    public BoundingBox(Vector2f position, float width){
        this.centerToPosition(position, width);
    }

    public Vector2f diagonal(){
        return max.subtract(min);
    }

    public Vector2f diagonalNormalized(){
        return max.subtract(min).normalize();
    }

    public float diagonalLength(){
        return max.subtract(min).length();
    }

    public void centerToPosition(Vector2f newCenter){
        Vector2f gradient = this.diagonalNormalized().scale( (diagonalLength()/2) );
        this.min = newCenter.subtract(gradient);
        this.max = newCenter.add(gradient);
    }

    public void centerToPosition(Vector2f newCenter, float width){
        float halfWidth = width / 2;
        Vector2f halfWidthVector = new Vector2f(halfWidth, halfWidth);
        this.min = newCenter.subtract(halfWidthVector);
        this.max = newCenter.add(halfWidthVector);
    }

    public void updatePosition(Vector2f add){
        this.min = this.min.add(add);
        this.max = this.max.add(add);
    }
    
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
