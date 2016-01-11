package com.crasteroidrunner.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;

public class CaptainRickAR extends DirectedGame {
	
	private static final String TAG = CaptainRickAR.class.getName();
	
	private WorldController worldController;
	private WorldRenderer worldRenderer;
	
	private boolean paused;

	@Override
	public void create() {
		//Set Libgdx log level to DEBUG
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		//Load assets
		Assets.instance.init(new AssetManager());
		//Initialize controller and renderer
		//GamePreferences.instance.load();
		//AudioManager.instance.play(Assets.instance.music.song01);
		setScreen(new MenuScreen(this));
	}

	
}
