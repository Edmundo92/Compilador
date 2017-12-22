package Lexico;

import java.util.LinkedList;

public class Token {

    private String codigo;
    private String nome;
    private String linha;
    private String p;

    
    
    Lista a = new Lista();
    //private int pilha;
    private LinkedList<Integer> pilha = new LinkedList<Integer>();
    
    
    public Token() {
    }

    public Token(String codigo, String nome, String linha) {
        this.codigo = codigo;
        this.linha = linha;
        this.nome = nome;
        this.p = p;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public LinkedList<Integer> getPilha() {
        return pilha;
    }
    public void setPilha(LinkedList<Integer> pilha) {
        this.pilha = pilha;
    }

    public String getNome() {
        return nome;
    }

    public String getLinha() {
        return linha;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String token) {
        this.nome = token;
    }

    public void setlinha(String linha) {
        this.linha = linha;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }
    
    

}
