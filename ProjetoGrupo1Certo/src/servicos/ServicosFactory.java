/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

/**
 *
 * @author flora
 */
public class ServicosFactory {
       private static TarefaServicos tarefaServicos = new TarefaServicos();
    
        public static TarefaServicos getTarefaServicos(){
        return tarefaServicos; 
        }
}
