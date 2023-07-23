package com.my.firstgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;
import java.util.Random;

public class FirstGame extends ApplicationAdapter{

	Platform movingPlatform =  new Platform(0,10, 100, 7);
	Ball bouncingBall = new Ball(20, 300, 20, 12, 5);
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

		// updates position of the ball and platform
		bouncingBall.update();
		movingPlatform.update();

		// checks if ball and platform are touching
		bouncingBall.checkCollision(movingPlatform);

		// draws a circle at x, y position, with radius radius
		bouncingBall.draw(shapeRenderer);
		movingPlatform.draw(shapeRenderer);

		shapeRenderer.end();
	}
}