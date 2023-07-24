package com.my.firstgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public class Platform {
    private int height;
    private int width;
    private int x;
    private int y;

    private Color color = Color.WHITE;

    public Platform(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public void update(){
        // change the position of the platform based on mose position
        x = Gdx.input.getX();

        // the platform can't move past the edge of the screen
        if(x > Gdx.graphics.getWidth() - width) x = Gdx.graphics.getWidth() - width - 5;
        if(x < 5) x = 5;
    }

    // draws the platform on the screen
    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x, y, width, height);
    }
}
