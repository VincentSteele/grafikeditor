
import display.ImageFileChooser;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
 
// todo resize, zoom offset mitte

public class ImageFrame extends javax.swing.JFrame {

    private static final int ZOOMSTUFEN = 20;
    
    private static final List<String> SUPPORTED_FORMATS = List.of("tif", "jpg", "tiff", "bmp", "gif", "png", "wbmp", "jpeg");
    
    private static ImageFrame frame;
    
    private ImageFileChooser fileChooser = new ImageFileChooser();

    private ImageFrame() {
        this.initComponents();
        this.initCustom();
        this.initMenu();
        
        BufferedImage buffer = null;
        
        try {
            buffer = ImageIO.read(new File("JCert.jpg"));
        } catch (IOException ex) {
            System.err.println("Grafik kann nicht geladen werden: " + ex);
        }
        
        this.gpBild.setBuffer(buffer);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gpBild = new display.GPanel();
        jPanel1 = new javax.swing.JPanel();
        paSidePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        buHell = new javax.swing.JButton();
        buDunkel = new javax.swing.JButton();
        buAufhellen = new javax.swing.JButton();
        buAbdunkeln = new javax.swing.JButton();
        buGraustufen = new javax.swing.JButton();
        buOptimieren = new javax.swing.JButton();
        buZurueck = new javax.swing.JButton();
        spMessages = new javax.swing.JScrollPane();
        taMessages = new javax.swing.JTextArea();
        cbZoom = new javax.swing.JComboBox<>();
        buAutozoom = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        meDatei = new javax.swing.JMenu();
        meHilfe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GrafikEditor01");

        javax.swing.GroupLayout gpBildLayout = new javax.swing.GroupLayout(gpBild);
        gpBild.setLayout(gpBildLayout);
        gpBildLayout.setHorizontalGroup(
            gpBildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        gpBildLayout.setVerticalGroup(
            gpBildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        buHell.setText("Hell");
        buHell.setToolTipText("Helligkeitsregler höher");
        buHell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buHellActionPerformed(evt);
            }
        });

        buDunkel.setText("Dunkel");
        buDunkel.setToolTipText("Helligkeitsregler runter");
        buDunkel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buDunkelActionPerformed(evt);
            }
        });

        buAufhellen.setText("aufhellen");
        buAufhellen.setToolTipText("Mit weisser Farbe aufhellen.");
        buAufhellen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buAufhellenActionPerformed(evt);
            }
        });

        buAbdunkeln.setText("abdunkeln");
        buAbdunkeln.setToolTipText("Mit schwarzer Farbe abdunkeln.");
        buAbdunkeln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buAbdunkelnActionPerformed(evt);
            }
        });

        buGraustufen.setText("Graustufen");
        buGraustufen.setToolTipText("In Graustufen umwandeln.");
        buGraustufen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buGraustufenActionPerformed(evt);
            }
        });

        buOptimieren.setText("Optimieren");
        buOptimieren.setToolTipText("Helligkeitsbereich optimal ausnutzen.");
        buOptimieren.setEnabled(false);

        buZurueck.setText("Zurück");
        buZurueck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buZurueckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buAufhellen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buGraustufen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buAbdunkeln, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buOptimieren, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
            .addComponent(buZurueck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buHell, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buDunkel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buHell)
                    .addComponent(buDunkel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buAufhellen)
                    .addComponent(buAbdunkeln))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buGraustufen)
                    .addComponent(buOptimieren))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buZurueck))
        );

        taMessages.setEditable(false);
        taMessages.setColumns(20);
        taMessages.setRows(5);
        spMessages.setViewportView(taMessages);

        cbZoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbZoomActionPerformed(evt);
            }
        });

        buAutozoom.setText("Autozoom");
        buAutozoom.setToolTipText("In Graustufen umwandeln.");
        buAutozoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buAutozoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paSidePanelLayout = new javax.swing.GroupLayout(paSidePanel);
        paSidePanel.setLayout(paSidePanelLayout);
        paSidePanelLayout.setHorizontalGroup(
            paSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(spMessages)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paSidePanelLayout.createSequentialGroup()
                        .addComponent(cbZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buAutozoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paSidePanelLayout.setVerticalGroup(
            paSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbZoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buAutozoom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        meDatei.setText("Datei");
        jMenuBar1.add(meDatei);

        meHilfe.setText("Hilfe");
        jMenuBar1.add(meHilfe);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gpBild, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paSidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gpBild, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 423, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buAutozoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buAutozoomActionPerformed
        float scale = this.gpBild.fitScale();
        this.gpBild.repaint();
        this.cbZoom.getModel().setSelectedItem(String.format("%.2f", (scale * 100)) + "%");
    }//GEN-LAST:event_buAutozoomActionPerformed

    private void cbZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbZoomActionPerformed
        try
        {
            String selected = (String)this.cbZoom.getModel().getSelectedItem();
            int percent = Integer.parseInt(selected.replace("%", ""));
            this.gpBild.setScale(percent);
            this.gpBild.repaint();
        }
        catch (NumberFormatException ignored) {}
    }//GEN-LAST:event_cbZoomActionPerformed

    private void buZurueckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buZurueckActionPerformed
        this.gpBild.swapBuffer();
        this.gpBild.repaint();
        this.taMessages.append("Zurück\n");
    }//GEN-LAST:event_buZurueckActionPerformed

    private void buGraustufenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buGraustufenActionPerformed
        this.gpBild.greyscale();
        this.gpBild.repaint();
        this.taMessages.append("Graustufen\n");
    }//GEN-LAST:event_buGraustufenActionPerformed

    private void buAbdunkelnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buAbdunkelnActionPerformed
        this.gpBild.darker(10);
        this.gpBild.repaint();
        this.taMessages.append("abdunkeln\n");
    }//GEN-LAST:event_buAbdunkelnActionPerformed

    private void buAufhellenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buAufhellenActionPerformed
        this.gpBild.lighter(10);
        this.gpBild.repaint();
        this.taMessages.append("aufhellen\n");
    }//GEN-LAST:event_buAufhellenActionPerformed

    private void buDunkelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buDunkelActionPerformed
        this.gpBild.brightness(80);
        this.gpBild.repaint();
        this.taMessages.append("Dunkel\n");
    }//GEN-LAST:event_buDunkelActionPerformed

    private void buHellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buHellActionPerformed
        this.gpBild.brightness(120);
        this.gpBild.repaint();
        this.taMessages.append("Hell\n");
    }//GEN-LAST:event_buHellActionPerformed

    private void initCustom() {
        this.getContentPane().removeAll();
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(this.gpBild, BorderLayout.CENTER);
        this.getContentPane().add(this.paSidePanel, BorderLayout.EAST);
        
        this.gpBild.addMouseWheelListener(e -> {
            if (this.cbZoom.getSelectedIndex() == -1) {
                String sel = (String)this.cbZoom.getSelectedItem();
                int curZoom = Integer.parseInt(sel.substring(0, sel.indexOf(','))) / 10;
                
                if (e.getWheelRotation() > 0) {
                    curZoom--;
                }
                
                if (curZoom >= this.cbZoom.getItemCount()) {
                    curZoom = this.cbZoom.getItemCount() - 1;
                }
                else if (curZoom < 0) {
                    curZoom = 0;
                }  
                
                this.cbZoom.setSelectedIndex(curZoom);
            }
            else {
                if (e.getWheelRotation() < 0) {
                    this.cbZoom.setSelectedIndex(Math.min(this.cbZoom.getItemCount() - 1, cbZoom.getSelectedIndex() + 1));
                }
                else if (e.getWheelRotation() > 0) {
                    this.cbZoom.setSelectedIndex(Math.max(0, this.cbZoom.getSelectedIndex() - 1));
                }
            }
        });
        
        this.spMessages.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<>();
        
        for (int i = 1; i <= ZOOMSTUFEN; i++) {
            cbModel.addElement((i * 10) + "%");
        }
        
        this.cbZoom.setModel(cbModel);
        this.cbZoom.getModel().setSelectedItem("100%");
    }
    
    private void initMenu() {
        // Datei
        
        this.meDatei.setMnemonic('d');
        
        JMenuItem loadImageItem = new JMenuItem("Bild laden");
        loadImageItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));
        loadImageItem.addActionListener(e -> this.openImage());
        this.meDatei.add(loadImageItem);
        
        JMenuItem saveAsItem = new JMenuItem("Speichern unter");
        saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        saveAsItem.addActionListener(e -> this.saveImage());
        this.meDatei.add(saveAsItem);
        
        this.meDatei.add(new JSeparator());
        
        JMenuItem exitItem = new JMenuItem("Beenden");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));
        exitItem.addActionListener(e -> System.exit(0));
        this.meDatei.add(exitItem);
        
        // Hilfe
        
        this.meHilfe.setMnemonic('h');
        
        JMenuItem infoItem = new JMenuItem("Info");
        infoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
        infoItem.addActionListener(e -> this.showInfo());
        this.meHilfe.add(infoItem);
        
    }
    
    private void openImage() {
        int result = this.fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = this.fileChooser.getSelectedFile();
                BufferedImage img = ImageIO.read(file);
                
                this.gpBild.setBuffer(img);
                this.buAutozoomActionPerformed(null);
                
                this.taMessages.append("Datei geladen\n");
            } catch (IOException ex) {
                this.taMessages.append(ex.getMessage() + "\n");
            }
        }
    }
    
    private void saveImage() {
        int result = this.fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = this.fileChooser.getSelectedFile();
                String[] nameParts = file.getName().split("\\.");
                String format;
                
                if (nameParts.length > 1) {
                    format = nameParts[nameParts.length - 1];
                }
                else {
                    format = "png";
                    file = new File(file.getAbsoluteFile() + ".png");
                }
                        
                if (SUPPORTED_FORMATS.contains(format)) {
                    ImageIO.write(this.gpBild.getBuffer(), format, file);
                    this.taMessages.append("Datei gespeichert\n");
                }
                else {
                    this.taMessages.append("Format nicht unterstützt\n");
                }
            } catch (IOException ex) {
                this.taMessages.append(ex.getMessage() + "\n");
            }
        }
    }
        
    private void showInfo() {
        String html = "<html>" +
                      "<h1>-+-+- Grafikeditor v2 -+-+-</h1>" +
                      "<ul>" +
                      "<li> füll </li>" +
                      "<li> mich </li>" +
                      "<li> aus </li>" +
                      "</ul>" +
                      "&copy; 2025 Dominik Szekely, ITO8" +
                      "</html>";

        JOptionPane.showMessageDialog(this, html, "Info", JOptionPane.PLAIN_MESSAGE);
    }
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ignored) {}

        java.awt.EventQueue.invokeLater(() -> {
            frame = new ImageFrame();
            frame.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buAbdunkeln;
    private javax.swing.JButton buAufhellen;
    private javax.swing.JButton buAutozoom;
    private javax.swing.JButton buDunkel;
    private javax.swing.JButton buGraustufen;
    private javax.swing.JButton buHell;
    private javax.swing.JButton buOptimieren;
    private javax.swing.JButton buZurueck;
    private javax.swing.JComboBox<String> cbZoom;
    private display.GPanel gpBild;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu meDatei;
    private javax.swing.JMenu meHilfe;
    private javax.swing.JPanel paSidePanel;
    private javax.swing.JScrollPane spMessages;
    private javax.swing.JTextArea taMessages;
    // End of variables declaration//GEN-END:variables
}
