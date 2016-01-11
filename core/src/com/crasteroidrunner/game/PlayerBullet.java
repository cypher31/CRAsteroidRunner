package com.crasteroidrunner.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerBullet extends AbstractGameObject{
	
	public static final String TAG = PlayerShip.class.getName();
	
	private TextureRegion regPBullet;
	//Level level;
	
	public PlayerBullet(){
		init();
		//Gdx.app.debug(TAG, "init()");
	}
	
	public void init(){
		dimension.set(.25f, .25f);
		regPBullet = Assets.instance.pBullet.bullet;
		//center image on gameobject
		origin.set(dimension.x / 2.0f, dimension.y / 2.0f);
		//bounding box for collsion
		bounds.set(0, 0, dimension.x, dimension.y);
		//physics values
		terminalVelocity.set(20.0f, 0.0f);
		acceleration.set(20.0f, 0);
		friction.set(0, 0);
		rotation = 270;
	}

	@Override
	public void render(SpriteBatch batch) {
		TextureRegion reg = null;
		//draw image
		reg = regPBullet;
		batch.draw(reg.getTexture(), position.x, position.y, origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y, rotation, //
				reg.getRegionX(), reg.getRegionY(), reg.getRegionWidth(), reg.getRegionHeight(), false, false);
	}

	@Override
	public void update(float deltaTime){
		super.update(deltaTime);
	}
	
}	
