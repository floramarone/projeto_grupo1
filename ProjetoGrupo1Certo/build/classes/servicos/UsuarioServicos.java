/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import Modelo.Usuario;
import dao.DAOFactory;
import dao.UsuarioDAO;
import java.sql.SQLException;


/**
 *
 * @author HENRI
 */
public class UsuarioServicos {
    
    public void cadastrarUsuario(Usuario uSU) throws SQLException{
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        uDAO.cadastrarUsuario(uSU);
    }
    
    public void deletarUsuario(int cpf) throws SQLException{
         UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
         uDAO.deletarUsuario(cpf);
     }
    
    
}
