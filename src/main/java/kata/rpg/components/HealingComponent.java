
package kata.rpg.components;

import kata.rpg.Actor;
import kata.rpg.ActorHelper;

public class HealingComponent extends Component {
    private static final String COMPONENT_NAME = "HealingComponent";

    private long healAmount;
    
    public HealingComponent(long healAmount){
        this.healAmount = healAmount;
    }
    
    public long heal(Actor target) {

        if ( (target != owner) && (!ActorHelper.checkAlliance(owner, target))){
            return 0;
        }

        HealthComponent component = HealthComponent.getComponentFromActor(target);
        if (component.isAlive()) {
            component.updateHealth( healAmount );
            return healAmount;
        }

        return 0;
    }

    public static HealingComponent addComponentToActor(Actor actor, long healAmount){
        HealingComponent component = new HealingComponent(healAmount);
        actor.addComponent(COMPONENT_NAME,component);
        return component;
    }

    public static HealingComponent getComponentFromActor(Actor actor){
        Component component = actor.getComponent(COMPONENT_NAME);
        if (component == null) {
            return null;
        }

        return (HealingComponent) component;
    }
}
