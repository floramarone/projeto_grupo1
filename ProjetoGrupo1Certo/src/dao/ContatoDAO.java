/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Modelo.ContatoVO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import persistencia.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Gustavo
 */
public class ContatoDAO {
    
        public void cadastrarContato(ContatoVO cVO) throws SQLException{
        //Busca conexão com o banco de dados
        Connection con = Conexao.getConexao();
        //Cria um objeto "stat" responsável por enviar os comandos de banco do java para serem executados dentro do BD
        Statement stat = con.createStatement();
        try{
            String sql;//String que receberá o comando SQL
            
            sql = "insert into contato(NOME,TELEFONE)"
                    +"values('"+cVO.getNome()+"', '"+cVO.getTelefone()+"',)";
            stat.execute(sql);
        }catch(SQLException e){
            throw new SQLException("Erro ao inserir contato!"+e.getMessage());
        }finally{
            stat.close();
            con.close();
        }        
    }   
     
        public ArrayList<ContatoVO> buscar() throws SQLException{
        Connection con = Conexao.getConexao();
        Statement stat = con.createStatement();
        try{
            String sql;
            sql = "select * from contato";
            ResultSet cs = stat.executeQuery(sql);
            ArrayList<ContatoVO> contato = new ArrayList<>();
            
            while(cs.next()){
                ContatoVO c = new ContatoVO();
                c.setNome(cs.getString("Nome"));
                c.setTelefone(cs.getInt("Telefone"));                
                contato.add(c);
            }
            return contato;
            
        }catch(SQLException e){
            throw new SQLException ("Erro ao buscar dados no banco"+e.getMessage());
        }finally{
           stat.close();
           con.close(); 
        }
        }
        
        public void alterarContato (ContatoVO cVO) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement sta = con.createStatement();
        try{
            String sql;
            sql="update contato set nome = '"+cVO.getNome()+ "', telefone = '"+cVO.getTelefone();
            sta.executeUpdate(sql);
            
        }catch(SQLException e){
            throw new SQLException ("Erro ao atualizar dados no banco"+e.getMessage());
        }finally{
            sta.close();
            con.close();  
        }
        }
        public void deletarContato(int codigo) throws SQLException{
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
        
        public ArrayList<ContatoVO> filtrarContato(String query) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement sta = con.createStatement();
        try{
            String sql;
            sql="select * from contato "+query;            
            ResultSet cs = sta.executeQuery(sql);
            ArrayList<ContatoVO> contato = new ArrayList<>();
            
            while(cs.next()){
                ContatoVO t = new ContatoVO();
                t.setNome(cs.getString("Nome"));
                t.setTelefone(cs.getInt("Telefone"));                
            }
                return contato;            
            
        }catch(SQLException e){
            throw new SQLException ("Erro ao filtrar dados no banco"+e.getMessage());
        }finally{
           sta.close();
           con.close(); 
        }
        
    }

    public ArrayList<ContatoVO> contatar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void alterarContato(ContatoDAO tDAO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   

    public void filtrar(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
