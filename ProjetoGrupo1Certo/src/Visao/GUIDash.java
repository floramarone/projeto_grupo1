/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

/**
 *
 * @author FERNANDO FINK
 */
public class GUIDash extends javax.swing.JFrame {

    /**
     * Creates new form GUIDash
     */
    public GUIDash() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jbTarefa = new javax.swing.JButton();
        jbLembrete = new javax.swing.JButton();
        jlData = new javax.swing.JLabel();
        jbResetar = new javax.swing.JButton();
        jlSair = new javax.swing.JLabel();
        jlCalendario = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(199, 212, 219));

        jbTarefa.setText("Agendar Nova Tarefa");

        jbLembrete.setText("Enviar Lembrete");

        jlData.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlData.setText("13/04/2021");

        jbResetar.setText("Resetar Informações");

        jlSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Fechar.png"))); // NOI18N
        jlSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlSairMouseClicked(evt);
            }
        });

        jlCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Calendário.png"))); // NOI18N
        jlCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCalendarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlSair))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(jbTarefa)
                                .addGap(79, 79, 79)
                                .addComponent(jbLembrete))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(263, 263, 263)
                                .addComponent(jlCalendario))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(jlData)))
                        .addGap(0, 135, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbResetar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlSair)
                .addGap(7, 7, 7)
                .addComponent(jlData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbTarefa)
                    .addComponent(jbLembrete))
                .addGap(46, 46, 46)
                .addComponent(jlCalendario)
                .addGap(41, 41, 41)
                .addComponent(jbResetar)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlCalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCalendarioMouseClicked
        GUITarefa t = new GUITarefa();
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jlCalendarioMouseClicked

    private void jlSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSairMouseClicked
        GUILogin l = new GUILogin();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jlSairMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(GUIDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIDash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbLembrete;
    private javax.swing.JButton jbResetar;
    private javax.swing.JButton jbTarefa;
    private javax.swing.JLabel jlCalendario;
    private javax.swing.JLabel jlData;
    private javax.swing.JLabel jlSair;
    // End of variables declaration//GEN-END:variables
}
