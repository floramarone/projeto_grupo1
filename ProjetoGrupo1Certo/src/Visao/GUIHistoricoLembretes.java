/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Modelo.LembreteVO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servicos.LembreteServicos;

/**
 *
 * @author FERNANDO FINK
 */
public class GUIHistoricoLembretes extends javax.swing.JFrame {

    /**
     * Creates new form GUIHistoricoLembretes
     */
    public GUIHistoricoLembretes() {
        initComponents();
        preencherTabela();
    }

        public void limparTabela(){
        dtm.setNumRows(0);
    }
    
    DefaultTableModel dtm = new DefaultTableModel(
                new Object[][]{},
                new Object[]{"Código", "Dia da Semana", "Data", "Contato", "Lembrete"}
    );
    
    public void preencherTabela(){
        try{
            LembreteServicos ls = servicos.ServicosFactory.getLembreteServicos();
            
            ArrayList<LembreteVO> lembrete = new ArrayList<>();
            
            lembrete = ls.buscarLembrete();
            
            for(int i=0; i<lembrete.size();i++){
                dtm.addRow(new String[]{
                    String.valueOf(lembrete.get(i).getCodigo()),
                    String.valueOf(lembrete.get(i).getDia_semana()),
                    String.valueOf(lembrete.get(i).getData()),
                    String.valueOf(lembrete.get(i).getTitulo()),
                    String.valueOf(lembrete.get(i).getComentario())
                });
                
            }//fecha for
            jTableLembretes.setModel(dtm);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ops, algo deu errado!"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public void filtrarLembrete(){
        try{
            if(jtfContato.getText().isEmpty()){
                preencherTabela();
            }else{
                LembreteServicos ls = servicos.ServicosFactory.getLembreteServicos();

                String query = "where titulo like '%"+jtfContato.getText()+"%'";

                ArrayList<LembreteVO> lembrete = new ArrayList<>();
            
                lembrete = ls.filtrarLembrete(query);
                
                for(int i=0; i<lembrete.size();i++){
                    dtm.addRow(new String[]{
                        String.valueOf(lembrete.get(i).getCodigo()),
                        String.valueOf(lembrete.get(i).getDia_semana()),
                        String.valueOf(lembrete.get(i).getData()),
                        String.valueOf(lembrete.get(i).getTitulo()),
                        String.valueOf(lembrete.get(i).getComentario()),
                        
                    });
                
                }//fecha for
                jTableLembretes.setModel(dtm);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao filtrar dados!"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE); 
        }
    }//fecha filtrar
     
    public void deletarLembrete(){
        try{
            int linha = jTableLembretes.getSelectedRow();
            if(linha == -1){
                JOptionPane.showMessageDialog(null, "Você não selecionou uma linha para exclusão.", "Erro!", JOptionPane.ERROR_MESSAGE);
            }else{
                LembreteServicos ls = servicos.ServicosFactory.getLembreteServicos();
                String codigo = (String) jTableLembretes.getValueAt(linha, 0);
                int r = JOptionPane.showConfirmDialog(null,"Você realmente deseja excluir os dados?","Confirmação",JOptionPane.WARNING_MESSAGE);
                if(r == JOptionPane.YES_OPTION){
                    ls.deletarLembrete(Integer.parseInt(codigo));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Sua exclusão não foi executada.", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Ops, algo deu errado!"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE); 
        }
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlHistorico = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLembretes = new javax.swing.JTable();
        jlVoltar = new javax.swing.JLabel();
        jlFiltrar = new javax.swing.JLabel();
        jtfContato = new javax.swing.JTextField();
        jlDeletar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(199, 212, 219));

        jlHistorico.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlHistorico.setText("Histórico de Lembretes");

        jTableLembretes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableLembretes);

        jlVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/voltar.png"))); // NOI18N
        jlVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlVoltarMouseClicked(evt);
            }
        });

        jlFiltrar.setText("Filtrar por Contato:");

        jtfContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfContatoActionPerformed(evt);
            }
        });
        jtfContato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfContatoKeyReleased(evt);
            }
        });

        jlDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Lixeira.png"))); // NOI18N
        jlDeletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlDeletarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 172, Short.MAX_VALUE)
                        .addComponent(jlHistorico)
                        .addGap(182, 182, 182))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlVoltar)
                                .addGap(222, 222, 222)
                                .addComponent(jlDeletar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jlFiltrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfContato, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jlHistorico)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFiltrar)
                    .addComponent(jtfContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlVoltar)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jlDeletar)
                        .addContainerGap(27, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void voltar() {
        GUILembrete l = new GUILembrete();
        l.setVisible(true);
        this.setVisible(false);
    }
    
    private void jlVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVoltarMouseClicked
        voltar();
    }//GEN-LAST:event_jlVoltarMouseClicked

    private void jtfContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfContatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfContatoActionPerformed

    private void jtfContatoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfContatoKeyReleased
        limparTabela();
        filtrarLembrete();
    }//GEN-LAST:event_jtfContatoKeyReleased

    private void jlDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlDeletarMouseClicked
        deletarLembrete();
        limparTabela();
        preencherTabela();
         JOptionPane.showMessageDialog(null, "Sua exclusão foi executada com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jlDeletarMouseClicked

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
            java.util.logging.Logger.getLogger(GUIHistoricoLembretes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIHistoricoLembretes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIHistoricoLembretes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIHistoricoLembretes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIHistoricoLembretes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLembretes;
    private javax.swing.JLabel jlDeletar;
    private javax.swing.JLabel jlFiltrar;
    private javax.swing.JLabel jlHistorico;
    private javax.swing.JLabel jlVoltar;
    private javax.swing.JTextField jtfContato;
    // End of variables declaration//GEN-END:variables
}
