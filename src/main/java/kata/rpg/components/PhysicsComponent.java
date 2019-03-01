package kata.rpg.components;

import kata.rpg.Actor;
import kata.rpg.eventsystem.Event;
import kata.rpg.eventsystem.GameEventType;
import kata.rpg.eventsystem.SubscribeComponent;
import kata.rpg.eventsystem.events.PositionUpdateEvent;
import kata.rpg.physics.BoundingBox;

public class PhysicsComponent extends Component implements SubscribeComponent {

    private static final String COMPONENT_NAME = "PhysicsComponent";

    private BoundingBox box;

    public PhysicsComponent(BoundingBox box) {
        this.box = box;
    }

    public BoundingBox getBoundingBox() {
        return box;
    }

    @Override
    public void receiveEvent(GameEventType type, Event event) {
        switch (type){
            case POSITION_UPDATE:
                PositionUpdateEvent posEvent = (PositionUpdateEvent) event;
                this.box.centerToPosition(posEvent.getPosition());
        }

    }

    public static PhysicsComponent addComponentToActor(Actor actor, BoundingBox position){
        PhysicsComponent component = new PhysicsComponent(position);
        actor.addComponent(COMPONENT_NAME, component);
        return component;
    }

    public static PhysicsComponent getComponentFromActor(Actor actor){
        Component component = actor.getComponent(COMPONENT_NAME);
        if (component == null) {
            return null;
        }
        return (PhysicsComponent) component;
    }


}