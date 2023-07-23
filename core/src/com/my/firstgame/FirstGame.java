package com.my.firstgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class FirstGame extends ApplicationAdapter{

	Ball bouncingBall = new Ball(50, 50, 50, 12, 5);
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


		// makes the ball run back and forward between the edges of the screen while jumping
		bouncingBall.update();

		// draws a circle at x, y position, with radius radius
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		bouncingBall.draw(shapeRenderer);
		shapeRenderer.end();
	}
}