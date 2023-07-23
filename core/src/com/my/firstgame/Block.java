package com.my.firstgame;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.graphics.Color;

public class Block {
    private int x;
    private int y;
    private int height;
    private int width;

    private Color color = Color.WHITE;

    public Block(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.rect(x, y, width, height);
    }
}
