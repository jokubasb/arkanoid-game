package com.arkanoid.game.States;

import com.arkanoid.game.Arkanoid;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State {

    private Texture background;
    private Texture playButton;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background.png");
        playButton = new Texture("playButton.png");
    }

    @Override
    public void handleImput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Arkanoid.WIDTH, Arkanoid.HEIGHT);
        sb.draw(playButton, (Arkanoid.WIDTH / 2) - (playButton.getWidth() / 2), Arkanoid.HEIGHT / 2);
        sb.end();
    }
}
