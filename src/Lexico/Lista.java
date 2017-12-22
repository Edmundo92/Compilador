package Lexico;

import java.util.ArrayList;
import java.util.List;

public class Lista {

    private ArrayList<Token> lista;
    private ArrayList<Token> var;
    

    public Lista() {
        lista = new ArrayList<Token>();
        var = new ArrayList<Token>();
    }

    public ArrayList<Token> getLista() {
        return lista;
    }

    public void adicionar(Token clas) {
        lista.add(clas);
    }

    public void linpar() {
        lista.clear();
    }
    
    public int tamanho() {
        return lista.size();
    }
    
    public Token retorna(int posicao){
        return lista.get(posicao);
    }
    
    public ArrayList<Token> getPilha() {
        return var;
    }

    public void setPilha(Token variavel) {
        var.add(variavel);

    }
    
}
