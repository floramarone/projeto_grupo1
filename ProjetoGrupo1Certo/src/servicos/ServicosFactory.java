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
       private static LembreteServicos lembreteServicos = new LembreteServicos();

       private static ContatoServicos contatoServicos =new ContatoServicos();

       private static UsuarioServicos usuarioServicos = new UsuarioServicos();

       
        public static TarefaServicos getTarefaServicos(){
        return tarefaServicos; 
        }
    
        public static UsuarioServicos getUsuarioServicos(){
        return usuarioServicos; 
        }

        public static LembreteServicos getLembreteServicos(){
        return lembreteServicos; 
        }

        public static ContatoServicos getContatoServicos(){
            return contatoServicos;
        }
}
        



