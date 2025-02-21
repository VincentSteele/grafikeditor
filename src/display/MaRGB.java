package display;

import java.awt.image.BufferedImage;
import xjama.Matrix;
import xswing.BuImgWrapper;

public class MaRGB {
    
    public static BufferedImage brightness(BufferedImage buffer, double percent) {
        BuImgWrapper img = new BuImgWrapper(buffer);
        img.setColorMatrix(img.getColorMatrix().times(percent / 100));
        return img;
    }
    
    public static BufferedImage lighter(BufferedImage buffer, double percent) {
        BuImgWrapper img = new BuImgWrapper(buffer);
        Matrix cm = img.getColorMatrix();
        
        Matrix wm = new Matrix(3, cm.getColumnDimension(), 1.0);

        double f = percent / 100;
        img.setColorMatrix(cm.times(1 - f).plus(wm.times(f)));
        
        return img;
    }
    
        public static BufferedImage darker(BufferedImage buffer, double percent) {
        BuImgWrapper img = new BuImgWrapper(buffer);
        Matrix cm = img.getColorMatrix();
        
        Matrix wm = new Matrix(3, cm.getColumnDimension(), 0.0);

        double f = percent / 100;
        img.setColorMatrix(cm.times(1 - f).plus(wm.times(f)));
        
        return img;
    }
    
    public static BufferedImage greyscale(BufferedImage buffer) {
        BuImgWrapper img = new BuImgWrapper(buffer);
        
        // https://de.wikipedia.org/wiki/Luminanz
        Matrix gm = new Matrix(new double[][] { {0.299, 0.587, 0.114} }).times(img.getColorMatrix()); 
        img.setColorMatrix(new Matrix(3, 1, 1.0).times(gm));
        
        return img;
    }
}
