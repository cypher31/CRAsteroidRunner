package com.crasteroidrunner.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.crasteroidrunner.game.CaptainRickAR;
import com.crasteroidrunner.game.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Title";
		cfg.height = Constants.VIEWPORT_GUI_HEIGHT;
		cfg.width = Constants.VIEWPORT_GUI_WIDTH;
		new LwjglApplication(new CaptainRickAR(), cfg);
	}
}
