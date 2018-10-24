package com.arkanoid.game.sprites;

import com.arkanoid.game.Arkanoid;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Platform{

    protected Vector3 position;
    protected Vector3 velocity;
    protected Rectangle bounds;
    protected Texture texture;

    public Platform(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);
        texture = new Texture("platform.png");
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    public void update(float dt){
        position.set(Gdx.input.getX(), 100, 0);
        bounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setPosition(Vector3 position) {
        if(position.x == 100)
            this.position = position;
    }



    public boolean collides(Rectangle ball){
        return bounds.overlaps(ball);
    }

}
