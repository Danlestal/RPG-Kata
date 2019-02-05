package kata.rpg.graphics;

import kata.rpg.states.State;

public class CmdLineRenderer implements Renderer {

    @Override
    public void init() {
        System.out.print("Iniciando renderer");
    }

    @Override
    public void begin() {
        System.out.print("Comenzando pintado de frame");
    }

    @Override
    public void render(State state, float alpha) {
        System.out.print("Renderizando estado de juego");
    }

    @Override
    public void end() {
        System.out.print("Finalizando pintado de frame");
    }

    @Override
    public void clear() {
        System.out.print("Limpiando render");
    }

    @Override
    public void dispose() {
        System.out.print("Disposing render");
    }

    @Override
    public boolean isClosing() {
        return false;
    }

} 