package com.arkanoid.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {

    protected GameStateManager gsm;

    protected State(GameStateManager gsm){
        this.gsm = gsm;
    }

    protected abstract void handleImput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
