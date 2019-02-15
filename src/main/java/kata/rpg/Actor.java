
package kata.rpg;

import kata.rpg.components.Component;
import kata.rpg.eventsystem.ActorInternalEventsHub;
import kata.rpg.eventsystem.Event;
import kata.rpg.eventsystem.GameEventType;
import kata.rpg.eventsystem.SubscribeComponent;

import java.util.HashMap;
import java.util.Map;

public class Actor {

    private Map<String, Component> componentStorage;
    private ActorInternalEventsHub eventsHub;

    public Actor() {
        this.componentStorage = new HashMap<String, Component>();
        this.eventsHub = new ActorInternalEventsHub();
    }

    public void addComponent(String componentName, Component component){
        if (componentStorage.containsKey(componentName))
            return;

        component.setOwner(this);
        componentStorage.put(componentName, component);
        if (component instanceof SubscribeComponent) {
            eventsHub.addSubscriber((SubscribeComponent)component);
        }
    }

    public Component getComponent(String componentName) {
        return componentStorage.get(componentName);
    }

    public void propagateInternalEvent(GameEventType eventType, Event event) {
        eventsHub.propagateEvent(GameEventType.POSITION_UPDATE, event);
    }
}
