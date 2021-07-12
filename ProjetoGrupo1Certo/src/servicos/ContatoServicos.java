/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import Modelo.ContatoVO;
import dao.ContatoDAO;
import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ContatoServicos {
    
    public void cadastrarContato(ContatoVO cVO) throws SQLException{
        ContatoDAO cDAO = DAOFactory.getContatoDAO();
        cDAO.cadastrarContato(cVO);
    }
    public ArrayList<ContatoVO> contatar() throws SQLException{
        ContatoDAO cDAO = DAOFactory.getContatoDAO();
        return cDAO.contatar();
    } 
    public void alterarContato (ContatoVO cVO) throws SQLException{
         ContatoDAO cDAO = DAOFactory.getContatoDAO();
         cDAO.alterarContato(cDAO);
     }
    public void deletarTarefa(int codigo) throws SQLException{
         ContatoDAO cDAO = DAOFactory.getContatoDAO();
         cDAO.deletarContato(codigo);
     }
    public void filtrar(String query) throws SQLException{
         ContatoDAO cDAO = DAOFactory.getContatoDAO();
         cDAO.filtrar(query);         
     }

}
