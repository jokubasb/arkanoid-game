package com.arkanoid.game.sprites;

import com.badlogic.gdx.graphics.Texture;

public class BlueBrick extends Brick {

    public BlueBrick(int x, int y) {
        super(x, y);
        texture = new Texture("brick.png");
    }
}
