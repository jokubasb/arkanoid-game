package com.arkanoid.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.arkanoid.game.Arkanoid;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Arkanoid.WIDTH;
		config.height = Arkanoid.HEIGHT;
		config.title = Arkanoid.TITLE;
		new LwjglApplication(new Arkanoid(), config);
	}
}
