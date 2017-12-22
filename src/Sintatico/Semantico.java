package Sintatico;

import java.util.ArrayList;

public class Semantico {

    ArrayList<String> simbolos = new ArrayList<>();;
//
//    public boolean isDeclaracaoValida(String ident, int line) {
//        if (getSimByIdent(ident)) {
//            showMessageError("Variável já declarada: " + ident + "\nLinha: " + line);
//            return false;
//        }
//
//        simbolos.add(new Simbolos(ident));
//        return true;
//    }

//    public boolean isChamadaValida(String ident, int type, int line) {
//        if (getSimByIdent(ident)) {
//            return true;
//        }
//
//        showMessageError((type == 1 ? "Variável" : "Função") + " não declarada: " + ident
//                + "\nLinha: " + line);
//        return false;
//    }
//
//    public boolean isChamadaFuncaoValida(String function, int numParam, int line) {
//        for (int i = 0; i < simbolos.size(); i++) {
//            if (simbolos.get(i).getIdentificador().equals(function)
//                    && simbolos.get(i).getQtdParametros() == numParam) {
//                return true;
//            }
//        }
//        showMessageError("Número de parâmetros errado na chamada da função: " + function
//                + "\nLinha: " + line);
//        return false;
//    }
//
//    public boolean incrementaParams(String ident) {
//        increment(ident);
//
//        return true;
//    }
//
//    private void increment(String ident) {
//        for (int i = 0; i < simbolos.size(); i++) {
//            if (simbolos.get(i).getIdentificador().equals(ident)) {
//                simbolos.get(i).setQtdParametros(
//                        simbolos.get(i).getQtdParametros() + 1);
//            }
//        }
//    }
//
//    public boolean getSimByIdent(String cIdent) {
//        for (int i = 0; i < simbolos.size(); i++) {
//            if (simbolos.get(i).getIdentificador().equals(cIdent)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public void showMessageError(String msg) {
//        JOptionPane.showMessageDialog(null, msg,
//                "Erro Semântico", JOptionPane.ERROR_MESSAGE);
//    }
//
//    public void reset() {
//        simbolos.clear();
//    }
    
    
    
    //    public void setPegarVar(Lista lista) {
//        String nome_var = "";
//        ArrayList<String> var = new ArrayList<>();
//        Token c = new Token();
//        int num = 0;
//        
//        for (int i = 0; i < lista.getLista().size(); i++) {
//
//            c = lista.getLista().get(i);
//            //JOptionPane.showMessageDialog(null, "Entrou " + c.getNome() + " --- " + i);
//
//            if (c.getCodigo() == "7") {
//                nome_var = c.getNome();
//              //  JOptionPane.showMessageDialog(null, "Vamos ver : " + nome_var);
////
//                // var.add(nome_var);
//                if (var.isEmpty()) {
//                    var.add(nome_var);
//  //                  JOptionPane.showMessageDialog(null, "Possas");
//
//                } else {
//
//                    for (int j = 0; j < var.size(); j++) {
//    //                    JOptionPane.showMessageDialog(null, "Pegou essa var"+var.get(j)+"   -> pos"+j);
//                        if (nome_var.equals(var.get(j))) {
//      //                      JOptionPane.showMessageDialog(null, "var igual");
//        //                    JOptionPane.showMessageDialog(null, "NomeVar "+nome_var+"  VARGET-> "+var.get(j));
//                            //return;
//                            //return AnaliseSintatica_ComErros;
//                        }else{
//                            num = 1;
//                        }
//                    }
//                    
//                    if(num == 1){
//                        var.add(nome_var);
//                    }
//                    
//                }
//
//                //token.setPegar_nome_var(c.getPegar_nome_var());
//            }
//
////        for(int j=0; j<var.size(); j++){
////            JOptionPane.showMessageDialog(null, "var: "+var.get(j));
////        }
////            
//            //modeloTable.addRow(new Object[]{c.getCodigo(), c.getNome(), c.getLinha()});
//        }
//    }

    

}
