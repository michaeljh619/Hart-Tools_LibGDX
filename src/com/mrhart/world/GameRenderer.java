package com.mrhart.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mrhart.backend.Debuggable;
import com.mrhart.settings.Settings;

/**
 * GameRenderer is solely responsible for rendering to the screen. No updating
 * whatsoever is to be done here! GameState will tell which function to use to
 * render and GameWorld will do the updating of the objects.
 * 
 * Timers from GameWorld can be accessed in this class since they are protected and in the same
 * package as GameRenderer.
 * 
 * @author Michael James Hart, mrhartgames@yahoo.com
 * @version v2.20
 * @since 11/01/2015
 * 
 */

public class GameRenderer {
	
	/*
	 *  Instance Variables
	 */
	private GameWorld gameWorld;
	private SpriteBatch batcher;
	private ShapeRenderer shapes;
	private OrthographicCamera camera;
	
	/*****************************************
	 * Main Methods
	 *****************************************/
	
	public GameRenderer(GameWorld inWorld, OrthographicCamera inCamera) {
		gameWorld = inWorld;
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(inCamera.combined);

		shapes = new ShapeRenderer();
		shapes.setProjectionMatrix(inCamera.combined);
		
		camera = inCamera;
	}

	/**
	 * Render is the control hub for rendering objects to the screen. It is only
	 * to be used as a control method to call helper methods from the
	 * GameRenderer class.
	 * 
	 * @param delta
	 */
	public void render(float runtime) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batcher.setProjectionMatrix(camera.combined);
		// Begin SpriteBatch
		batcher.begin();

		// Enable Transparency
		batcher.enableBlending();
		
		// Renders current mode
		if(gameWorld.assets.getProgress() >= 1.0f){
			gameWorld.currentMode.render(batcher, runtime);
		}
		// Render the meta Mode instead
		else{
			gameWorld.metaMode.render(batcher, runtime);
		}
			

		batcher.end();
		
		if(gameWorld.currentMode instanceof Debuggable && Settings.DEBUG_ON
				&& gameWorld.assets.getProgress() >= 1.0f){
			shapes.setColor(Color.RED);
			shapes.begin(ShapeType.Line);
			((Debuggable) gameWorld.currentMode).debug(shapes);
			shapes.end();
		}
	}
	
	/*****************************************
	 * Main Methods [END]
	 *****************************************/
}
