/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;
import Modelo.LembreteVO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servicos.LembreteServicos;
/**
 *
 * @author FERNANDO FINK
 */
public class GUILembrete extends javax.swing.JFrame {

    /**
     * Creates new form GUILembrete
     */
    public GUILembrete() {
        initComponents();
    }

    public void cadastrarLembrete(){
       try{
           LembreteVO l = new LembreteVO();
           
           l.setDia_semana(String.valueOf(jcbDiaSemana.getSelectedItem()));
           l.setData((jftfData8.getText()));
           l.setTitulo(String.valueOf(jcbTitulo.getSelectedItem()));
           l.setComentario((jtaComentario.getText()));
           
           servicos.LembreteServicos ts = servicos.ServicosFactory.getLembreteServicos();
           ts.cadastrarLembrete(l);
           JOptionPane.showMessageDialog(null,"Seu lembrete foi enviado com sucesso!", "Confirmação" ,JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Ops, algo deu errado!"+e.getMessage(), "Erro!" , JOptionPane.ERROR_MESSAGE);
       } 
    }
    
    public void cancelar(){
        jftfData8.setText(null);
        jtaComentario.setText(null);
        jcbTitulo.setSelectedItem(null);
        jcbDiaSemana.setSelectedItem(null);
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    
    public void voltar() {
        GUIDash d = new GUIDash();
        d.setVisible(true);
        this.setVisible(false);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jcbTitulo = new javax.swing.JComboBox();
        jlData8 = new javax.swing.JLabel();
        jlDiaSemana = new javax.swing.JLabel();
        jlLembrete = new javax.swing.JLabel();
        jlEnviarLembrete8 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtaComentario = new javax.swing.JTextArea();
        jftfData8 = new javax.swing.JFormattedTextField();
        jlEnviar8 = new javax.swing.JLabel();
        jlVoltar8 = new javax.swing.JLabel();
        jbHistorico = new javax.swing.JButton();
        jcbDiaSemana = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel9.setBackground(new java.awt.Color(199, 212, 219));

        jcbTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbTitulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar Contato", "Andressa", "Camila", "Edmundo", "Eduardo", "Fernando", "Flora", "Gabriel Matiolla", "Gabriel Medeiros", "Isabella", "Jaderson", "Gustavo", "Lucas", "Marco", "Thiago", "Tiago", " " }));
        jcbTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTituloActionPerformed(evt);
            }
        });

        jlData8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlData8.setText("Data:");

        jlDiaSemana.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlDiaSemana.setText("Dia da Semana:");

        jlLembrete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlLembrete.setText("Lembrete:");

        jlEnviarLembrete8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlEnviarLembrete8.setText("Enviar Lembrete");

        jtaComentario.setColumns(20);
        jtaComentario.setRows(5);
        jScrollPane9.setViewportView(jtaComentario);

        try {
            jftfData8.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftfData8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftfData8ActionPerformed(evt);
            }
        });

        jlEnviar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ok.png"))); // NOI18N
        jlEnviar8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlEnviar8MouseClicked(evt);
            }
        });

        jlVoltar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/voltar.png"))); // NOI18N
        jlVoltar8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlVoltar8MouseClicked(evt);
            }
        });

        jbHistorico.setText("Histórico");

        jcbDiaSemana.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado", "Domingo" }));
        jcbDiaSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDiaSemanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlVoltar8)
                        .addGap(228, 228, 228)
                        .addComponent(jlEnviar8))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jbHistorico)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jlData8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jftfData8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(237, 237, 237))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlEnviarLembrete8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlDiaSemana)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jlLembrete)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(225, 225, 225))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlEnviarLembrete8)
                .addGap(18, 18, 18)
                .addComponent(jcbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jftfData8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlData8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDiaSemana)
                    .addComponent(jcbDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jlLembrete)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(jlEnviar8))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlVoltar8)))
                .addGap(8, 8, 8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbHistorico)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTituloActionPerformed

    private void jftfData8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfData8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jftfData8ActionPerformed

    private void jlVoltar8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVoltar8MouseClicked
        cancelar();
        voltar();
    }//GEN-LAST:event_jlVoltar8MouseClicked

    private void jcbDiaSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDiaSemanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDiaSemanaActionPerformed

    private void jlEnviar8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEnviar8MouseClicked
        cadastrarLembrete();
        cancelar();
    }//GEN-LAST:event_jlEnviar8MouseClicked

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
            java.util.logging.Logger.getLogger(GUILembrete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUILembrete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUILembrete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUILembrete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUILembrete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton jbHistorico;
    private javax.swing.JComboBox jcbDiaSemana;
    private javax.swing.JComboBox jcbTitulo;
    private javax.swing.JFormattedTextField jftfData8;
    private javax.swing.JLabel jlData8;
    private javax.swing.JLabel jlDiaSemana;
    private javax.swing.JLabel jlEnviar8;
    private javax.swing.JLabel jlEnviarLembrete8;
    private javax.swing.JLabel jlLembrete;
    private javax.swing.JLabel jlVoltar8;
    private javax.swing.JTextArea jtaComentario;
    // End of variables declaration//GEN-END:variables
}
