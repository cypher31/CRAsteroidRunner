package com.crasteroidrunner.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.crasteroidrunner.game.CaptainRickAR;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Title";
		cfg.height = 900;
		cfg.width = 1600;
		new LwjglApplication(new CaptainRickAR(), cfg);
	}
}
