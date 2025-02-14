
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 
public class ImageFrame extends javax.swing.JFrame {

    private static ImageFrame frame;

    private ImageFrame() {
        initComponents();
        
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
        buHell = new javax.swing.JButton();
        buDunkel = new javax.swing.JButton();
        buOptimieren = new javax.swing.JButton();
        buAufhellen = new javax.swing.JButton();
        buAbdunkeln = new javax.swing.JButton();
        buGraustufen = new javax.swing.JButton();
        buZurueck = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GrafikEditor01");

        javax.swing.GroupLayout gpBildLayout = new javax.swing.GroupLayout(gpBild);
        gpBild.setLayout(gpBildLayout);
        gpBildLayout.setHorizontalGroup(
            gpBildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        gpBildLayout.setVerticalGroup(
            gpBildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        buHell.setText("Hell");
        buHell.setToolTipText("Helligkeitsregler höher");
        buHell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buHellActionPerformed(evt);
            }
        });

        buDunkel.setText("Dunkel");
        buDunkel.setToolTipText("Helligkeitsregler runter");

        buOptimieren.setText("Optimieren");
        buOptimieren.setToolTipText("Helligkeitsbereich optimal ausnutzen.");

        buAufhellen.setText("aufhellen");
        buAufhellen.setToolTipText("Mit weisser Farbe aufhellen.");

        buAbdunkeln.setText("abdunkeln");
        buAbdunkeln.setToolTipText("Mit schwarzer Farbe abdunkeln.");

        buGraustufen.setText("Graustufen");
        buGraustufen.setToolTipText("In Graustufen umwandeln.");

        buZurueck.setText("Zurück");
        buZurueck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buZurueckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gpBild, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buHell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buDunkel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buOptimieren, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buAufhellen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buAbdunkeln, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buGraustufen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buZurueck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buHell)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buDunkel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buOptimieren)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buAufhellen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buAbdunkeln)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buGraustufen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buZurueck))
                    .addComponent(gpBild, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buHellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buHellActionPerformed
        this.gpBild.setBrightness(120);
        this.gpBild.repaint();
    }//GEN-LAST:event_buHellActionPerformed

    private void buZurueckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buZurueckActionPerformed
        this.gpBild.swapBuffer();
        this.gpBild.repaint();
    }//GEN-LAST:event_buZurueckActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            frame = new ImageFrame();
            frame.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buAbdunkeln;
    private javax.swing.JButton buAufhellen;
    private javax.swing.JButton buDunkel;
    private javax.swing.JButton buGraustufen;
    private javax.swing.JButton buHell;
    private javax.swing.JButton buOptimieren;
    private javax.swing.JButton buZurueck;
    private display.GPanel gpBild;
    // End of variables declaration//GEN-END:variables
}
