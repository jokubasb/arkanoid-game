package com.arkanoid.game.sprites;

import com.arkanoid.game.Arkanoid;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Platform {
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;

    private Texture platform;

    public Platform(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);
        platform = new Texture("platform.png");
        bounds = new Rectangle(x, y, platform.getWidth(), platform.getHeight());
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
        return platform;
    }

    public boolean collides(Rectangle ball){
        return bounds.overlaps(ball);
    }
}
