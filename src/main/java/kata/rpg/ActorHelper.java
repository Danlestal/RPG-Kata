package kata.rpg;

import kata.rpg.components.FactionComponent;
import kata.rpg.components.Position;
import kata.rpg.components.PositionComponent;

public class ActorHelper {

    public static boolean checkAlliance(Actor firstActor, Actor secondActor) {
        FactionComponent factionComponent = FactionComponent.getComponentFromActor(firstActor);
        if (factionComponent == null ) {
            return false;
        }

        return factionComponent.isAllied(secondActor);

    }

    private static Position getActorCurrentPosition(Actor actor) {
        PositionComponent levelComponent = (PositionComponent) actor.getComponent("Position");
        if (levelComponent != null ){
            return levelComponent.getPosition();
        }
        else {
            return null;
        }

    }

    public static double distance(Actor firstActor, Actor secondActor) {
        Position myPosition = getActorCurrentPosition(firstActor);
        Position targetPosition = getActorCurrentPosition(secondActor);
        if ((myPosition == null) || (targetPosition == null)) {
            return -1;
        }

        return myPosition.distance(targetPosition);

    }
}