package kata.rpg.components;

import kata.rpg.Actor;

public abstract class Component {
    protected Actor owner;

    public void setOwner(Actor owner){
        this.owner = owner;
    }
}