package com.arkanoid.game.states;

import com.arkanoid.game.Arkanoid;
import com.arkanoid.game.sprites.Ball;
import com.arkanoid.game.sprites.Brick;
import com.arkanoid.game.sprites.Platform;
import com.arkanoid.game.sprites.Walls;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class PlayState extends State {
    private Ball ball;
    private Texture background;
    private Platform platform;
    private Brick oneBrick;
    private List<Brick> bricks = new ArrayList<Brick>();

    private BitmapFont font;
    Random rand = new Random();
    private int deltaCoord;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        ball = new Ball(Arkanoid.WIDTH/2, 130, 5,5);
        background = new Texture("background.png");
        platform = new Platform(Arkanoid.WIDTH/2, 100);
        //nieko nedaranti plytele
        oneBrick = new Brick(1000, 1000);
        //plyteliu generavimas
        //TODO grazesne implementacija.....
        for(int i = oneBrick.getWidth() * 2; i < Arkanoid.WIDTH - oneBrick.getWidth() * 2; i += oneBrick.getTexture().getWidth()) {
            for(int j = 600; j < 900; j += oneBrick.getTexture().getHeight()) {
                bricks.add(new Brick(i, j));
            }
        }
        //sriftas ir jo dydis
        font = new BitmapFont();
        font.getData().setScale(2);
        score  = 0;
        deltaCoord = 0;

    }

    @Override
    protected void handleImput() {

    }

    @Override
    public void update(float dt) {
        handleImput();
        ball.update(dt);
        platform.update(dt);
        //atmusimas nuo platformos
        if(platform.collides(ball.getBounds())){
            ball.setVelocity(new Vector3(ball.getVelocity().x, ball.getVelocity().y * -1, 0));
        }
        //plyteles sudayztmas
        for(Brick brick : bricks){
            if(!brick.isDead() && brick.collides(ball.getBounds())){
                //TODO atsitiktine kryptis
                //deltaCoord = rand.nextInt(5) - 5;
                //kamoliuko atmusimas nuo plyteles
                ball.setVelocity(new Vector3(ball.getVelocity().x, ball.getVelocity().y * -1, 0));
                ++score;
            }
        }

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Arkanoid.WIDTH, Arkanoid.HEIGHT);
        //atvaizduoja kamuoliuka atsizvelgiant i jo koordinates
        sb.draw(ball.getTexture(), ball.getPosition().x, ball.getPosition().y);
        sb.draw(platform.getTexture(), platform.getPosition().x, platform.getPosition().y);
        font.draw(sb, "Score: " + score.toString(), Arkanoid.WIDTH - 150, Arkanoid.HEIGHT - 10);
        sb.end();
        //plyteliu renderinimas
        sb.begin();
        for(Brick brick : bricks) {
            if (!brick.isDead()) {
                sb.draw(brick.getTexture(), brick.getPosition().x, brick.getPosition().y);
            }
        }
        sb.end();
        if(ball.isDead()){
            infoBox(this.toString(), "Oops");
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void dispose() {

    }

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String toString() {
        return "PlayState{" +
                "score=" + score +
                '}';
    }
}
