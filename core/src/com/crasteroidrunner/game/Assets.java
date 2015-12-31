package com.crasteroidrunner.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable, AssetErrorListener{
	
	private static final String TAG = Assets.class.getName();
	public static final Assets instance = new Assets();
	private AssetManager assetManager;
	
	public AssetPShip pShip;
	public AssetAsteroidBrnBig	asteroidBrnBig;
	public AssetAsteroidGryBig	asteroidGryBig;
	public AssetAsteroidBrnSmall	asteroidBrnSmall;
	public AssetAsteroidGrySmall	asteroidGrySmall;
	public AssetEnemyCarp	enemyCarp;
	public AssetEnemyCrab	enemyCrab;
	public AssetEnemyBear	enemyBear;
	public AssetEnemyOrca	enemyOrca;
	
	private Assets(){
		
	}
	
	public void init(AssetManager assetManager){
		this.assetManager = assetManager;
		//set asset manager error handler
		assetManager.setErrorListener(this);
		//load Texture atlas
		assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
		assetManager.finishLoading();
		
		TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS);
		for(Texture texture : atlas.getTextures()){
			texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		pShip = new AssetPShip(atlas);
	}

	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public class AssetPShip{
		public final AtlasRegion ship;
		
		public AssetPShip(TextureAtlas atlas){
			ship = atlas.findRegion("player_ship");
		}
	}
	
	public class AssetAsteroidBrnBig{
		
	}
	
	public class AssetAsteroidGryBig{
		
	}
	
	public class AssetAsteroidBrnSmall{
		
	}
	
	public class AssetAsteroidGrySmall{
		
	}
	
	public class AssetEnemyCarp{
		
	}
	
	public class AssetEnemyCrab{
		
	}
	
	public class AssetEnemyBear{
		
	}
	
	public class AssetEnemyOrca{
		
	}

}
