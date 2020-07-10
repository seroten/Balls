import java.awt.*;

public class Background{
    int[] rgb = {0, 0, 0};

    int incrementR = 10;
    int incrementG = 5;
    int incrementB = 1;

    double lastUpdateTime = System.nanoTime() * 0.000000001;
    double deltaTime;
    public Background() {

    }

    public int[] update() {
        deltaTime = System.nanoTime() * 0.000000001 - lastUpdateTime;
        if(deltaTime > 0.01) {
            rgb[0] += incrementR;
            rgb[1] += incrementG;
            rgb[2] += incrementB;
            if (rgb[0] > 255 || rgb[0] < 0) {
                rgb[0] -= incrementR;
                incrementR *= (-1);
            }
            if (rgb[1] > 255 || rgb[1] < 0) {
                rgb[1] -= incrementG;
                incrementG *= (-1);
            }
            if (rgb[2] > 255 || rgb[2] < 0) {
                rgb[2] -= incrementB;
                incrementB *= (-1);
            }
            deltaTime = 0;
            lastUpdateTime = System.nanoTime() * 0.000000001;
        }
        return rgb;
    }
    public Color render() {
       return new Color(rgb[0], rgb[1], rgb[2]);
    }
}
