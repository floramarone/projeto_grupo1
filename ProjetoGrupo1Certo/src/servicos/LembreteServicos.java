/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import Modelo.LembreteVO;
import dao.DAOFactory;
import dao.LembreteDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author flora
 */
public class LembreteServicos {
    
    public void cadastrarLembrete(LembreteVO lVO) throws SQLException{
        LembreteDAO lDAO = DAOFactory.getLembreteDAO();
        lDAO.cadastrarLembrete(lVO);
    }
    public ArrayList<LembreteVO> buscarLembrete() throws SQLException{
        LembreteDAO lDAO = DAOFactory.getLembreteDAO();
        return lDAO.buscarLembrete();
    } 
    public void alterarLembrete (LembreteVO lVo) throws SQLException{
         LembreteDAO tDAO = DAOFactory.getLembreteDAO();
         tDAO.alterarLembrete(lVo);
     }
    public void deletarLembrete(int codigo) throws SQLException{
         LembreteDAO tDAO = DAOFactory.getLembreteDAO();
         tDAO.deletarLembrete(codigo);
     }
    public ArrayList<LembreteVO> filtrarLembrete(String query) throws SQLException{
         LembreteDAO lDAO = DAOFactory.getLembreteDAO();
         lDAO.filtrarLembrete(query);
         return lDAO.filtrarLembrete(query);
     }
    
}
