package com.crasteroidrunner.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//research interface
public interface ScreenTransition {
	
	public float getDuration();
	
	public float render(SpriteBatch batch, Texture currScreen, Texture nextScreen, float alpha);

}
