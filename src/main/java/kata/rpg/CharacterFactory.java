package kata.rpg;

import kata.rpg.components.AttackComponent;
import kata.rpg.components.HealingComponent;
import kata.rpg.components.HealthComponent;
import kata.rpg.components.Position;
import kata.rpg.components.PositionComponent;

public class CharacterFactory {

    public static Character createCharacter(Position pos){
        Actor result = new Actor();
        result.addComponent("Health", new HealthComponent(1000));
        result.addComponent("Position", new PositionComponent(pos));
        result.addComponent("AttackAction", new AttackComponent(10,10));
        result.addComponent("HealingAction", new HealingComponent(10));
        return new Character(result);
    }

    public static Character createMeleeCharacter(Position pos) {
        Actor result = new Actor();
        result.addComponent("Health", new HealthComponent(1000));
        result.addComponent("Position", new PositionComponent(pos));
        result.addComponent("AttackAction", new AttackComponent(2,10));
        result.addComponent("HealingAction", new HealingComponent(10));
        return new Character(result);
    }

    public static Character createRangerCharacter(Position pos){
        Actor result = new Actor();
        result.addComponent("Health", new HealthComponent(1000));
        result.addComponent("Position", new PositionComponent(pos));
        result.addComponent("AttackAction", new AttackComponent(20,10));
        result.addComponent("HealingAction", new HealingComponent(10));
        return new Character(result);
        
    }
}