/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Modelo.ContatoVO;
import Modelo.TarefaVO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servicos.ContatoServicos;
import servicos.TarefaServicos;

/**
 *
 * @author FERNANDO FINK
 */
public class GUIContato extends javax.swing.JFrame {

    /**
     * Creates new form GUIContato
     */
    public GUIContato() {
        initComponents();
    }
    public void cadastrarContato(){
        try{
            ContatoVO v = new ContatoVO();
            
            v.setNome(jtfNome.getText());
            v.setTelefone(jftfTelefone.getText());
           
           servicos.ContatoServicos vs = servicos.ServicosFactory.getContatoServicos();
           vs.cadastrarContato(v);
           JOptionPane.showMessageDialog(null,"Seu contato foi cadastrado com sucesso!", "Confirmação" ,JOptionPane.INFORMATION_MESSAGE);
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ops, algo deu errado!"+e.getMessage(), "Erro!" , JOptionPane.ERROR_MESSAGE);
        }
    }
     public void cancelar(){
        jtfNome.setText(null);
        jftfTelefone.setText(null);        
    }
     public void limparTabela(){
        dtm.setNumRows(0);
    }
    
    DefaultTableModel dtm = new DefaultTableModel(
                new Object[][]{},
                new Object[]{"ID", "NOME", "TELEFONE"}
    );
    
    public void preencherContato(){
        try{
            ContatoServicos cs = servicos.ServicosFactory.getContatoServicos();
            
            ArrayList<ContatoVO> contato = new ArrayList<>();
            
            contato = cs.buscar(); 
            
            for(int i=0; i<contato.size();i++){
                dtm.addRow(new String[]{
                    String.valueOf(contato.get(i).getNome()),
                    String.valueOf(contato.get(i).getTelefone())
                   
                });
                
            }//fecha for
            jTableContatos.setModel(dtm);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ops, algo deu errado!"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void alterarDados(){
        int linha = jTableContatos.getSelectedRow();
        if (linha != -1){
            //busca os dados da linha selecionada e envia para cada JTextField da tela cadastrar
            jtfNome.setText((String) jTableContatos.getValueAt(linha, 0));
            jftfTelefone.setText((String) jTableContatos.getValueAt(linha, 5));            
          
        }else{
            JOptionPane.showMessageDialog(null, "Você não selecionou nenhuma linha!");
        }
    }
        public void confirmarAlteracao(){
        try{
            ContatoVO cVo = new ContatoVO();
            cVo.setTelefone(String.valueOf(jftfTelefone.getText()));
             
             
            
        
            ContatoServicos cs = servicos.ServicosFactory.getContatoServicos();
            cs.alterarContato(cVo);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ops, houve algum erro na alteração do dado..."+e.getMessage());
    }
    }
        public void deletar(){
        try{
            int linha = jTableContatos.getSelectedRow();
            if(linha == -1){
                JOptionPane.showMessageDialog(null, "Você não selecionou uma linha para exclusão.", "Erro!", JOptionPane.ERROR_MESSAGE);
            }else{
                ContatoServicos cs = servicos.ServicosFactory.getContatoServicos();
                String codigo = (String) jTableContatos.getValueAt(linha, 0);
                int r = JOptionPane.showConfirmDialog(null,"Você realmente deseja excluir os dados?","Confirmação",JOptionPane.WARNING_MESSAGE);
                if(r == JOptionPane.YES_OPTION){
                    cs.deletarTarefa(Integer.parseInt(codigo));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Sua exclusão não foi executada.", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Ops, algo deu errado!"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE); 
        }
    }
        public void filtrar(){
        try{
            if(jtfFiltrar.getText().isEmpty()){
                preencherContato();
            }else{
                ContatoServicos cs = servicos.ServicosFactory.getContatoServicos();

                String query = "where nome like '%"+jtfFiltrar.getText()+"%'";

                ArrayList<ContatoVO> contato = new ArrayList<>();
            
                contato = cs.buscar();
                        
                for(int i=0; i<contato.size();i++){
                    dtm.addRow(new String[]{
                        String.valueOf(contato.get(i).getNome()),
                        String.valueOf(contato.get(i).getTelefone()),                        
                        
                    });
                
                }//fecha for
                jTableContatos.setModel(dtm);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao filtrar dados!"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE); 
        }
    }//fecha filtrar

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlContato = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContatos = new javax.swing.JTable();
        jlExcluir = new javax.swing.JLabel();
        jlSalvar = new javax.swing.JLabel();
        jlEditar = new javax.swing.JLabel();
        jlFiltrar = new javax.swing.JLabel();
        jtfFiltrar = new javax.swing.JTextField();
        jlVoltar = new javax.swing.JLabel();
        jlCodigo = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jlTelefone = new javax.swing.JLabel();
        jftfTelefone = new javax.swing.JFormattedTextField();
        jtfCodigo = new javax.swing.JTextField();
        jtfNome = new javax.swing.JTextField();
        jbEdicao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(199, 212, 219));

        jlContato.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlContato.setText("Contatos");

        jTableContatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableContatos);

        jlExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Lixeira.png"))); // NOI18N
        jlExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlExcluirMouseClicked(evt);
            }
        });

        jlSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/disk.png"))); // NOI18N
        jlSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlSalvarMouseClicked(evt);
            }
        });

        jlEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editar.png"))); // NOI18N
        jlEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlEditarMouseClicked(evt);
            }
        });

        jlFiltrar.setText("Filtrar por Nome:");

        jtfFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFiltrarActionPerformed(evt);
            }
        });

        jlVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/voltar.png"))); // NOI18N
        jlVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlVoltarMouseClicked(evt);
            }
        });

        jlCodigo.setText("Código:");

        jlNome.setText("Nome:");

        jlTelefone.setText("Telefone:");

        try {
            jftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+55 (##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftfTelefoneActionPerformed(evt);
            }
        });

        jtfCodigo.setEnabled(false);

        jbEdicao.setText("Selecionar Contato para Edição");
        jbEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEdicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(jlContato)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlVoltar)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jlSalvar)
                        .addGap(39, 39, 39)
                        .addComponent(jlEditar)
                        .addGap(48, 48, 48)
                        .addComponent(jlExcluir))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jlFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbEdicao)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCodigo)
                            .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNome)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlTelefone)
                            .addComponent(jftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlContato)))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlEditar)
                    .addComponent(jlSalvar)
                    .addComponent(jlExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlFiltrar)
                            .addComponent(jtfFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbEdicao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlVoltar)
                        .addContainerGap())))
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

    private void jtfFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFiltrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFiltrarActionPerformed

    public void voltar() {
        GUIDash d = new GUIDash();
        d.setVisible(true);
        this.setVisible(false);
    }
    
    private void jlVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlVoltarMouseClicked
        voltar();
    }//GEN-LAST:event_jlVoltarMouseClicked

    private void jbEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEdicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEdicaoActionPerformed

    private void jftfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jftfTelefoneActionPerformed

    private void jlSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalvarMouseClicked
        cadastrarContato();
    }//GEN-LAST:event_jlSalvarMouseClicked

    private void jlEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEditarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlEditarMouseClicked

    private void jlExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlExcluirMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlExcluirMouseClicked

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
            java.util.logging.Logger.getLogger(GUIContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIContato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContatos;
    private javax.swing.JButton jbEdicao;
    private javax.swing.JFormattedTextField jftfTelefone;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlContato;
    private javax.swing.JLabel jlEditar;
    private javax.swing.JLabel jlExcluir;
    private javax.swing.JLabel jlFiltrar;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlSalvar;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JLabel jlVoltar;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfFiltrar;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
}
