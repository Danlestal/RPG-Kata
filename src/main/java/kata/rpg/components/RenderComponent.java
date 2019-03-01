
package kata.rpg.components;

import kata.lwjgl.math.Vector2f;
import kata.rpg.Actor;
import kata.rpg.eventsystem.Event;
import kata.rpg.eventsystem.GameEventType;
import kata.rpg.eventsystem.SubscribeComponent;
import kata.rpg.graphics.LWJGLRenderer;

public class RenderComponent extends Component implements SubscribeComponent {

    private static final String COMPONENT_NAME = "RenderComponent";
    private RenderData data;

    public RenderComponent(RenderData data) {
        this.data = data;
    }


    public void render(LWJGLRenderer renderer, float alpha) {
        //this.data.texture.bind();
        Vector2f interpolated = BidimensionalPositionComponent.getComponentFromActor(this.owner).lerp(alpha);
        renderer.drawTextureRegion( this.data.texture,
                interpolated.x,
                interpolated.y,
                this.data.tx,
                this.data.ty,
                this.data.width,
                this.data.height,
                this.data.color);
    }

    @Override
    public void receiveEvent(GameEventType type, Event event) {

    }

    public static RenderComponent addComponentToActor(Actor actor, RenderData data) {

        RenderComponent component = new RenderComponent(data);
        actor.addComponent(COMPONENT_NAME,component);
        return component;
    }

    public static RenderComponent getComponentFromActor(Actor actor){
        Component component = actor.getComponent(COMPONENT_NAME);
        if (component == null) {
            return null;
        }

        return (RenderComponent) component;
    }



}
