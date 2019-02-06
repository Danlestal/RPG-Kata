
package kata.rpg.components;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import kata.rpg.Actor;
import kata.rpg.orders.Order;

public class OrdersExecutionComponent extends Component {
    private static final String COMPONENT_NAME = "OrdersExecutionComponent";
    private static final int MAX_ORDERS = 3;

    private Queue<Order> orders;


    public OrdersExecutionComponent() {
        orders = new ArrayBlockingQueue<Order>(MAX_ORDERS);
    }

    public void addOrder(Order newOrder) {
        newOrder.setActor(this.owner);
        orders.add(newOrder);
    }

    public void clearOrders(){
        orders.clear();
    }

    public void updateOrders(){
        Order order = orders.peek();
        if (order == null) {
            return;
        }

        order.execute();
        if (order.isComplete()) {
            orders.remove();
        }
    }

    public static OrdersExecutionComponent addComponentToActor(Actor actor){
        OrdersExecutionComponent component = new OrdersExecutionComponent();
        actor.addComponent(COMPONENT_NAME,component);
        return component;
    }

    public static OrdersExecutionComponent getComponentFromActor(Actor actor){
        Component component = actor.getComponent(COMPONENT_NAME);
        if (component == null) {
            return null;
        }

        return (OrdersExecutionComponent) component;
    }
}