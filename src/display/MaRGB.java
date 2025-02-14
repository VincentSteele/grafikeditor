package display;

import java.awt.image.BufferedImage;
import xswing.BuImgWrapper;

public class MaRGB {
    public static BufferedImage setBrightness(BufferedImage buffer, double percent) {
        BuImgWrapper b = new BuImgWrapper(buffer);
        double f = percent / 100;
        b.setColorMatrix(b.getColorMatrix().times(f));
        return b;
    }
}
