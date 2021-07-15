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
import Modelo.Usuario;



/**
 *
 * @author HENRI
 */
public class UsuarioDAO {
    
    public void cadastrarUsuario(Usuario uSU) throws SQLException{
        //Busca conexão com o banco de dados
        Connection con = Conexao.getConexao();
        //Cria um objeto "stat" responsável por enviar os comandos de banco do java para serem executados dentro do BD
        Statement stat = con.createStatement();
        try{
            String sql;//String que receberá o comando SQL
            
            sql = "insert into usuario(nome, email, senha, telefone, cpf )"
                    +"values(null, '"+uSU.getNome()+"', '"+uSU.getEmail()+"', '"+uSU.getSenha()+"', '"+uSU.getTelefone()+"', '"+uSU.getCpf()+"')";
            stat.execute(sql);
        }catch(SQLException e){
            throw new SQLException("Erro ao cadastrar usuario "+e.getMessage());
        }finally{
            stat.close();
            con.close();
        }        
    }
    
    public void deletarUsuario(int cpf) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement sta = con.createStatement();
        try{
            String sql;
            sql="delete from usuario where cpf ="+cpf;
            sta.execute(sql);
        }catch(SQLException e){
             throw new SQLException ("Erro ao excluir dados no banco"+e.getMessage());
        }finally{
           sta.close();
           con.close();  
        }
        }
    
}