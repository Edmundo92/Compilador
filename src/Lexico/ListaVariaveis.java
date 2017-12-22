package Lexico;

import java.util.ArrayList;
import java.util.List;

public class ListaVariaveis {
    
     //private ArrayList<String> var;
    private final List<String> var = new ArrayList<>();
    //ArrayList<String> var = new ArrayList<>();

//    public ListaVariaveis() {
//        var = new ArrayList<String>();
//    }

//    public ArrayList<String> getListaVariaveis() {
//        return var;
//    }
//
//    public void adicionar(String clas) {
//        var.add(clas);
//    }
    
    public List<String> getPilha() {
        return var;
    }

    public void setPilha(String clas) {
        var.add(clas);

    }
    
//
//    public void linpar() {
//        var.clear();
//    }
//    
//    public int tamanho() {
//        return var.size();
//    }
//    
//    public String retorna(int posicao){
//        return var.get(posicao);
//    }
    
}
