package com.my.firstgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

import java.util.Random;

public class Ball {

    private int x;
    private int y;
    private int radius;
    private int xSpeed;
    private int ySpeed;

    private Color color = Color.WHITE;

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
        shapeRenderer.setColor(color);
        shapeRenderer.circle(x, y, radius);
    }

    // checks if the ball is colliding with the platform
    // if the ball is colliding with the platform, change color to green
    public void checkCollision(Platform platform){
        if (collidesWith(platform)) {
            ySpeed = -ySpeed;
        }
    }


    // returns true if the ball is touching the platform
    private boolean collidesWith(Platform platform){
        boolean collision = false;

        //get the extreme points for the platform
        int platformMinWidth = platform.getX();
        int platformMaxWidth = platform.getX() + platform.getWidth();
        int platformMinHeight = platform.getY();
        int platformMaxHeight = platform.getY() + platform.getHeight();

        //get the extreme points for the ball
        int ballMinWidth = x - radius;
        int ballMaxWidth = x + radius;
        int ballMinHeight = y - radius;
        int ballMaxHeight = y + radius;

        //check if the Ys overlap
        if(platformMaxHeight >= ballMinHeight && ballMaxHeight >= platformMinHeight){
            //check if the Xs overlap
            if(platformMaxWidth >= ballMinWidth && ballMaxWidth >= platformMinWidth){
                collision = true;
            }
        }

        return collision;
    }

    public void checkCollision(Block block){
        if (collidesWith(block)){
            ySpeed = -ySpeed;
            block.setDestroyed(true);
        }
    }

    private boolean collidesWith(Block block){
        boolean collision = false;

        //get the extreme points for the block
        int blockMinWidth = block.getX();
        int blockMaxWidth = block.getX() + block.getWidth();
        int blockMinHeight = block.getY();
        int blockMaxHeight = block.getY() + block.getHeight();

        //get the extreme points for the ball
        int ballMinWidth = x - radius;
        int ballMaxWidth = x + radius;
        int ballMinHeight = y - radius;
        int ballMaxHeight = y + radius;

        //check if the Ys overlap
        if(blockMaxHeight >= ballMinHeight && ballMaxHeight >= blockMinHeight){
            //check if the Xs overlap
            if(blockMaxWidth >= ballMinWidth && ballMaxWidth >= blockMinWidth){
                collision = true;
            }
        }

        return collision;
    }
}
