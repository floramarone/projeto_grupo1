/*

 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import persistencia.Conexao;
import Modelo.LembreteVO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author flora
 */

public class LembreteDAO {
    
    public void cadastrarLembrete(LembreteVO lVO) throws SQLException{
        //Busca conexão com o banco de dados
        Connection con = Conexao.getConexao();
        //Cria um objeto "stat" responsável por enviar os comandos de banco do java para serem executados dentro do BD
        Statement stat = con.createStatement();
        try{
            String sql;//String que receberá o comando SQL
            
            sql = "insert into lembrete(codigo, dia_semana, data, titulo, comentario)"
                    +"values(null, '"+lVO.getDia_semana()+"', '"+lVO.getData()+"', '"+lVO.getTitulo()+"', '"+lVO.getComentario()+"')";
            stat.execute(sql);
        }catch(SQLException e){
            throw new SQLException("Erro ao inserir lembrete!"+e.getMessage());
        }finally{
            stat.close();
            con.close();
        }        
    }   
    
    public ArrayList<LembreteVO> buscarLembrete() throws SQLException{
        Connection con = Conexao.getConexao();
        Statement stat = con.createStatement();
        try{
            String sql;
            sql = "select * from lembrete ";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<LembreteVO> lembrete = new ArrayList<>();
            
            while(rs.next()){
                LembreteVO l = new LembreteVO();
                l.setCodigo(rs.getInt("codigo"));
                l.setDia_semana(rs.getString("dia_semana"));
                l.setData(rs.getString("data"));
                l.setTitulo(rs.getString("titulo"));
                l.setComentario(rs.getString("comentario"));
                lembrete.add(l);
            }
            return lembrete;
            
        }catch(SQLException e){
            throw new SQLException ("Erro ao buscar dados no banco"+e.getMessage());
        }finally{
           stat.close();
           con.close(); 
        }
        }
    public void alterarLembrete (LembreteVO lVo) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement sta = con.createStatement();
        try{
            String sql;
            sql="update lembrete set  dia_semana = '"+lVo.getDia_semana()+ "', data = '"+lVo.getData()+ "',titulo = '"+lVo.getTitulo()+ "', comentario = '"+lVo.getComentario()+"' where codigo= "+lVo.getCodigo();
            sta.executeUpdate(sql);
            
        }catch(SQLException e){
            throw new SQLException ("Erro ao atualizar dados no banco"+e.getMessage());
        }finally{
            sta.close();
            con.close();  
        }
        }
    
    
    public void deletarLembrete(int codigo) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement sta = con.createStatement();
        try{
            String sql;
            sql="delete from lembrete where codigo ="+codigo;
            sta.execute(sql);
        }catch(SQLException e){
             throw new SQLException ("Erro ao excluir dados no banco"+e.getMessage());
        }finally{
           sta.close();
           con.close();  
        }
        }
    
    public ArrayList<LembreteVO> filtrarLembrete(String query) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement sta = con.createStatement();
        try{
            String sql;
            sql="select * from lembrete "+query;            
            ResultSet rs = sta.executeQuery(sql);
            ArrayList<LembreteVO> lembrete = new ArrayList<>();
            
            while(rs.next()){
                LembreteVO t = new LembreteVO();
                t.setCodigo(rs.getInt("codigo"));
                t.setDia_semana(rs.getString("dia_semana"));
                t.setData(rs.getString("data"));
                t.setTitulo(rs.getString("titulo"));
                t.setComentario(rs.getString("comentario"));
                lembrete.add(t);
            }
            return lembrete;
            
            
        }catch(SQLException e){
            throw new SQLException ("Erro ao filtrar dados no banco"+e.getMessage());
        }finally{
           sta.close();
           con.close(); 
        }
        
    }
}
