/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Modelo.TarefaVO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servicos.TarefaServicos;

/**
 *
 * @author FERNANDO FINK
 */
public class GUITarefa extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUITarefa
     */
    public GUITarefa() {
        initComponents();
        
    }

    public void cadastrarTarefa(){
       try{
           TarefaVO t = new TarefaVO();
        
           t.setNome(jtfNome.getText());
           t.setData((jftfData.getText()));
           t.setHorario((jftfHora.getText()));
           t.setDescricao((jtaDescricao.getText()));
           t.setDia_semana(String.valueOf(jcbDiaSemana.getSelectedItem()));
           
           servicos.TarefaServicos ts = servicos.ServicosFactory.getTarefaServicos();
           ts.cadastrarTarefa(t);
           JOptionPane.showMessageDialog(null,"Sua tarefa foi cadastrado com sucesso!", "Confirmação" ,JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Ops, algo deu errado!"+e.getMessage(), "Erro!" , JOptionPane.ERROR_MESSAGE);
       } 
    }
    
    public void cancelar(){
        jtfNome.setText(null);
        jftfData.setText(null);
        jftfHora.setText(null);
        jtaDescricao.setText(null);
        jcbDiaSemana.setSelectedItem(null);
    }
   
    public void limparTabela(){
        dtm.setNumRows(0);
    }
   
    DefaultTableModel dtm = new DefaultTableModel(
                new Object[][]{},
                new Object[]{"Código", "Dia da Semana", "Data", "Horário", "Descrição", "Título"}
    );
    
    
    public void preencherTabela(){
        try{
            TarefaServicos ts = servicos.ServicosFactory.getTarefaServicos();
            
            ArrayList<TarefaVO> tarefa = new ArrayList<>();
            
            tarefa = ts.buscar();
            
            for(int i=0; i<tarefa.size();i++){
                dtm.addRow(new String[]{
                    String.valueOf(tarefa.get(i).getCodigo()),
                    String.valueOf(tarefa.get(i).getDia_semana()),
                    String.valueOf(tarefa.get(i).getData()),
                    String.valueOf(tarefa.get(i).getHorario()),
                    String.valueOf(tarefa.get(i).getDescricao()),
                    String.valueOf(tarefa.get(i).getNome())
                });
                
            }//fecha for
            jTableResultado.setModel(dtm);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ops, algo deu errado!"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void alterarDados(){
        int linha = jTableResultado.getSelectedRow();
        if (linha != -1){
            //busca os dados da linha selecionada e envia para cada JTextField da tela cadastrar
            jtfCodigo.setText((String) jTableResultado.getValueAt(linha, 0));
            jtfNome.setText((String) jTableResultado.getValueAt(linha, 5));
            jftfData.setText((String) jTableResultado.getValueAt(linha, 2));
            jftfHora.setText((String) jTableResultado.getValueAt(linha, 3));
            jtaDescricao.setText((String) jTableResultado.getValueAt(linha, 4));
            jcbDiaSemana.setSelectedItem((String)jTableResultado.getValueAt(linha, 1));
            //jcbDiaSemana.setSelectedItem((String)jTableResultado.getValueAt(linha, 1));
            // jcbDiaSemana.setSelectedItem(jTableResultado.getValueAt(jTableResultado.getSelectedRow(),1));
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Você não selecionou nenhuma linha!");
        }
        
    }
    
    public void confirmarAlteracao(){
        try{
            TarefaVO tVo = new TarefaVO();
            tVo.setCodigo(Integer.parseInt(jtfCodigo.getText()));
            tVo.setDia_semana(String.valueOf(jcbDiaSemana.getSelectedItem()));
            tVo.setNome(jtfNome.getText());
            tVo.setData(jftfData.getText());
            tVo.setHorario(jftfHora.getText());
            tVo.setDescricao(jtaDescricao.getText());
            
            
        
            TarefaServicos ts = servicos.ServicosFactory.getTarefaServicos();
            ts.alterarTarefa(tVo);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ops, houve algum erro na alteração do dado..."+e.getMessage());
    }
    }
    
    public void deletar(){
        try{
            int linha = jTableResultado.getSelectedRow();
            if(linha == -1){
                JOptionPane.showMessageDialog(null, "Você não selecionou uma linha para exclusão.", "Erro!", JOptionPane.ERROR_MESSAGE);
            }else{
                TarefaServicos ts = servicos.ServicosFactory.getTarefaServicos();
                String codigo = (String) jTableResultado.getValueAt(linha, 0);
                int r = JOptionPane.showConfirmDialog(null,"Você realmente deseja excluir os dados?","Confirmação",JOptionPane.WARNING_MESSAGE);
                if(r == JOptionPane.YES_OPTION){
                    ts.deletarTarefa(Integer.parseInt(codigo));
                    
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
            if(jtfPesquisa.getText().isEmpty()){
                preencherTabela();
            }else{
                TarefaServicos ts = servicos.ServicosFactory.getTarefaServicos();

                String query = "where nome like '%"+jtfPesquisa.getText()+"%'";

                ArrayList<TarefaVO> tarefa = new ArrayList<>();
            
                tarefa = ts.filtrar(query);
                
                for(int i=0; i<tarefa.size();i++){
                    dtm.addRow(new String[]{
                        String.valueOf(tarefa.get(i).getCodigo()),
                        String.valueOf(tarefa.get(i).getDia_semana()),
                        String.valueOf(tarefa.get(i).getData()),
                        String.valueOf(tarefa.get(i).getHorario()),
                        String.valueOf(tarefa.get(i).getDescricao()),
                        String.valueOf(tarefa.get(i).getNome()),
                        
                    });
                
                }//fecha for
                jTableResultado.setModel(dtm);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao filtrar dados!"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE); 
        }
    }//fecha filtrar
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlCriacaoTarefa = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jlData = new javax.swing.JLabel();
        jlHora = new javax.swing.JLabel();
        jlDescricao = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescricao = new javax.swing.JTextArea();
        jftfData = new javax.swing.JFormattedTextField();
        jftfHora = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableResultado = new javax.swing.JTable();
        jlSalvar = new javax.swing.JLabel();
        jlEditar = new javax.swing.JLabel();
        jlExcluir = new javax.swing.JLabel();
        jlDiaSemana = new javax.swing.JLabel();
        jcbDiaSemana = new javax.swing.JComboBox<>();
        jbSelecionarLinha = new javax.swing.JButton();
        jtfCodigo = new javax.swing.JTextField();
        jlCodigo = new javax.swing.JLabel();
        jtfPesquisa = new javax.swing.JTextField();
        jlPesquisePor = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(199, 212, 219));

        jlCriacaoTarefa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlCriacaoTarefa.setText("Crie e edite suas tarefas");

        jlNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlNome.setText("Nome:");

        jlData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlData.setText("Data:");

        jlHora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlHora.setText("Hora:");

        jlDescricao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlDescricao.setText("Descrição:");

        jtaDescricao.setColumns(20);
        jtaDescricao.setRows(5);
        jScrollPane1.setViewportView(jtaDescricao);

        try {
            jftfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jftfHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jTableResultado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableResultado);

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

        jlExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Lixeira.png"))); // NOI18N
        jlExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlExcluirMouseClicked(evt);
            }
        });

        jlDiaSemana.setText("Dia da Semana:");

        jcbDiaSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado", "Domingo" }));

        jbSelecionarLinha.setText("Selecionar tarefa para edição");
        jbSelecionarLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSelecionarLinhaActionPerformed(evt);
            }
        });

        jtfCodigo.setEnabled(false);

        jlCodigo.setText("Código");

        jtfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPesquisaKeyReleased(evt);
            }
        });

        jlPesquisePor.setText("Pesquise pelo Nome da Tarefa:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jlCriacaoTarefa)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlNome)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlData)
                                        .addGap(5, 5, 5))
                                    .addComponent(jlCodigo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jftfData, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jlHora)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jftfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlDescricao))
                                .addGap(13, 13, 13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlPesquisePor, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jlDiaSemana)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jlSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(jlExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbSelecionarLinha)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jlCriacaoTarefa)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlCodigo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlNome)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlData)
                            .addComponent(jftfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlHora)
                            .addComponent(jftfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlDiaSemana)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jlDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jbSelecionarLinha))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlExcluir)
                        .addComponent(jlEditar)
                        .addComponent(jlSalvar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPesquisePor))
                .addContainerGap())
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

    private void jlSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalvarMouseClicked
        cadastrarTarefa();
        limparTabela();
        preencherTabela();
        cancelar();
    }//GEN-LAST:event_jlSalvarMouseClicked

    private void jbSelecionarLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSelecionarLinhaActionPerformed
        alterarDados();
    }//GEN-LAST:event_jbSelecionarLinhaActionPerformed

    private void jlEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEditarMouseClicked
        confirmarAlteracao();
        limparTabela();
        preencherTabela();
        cancelar();
    }//GEN-LAST:event_jlEditarMouseClicked

    private void jlExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlExcluirMouseClicked
        deletar();
        limparTabela();
        preencherTabela();
        JOptionPane.showMessageDialog(null, "Sua exclusão foi executada com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jlExcluirMouseClicked
        
    private void jtfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyReleased
        limparTabela();
        filtrar();
        
    }//GEN-LAST:event_jtfPesquisaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableResultado;
    private javax.swing.JButton jbSelecionarLinha;
    private javax.swing.JComboBox<String> jcbDiaSemana;
    private javax.swing.JFormattedTextField jftfData;
    private javax.swing.JFormattedTextField jftfHora;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlCriacaoTarefa;
    private javax.swing.JLabel jlData;
    private javax.swing.JLabel jlDescricao;
    private javax.swing.JLabel jlDiaSemana;
    private javax.swing.JLabel jlEditar;
    private javax.swing.JLabel jlExcluir;
    private javax.swing.JLabel jlHora;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlPesquisePor;
    private javax.swing.JLabel jlSalvar;
    private javax.swing.JTextArea jtaDescricao;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPesquisa;
    // End of variables declaration//GEN-END:variables
}
