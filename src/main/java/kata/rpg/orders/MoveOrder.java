package kata.rpg.orders;

import kata.lwjgl.math.Vector2f;
import kata.rpg.Actor;
import kata.rpg.components.BidimensionalPositionComponent;

public class MoveOrder extends Order {

    private BidimensionalPositionComponent positionComponent;
    private static final float moveOrderThreshold = 1;
    private float moveOrderStep = 10;
    private Vector2f destination;

    public MoveOrder( Vector2f destination) {
        this.destination = destination;
    }

    @Override
    public void setActor(Actor actor){
        super.setActor(actor);
        this.positionComponent = BidimensionalPositionComponent.getComponentFromActor(actor);
    }

    
    @Override
    public void execute() {
        Vector2f currentPosition = this.positionComponent.getPosition();
        Vector2f directionVector = this.destination.subtract(currentPosition).normalize();
        Vector2f newPosition = currentPosition.add(directionVector.scale(moveOrderStep));
        this.positionComponent.setPosition(newPosition);
    }

    @Override
    public boolean isComplete() {
        return this.positionComponent.distance(destination) < moveOrderThreshold;
    }

}