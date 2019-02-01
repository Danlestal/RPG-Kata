
package kata.rpg.components;

import java.util.HashSet;
import java.util.Set;

import kata.rpg.Actor;

public class FactionComponent extends Component {
    private static final String COMPONENT_NAME = "FactionComponent";
    private Set<String> factions;

    public FactionComponent(){
        this.factions = new HashSet<String>();
    }

    public FactionComponent(String[] factions){
        this.factions = new HashSet<String>();
        this.addFaction(factions);

    }

    public void addFaction(String faction){
        this.factions.add(faction);
    }

    public void addFaction(String[] factions){
        for (String faction : factions) {
            addFaction(faction);
        }
    }

    public Boolean isAllied(Actor otherActor) {

        FactionComponent otherFactionComponent = FactionComponent.getComponentFromActor(otherActor);
        if (otherFactionComponent == null ) {
            return true;
        }

        Set<String> intersection = new HashSet<String>(this.factions);
        intersection.retainAll(otherFactionComponent.factions);
        return intersection.size() > 0;
    }

    public static FactionComponent addComponentToActor(Actor actor, String[] factions){
        FactionComponent component = new FactionComponent(factions);
        actor.addComponent(COMPONENT_NAME,component);
        return component;
    }

    public static FactionComponent getComponentFromActor(Actor actor){
        Component component = actor.getComponent(COMPONENT_NAME);
        if (component == null) {
            return null;
        }

        return (FactionComponent) component;
    }
}