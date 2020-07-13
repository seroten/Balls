package Bricks;

import common.GameCanvas;
import common.GameObject;

import java.awt.*;

public class Background implements GameObject {
    int red;
    int green;
    int blue;
    Color color = new Color(0, 0, 0);

    int incrementR = 10;
    int incrementG = 5;
    int incrementB = 1;

    float time = 0;
    public Background() {

    }

    @Override
    public void update(GameCanvas canvas, float deltaTime) {
        time += deltaTime;
        if(time > 0.01) {
            red += incrementR;
            green += incrementG;
            blue += incrementB;
            if (red > 255 || red < 0) {red -= incrementR; incrementR *= (-1);}
            if (green > 255 || green < 0) {green -= incrementG; incrementG *= (-1);}
            if (blue > 255 || blue < 0) {blue -= incrementB; incrementB *= (-1);}
            color = new Color(red, green, blue);
            time = 0;
        }
    }

    @Override
    public void render(GameCanvas gameCanvas, Graphics g) {
        gameCanvas.setBackground(color);
    }
}
