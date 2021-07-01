/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import persistencia.Conexao;
import Modelo.TarefaVO;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author flora
 */
public class TarefaDAO {
    
        public void cadastrarTarefa(TarefaVO tVO) throws SQLException{
        //Busca conexão com o banco de dados
        Connection con = Conexao.getConexao();
        //Cria um objeto "stat" responsável por enviar os comandos de banco do java para serem executados dentro do BD
        Statement stat = con.createStatement();
        try{
            String sql;//String que receberá o comando SQL
            
            sql = "insert into tarefa(codigo, dia_semana, data, horario, descricao, nome)"
                    +"values(null, '"+tVO.getDia_semana()+"', '"+tVO.getData()+"', '"+tVO.getHorario()+"', '"+tVO.getDescricao()+"', '"+tVO.getNome()+"')";
            stat.execute(sql);
        }catch(SQLException e){
            throw new SQLException("Erro ao inserir tarefa!"+e.getMessage());
        }finally{
            stat.close();
            con.close();
        }        
    }   
     
        public ArrayList<TarefaVO> buscar() throws SQLException{
        Connection con = Conexao.getConexao();
        Statement stat = con.createStatement();
        try{
            String sql;
            sql = "select * from tarefa";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<TarefaVO> tarefa = new ArrayList<>();
            
            while(rs.next()){
                TarefaVO t = new TarefaVO();
                t.setCodigo(rs.getInt("codigo"));
                t.setDia_semana(rs.getString("dia_semana"));
                t.setData(rs.getString("data"));
                t.setHorario(rs.getString("horario"));
                t.setDescricao(rs.getString("descricao"));
                t.setNome(rs.getString("nome"));
                tarefa.add(t);
            }
            return tarefa;
            
        }catch(SQLException e){
            throw new SQLException ("Erro ao buscar dados no banco"+e.getMessage());
        }finally{
           stat.close();
           con.close(); 
        }
        }
        
        public void alterarTarefa (TarefaVO tVo) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement sta = con.createStatement();
        try{
            String sql;
            sql="update tarefa set  dia_semana = '"+tVo.getDia_semana()+ "', data = '"+tVo.getData()+ "',horario = '"+tVo.getHorario()+ "', descricao = '"+tVo.getDescricao()+"' ,nome = '"+tVo.getNome()+"' where codigo= "+tVo.getCodigo();
            sta.executeUpdate(sql);
            
        }catch(SQLException e){
            throw new SQLException ("Erro ao atualizar dados no banco"+e.getMessage());
        }finally{
            sta.close();
            con.close();  
        }
        }
        public void deletarTarefa(int codigo) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement sta = con.createStatement();
        try{
            String sql;
            sql="delete from tarefa where codigo ="+codigo;
            sta.execute(sql);
        }catch(SQLException e){
             throw new SQLException ("Erro ao excluir dados no banco"+e.getMessage());
        }finally{
           sta.close();
           con.close();  
        }
        }
        
        public ArrayList<TarefaVO> filtrar(String query) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement sta = con.createStatement();
        try{
            String sql;
            sql="select * from tarefa "+query;            
            ResultSet rs = sta.executeQuery(sql);
            ArrayList<TarefaVO> tarefa = new ArrayList<>();
            
            while(rs.next()){
                TarefaVO t = new TarefaVO();
                t.setCodigo(rs.getInt("codigo"));
                t.setDia_semana(rs.getString("dia_semana"));
                t.setData(rs.getString("data"));
                t.setHorario(rs.getString("horario"));
                t.setDescricao(rs.getString("descricao"));
                t.setNome(rs.getString("nome"));
                tarefa.add(t);
            }
            return tarefa;
            
            
        }catch(SQLException e){
            throw new SQLException ("Erro ao filtrar dados no banco"+e.getMessage());
        }finally{
           sta.close();
           con.close(); 
        }
        
    }
        
}
