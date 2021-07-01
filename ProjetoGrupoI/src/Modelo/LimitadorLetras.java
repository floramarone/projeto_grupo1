package Modelo;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author FERNANDO FINK
 */
public class LimitadorLetras extends PlainDocument {
    
    private int quantidadeMax;
    //contrutor da classe - serve para inicializar variáveis da classe
    public LimitadorLetras(int max) { //sempre com o nome da classe
        
        /*verifica se o que o programador definiu no GUIPessoa para caracter é negativo ou nulo*/
        if (max <= 0) {
            throw new IllegalArgumentException("Erro ao definir a quantidade de caracteres máxima");
        } else {
            this.quantidadeMax = max;
        } //caso esteja tudo certo, a quantidade é definida pelo programador com sucesso
        
    }
    
    // cira o método InsertString para verificar a quantidade de caracteres no JTextField
    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
        /*
        offs/i = posição do texto
        str/string =texto que o usuário digita
        a/as = atributo da fonte, se aceita letras, números e caracteres especiais
        */
        if (string == null || getLength() == quantidadeMax) {
            return;
        }
        
        int totalQuantidade =(getLength() + string.length());
        if (totalQuantidade <= quantidadeMax) {
            super.insertString(i, string.replaceAll("[^a-z^A-Z^' '^@^.^0-9]", ""), as); //To change body of generated methods, choose Tools | Templates.
            return;
        }
        
        String nova = string.substring(0,getLength() - quantidadeMax);
        super.insertString(i, nova, as);
    }
    
    
}
