package com.crasteroidrunner.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerShip extends AbstractGameObject{
	
	public static final String TAG = PlayerShip.class.getName();
	
	public enum VIEW_DIRECTION{
		LEFT
	}

	public enum STATE{
		ACCELERATING, DECELERATING, GAME_OVER
	}
	
	private TextureRegion regShip;
	public VIEW_DIRECTION viewDirection;
	public boolean hasOverCharge;
	public float timeLeftOverCharge;
	
	public PlayerShip(){
		init();
	}
	
	public void init(){
		dimension.set(1,1);
		regShip = Assets.instance.pShip.ship;
		//Center image on game object
		origin.set(dimension.x / 2, dimension.y /2);
		//Bounding box for collision detection
		bounds.set(0, 0, dimension.x, dimension.y);
		//set physics values
		terminalVelocity.set(10.0f, 0f);
		acceleration.set(25.0f, 0.0f);
		//power-ups
		hasOverCharge = false;
		timeLeftOverCharge = 0;
		//Dust particles -- add later
		//dustParticles.load(Gdx.files.internal(dust.pfx), Gdx.files.internal("particles"));
	}
	
	public void setOverCharge(boolean pickedUp){
		hasOverCharge = pickedUp;
		if(pickedUp){
			timeLeftOverCharge = Constants.ITEM_OVERCHARGE_POWERUP_DURATION;
		}
	}
	
	public boolean hasOverCharge(){
		return hasOverCharge && timeLeftOverCharge > 0;
	}
	
	@Override
	public void update(float deltaTime){
		super.update(deltaTime);
		if(velocity.x !=0){
		}
		if(timeLeftOverCharge > 0){
			timeLeftOverCharge -= deltaTime;
			if(timeLeftOverCharge < 0){
				//disable power-up
				timeLeftOverCharge = 0;
						setOverCharge(false);
			}
		}
		//dustParticles.update(deltaTime);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		TextureRegion reg = null;
		//Draw image
		reg = regShip;
		//not exactly sure why this works...need to find the page reference
		batch.draw(reg.getTexture(), position.x, position.y, origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y, rotation, //
				reg.getRegionX(), reg.getRegionY(), reg.getRegionWidth(), reg.getRegionHeight(), viewDirection == VIEW_DIRECTION.LEFT, false);
	}
	
	

}
