package kata.rpg.components;

import kata.lwjgl.math.Vector2f;
import kata.rpg.Actor;
import kata.rpg.eventsystem.GameEventType;
import kata.rpg.eventsystem.events.HeadingUpdateEvent;
import kata.rpg.eventsystem.events.PositionUpdateEvent;


public class BidimensionalPositionComponent extends Component {

    private static final String COMPONENT_NAME = "BidimensionalPositionComponent";

    private Vector2f previousPosition;
    private Vector2f position;

    private Heading heading;
    private Heading previousHeading;

    public BidimensionalPositionComponent(Vector2f position){
        super();
        this.previousPosition = position;
        this.position = position;
        this.heading = Heading.DOWN;
        this.previousHeading = Heading.DOWN;
    }

    public Vector2f getPosition() {
        return position;
    }

    public Heading getHeading(Vector2f normalizedVector) {
        float xValue = Math.abs(normalizedVector.x);
        float yValue = Math.abs(normalizedVector.y);

        if (xValue >= yValue) {
            if (normalizedVector.x <= 0)
                return Heading.LEFT;
            else
                return Heading.RIGHT;
        }
        else {
            if (normalizedVector.y <= 0)
                return Heading.DOWN;
            else
                return Heading.UP;

        }
    }

    public void setPosition(Vector2f position){
        this.heading = this.getHeading(position.subtract(this.previousPosition).normalize());
        if (this.heading != this.previousHeading) {
            this.owner.propagateInternalEvent(GameEventType.HEADING_UPDATE, new HeadingUpdateEvent(this.heading));
            this.previousHeading = this.heading;
        }

        this.previousPosition = position;
        this.position = position;
        this.owner.propagateInternalEvent(GameEventType.POSITION_UPDATE, new PositionUpdateEvent(this.previousPosition, this.position));
    }

    public float distance(BidimensionalPositionComponent otherPositionComponent) {
        return this.distance(otherPositionComponent.position);
    }

    public float distance(Vector2f otherPosition) {
        return this.position.subtract(otherPosition).length();
    }

    public Vector2f lerp(float alpha) {
        return this.position.lerp(previousPosition, alpha);
    }

    public static BidimensionalPositionComponent addComponentToActor(Actor actor, Vector2f position){
        BidimensionalPositionComponent component = new BidimensionalPositionComponent(position);
        actor.addComponent(COMPONENT_NAME, component);
        return component;
    }

    public static BidimensionalPositionComponent getComponentFromActor(Actor actor){
        Component component = actor.getComponent(COMPONENT_NAME);
        if (component == null) {
            return null;
        }
        return (BidimensionalPositionComponent) component;
    }

}