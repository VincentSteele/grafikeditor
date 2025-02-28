package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class GPanel extends JPanel {

    private BufferedImage buffer;
    private BufferedImage oldBuffer;
    
    private float scale = 1;

    public GPanel() {
        this(130, 90, Color.BLUE);
    }

    public GPanel(int xSize, int ySize, Color bgColor) {
        this.setBackground(bgColor);
        this.setPreferredSize(new Dimension(xSize, ySize));
    }

    public BufferedImage cloneBuffer() {
        BufferedImage copy = new BufferedImage(
                this.buffer.getWidth(),
                this.buffer.getHeight(),
                this.buffer.getType()
        );

        Graphics g = copy.createGraphics();
        g.drawImage(this.buffer, 0, 0, null);
        g.dispose();

        return copy;
    }

    public void brightness(double percent) {
        this.oldBuffer = this.buffer;
        this.buffer = MaRGB.brightness(this.buffer, percent);
    }
    
        public void lighter(double percent) {
        this.oldBuffer = this.buffer;
        this.buffer = MaRGB.lighter(this.buffer, percent);
    }
    
    public void darker(double percent) {
        this.oldBuffer = this.buffer;
        this.buffer = MaRGB.darker(this.buffer, percent);
    }

    public void greyscale() {
        this.oldBuffer = this.buffer;
        this.buffer = MaRGB.greyscale(this.buffer);
    }
   
    public void swapBuffer() {
        BufferedImage temp = this.oldBuffer;
        this.oldBuffer = this.buffer;
        this.buffer = temp;
    }
        
    @Override
    public void paintComponent(Graphics g) {
        if (this.buffer == null) {
            int h = this.getHeight();
            int w = this.getWidth();
            g.setColor(this.getBackground());
            g.fillRect(0, 0, w, h);

            g.setColor(Color.BLACK);
            g.drawRect(0, 0, w, h);
            g.drawLine(0, 0, w - 1, h - 1);
            g.drawLine(0, h - 1, w - 1, 0);
        } 
        else {
            Graphics2D g2d = (Graphics2D)g;
            
            int h = (int)(this.buffer.getHeight() * this.scale);
            int w = (int)(this.buffer.getWidth() * this.scale);
            
            // set rendering
            
            g2d.drawImage(this.buffer, 0, 0, w, h, null);
        }
    }
    
    public BufferedImage getBuffer() {
        return buffer;
    }
        
    public void setBuffer(BufferedImage buffer) {
        this.oldBuffer = this.buffer;
        this.buffer = buffer;
    }
    
    public void setScale(int percent)
    {
        this.scale = (float)percent / 100;
    }
    
    public float fitScale()
    {
        float sx = (float)this.getWidth() / this.buffer.getWidth();
        float sy = (float)this.getHeight() / this.buffer.getHeight();
        this.scale = Math.min(sx, sy);
        return this.scale;
    }
}
