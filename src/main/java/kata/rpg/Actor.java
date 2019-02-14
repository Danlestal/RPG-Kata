
package kata.rpg;

import kata.rpg.components.Component;

import java.util.HashMap;
import java.util.Map;

public class Actor {

    private Map<String, Component> componentStorage;

    public Actor() {
        this.componentStorage = new HashMap<String, Component>();
    }

    public void addComponent(String componentName, Component component){
        if (!componentStorage.containsKey(componentName)){
            component.setOwner(this);
            componentStorage.put(componentName, component);
        }
    }

    public Component getComponent(String componentName) {
        return componentStorage.get(componentName);
    }

    public void addUpdateMessage(Component sourceComponent, GameAction action) {

    }


    
}
