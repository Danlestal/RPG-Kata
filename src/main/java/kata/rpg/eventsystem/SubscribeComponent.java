package kata.rpg.eventsystem;

public interface SubscribeComponent {
    void receiveEvent(GameEventType type, Event event);
}