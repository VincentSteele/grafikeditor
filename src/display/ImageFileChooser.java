package display;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * JFileChooser for graphic files from ImageIO with picture preview.
 * @version 1.0
 * @author rla
 */
public class ImageFileChooser extends JFileChooser {

	private JLabel previewLabel;
	private static final int PREVIEW_SIZE = 170;

	public ImageFileChooser() {
    	super();
    	initComponents();
	}

	private void initComponents() {
    	// Dateifilter einrichten
    	setFileFilter(new ImageFileFilter());

    	// Vorschaulabel erstellen
    	previewLabel = new JLabel("", JLabel.CENTER);
    	previewLabel.setPreferredSize(new Dimension(PREVIEW_SIZE, PREVIEW_SIZE));
    	setAccessory(previewLabel);

    	// Listener für Dateiänderungen hinzufügen
    	addPropertyChangeListener((PropertyChangeEvent evt) -> {
        	if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(evt.getPropertyName())) {
            	File file = (File) evt.getNewValue();
            	updatePreview(file);
        	}
    	});
	}

	private void updatePreview(File file) {
    	if (file == null || file.isDirectory()) {
        	previewLabel.setIcon(null);
        	previewLabel.setText("no preview");
            return;
    	}

    	try {
        	BufferedImage image = ImageIO.read(file);
        	if (image == null) {
            	throw new Exception("Unsupported image format");
        	}

        	// Skalieren des Bildes
        	Image scaled = scaleImage(image);
        	previewLabel.setIcon(new ImageIcon(scaled));
        	previewLabel.setText("");
    	} catch (Exception e) {
        	previewLabel.setIcon(null);
        	previewLabel.setText("no preview availlable");
    	}
	}

	private Image scaleImage(BufferedImage image) {
    	int width = image.getWidth();
    	int height = image.getHeight();
    	double ratio = (double) width / height;

    	// Skalierungsgröße berechnen
    	int newWidth = PREVIEW_SIZE;
    	int newHeight = PREVIEW_SIZE;
    	if (ratio > 1) {
        	newHeight = (int) (PREVIEW_SIZE / ratio);
    	} else {
        	newWidth = (int) (PREVIEW_SIZE * ratio);
    	}

    	return image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
	}

	// Custom FileFilter für ImageIO-Formate
	private class ImageFileFilter extends FileFilter {

    	private final String[] supportedExtensions = ImageIO.getReaderFileSuffixes();

    	@Override
    	public boolean accept(File file) {
        	if (file.isDirectory()) {
            	return true;
        	}

        	String name = file.getName().toLowerCase();
        	for (String ext : supportedExtensions) {
            	if (name.endsWith("." + ext.toLowerCase())) {
                	return true;
            	}
        	}
        	return false;
    	}

    	@Override
    	public String getDescription() {
        	return "Graphic files (" + String.join(", ", supportedExtensions) + ")";
    	}
	}

	/**
 	* Demoprogramm zur Anwendung des ImageFileChoosers.
 	* @param args
 	*/
	public static void main(String[] args) {
    	JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	ImageFileChooser chooser = new ImageFileChooser();
    	int result = chooser.showOpenDialog(frame);

    	if (result == JFileChooser.APPROVE_OPTION) {
        	System.out.println("Gewählte Datei: " + chooser.getSelectedFile());
    	}

    	frame.dispose();
	}
}
