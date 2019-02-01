package kata.rpg;

import kata.rpg.components.*;

public class Character {

    private Actor actor;

    public Character(Actor actor){
        this.actor = actor;
    }

    public Actor getActor(){
        return this.actor;
    }

    public void attack(Actor target) {
        AttackComponent component = (AttackComponent) actor.getComponent("AttackComponent");
        component.dealDamage(target);
    }

    public void heal(Character target) {
        HealingComponent component = (HealingComponent) actor.getComponent("HealingComponent");
        component.heal(target.getActor());

    }

}