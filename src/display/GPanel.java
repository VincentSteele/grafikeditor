package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class GPanel extends JPanel {

    private BufferedImage buffer;
    private BufferedImage oldBuffer;

    public GPanel() {
        this(130, 90, Color.BLUE);
    }

    public GPanel(int xSize, int ySize, Color bgColor) {
        this.setBackground(bgColor);
        this.setPreferredSize(new Dimension(xSize, ySize));
    }

    public BufferedImage cloneBuffer() {
        BufferedImage copy = new BufferedImage(
                buffer.getWidth(),
                buffer.getHeight(),
                buffer.getType()
        );

        Graphics g = copy.createGraphics();
        g.drawImage(buffer, 0, 0, null);
        g.dispose();

        return copy;
    }

    public void swapBuffer() {
        BufferedImage temp = oldBuffer;
        oldBuffer = buffer;
        buffer = temp;
    }

    public void brightness(double percent) {
        oldBuffer = buffer;
        buffer = MaRGB.brightness(buffer, percent);
    }

    public void greyscale() {
        oldBuffer = buffer;
        buffer = MaRGB.greyscale(buffer);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        int h = this.getHeight();
        int w = this.getWidth();

        if (buffer == null) {
            g.setColor(this.getBackground());
            g.fillRect(0, 0, w, h);

            g.setColor(Color.BLACK);
            g.drawRect(0, 0, w, h);
            g.drawLine(0, 0, w - 1, h - 1);
            g.drawLine(0, h - 1, w - 1, 0);
        } 
        else {
            g.drawImage(buffer, 0, 0, null);
        }
    }
    
    public BufferedImage getBuffer() {
        return buffer;
    }
        
    public void setBuffer(BufferedImage buffer) {
        this.buffer = buffer;
    }
}
