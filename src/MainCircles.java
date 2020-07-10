import javax.swing.*;
import java.awt.*;

public class MainCircles extends JFrame{
    private static final int POS_X = 200;
    private static final int POS_Y = 100;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    int count = 0;
    Background bg = new Background();

    Sprite[] sprites = new Sprite[10];

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

        setResizable(false);
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }
    public void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }
    public void update(GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(gameCanvas, deltaTime);
            count++;
            if(count == 10) {
                bg.update();
                count = 0;
            }
        }
    }
    public void render(GameCanvas gameCanvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            gameCanvas.setBackground(bg.render());
            sprites[i].render(gameCanvas, g);
        }
    }
}