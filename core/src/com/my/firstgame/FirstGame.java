package com.my.firstgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;
import java.util.Random;

public class FirstGame extends ApplicationAdapter{

	Platform movingPlatform =  new Platform(0,10, 60, 5);
	Ball bouncingBall = new Ball(15, 15, 15, 12, 7);
	Random r = new Random();
	ShapeRenderer shapeRenderer;

	// runs when the program begins
	@Override
	public void create(){
		this.shapeRenderer = new ShapeRenderer();
	}

	// runs every frame
	@Override
	public void render(){
		// clear screen at the beginning of frame
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

		//updates position of the ball and platform
		bouncingBall.update();
		movingPlatform.update();
		// draws a circle at x, y position, with radius radius
		bouncingBall.draw(shapeRenderer);
		movingPlatform.draw(shapeRenderer);

		shapeRenderer.end();
	}
}