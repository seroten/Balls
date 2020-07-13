package Balls;

import common.CanvasListener;
import common.GameCanvas;
import common.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame implements CanvasListener {
    private static final int POS_X = 200;
    private static final int POS_Y = 100;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    int gameObjectsCount;
    GameObject[] gameObjects = new GameObject[1];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        initApplication();
        GameCanvas gameCanvas = new GameCanvas(this);
        add(gameCanvas, BorderLayout.CENTER);
        gameCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    addGameObject(new Ball(e.getX(), e.getY()));
                }
                if(e.getButton() == MouseEvent.BUTTON3) {
                    removeGameObject();
                }
            }
        });
        setResizable(false);
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        addGameObject(new Background());
        addGameObject(new Ball());
    }

    private void addGameObject(GameObject sprite) {
        if(gameObjectsCount == gameObjects.length) {
            GameObject[] newGameObjects = new GameObject[gameObjects.length*2];
            System.arraycopy(gameObjects, 0, newGameObjects, 0, gameObjects.length);
            gameObjects = newGameObjects;
        }
        gameObjects[gameObjectsCount++] = sprite;
    }

    private void removeGameObject() {
        if(!(gameObjects[gameObjectsCount-1] instanceof Background)) {
            gameObjectsCount--;
        }
    }

    @Override
    public void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    public void update(GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < gameObjectsCount; i++) {
            gameObjects[i].update(gameCanvas, deltaTime);
        }
    }

    public void render(GameCanvas gameCanvas, Graphics g) {
        for (int i = 0; i < gameObjectsCount; i++) {
            gameObjects[i].render(gameCanvas, g);
        }
    }
}