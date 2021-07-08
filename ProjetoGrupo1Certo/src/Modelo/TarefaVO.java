/*
 create table tarefa( 
codigo int auto_increment primary key, 
dia_semana varchar(15) not null, 
data date not null, 
horario time not null, 
descricao text  
);  */
package Modelo;

public class TarefaVO {
    private long codigo;
    private String dia_semana;
    private String data;
    private String horario;
    private String descricao;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TarefaVO{" + "codigo=" + codigo + ", dia_semana=" + dia_semana + ", data=" + data + ", horario=" + horario + ", descricao=" + descricao + ", nome=" + nome + '}';
    }


    
    
    
}
