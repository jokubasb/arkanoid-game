package com.arkanoid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Brick {
    private Rectangle bounds;
    private Texture brick;
    private Vector3 position;
    private boolean dead = false;

    public Brick(int x, int y){
        brick = new Texture("brick.png");
        position = new Vector3(x, y, 0);
        bounds = new Rectangle(x, y, brick.getWidth(), brick.getHeight());
    }

    public Brick(int x, int y, int colour){
        //TODO png sprite'ai skirtingom spalvom
        String filename = "";
        switch (colour){
            case 1 : filename = "blueBrick.png";
            break;
            default : filename = "brick.png";
            break;
        }

        brick = new Texture(filename);
        position = new Vector3(x, y, 0);
        bounds = new Rectangle(x, y, brick.getWidth(), brick.getHeight());
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Texture getTexture() {
        return brick;
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
        return this.brick.getWidth();
    }

    public int getHeight(){
        return this.brick.getHeight();
    }

    @Override
    public String toString() {
        return "Brick{" +
                "dead=" + dead +
                '}';
    }
}
