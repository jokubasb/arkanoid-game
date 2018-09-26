package com.arkanoid.game.sprites;

import com.arkanoid.game.Arkanoid;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Ball {
    private static final int GRAVITY = -15;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    private boolean dead;

    private Texture ball;
    private Walls walls;

    public Ball(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(5,5,0);
        ball = new Texture("ball.png");
        bounds = new Rectangle(x, y, ball.getWidth(), ball.getHeight());
        walls = new Walls();
        dead = false;
    }

    public Ball(int x, int y, int vx, int vy){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(vx,vy,0);
        ball = new Texture("ball.png");
        bounds = new Rectangle(x, y, ball.getWidth(), ball.getHeight());
        walls = new Walls();
        dead = false;
    }

    public void update(float dt){
        position.add(velocity.x, velocity.y, 0);
        bounds.setPosition(position.x, position.y);

        //--------------------atsitrenkimas i sienas---------------------------
        //sonines sienos
        if(collidesWithWall(walls.getBounds()) && ((position.x >= Arkanoid.WIDTH) || (position.x <= 0))){
            velocity.set(new Vector3(velocity.x * -1, velocity.y, 0));
        }
        //virsutine siena
        if(collidesWithWall(walls.getBounds()) && ((position.y >= Arkanoid.HEIGHT))) {
            velocity.set(new Vector3(velocity.x, velocity.y * -1, 0));
        }
        //apacia = dead
        if(collidesWithWall(walls.getBounds()) && (position.y <= 0)){
            dead = true;
        }

    }

    public Vector3 getPosition() {
        return position;
    }
    public Texture getTexture() {
        return ball;
    }
    public void setPosition(Vector3 position) {
        this.position = position;
    }
    public void setVelocity(Vector3 velocity) {
        this.velocity = velocity;
    }
    public Rectangle getBounds() {
        return bounds;
    }
    public Boolean collidesWithWall(Rectangle wallsBounds){
        return !bounds.overlaps(wallsBounds);
    }
    public Vector3 getVelocity() {
        return velocity;
    }
    public boolean isDead() {
        return dead;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "dead=" + dead +
                '}';
    }
}
