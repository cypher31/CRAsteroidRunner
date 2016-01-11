package com.crasteroidrunner.game;

public class Constants {

	/**
	 * Visible game world is 32 meters wide
	 */
	public static final float VIEWPORT_WIDTH = 32;

	/**
	 * Visible game world is 18 meters tall
	 */
	public static final float VIEWPORT_HEIGHT = 18;

	/**
	 * GUI Width
	 */
	public static final int VIEWPORT_GUI_WIDTH = 1600;

	/**
	 * GUI Height
	 */
	public static final int VIEWPORT_GUI_HEIGHT = 900;

	/**
	 * Location of description file for texture atlas
	 */
	public static final String TEXTURE_ATLAS_OBJECTS = "GameScreen.pack";

	/**
	 * Location of image file for level 01
	 */
	public static final String LEVEL_01 = "level_01.png";

	/**
	 * Amount of extra lives at level start
	 */
	public static final int LIVES_START = 3;

	/**
	 * Duration of feather power-up in seconds
	 */
	public static final float ITEM_OVERCHARGE_POWERUP_DURATION = 4;

	/**
	 * Delay after game over
	 */
	public static final float TIME_DELAY_GAME_OVER = 3;

	/**
	 * Menu screen skin
	 */
	public static final String TEXTURE_ATLAS_UI = "GameScreen.pack";

	/**
	 * Options skin
	 */
	public static final String TEXTURE_ATLAS_LIBGDX_UI = "images/uiskin.atlas";

	/**
	 * Location of description file for skins
	 */
	public static final String SKIN_LIBGDX_UI = "images/uiskin.json";

	/**
	 * Location of description file for skins
	 */
	public static final String SKIN_MENU_UI = "menu-ui.json";

	/**
	 * Game preferences file
	 */
	public static final String PREFERENCES = "canyonbunny.prefs";

	/**
	 * Number of carrots to spawn
	 */
	public static final int CARROTS_SPAWN_MAX = 100;

	/**
	 * Spawn radius for carrots
	 */
	public static final float CARROTS_SPAWN_RADIUS = 3.5f;

	/**
	 * Delay after game finished
	 */
	public static final float TIME_DELAY_GAME_FINISHED = 6;

	/**
	 * Monochrome vertex shader
	 */
	public static final String SHADER_MONOCHROME_VERTEX = "shaders/monochrome.vs";

	/**
	 * Monochrome fragment shader
	 */
	public static final String SHADER_MONOCHROME_FRAGMENT = "shaders/monochrome.fs";

}
