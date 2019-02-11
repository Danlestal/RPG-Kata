package kata.rpg.physics;

import kata.rpg.components.PhysicsComponent;

public class Collision {

    private PhysicsComponent firstItem;
    private PhysicsComponent secondItem;

    public Collision(PhysicsComponent firstItem, PhysicsComponent secondItem) {
        this.setFirstItem(firstItem);
        this.setSecondItem(secondItem);
    }

    /**
     * @return the secondItem
     */
    public PhysicsComponent getSecondItem() {
        return secondItem;
    }

    /**
     * @param secondItem the secondItem to set
     */
    public void setSecondItem(PhysicsComponent secondItem) {
        this.secondItem = secondItem;
    }

    /**
     * @return the firstItem
     */
    public PhysicsComponent getFirstItem() {
        return firstItem;
    }

    /**
     * @param firstItem the firstItem to set
     */
    public void setFirstItem(PhysicsComponent firstItem) {
        this.firstItem = firstItem;
    }

}