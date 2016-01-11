package com.crasteroidrunner.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level {
	
	public static final String TAG = Level.class.getName();
	
	//player
	public PlayerShip playerShip;
	
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
		//player character
		playerShip = null;
		
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
					offsetHeight = -3.0f;
					playerShip.position.set(5, 5);
					playerShip.rotation = 270;
					//playerShip = (PlayerShip) obj;
					Gdx.app.debug("spawn", "player");
					System.out.print(playerShip.position);
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
		//decoration
		pixmap.dispose();
		Gdx.app.debug(TAG, "level '" + filename + "' loaded");
	}
	
	public void render(SpriteBatch batch){
		playerShip.render(batch);
		//Gdx.app.debug(TAG, "render()");
	}
	
	public void update(float deltaTime){
		playerShip.update(deltaTime);
	}

}
