package kata.rpg.eventsystem;

import java.util.ArrayList;
import java.util.List;

public class ActorInternalEventsHub {

    private List<SubscribeComponent> subscribers = new ArrayList<SubscribeComponent>();


    public void addSubscriber(SubscribeComponent channel) {
        this.subscribers.add(channel);
    }

    public void propagateEvent(GameEventType eventType, Event event) {
        for (SubscribeComponent component : this.subscribers) {
            component.receiveEvent(eventType, event);
        }
    }
}