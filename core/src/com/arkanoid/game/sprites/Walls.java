package com.arkanoid.game.sprites;

import com.arkanoid.game.Arkanoid;

import com.badlogic.gdx.math.Rectangle;

//klase skirta laikyti soniniu sienu ribas
//daugiau nieko nedaro kol kas
public class Walls {
    private Rectangle bounds;


    public Walls() {
        bounds = new Rectangle(0, 0, Arkanoid.WIDTH, Arkanoid.HEIGHT);
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
