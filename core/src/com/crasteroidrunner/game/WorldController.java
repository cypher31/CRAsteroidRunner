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
	
	DirectedGame game;
	PlayerShip playerShip;
	PlayerBullet playerBullet;
	
	public Level level;
	public World b2world;
	
	public Sprite[] testSprites;
	public int selectedSprite;
	
	//rectangles for collision detection
	private final Rectangle r1 = new Rectangle();
	private final Rectangle r2 = new Rectangle();
	
	public WorldController(DirectedGame game){
		this.game = game;
		init();
	}
	
	private void init(){
		Gdx.input.setInputProcessor(this);
		initLevel();
	}
	
	private void initLevel(){
		level = new Level(Constants.LEVEL_01);
	}

	public void update(float deltaTime) {
		handleInputGame(deltaTime);
		level.update(deltaTime);
	}
	
	private void handleInputGame(float deltaTime){
		if (Gdx.input.isKeyPressed(Keys.RIGHT)){
			if(level.playerShip.position.x < Constants.VIEWPORT_WIDTH / 3.0f - level.playerShip.dimension.x){
				level.playerShip.velocity.x = level.playerShip.terminalVelocity.x;
				//System.out.print(level.playerShip.position.x);
			} 
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)){
			if(level.playerShip.position.x > 0 + level.playerShip.dimension.x){
				level.playerShip.velocity.x = -level.playerShip.terminalVelocity.x;
				//System.out.print(level.playerShip.position.x);
			} 
		}
		if (Gdx.input.isKeyPressed(Keys.UP) && level.playerShip.position.y < 16 - level.playerShip.dimension.y){
			level.playerShip.velocity.y = level.playerShip.terminalVelocity.y;
			System.out.print(level.playerShip.position);
		} 
		if (Gdx.input.isKeyPressed(Keys.DOWN) && level.playerShip.position.y > 2){
			level.playerShip.velocity.y = -level.playerShip.terminalVelocity.y;
			System.out.print(level.playerShip.position);
		} 
		if(Gdx.input.isKeyPressed(Keys.SPACE)){
//			playerBullet = new PlayerBullet();
//			playerBullet.render(playerBullet.batch);
//			//offsetHeight = -3.0f;
//			playerBullet.rotation = 270;
//			playerBullet.position.set(5, 5);
//			System.out.print("space");
		}
	}
	
	@Override
	public boolean keyUp(int keycode){
		//Reset game world
		if(keycode == Keys.R){
			init();
			Gdx.app.debug(TAG, "Game world reset");
		}else if(keycode == Keys.ESCAPE){
			backToMenu();
		}
		return false;
	}
	
	private void backToMenu(){
		game.setScreen(new MenuScreen(game));
	}

	@Override
	public void dispose() {
		if(b2world != null){
			b2world.dispose();
		}
	}

}
