import java.awt.*;

public class Ball extends Sprite {
    private final Color color = new Color (
        (int) (Math.random() * 255),
        (int) (Math.random() * 255),
        (int) (Math.random() * 255)
    );

    private float vX = (float)(200f + Math.random() * 200f);
    private float vY = (float)(200f + Math.random() * 200f);

    public Ball() {
        halfHeight = 20 + (float)(Math.random() * 50f);
        halfWidth = halfHeight;
    }

    @Override
    void update(GameCanvas gameCanvas, float deltaTime) {
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
    void render(GameCanvas gameCanvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int)getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}
