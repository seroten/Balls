package common;

import common.GameCanvas;

import java.awt.*;

public interface CanvasListener {
    void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime);
}
