package com.crasteroidrunner.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level_01 {
	
	public static final String TAG = Level_01.class.getName();
	
	//player
	public PlayerShip playerShip;
	
	//color for each block type
	public enum BLOCK_TYPE{
		EMPTY(0,0,0),
		PLAYER_SPAWNPOINT(255,255,255);
		
		private int color;
		
		private BLOCK_TYPE(int r, int g, int b){
			//reserach
			color = r << 24 | g << 16 | b << 8 | 0xff;
		}
		
		public boolean sameColor(int color){
			return this.color == color;
		}
		
		public int getColor(){
			return color;
		}
	}
	
	public Level_01(String filename){
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
				}
				//spawn point
				else if(BLOCK_TYPE.PLAYER_SPAWNPOINT.sameColor(currentPixel)){
					obj = new PlayerShip();
					offsetHeight = -3.0f;
					obj.position.set(pixelX, baseHeight * obj.dimension.y + offsetHeight);
					playerShip = (PlayerShip) obj;
				}
				
				else{
					//unknown colors go here
				}
				lastPixel = currentPixel;
			}
		}
		//decoration
	}
	
	public void render(SpriteBatch batch){
		playerShip.render(batch);
	}
	
	public void update(float deltaTime){
		playerShip.update(deltaTime);
	}

}
