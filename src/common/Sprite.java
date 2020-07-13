package common;

import java.awt.*;

public class Sprite implements GameObject{
    protected float x;
    protected float y;
    protected float Width;
    protected float Height;

    protected float getLeft() {
    return x;
}
    protected void setLeft(float left) {
        x = left;
    }
    protected float getRight() {
        return x + Width;
    }
    protected void setRight(float right) {
        x = right - Width;
    }
    protected float getTop() {
        return y;
    }
    protected void setTop(float top) {
        y = top;
    }
    protected  float getBottom() {
        return y + Height;
    }
    protected void setBottom(float bottom) {
        y = bottom - Height;
    }
    protected float getWidth() {
        return Width;
    }
    protected float getHeight() {
        return Height;
    }
    @Override
    public void update(GameCanvas gameCanvas, float deltaTime) {}
    @Override
    public void render(GameCanvas gameCanvas, Graphics g) {}
}
