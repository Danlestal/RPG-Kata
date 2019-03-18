package kata.rpg.eventsystem.events;

import kata.rpg.components.Heading;
import kata.rpg.eventsystem.Event;

public class HeadingUpdateEvent extends Event {

    private final Heading heading;

    public HeadingUpdateEvent(Heading heading) {
        super();
        this.heading = heading;
    }


    public Heading getHeading() {
        return this.heading;
    }
}
