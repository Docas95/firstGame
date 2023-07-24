package com.my.firstgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.audio.Sound;

public class Block {
    private int x;
    private int y;
    private int height;
    private int width;

    private Color color = Color.GREEN;

    private boolean destroyed;

    private Sound destroyedSound = Gdx.audio.newSound(Gdx.files.internal("block_destroyed.mp3"));

    public Block(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        destroyed = false;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public boolean getDestroyed(){
        return destroyed;
    }

    public void setDestroyed(boolean destroyed){
        this.destroyed = destroyed;
        if(destroyed){
            destroyedSound.play(0.1f);
        }
    }

    public Sound getDestroyedSound(){
        return destroyedSound;
    }

    //draws a block on the screen
    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x, y, width, height);
    }
}
