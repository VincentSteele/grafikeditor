package display;

import java.awt.image.BufferedImage;
import xjama.Matrix;
import xswing.BuImgWrapper;

public class MaRGB {
    
    public static BufferedImage brightness(BufferedImage buffer, double percent) {
        BuImgWrapper img = new BuImgWrapper(buffer);
        double f = percent / 100;
        img.setColorMatrix(img.getColorMatrix().times(f));
        return img;
    }
    
    public static BufferedImage greyscale(BufferedImage buffer) {
        BuImgWrapper img = new BuImgWrapper(buffer);
        Matrix cm = img.getColorMatrix();
        Matrix gm = new Matrix(3, cm.getColumnDimension());

        for (int i = 0; i < cm.getColumnDimension(); i++) {
            double r = cm.get(0, i);
            double g = cm.get(1, i);
            double b = cm.get(2, i);

            // https://de.wikipedia.org/wiki/Luminanz
            double grey = 0.299 * r + 0.587 * g + 0.114 * b;

            gm.set(0, i, grey);
            gm.set(1, i, grey);
            gm.set(2, i, grey);
        }

        img.setColorMatrix(gm);
        return img;
    }
    
}
