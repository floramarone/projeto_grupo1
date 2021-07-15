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
    
<<<<<<< HEAD:ProjetoGrupoI/src/dao/DAOFactory.java
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public static UsuarioDAO getUsuarioDAO(){
        return usuarioDAO;
=======
    public static LembreteDAO getLembreteDAO(){
        return lembreteDAO;
>>>>>>> master:ProjetoGrupo1Certo/src/dao/DAOFactory.java
    }
}
