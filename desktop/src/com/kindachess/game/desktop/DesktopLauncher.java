package com.kindachess.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kindachess.game.KindaChessGame;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Kinda Chess";
		config.width = 400;
		config.height = 400;
		new LwjglApplication(new KindaChessGame(), config);
	}
}
