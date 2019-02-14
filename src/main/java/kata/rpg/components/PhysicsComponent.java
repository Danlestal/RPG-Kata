package kata.rpg.components;

import kata.rpg.Actor;
import kata.rpg.physics.BoundingBox;

public class PhysicsComponent extends Component {

    private static final String COMPONENT_NAME = "PhysicsComponent";

    private BoundingBox box;

    public PhysicsComponent(BoundingBox box) {
        this.box = box;
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

	public BoundingBox getBoundingBox() {
		return box;
	}

}