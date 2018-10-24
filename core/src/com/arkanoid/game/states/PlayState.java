package com.arkanoid.game.states;

import com.arkanoid.game.Arkanoid;
import com.arkanoid.game.sprites.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.audio.*;

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
    private static int game = 0;
    private static int  highscore = 0;
    private Music themeMusic;

    private BitmapFont font;
    Random rand = new Random();
    private int deltaCoord;
    protected static Integer score;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        ++game;
        ball = new Ball();
        background = new Texture("background.png");
        themeMusic = Gdx.audio.newMusic(Gdx.files.internal("theme.mp3"));
        themeMusic.play();
        themeMusic.setLooping(true);
        platform = new Platform(Arkanoid.WIDTH/2, 100);
        //nieko nedaranti plytele
        oneBrick = new BlueBrick(1000, 1000);
        //plyteliu generavimas
        //TODO grazesne implementacija.....
        for(int i = oneBrick.getWidth() * 2; i < Arkanoid.WIDTH - oneBrick.getWidth() * 2; i +=
                oneBrick.getTexture().getWidth()) {
            for(int j = 600; j < 900; j += oneBrick.getTexture().getHeight()) {
                int  n = rand.nextInt(5) + 1;
                //bricks.add(new Brick(i, j));
                switch(n){
                    case 1 :
                        bricks.add(new RedBrick(i,j));
                        break;
                    case 2:
                        bricks.add(new GreenBrick(i,j));
                        break;
                    case 3:
                        bricks.add(new YellowBrick(i,j));
                        break;
                    case 4:
                        bricks.add(new VioletBrick(i,j));
                        break;
                    case 5:
                        bricks.add(new BlueBrick(i,j));
                        break;
                }
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
        font.draw(sb, "Score: " + score.toString(), Arkanoid.WIDTH - 170, Arkanoid.HEIGHT - 10);
        font.draw(sb, "Game: " + game, Arkanoid.WIDTH - 170, Arkanoid.HEIGHT - 40);
        if (score > highscore) {
            highscore = score;
        }
        font.draw(sb, "Highscore: " + highscore, Arkanoid.WIDTH - 170, Arkanoid.HEIGHT - 70);
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
        themeMusic.dispose();
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
