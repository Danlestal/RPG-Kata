package kata.rpg.components;

import kata.rpg.Actor;

public class HealthComponent extends Component {

    private static final String COMPONENT_NAME = "HealthComponent";
    private long currentHealth;
    private long maximunHealth;

    public HealthComponent(long health) {
        this.currentHealth = health;
        this.maximunHealth = health;
    }

    public void updateHealth(long healthDelta) {
        this.currentHealth += healthDelta;
        if (this.currentHealth > this.maximunHealth) {
            this.currentHealth = this.maximunHealth;
        }

        if (this.currentHealth < 0){
            this.currentHealth = 0;
        }
    }

    public static HealthComponent addComponentToActor(Actor actor, long health){
        HealthComponent component = new HealthComponent(health);
        actor.addComponent(COMPONENT_NAME,component);
        return component;
    }

    public static HealthComponent getComponentFromActor(Actor actor){
        Component component = actor.getComponent(COMPONENT_NAME);
        if (component == null) {
            return null;
        }

        return (HealthComponent) component;
    }

    public boolean isAlive(){
        return (this.currentHealth > 0);
    }

    /**
     * @return the health
     */
    public long getHealth() {
        return this.currentHealth;
    }
}



