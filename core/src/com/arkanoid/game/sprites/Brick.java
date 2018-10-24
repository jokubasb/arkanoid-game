package com.arkanoid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Brick{

    protected Vector3 position;
    protected Vector3 velocity;
    protected Rectangle bounds;
    protected Texture texture;
    protected boolean dead;

    public Brick(){

    }

    public Brick(int x, int y){
        texture = new Texture("brick.png");
        position = new Vector3(x, y, 0);
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
        dead = false;
    }

    public Brick(int x, int y, int colour){
        String filename = "";
        switch (colour){
            case 1 : filename = "brick_green.png";
            break;
            case 2 : filename = "brick_red.png";
            break;
            case 3 : filename = "brick_violet.png";
            break;
            case 4 : filename = "brick_yellow.png";
            break;
            case 5 : filename = "brick.png";
            break;
        }

        texture = new Texture(filename);
        position = new Vector3(x, y, 0);
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
        dead = false;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector3 getPosition() {
        return position;
    }


    public boolean collides(Rectangle ball){
        if(bounds.overlaps(ball)){
            dead = true;
            return true;
        }
        return false;
    }


    public boolean isDead() {
        return dead;
    }

    public int getWidth(){
        return this.texture.getWidth();
    }

    public int getHeight(){
        return this.texture.getHeight();
    }

    @Override
    public String toString() {
        return "Brick{" +
                "dead=" + dead +
                '}';
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
