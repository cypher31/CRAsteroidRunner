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
		
		//create the game resource objects (LLGD 156)
		pShip = new AssetPShip(atlas);
		asteroidBrnBig = new AssetAsteroidBrnBig(atlas);
		asteroidGryBig = new AssetAsteroidGryBig(atlas);
		asteroidBrnSmall = new AssetAsteroidBrnSmall(atlas);
		asteroidGrySmall = new AssetAsteroidGrySmall(atlas);
		enemyCarp = new AssetEnemyCarp(atlas);
		enemyCrab = new AssetEnemyCrab(atlas);
		enemyBear = new AssetEnemyBear(atlas);
		enemyOrca = new AssetEnemyOrca(atlas);
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
		public final AtlasRegion aBrnBig;
		
		public AssetAsteroidBrnBig(TextureAtlas atlas){
			aBrnBig = atlas.findRegion("asteroid_brn_big");
		}
	}
	
	public class AssetAsteroidGryBig{
		public final AtlasRegion aGryBig;
		
		public AssetAsteroidGryBig(TextureAtlas atlas){
			aGryBig = atlas.findRegion("asteroid_gry_big");
		}
	}
	
	public class AssetAsteroidBrnSmall{
		public final AtlasRegion aBrnSmall;
		
		public AssetAsteroidBrnSmall(TextureAtlas atlas){
			aBrnSmall = atlas.findRegion("asteroid_brn_small");
		}
	}
	
	public class AssetAsteroidGrySmall{
		public final AtlasRegion aGrySmall;
		
		public AssetAsteroidGrySmall(TextureAtlas atlas){
			aGrySmall = atlas.findRegion("asteroid_gry_small");
		}
	}
	
	public class AssetEnemyCarp{
		public final AtlasRegion aeCarp;
		
		public AssetEnemyCarp(TextureAtlas atlas){
			aeCarp = atlas.findRegion("enemy_carp");
		}
	}
	
	public class AssetEnemyCrab{
		public final AtlasRegion aeCrab;
		
		public AssetEnemyCrab(TextureAtlas atlas){
			aeCrab = atlas.findRegion("enemy_crab");
		}
	}
	
	public class AssetEnemyBear{
		public final AtlasRegion aeBear;
		
		public AssetEnemyBear(TextureAtlas atlas){
			aeBear = atlas.findRegion("enemy_bear");
		}
	}

	public class AssetEnemyOrca{
		public final AtlasRegion aeOrca;
		
		public AssetEnemyOrca(TextureAtlas atlas){
			aeOrca = atlas.findRegion("enemy_orca");
		}
	}
}
