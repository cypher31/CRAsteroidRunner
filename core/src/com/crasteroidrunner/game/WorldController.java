package com.crasteroidrunner.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.Disposable;

public class WorldController extends InputAdapter implements Disposable{
	
	private static final String TAG = WorldController.class.getName();
	
	public WorldController(){
		
	}
	
	private void init(){
		Gdx.input.setInputProcessor(this);
	}

	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean keyUp(int keycode){
		//Reset game world
		if(keycode == Keys.R){
			init();
			Gdx.app.debug(TAG, "Game world reset");
		}
		return false;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
