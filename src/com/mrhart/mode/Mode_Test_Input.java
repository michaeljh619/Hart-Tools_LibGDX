package com.mrhart.mode;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mrhart.assets.loaders.Loader_Input;
import com.mrhart.backend.Debuggable;
import com.mrhart.input.Button_InGame;
import com.mrhart.input.Joystick;
import com.mrhart.input.JoystickCommands;
import com.mrhart.state.GameState;

public class Mode_Test_Input extends Mode implements Debuggable{
	/*
	 * Instance Vars
	 */
	// Inputs
	private Joystick joystick;
	private Button_InGame button;
	private JoystickCommands commands;
	// Graphics
	private TextureRegion jsStick, jsBackground, buttonRegion;
	
	public Mode_Test_Input(){
		super(GameState.TEST);
		
		// Load into AssetManager
		Loader_Input.loadButtonLight_A(assets);
		Loader_Input.loadJoystickLight(assets);
		
		// Create inputs
		joystick = new Joystick(new Vector2(200, 300), 100, 50);
		button = new Button_InGame(new Vector2(600, 300), 100);
		
		// Commands from joystick
		commands = joystick.commands;
	}
	
	@Override
	public int update(float delta) {
		joystick.update();
		button.update();
		
		if(button.isTouched()){
			System.err.println("Button is touched");
		}
		if(joystick.isTouched()){
			System.err.println("Joystick Normalized X: " + commands.normalized.x);
			System.err.println("Joystick Normalized Y: " + commands.normalized.y);
		}
		
		return GameState.NULL;
	}

	@Override
	public void render(SpriteBatch batcher, float runtime) {
		joystick.render(batcher);
		button.render(batcher);
	}

	@Override
	public void dispose() {
		
	}
	
	public void debug(ShapeRenderer shapes){
		button.debug(shapes);
	}

	@Override
	public void finalize() {
		// Finalize Joystick Regions
		jsStick = Loader_Input.getJoystickLightStick(assets);
		jsBackground = Loader_Input.getJoystickLightBackground(assets);
		joystick.setTextureRegions(jsBackground, jsStick);
		// Finalize Button Region
		buttonRegion = Loader_Input.getButtonLight_A(assets);
		button.setTextureRegion(buttonRegion);
	}
}
