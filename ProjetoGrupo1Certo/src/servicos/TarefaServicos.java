/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import Modelo.TarefaVO;
import dao.DAOFactory;
import dao.TarefaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author flora
 */
public class TarefaServicos {
    
    public void cadastrarTarefa(TarefaVO tVO) throws SQLException{
        TarefaDAO tDAO = DAOFactory.getTarefaDAO();
        tDAO.cadastrarTarefa(tVO);
    }
    public ArrayList<TarefaVO> buscar() throws SQLException{
        TarefaDAO tDAO = DAOFactory.getTarefaDAO();
        return tDAO.buscar();
    } 
    public void alterarTarefa (TarefaVO tVo) throws SQLException{
         TarefaDAO tDAO = DAOFactory.getTarefaDAO();
         tDAO.alterarTarefa(tVo);
     }
    public void deletarTarefa(int codigo) throws SQLException{
         TarefaDAO tDAO = DAOFactory.getTarefaDAO();
         tDAO.deletarTarefa(codigo);
     }
    public ArrayList<TarefaVO> filtrar(String query) throws SQLException{
         TarefaDAO tDAO = DAOFactory.getTarefaDAO();
         tDAO.filtrar(query);
         return tDAO.filtrar(query);
     }

}
