package kata.rpg.components;

import kata.lwjgl.graphic.Color;
import kata.lwjgl.graphic.Texture;


public class RenderData {

    public RenderData(Color color, kata.lwjgl.graphic.Texture texture2, int width, int height, int tx, int ty){
        this.color = color;
        this.texture = texture2;
        this.width = width;
        this.height = height;
        this.tx = tx;
        this.ty = ty;
    }


	public Color getColor(){
        return color;
    }

    public Texture getTexture(){
        return texture;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getTx(){
        return tx;
    }

    public int getTy(){
        return ty;
    }

    protected final Color color;
    protected final Texture texture;
    protected final int width;
    protected final int height;
    protected final int tx;
    protected final int ty;



}