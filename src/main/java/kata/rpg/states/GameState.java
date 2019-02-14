
package kata.rpg.states;

import kata.lwjgl.graphic.Color;
import kata.lwjgl.graphic.Texture;
import kata.lwjgl.math.Vector2f;
import kata.rpg.Actor;
import kata.rpg.components.*;
import kata.rpg.orders.MoveOrder;
import kata.rpg.orders.Order;
import kata.rpg.physics.BoundingBox;
import kata.rpg.physics.NaiveBroadPhase;
import kata.rpg.physics.PhysEngine;

import java.util.ArrayList;
import java.util.List;

public class GameState implements State {

    private List<Actor> actorList;
    private PhysEngine physics;

    public GameState() {
        this.actorList =  new ArrayList<Actor>();
        physics = new PhysEngine(this, new NaiveBroadPhase());
        
    }

    @Override
    public void input() {
    }

    @Override
    public void update(float delta) {
        for(Actor actor : this.actorList) {
            OrdersExecutionComponent component = (OrdersExecutionComponent) actor.getComponent("OrdersExecutionComponent");
            if ( component != null ){
                component.updateOrders();
            }
        }

        physics.update();
    }

    @Override
    public void enter() {
        // Esto son recursos estaticos 
        Texture texture = Texture.loadTexture("resources/walkAnim.png");

        texture.bind();

        // Actores
        Actor targetActor = new Actor();
        Vector2f initialPosition = new Vector2f(400, 300);
        BidimensionalPositionComponent.addComponentToActor(targetActor,initialPosition);
        PhysicsComponent.addComponentToActor(targetActor, new BoundingBox(initialPosition, 20));
        RenderData data = new RenderData(Color.WHITE,
                                            texture,
                                            50, 
                                            60,
                                            50,
                                            60);
        RenderComponent.addComponentToActor(targetActor,data);
        OrdersExecutionComponent ordersComponent  = OrdersExecutionComponent.addComponentToActor(targetActor);
        Order newMovementOrder = new MoveOrder(new Vector2f(0, 0));
        ordersComponent.addOrder(newMovementOrder);

        Order otherMovementOrder = new MoveOrder(new Vector2f(200, 50));
        ordersComponent.addOrder(otherMovementOrder);

        Order anotherMovementOrder = new MoveOrder(new Vector2f(600, 500));
        ordersComponent.addOrder(anotherMovementOrder);


        this.actorList.add(targetActor);


        // Actores
        Actor otherActor = new Actor();
        Vector2f otherPosition = new Vector2f(100, 100);
        BidimensionalPositionComponent.addComponentToActor(otherActor, otherPosition);
        PhysicsComponent.addComponentToActor(otherActor, new BoundingBox(otherPosition, 20));
        RenderComponent.addComponentToActor(otherActor,data);
        this.actorList.add(otherActor);
    }

    @Override
    public void exit() {
        System.out.println("Finalizando el juego");
    }

    @Override
    public Iterable<RenderComponent> getRenderizableComponents() {
        ArrayList<RenderComponent> result = new ArrayList<RenderComponent>();
        for(Actor actor : this.actorList) {
            RenderComponent component = (RenderComponent) actor.getComponent("RenderComponent");
            if ( component != null ){
                result.add(component);
            }
        }
        return result;
    }

	public PhysicsComponent[] getPhysicsComponents() {
		ArrayList<PhysicsComponent> result = new ArrayList<PhysicsComponent>();
        for(Actor actor : this.actorList) {
            PhysicsComponent component = (PhysicsComponent) actor.getComponent("PhysicsComponent");
            if ( component != null ){
                result.add(component);
            }
        }
        return result.toArray(new PhysicsComponent[0]);
	}




}
