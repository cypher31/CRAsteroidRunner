package com.crasteroidrunner.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class WorldRenderer implements Disposable{
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private WorldController worldController;
	public PlayerBullet playerBullet;
	
	public WorldRenderer (WorldController worldController) {
		this.worldController = worldController;
		init();
	}
	
	private void init(){
		batch = new SpriteBatch();
		
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
		camera.position.set(Constants.VIEWPORT_WIDTH / 2, Constants.VIEWPORT_HEIGHT / 2, 0);
		camera.update();
	}
	
	public void render(){
		renderWorld(batch);
		//renderGUI(batch);
//		batch.setProjectionMatrix(camera.combined);
//		batch.begin();
//		for(Sprite sprite : worldController.testSprites){
//			sprite.draw(batch);
//		}
//		batch.end();
	}
	
	private void renderWorld(SpriteBatch batch){
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		worldController.level.render(batch);
		batch.end();
	}
	
	public void resize (int width, int height){
		camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
		camera.update();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}
