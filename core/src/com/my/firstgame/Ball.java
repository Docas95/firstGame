package com.my.firstgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Ball extends Actor {

    private int x;
    private int y;
    private int radius;
    private int xSpeed;
    private int ySpeed;

    private Color color = Color.GREEN;

    private Sound jumpSound;

    // create a new ball
    public Ball(int x, int y, int radius, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void setJumpSound(Sound jumpSound){
        this.jumpSound = jumpSound;
    }

    //updates every frame
    public void update(){
        // makes the circle move
        x+=xSpeed;
        y+=ySpeed;

        // if the circle is out of the screen, invert the direction of it's trajectory
        if(x < radius && xSpeed < 0) xSpeed = -xSpeed;
        if (x > Gdx.graphics.getWidth() - radius && xSpeed > 0) xSpeed = -xSpeed;

        if(y < radius && ySpeed < 0) ySpeed = -ySpeed;
        if(y > Gdx.graphics.getHeight() - radius && ySpeed > 0) ySpeed = -ySpeed;
    }

    // draw a circle on screen
    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(color);
        shapeRenderer.circle(x, y, radius);
    }

    // checks if the ball is colliding with the platform
    // if the ball is colliding with the platform, change color to green
    public void checkCollision(Platform platform){
        if (collidesWith(platform) == 1) {
            jumpSound.play(0.4f);
            ySpeed = -ySpeed;
            if(xSpeed > 0) xSpeed = -xSpeed;
        } else if (collidesWith(platform) == 2){
            jumpSound.play(0.4f);
            ySpeed = -ySpeed;
            if(xSpeed < 0) xSpeed = -xSpeed;
        }
    }


    // returns true if the ball is touching the platform
    // if the ball is touching the left side of the platform, returns 1
    // if the ball is touching the right side of the platform, returns 2
    private int collidesWith(Platform platform){
        int collision = 0;

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
                collision = 1;
            }
        }

        // check if the ball is on the right or left side of platform
        int platformMidWidth = (platformMaxWidth + platformMinWidth) / 2;
        if(collision == 1){
            if(x >= platformMidWidth) collision = 2;
        }

        return collision;
    }

    // checks if the ball is colliding with a block
    public void checkCollision(Block block){
        if (collidesWith(block) == 1){
            ySpeed = -ySpeed;
            block.setDestroyed(true);
        } else if (collidesWith(block) == 2){
            xSpeed = -xSpeed;
            block.setDestroyed(true);
        }
    }

    // checks if the ball is colliding with a block
    // returns 0 if no
    // returns 1 if touching the top or bottom of a block
    // returns 2 if touching the sides of a block
    private int collidesWith(Block block){
        int collision = 0;

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
                collision = 1;
            }
        }


        // check if the ball is touching the side of the block
        if(collision == 1) {
            if (x <= blockMinWidth || x >= blockMaxWidth) collision = 2;
        }

        return collision;
    }
}
