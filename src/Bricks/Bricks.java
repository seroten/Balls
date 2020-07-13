package Bricks;

import common.GameCanvas;
import common.Sprite;

import java.awt.*;

public class Bricks extends Sprite {
    private final Color color = new Color (
        (int) (Math.random() * 255),
        (int) (Math.random() * 255),
        (int) (Math.random() * 255)
    );

    private float vX = (float)(400f + Math.random() * 200f);
    private float vY = (float)(200f + Math.random() * 200f);

    public Bricks() {
        Height = 40 + (float)(Math.random() * 50f);
        Width = Height;
    }

    public Bricks(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }


    @Override
    public void update(GameCanvas gameCanvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;
        if(getLeft() < gameCanvas.getLeft()) {
            setLeft(gameCanvas.getLeft());
            vX = -vX;
        }
        if(getRight() > gameCanvas.getRight()) {
            setRight(gameCanvas.getRight());
            vX = -vX;
        }
        if(getTop() < gameCanvas.getTop()) {
            setTop(gameCanvas.getTop());
            vY = -vY;
        }
        if(getBottom() > gameCanvas.getBottom()) {
            setBottom(gameCanvas.getBottom());
            vY = -vY;
        }
    }

    @Override
    public void render(GameCanvas gameCanvas, Graphics g) {
        g.setColor(color);
        g.fillRect((int)getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}
