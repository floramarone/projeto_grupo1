package Visao;

import Modelo.TarefaVO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servicos.TarefaServicos;

/**
 *
 * @author FERNANDO FINK
 */
public class GUIPrincipal extends javax.swing.JFrame {

    Modelo.Usuario u = new Modelo.Usuario();
    
    public GUIPrincipal() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPrincipal = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jlLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuTarefa = new javax.swing.JMenu();
        jMenuItemTarefa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jlLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jDesktopPrincipal.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPrincipalLayout = new javax.swing.GroupLayout(jDesktopPrincipal);
        jDesktopPrincipal.setLayout(jDesktopPrincipalLayout);
        jDesktopPrincipalLayout.setHorizontalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPrincipalLayout.setVerticalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuTarefa.setText("Tarefas");

        jMenuItemTarefa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemTarefa.setText("Tarefas");
        jMenuItemTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTarefaActionPerformed(evt);
            }
        });
        jMenuTarefa.add(jMenuItemTarefa);

        jMenuBar1.add(jMenuTarefa);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPrincipal)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTarefaActionPerformed
        GUITarefa t = new GUITarefa();
        jDesktopPrincipal.add(t);
        t.setVisible(true);
        t.preencherTabela();
    }//GEN-LAST:event_jMenuItemTarefaActionPerformed

    public void entrar() {
        
        /*
        if (jtfEmail.getText().equals(u.getEmail()) && jtfSenha.getText().equals(u.getSenha())) {
        GUIDash d = new GUIDash();
        jDesktopPrincipal.add(d);
        d.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Login e/ou senha incorreto(s)", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        */
        GUIDash d = new GUIDash();
        
        jDesktopPrincipal.add(d);
        d.setVisible(true);
    }
        
    public void cadastrar() {
        GUICadastro c = new GUICadastro();
        jDesktopPrincipal.add(c);
        c.setVisible(true);
    }
    
    public void fecharAplicacao() {
        System.exit(1);
    }
        
    
    
        
    
    
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
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPrincipal().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPrincipal;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemTarefa;
    private javax.swing.JMenu jMenuTarefa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlLogo;
    // End of variables declaration//GEN-END:variables
}