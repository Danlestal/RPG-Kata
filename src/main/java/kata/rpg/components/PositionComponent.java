package kata.rpg.components;

import kata.rpg.Actor;

public class PositionComponent extends Component {

    private static final String COMPONENT_NAME = "PositionComponent";

    private Position position;

    public PositionComponent(Position position){
        super();
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public double distance(PositionComponent otherChar) {
        return this.position.distance(otherChar.position);
    }

    public static PositionComponent addComponentToActor(Actor actor, Position position){
        PositionComponent component = new PositionComponent(position);
        actor.addComponent(COMPONENT_NAME,component);
        return component;
    }

    public static PositionComponent getComponentFromActor(Actor actor){
        Component component = actor.getComponent(COMPONENT_NAME);
        if (component == null) {
            return null;
        }
        return (PositionComponent) component;
    }
}