package com.my.firstgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Platform {
    int height;
    int width;
    int x;
    int y;

    public Platform(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update(){
        x = Gdx.input.getX();
        // the platform can't move past the edge of the screen
        if(x > Gdx.graphics.getWidth() - width) x = Gdx.graphics.getWidth() - width - 5;
        if(x < width) x = 5;
    }

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.rect(x, y, width, height);
    }
}
