
package kata.rpg.components;

import kata.rpg.Actor;
import kata.rpg.ActorHelper;

public class AttackComponent extends Component {
    
    private static final String COMPONENT_NAME = "AttackComponent";

    private long range;
    private long baseDamage;

    public AttackComponent(long range, long baseDamage){
        this.range = range;
        this.baseDamage = baseDamage;

    }

    public long dealDamage(Actor target) {
        if (target == super.owner) {
            return 0;
        }
        
        if ( this.range < ActorHelper.distance(this.owner, target)) {
            return 0;
        }

        if (ActorHelper.checkAlliance(owner, target)){
            return 0;
        }

        HealthComponent healthComponent = (HealthComponent) target.getComponent("HealthComponent");
        if (healthComponent == null)
            return 0;

        long healthDelta = updateHealthDeltaDependingLevel(target, baseDamage);
        healthDelta *= (-1);


        healthComponent.updateHealth( healthDelta );
        return healthDelta;
    }

    public static AttackComponent addComponentToActor(Actor actor, long range, long baseDamage){
        AttackComponent component = new AttackComponent(range, baseDamage);
        actor.addComponent(COMPONENT_NAME,component);
        return component;
    }

    public static AttackComponent getComponentFromActor(Actor actor){
        Component component = actor.getComponent(COMPONENT_NAME);
        if (component == null) {
            return null;
        }

        return (AttackComponent) component;
    }

    private int getActorCurrentLevel(Actor actor) {
        LevelComponent levelComponent = (LevelComponent) actor.getComponent("LevelComponent");
        if (levelComponent != null ){
            return levelComponent.getCurrentLevel();
        }
        else {
            return -1;
        }
    }

    private long updateHealthDeltaDependingLevel(Actor target, long healthDelta) {
        int targetLevel = getActorCurrentLevel(target);
        int myLevel = getActorCurrentLevel(this.owner);
        if ((targetLevel == -1) || 
            (myLevel == -1)){
            return healthDelta;
        }


        int levelDiff = targetLevel - myLevel;
        long result = healthDelta;
        if (levelDiff > 5) {
            //If the target is 5 or more Levels above the attacker, Damage is reduced by 50%
            result = (long) (healthDelta * 0.5);
        }

        levelDiff = myLevel - targetLevel;
        if (levelDiff > 5){
            //If the target is 5 or more levels below the attacker, Damage is increased by 50%
            result = (long) (healthDelta * 1.5);
        }
        return result;
    }
}
