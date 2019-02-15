package kata.rpg.eventsystem.events;

import kata.lwjgl.math.Vector2f;
import kata.rpg.eventsystem.Event;

public class PositionUpdateEvent extends Event {

    private final Vector2f previousPosition;
    private final Vector2f position;

    public PositionUpdateEvent(Vector2f previousPosition, Vector2f position) {
        super();
        this.previousPosition = previousPosition;
        this.position = position;
    }

    public Vector2f getPreviousPosition() {
        return previousPosition;
    }

    public Vector2f getPosition() {
        return position;
    }
}
