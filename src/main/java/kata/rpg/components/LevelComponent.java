
package kata.rpg.components;

import kata.rpg.Actor;

public class LevelComponent extends Component {
    private static final String COMPONENT_NAME = "LevelComponent";
    private int currentLevel;

    public LevelComponent(int level){
        this.currentLevel = level;
    }

    /**
     * @return the currentLevel
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * @param currentLevel the currentLevel to set
     */
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public static LevelComponent addComponentToActor(Actor actor, int level){
        LevelComponent component = new LevelComponent(level);
        actor.addComponent(COMPONENT_NAME,component);
        return component;
    }

    public static LevelComponent getComponentFromActor(Actor actor){
        Component component = actor.getComponent(COMPONENT_NAME);
        if (component == null) {
            return null;
        }

        return (LevelComponent) component;
    }

    
}