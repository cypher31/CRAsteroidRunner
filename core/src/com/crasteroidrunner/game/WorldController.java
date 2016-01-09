package com.crasteroidrunner.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

//Contains all game logic and handles the following
//collsions, player input, GUI update, gamestate update

public class WorldController extends InputAdapter implements Disposable{
	
	private static final String TAG = WorldController.class.getName();
	
	public Level_01 level_01;
	public World b2world;
	
	public Sprite[] testSprites;
	public int selectedSprite;
	
	//rectangles for collision detection
	private final Rectangle r1 = new Rectangle();
	private final Rectangle r2 = new Rectangle();
	
	public WorldController(){
		init();
	}
	
	private void init(){
		initTestObjects();
		Gdx.input.setInputProcessor(this);
	}

	public void update(float deltaTime) {
		updateTestObjects(deltaTime);
	}
	
	public void updateTestObjects(float deltaTime){
		//get current rotation from selected sprite
		float rotation = testSprites[selectedSprite].getRotation();
		//rotate sprite
		rotation = 270;
		testSprites[selectedSprite].setRotation(rotation);
	}
	
	private void initTestObjects(){
		//create array for 1 new sprites
		testSprites = new Sprite[1];
		//create a list of texture regions
		Array<TextureRegion> regions = new Array<TextureRegion>();
		regions.add(Assets.instance.pShip.ship);
		
		for(int i = 0; i < testSprites.length; i++){
			Sprite spr = new Sprite(regions.random());
			//define sprite size to be 1mx1m
			spr.setSize(1, 1);
			//set origin to sprites center
			spr.setOrigin(spr.getWidth() / 2.0f, spr.getHeight() / 2.0f);
			//random position for sprite
			float randomX = MathUtils.random(-2.0f, 2.0f);
			float randomY = MathUtils.random(-2.0f, 2.0f);
			spr.setPosition(randomX, randomY);
			//put new sprite into array
			testSprites[i] = spr;
		}
		selectedSprite = 0;
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
