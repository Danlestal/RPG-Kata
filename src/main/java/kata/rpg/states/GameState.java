
package kata.rpg.states;

import java.util.ArrayList;
import java.util.List;

import kata.rpg.Actor;
import kata.rpg.components.RenderComponent;

public class GameState implements State {


    private List<Actor> actorList;

    public GameState() {
        this.actorList =  new ArrayList<Actor>();
    }

    public void addActor(Actor newActor) {
        this.actorList.add(newActor);
    }


    @Override
    public void input() {
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void enter() {
        /*
        //Esto es algo del renderer
        int width, height;
        try (MemoryStack stack = MemoryStack.stackPush()) {
            long window = GLFW.glfwGetCurrentContext();
            IntBuffer widthBuffer = stack.mallocInt(1);
            IntBuffer heightBuffer = stack.mallocInt(1);
            GLFW.glfwGetFramebufferSize(window, widthBuffer, heightBuffer);
            width = widthBuffer.get();
            height = heightBuffer.get();
        }
        glClearColor(0.5f, 0.5f, 0.5f, 1f);

        // Esto son recursos estaticos
        texture = Texture.loadTexture("resources/pong.png");


        // Ctes de juego
        float speed = 250f;
        playerScore = 0;
        opponentScore = 0;
        gameWidth = width;
        gameHeight = height;

        // Actores
        player = new Paddle(Color.GREEN, texture, 5f, (height - 100) / 2f, speed, true);
        opponent = new Paddle(Color.RED, texture, width - 25f, (height - 100) / 2f, speed, false);
        ball = new Ball(Color.BLUE, texture, (width - 20) / 2f, (height - 20) / 2f, speed * 1.5f);
        */
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
