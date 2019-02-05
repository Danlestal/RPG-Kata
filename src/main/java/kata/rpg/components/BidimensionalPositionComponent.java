package kata.rpg.components;

import kata.lwjgl.math.Vector2f;
import kata.rpg.Actor;

public class BidimensionalPositionComponent extends Component {

    private static final String COMPONENT_NAME = "BidimensionalPositionComponent";

    private Vector2f previousPosition;
    private Vector2f position;

    public BidimensionalPositionComponent(Vector2f position){
        super();
        this.previousPosition = position;
        this.position = position;
    }

    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(Vector2f position){
        this.previousPosition = position;
        this.position = position;
    }

    public float distance(BidimensionalPositionComponent otherPosition) {
        return this.position.subtract(otherPosition.position).length();
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