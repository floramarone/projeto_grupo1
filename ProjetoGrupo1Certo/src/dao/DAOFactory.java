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
<<<<<<< HEAD

    public static ContatoDAO contatoDAO = new ContatoDAO();
        
        public static ContatoDAO getContatoDAO(){
            return contatoDAO;
        }
    }
        




   
=======
    
    public static LembreteDAO getLembreteDAO(){
        return lembreteDAO;
    }
}
>>>>>>> ccd37f890158115f708e616a465b5d4a96d5067d
