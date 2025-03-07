package display;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import static java.awt.RenderingHints.*;

public class GPanel extends JPanel  {

    private BufferedImage buffer;
    private BufferedImage oldBuffer;
    
    private float scale = 1;
    
    private int offsetX = 0;
    private int offsetY = 0;
    private int dragStartX = 0;
    private int dragStartY = 0;

    public GPanel() {
        this(130, 90, Color.BLUE);
    }

    public GPanel(int xSize, int ySize, Color bgColor) {
        this.setBackground(bgColor);
        this.setPreferredSize(new Dimension(xSize, ySize));
        
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dragStartX = e.getX() - offsetX;
                dragStartY = e.getY() - offsetY;
            }
        });
        
       
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                offsetX = e.getX() - dragStartX;
                offsetY = e.getY() - dragStartY;
                repaint();
            }
        });
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
            
            g2d.setRenderingHint(KEY_RENDERING, VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(KEY_COLOR_RENDERING, VALUE_COLOR_RENDER_QUALITY);
            
            if (this.scale == 1)
            {
                g2d.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_OFF);
                g2d.setRenderingHint(KEY_INTERPOLATION, VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
            }
            else
            {
                g2d.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(KEY_INTERPOLATION, VALUE_INTERPOLATION_BICUBIC);
            }

            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(0, 0, this.getMaximumSize().height, this.getMaximumSize().width);
            
            
            int h = (int)(this.buffer.getHeight() * this.scale);
            int w = (int)(this.buffer.getWidth() * this.scale);
            int x = (this.getWidth() - w) / 2;
            int y = (this.getHeight() - h) / 2;
            
            g2d.drawImage(this.buffer, x + this.offsetX, y + this.offsetY, w, h, null);
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
        this.offsetX = 0;
        this.offsetY = 0;
        
        return this.scale;
    }
}
