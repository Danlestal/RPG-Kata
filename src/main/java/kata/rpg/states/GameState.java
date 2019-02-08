
package kata.rpg.states;

import java.util.ArrayList;
import java.util.List;

import kata.lwjgl.graphic.Color;
import kata.lwjgl.graphic.Texture;
import kata.lwjgl.math.Vector2f;
import kata.rpg.Actor;
import kata.rpg.components.BidimensionalPositionComponent;
import kata.rpg.components.OrdersExecutionComponent;
import kata.rpg.components.RenderComponent;
import kata.rpg.components.RenderData;
import kata.rpg.orders.MoveOrder;
import kata.rpg.orders.Order;

public class GameState implements State {

    private List<Actor> actorList;

    public GameState() {
        this.actorList =  new ArrayList<Actor>();
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
    }

    @Override
    public void enter() {
        // Esto son recursos estaticos 
        Texture texture = Texture.loadTexture("resources/walkAnim.png");

        texture.bind();

        // Actores
        Actor targetActor = new Actor();
        BidimensionalPositionComponent.addComponentToActor(targetActor, new Vector2f(400, 300));
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



}
