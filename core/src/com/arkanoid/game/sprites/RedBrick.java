package com.arkanoid.game.sprites;

import com.badlogic.gdx.graphics.Texture;

public class RedBrick extends Brick {

    public RedBrick(int x, int y) {
        super(x, y);
        texture = new Texture("brick_red.png");
    }
}
