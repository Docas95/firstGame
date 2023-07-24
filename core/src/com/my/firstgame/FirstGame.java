package com.my.firstgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;

public class FirstGame extends ApplicationAdapter{

	private Platform movingPlatform =  new Platform(0,10, 100, 7);
	private Ball bouncingBall = new Ball(10, 10, 10, 7, 5);
	private ShapeRenderer shapeRenderer;

	private ArrayList<Block> blocks =  new ArrayList<>();

	private int blockHeight = 20;

	private int blockWidth = 63;

	private Sound soundPlayer;

	private int points = 0;

	// runs when the program begins
	@Override
	public void create(){
		this.shapeRenderer = new ShapeRenderer();

		//creates a group og blocks starting at the middle Y of the screen
		for (int y = Gdx.graphics.getHeight()/2 + 2*blockHeight; y < Gdx.graphics.getHeight(); y += 10 + blockHeight) {
			for (int x = 0; x < Gdx.graphics.getWidth(); x += 10 + blockWidth){
				blocks.add(new Block(x, y, blockWidth, blockHeight));
			}
		}

		bouncingBall.setJumpSound(Gdx.audio.newSound(Gdx.files.internal("jump.mp3")));
	}

	// runs every frame
	@Override
	public void render(){
		// clear screen at the beginning of frame
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//begin shape renderer
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

		// updates position of the ball and platform
		bouncingBall.update();
		movingPlatform.update();

		// checks if ball and platform are touching
		bouncingBall.checkCollision(movingPlatform);

		// draws a circle at x, y position
		bouncingBall.draw(shapeRenderer);

		//draws moving platform
		movingPlatform.draw(shapeRenderer);

		//draws all blocks
		for(Block block : blocks){
			block.draw(shapeRenderer);
			bouncingBall.checkCollision(block);
		}

		//remove destroyed blocks
		for (int i = 0; i < blocks.size(); i++) {
			Block blockTmp = blocks.get(i);
			if (blockTmp.getDestroyed()){
				blocks.remove(blockTmp);
				i--;

				points++;
			}
		}

		//finish shape renderer
		shapeRenderer.end();
	}
}
