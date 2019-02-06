package kata.rpg.orders;

import kata.rpg.Actor;

public abstract class Order {

    protected Actor actor;

    public void setActor(Actor actor){
        this.actor = actor;
    }
    
    public abstract void execute();
    public abstract boolean isComplete();
}