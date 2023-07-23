package com.my.firstgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;
import java.util.Random;

public class FirstGame extends ApplicationAdapter{

	ArrayList<Ball> bouncingBalls = new ArrayList<>();
	Random r = new Random();
	ShapeRenderer shapeRenderer;

	// runs when the program begins
	@Override
	public void create(){
		this.shapeRenderer = new ShapeRenderer();

		for (int i = 0; i < 10; i++) {
			bouncingBalls.add(new Ball(r.nextInt(Gdx.graphics.getWidth()), r.nextInt(Gdx.graphics.getHeight()), r.nextInt(70), r.nextInt(20), r.nextInt(14)));
		}
	}

	// runs every frame
	@Override
	public void render(){
		// clear screen at the beginning of frame
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		// makes the ball run back and forward between the edges of the screen while jumping
		for(Ball ball : bouncingBalls){
			ball.update();
			// draws a circle at x, y position, with radius radius
			ball.draw(shapeRenderer);
		}

		shapeRenderer.end();
	}
}