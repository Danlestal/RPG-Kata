package kata.rpg;

import kata.lwjgl.math.Vector2f;

public class PositionUpdateAction extends GameAction {
    private final Vector2f previousPosition;
    private final Vector2f newPosition;

    public  PositionUpdateAction(Vector2f previousPosition, Vector2f newPosition){
        super.type = GameMessageType.POSITION_UPDATE;
        this.previousPosition = previousPosition;
        this.newPosition = newPosition;
    }


    public Vector2f getPreviousPosition() {
        return previousPosition;
    }

    public Vector2f getNewPosition() {
        return newPosition;
    }
}
