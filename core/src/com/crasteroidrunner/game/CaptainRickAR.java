package com.crasteroidrunner.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CaptainRickAR extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private static float WORLD_TO_SCREEN = 1.0f / 1.0f;
	
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		
		
	}

	@Override
	public void render () {
		int w = img.getWidth();
		int h = img.getHeight();
		
		float xOrigin = w * .5f;
		float yOrigin = h * .5f;
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//I think this doesnt work the correct way because we need to have a camera so we can do the projection matrix.
		batch.draw(img, Gdx.graphics.getWidth() / 2 - xOrigin, Gdx.graphics.getHeight() / 2 - yOrigin, xOrigin, yOrigin, w, h, WORLD_TO_SCREEN, WORLD_TO_SCREEN, 
				0.0f, 0, 0, w, h, false, false);
		batch.end();
	}
}
