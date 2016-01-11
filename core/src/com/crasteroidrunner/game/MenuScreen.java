package com.crasteroidrunner.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

public class MenuScreen extends AbstractGameScreen{
	
	private Stage stage;
	private Skin skinMenuScreen;
	
	private Button btnMenuPlay;
	
	//debug
	private final float DEBUG_REBUILD_INTERVAL = 5.0f;
	private final boolean debugEnabled = false;
	private float debugRebuildStage;

	public MenuScreen(DirectedGame game) {
		super(game);
	}

	@Override
	public void render(float deltaTime) {
		Gdx.gl20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(debugEnabled){
			debugRebuildStage -= deltaTime;
			if(debugRebuildStage <= 0){
				debugRebuildStage = DEBUG_REBUILD_INTERVAL;
				//rebuildStage();
			}
		}
		stage.act(deltaTime);
		stage.draw();
		//Table.drawDebug(stage);
	}
	
	public void rebuildStage(){
		skinMenuScreen = new Skin(Gdx.files.internal(Constants.SKIN_MENU_UI), new TextureAtlas(Constants.TEXTURE_ATLAS_UI));
		//build layer
		Table layerControls = buildControlsLayer();
		//assemble stage
		stage.clear();
		Stack stack = new Stack();
		stage.addActor(stack);
		stack.setSize(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
		stack.add(layerControls);
	}
	
	private Table buildControlsLayer(){
		Table layer = new Table();
		layer.top().center();
		//play button
		btnMenuPlay = new Button(skinMenuScreen, "play");
		layer.add(btnMenuPlay).width(50).height(50);
		btnMenuPlay.addListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor){
				onPlayClicked();
			}
		});
		layer.row();
		return layer;
	}
	
	private void onPlayClicked(){
		game.setScreen(new GameScreen(game));
	}

	@Override
	public void resize(int width, int height) {
		//API was updated -- does not match book
		stage.getViewport().update(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT, false);
	}
	
	@Override
	public void show() {
		stage = new Stage();
		rebuildStage();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void hide() {
		stage.dispose();
		skinMenuScreen.dispose();
	}
	
	@Override
	public InputProcessor getInputProcessor() {
		// TODO Auto-generated method stub
		return stage;
	}

}
