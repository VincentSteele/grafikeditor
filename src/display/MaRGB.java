package display;

import java.awt.image.BufferedImage;
import java.util.Comparator;
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
        
        Matrix wb = new Matrix(3, cm.getColumnDimension(), 0.0);

        double f = percent / 100;
        img.setColorMatrix(cm.times(1 - f).plus(wb.times(f)));
        
        return img;
    }
    
    public static BufferedImage greyscale(BufferedImage buffer) {
        BuImgWrapper img = new BuImgWrapper(buffer);
        
        // https://de.wikipedia.org/wiki/Luminanz
        Matrix gm = new Matrix(new double[][] { {0.299, 0.587, 0.114} }).times(img.getColorMatrix()); 
        img.setColorMatrix(new Matrix(3, 1, 1.0).times(gm));
        
        return img;
    }
    
    public static BufferedImage optimize(BufferedImage buffer) {
        BuImgWrapper img = new BuImgWrapper(buffer);
       
        Matrix cm = img.getColorMatrix();  
        Matrix minMax = cm.columnMinMax();
        
        double min = minMax.getRowList(0).stream().min(Double::compareTo).orElse(0d);
        double max = minMax.getRowList(1).stream().max(Double::compareTo).orElse(1d);

        Matrix bias = new Matrix(cm.getRowDimension(), cm.getColumnDimension(), min);
        double f = 1 / (max - min);

        img.setColorMatrix(cm.minus(bias).times(f));
        
        return img;
    }
}
