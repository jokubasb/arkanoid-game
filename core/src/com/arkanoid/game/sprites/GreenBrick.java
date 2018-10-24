package com.arkanoid.game.sprites;

import com.badlogic.gdx.graphics.Texture;

public class GreenBrick extends Brick {

    public GreenBrick(int x, int y) {
        super(x, y);
        texture = new Texture("brick_green.png");
    }
}
