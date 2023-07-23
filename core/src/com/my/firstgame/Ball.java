package com.my.firstgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {

    private int x;
    private int y;
    private int radius;
    private int xSpeed;
    private int ySpeed;

    // create a new ball
    public Ball(int x, int y, int radius, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    //updates every frame
    public void update(){
        // makes the circle move
        x+=xSpeed;
        y+=ySpeed;

        // if the circle is out of the screen, invert the direction of it's trajectory
        if(x < radius || x > Gdx.graphics.getWidth() - radius) xSpeed = -xSpeed;
        if(y < radius || y > Gdx.graphics.getHeight() - radius) ySpeed = -ySpeed;
    }

    // draw a circle on screen
    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.circle(x, y, radius);
    }
}
