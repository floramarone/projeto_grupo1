/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author flora
 */
public class DAOFactory {
    
    private static TarefaDAO tarefaDAO = new TarefaDAO();
    private static LembreteDAO lembreteDAO = new LembreteDAO();
    
    public static TarefaDAO getTarefaDAO(){
        return tarefaDAO;
    }
    
    public static LembreteDAO getLembreteDAO(){
        return lembreteDAO;
    }
}
