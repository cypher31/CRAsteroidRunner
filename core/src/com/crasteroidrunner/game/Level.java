package com.crasteroidrunner.game;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class Level {
	
	public static final String TAG = Level.class.getName();

	//player
	public PlayerShip playerShip;
	public WorldController worldController;
	public PlayerBullet playerBullet;
	
	//color for each block type
	public enum BLOCK_TYPE{
		EMPTY(0,0,0), //black
		PLAYER_SPAWNPOINT(255,255,255); //white
		
		private int color;
		
		private BLOCK_TYPE(int r, int g, int b){
			//research
			color = r << 24 | g << 16 | b << 8 | 0xff;
		}
		
		public boolean sameColor(int color){
			return this.color == color;
		}
		
		public int getColor(){
			return color;
		}
	}
	
	public Level(String filename){
		init(filename);
	}
	
	private void init(String filename){
		//playerBullet = new Array<PlayerBullet>();
		//player character
		playerShip = null;
		playerBullet = null;
		//load image file
		Pixmap pixmap = new Pixmap(Gdx.files.internal(filename));
		//scan pixels from top-left to bottom-right
		int lastPixel = -1;
		for(int pixelY = 0; pixelY < pixmap.getWidth(); pixelY++){
			for(int pixelX = 0; pixelX < pixmap.getWidth(); pixelX++){
				AbstractGameObject obj = null;
				float offsetHeight = 0;
				//height grows from bottom to top
				float baseHeight = pixmap.getHeight() - pixelY;
				//get color of current pixel as 32-big RGBA value
				int currentPixel = pixmap.getPixel(pixelX, pixelY);
				//find matching color value to identify block type at (x,y)
				//point and create the corresponding game object if there is a match
				if(BLOCK_TYPE.EMPTY.sameColor(currentPixel)){
					//do nothing
					//Gdx.app.debug(TAG, "empty cell");
				}
				//spawn point
				else if(BLOCK_TYPE.PLAYER_SPAWNPOINT.sameColor(currentPixel)){
					//changed from the book...
					//setting as obj variable would not work, instantiated directly and now works
					//debugger now shows the playership under >level instead of >worldcontroller
					playerShip = new PlayerShip();
					//offsetHeight = -3.0f;
					playerShip.rotation = 270;
					playerShip.position.set(pixelX, baseHeight);
					//playerShip = (PlayerShip) obj;
					//Gdx.app.debug("spawn", "player");
				}
				else{
					//unknown colors go here
//					int r = 0xff & currentPixel >>> 24; // red color channel
//					int g = 0xff & currentPixel >>> 16; // green color channel
//					int b = 0xff & currentPixel >>> 8; // blue color channel
//					int a = 0xff & currentPixel; // alpha channel
//					Gdx.app.error(TAG, "Unknown object at x<" + pixelX + "> y<" + pixelY + ">: r<" + r + "> g<" + g + "> b<" + b + "> a<" + a + ">");
				}
				lastPixel = currentPixel;
			}
		}
		playerBullet = new PlayerBullet();
		playerBullet.position.set(playerShip.position.x + playerShip.dimension.x, 
				playerShip.position.y + playerShip.dimension.y / 2 - playerBullet.dimension.y / 2);
		//decoration
		pixmap.dispose();
		Gdx.app.debug(TAG, "level '" + filename + "' loaded");
	}
	
	public void render(SpriteBatch batch){
		playerShip.render(batch);
		playerBullet.render(batch);
//		for(Iterator<PlayerBullet> itr = .iterator(); itr.hasNext();)
//		{
//		  PlayerBullet playerBullet = itr.next();
//
//		  playerBullet.update();
//
//		  if(playerBullet.position.y > Gdx.graphics.getHeight())
//		  {
//		     itr.remove();
//		  }
//		}
		//playerBullet.render(batch);
		//Gdx.app.debug(TAG, "render()");
	}
	
	public void update(float deltaTime){
		playerShip.update(deltaTime);
//		playerBullet.update(deltaTime);
	}

}
