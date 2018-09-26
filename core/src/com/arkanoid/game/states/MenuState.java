package com.arkanoid.game.states;

import com.arkanoid.game.Arkanoid;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MenuState extends State {

    private Texture background;
    private Texture playButton;
    private Texture title;
    private Rectangle button;
    private BitmapFont font;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background.png");
        playButton = new Texture("playButton.png");
        title = new Texture("title.png");
        button = new Rectangle((Arkanoid.WIDTH / 2) - (playButton.getWidth() / 2),
                Arkanoid.HEIGHT / 2 - playButton.getHeight(), playButton.getWidth(), playButton.getHeight());
        font = new BitmapFont();
        font.getData().setScale(2);
    }

    @Override
    public void handleImput() {
        //tik mygtuko paspaudimas
        if(Gdx.input.justTouched() && playTouched(button)){
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    private boolean playTouched(Rectangle button) {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        if (button.contains(touchPos.x, touchPos.y))
            return true;
        else
            return false;
    }

    @Override
    public void update(float dt) {
        handleImput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Arkanoid.WIDTH, Arkanoid.HEIGHT);
        sb.draw(title, 0, 600);
        sb.draw(playButton, (Arkanoid.WIDTH / 2) - (playButton.getWidth() / 2), Arkanoid.HEIGHT / 2);
        //font.draw(sb, "Score: " + score.toString(), Arkanoid.WIDTH - 150, Arkanoid.HEIGHT - 10);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
