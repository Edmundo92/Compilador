package Lexico;

import Sintatico.Sintatico;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerClassifica {

    Token token = new Token();
    Lista listaToken = new Lista();
    Interface ui = new Interface();
    
    ArrayList<String> p = new ArrayList<>();
    
    //paToken - armazena as palavras reservadas e as palavras de nome de variaveis.
    public Lista getPalavra(String texto) {

        int contadorDelinha = 1;// Esta variavel conta as linhas do texto
        String paToken = "";
        char pegarCaracter;

        try {
           
            for (int i = 0; i < texto.length(); i++) {
                Token token = new Token();
                pegarCaracter = texto.charAt(i);
                
                //esse if é a validaçao da contagem de linha 
                if (String.valueOf(pegarCaracter).matches("[\n]")) {
                    contadorDelinha++;

                    //esse if ignora os espaços
                } else if (String.valueOf(pegarCaracter).matches(" ")) {
                    
                    // esse if trata os comandos nativos e palavras de variaveis
                } else if (String.valueOf(pegarCaracter).matches("[a-zA-Z]")) {

                    //enquanto for letra 
                    while (String.valueOf(pegarCaracter).matches("[a-zA-Z]")) {

                        pegarCaracter = texto.charAt(i);
                        paToken += String.valueOf(pegarCaracter);

                        i++;
                        pegarCaracter = texto.charAt(i);
                    }
                    
                    setLista(paToken, contadorDelinha);
                    paToken = "";
                    i--;

                } else if(String.valueOf(pegarCaracter).matches("[,]")){
                    paToken += String.valueOf(pegarCaracter);
                    setLista(paToken, contadorDelinha);
                    paToken = "";
                
                    //inteiros e floats
                }else if (String.valueOf(pegarCaracter).matches("[0-9]") || String.valueOf(pegarCaracter).matches("[,]")) {
                    boolean numeroDecimal = false;

                    //enquanto for número ou 
                    while(String.valueOf(pegarCaracter).matches("[0-9]") || String.valueOf(pegarCaracter).matches("[,]")) {

                        //pegarCaracter = texto.charAt(i);
                        paToken += String.valueOf(pegarCaracter);
                        
                        i++;
                        pegarCaracter = texto.charAt(i);
                    }
                    
                    //palavrasReservadas - palavrasReservadas e nomes de variaveis
                    String palavrasReservadas = "";
                    palavrasReservadas += paToken;
                    for (int j = 0; j < palavrasReservadas.length(); j++) {
                        char p1 = palavrasReservadas.charAt(j);
                        if (String.valueOf(p1).matches("[,]")) {
                            numeroDecimal = true;
                        }
                    };
                    if (!numeroDecimal) {// verificação da classificação float ou int
                        token.setCodigo("5"); //num_inteiro
                        token.setlinha(String.valueOf(contadorDelinha));
                        token.setNome(paToken);
                        listaToken.adicionar(token);
                        paToken = "";
                        i--;
                    } else {
                        token.setCodigo("6"); //num_float
                        token.setlinha(String.valueOf(contadorDelinha));
                        token.setNome(paToken);
                        listaToken.adicionar(token);
                        paToken = "";
                        i--;
                    }
                } else // esse if e a definição de literal "Texto"
                if (String.valueOf(pegarCaracter).matches("[\"]")) {
                    int j = i + 1;
                    char a = texto.charAt(j);
                    paToken += String.valueOf(pegarCaracter);

                    while (!String.valueOf(a).matches("[\"]")) {
                        a = texto.charAt(j);
                        paToken += String.valueOf(a);
                        j++;
                    }
                    j--;
                    i = j;
                    token.setCodigo("11");
                    token.setlinha(String.valueOf(contadorDelinha));
                    token.setNome(paToken);
                    listaToken.adicionar(token);
                    paToken = "";

                } else if (String.valueOf(pegarCaracter).matches("[']")) { //tratar char

                    int j = i + 1;
                    char a = texto.charAt(j);
                    paToken += String.valueOf(pegarCaracter);
                    while (!String.valueOf(a).matches("[']") && String.valueOf(a).length() == 1) {

                        a = texto.charAt(j);
                        paToken += String.valueOf(a);
                        j++;
                    }
                    j--;
                    i = j;
                    token.setCodigo("8");
                    token.setlinha(String.valueOf(contadorDelinha));
                    token.setNome(paToken);
                    listaToken.adicionar(token);
                    paToken = "";

                } else // tratar String
                if (String.valueOf(pegarCaracter).matches("[$]")) {
                    int j = i + 1;
                    char a = texto.charAt(j);
                    paToken += String.valueOf(pegarCaracter);
                    while (!String.valueOf(a).matches("[$]")) {

                        a = texto.charAt(j);
                        paToken += String.valueOf(a);
                        j++;
                    }
                    j--;
                    i = j;
                    token.setCodigo("9");
                    token.setlinha(String.valueOf(contadorDelinha));
                    token.setNome(paToken);
                    listaToken.adicionar(token);
                    paToken = "";

                } else {
                    //Daqui até o final Tratamento de operadores 
                    if (String.valueOf(pegarCaracter).matches("<")) {
                        paToken += String.valueOf(pegarCaracter);
                        char a;
                        int j = i + 1;
                        a = texto.charAt(j);
                        if (String.valueOf(a).matches("[=]")) {
                            paToken += String.valueOf(a);

                            i = j;

                        } else if (String.valueOf(a).matches("[<]")) {
                            paToken += String.valueOf(a);
                            
                            i = j;
                        }
                          
                        setLista(paToken, contadorDelinha);
                        paToken = "";
                    }else if (String.valueOf(pegarCaracter).matches("!")) {
                        paToken += String.valueOf(pegarCaracter);
                        char a;
                        int j = i + 1;
                        a = texto.charAt(j);
                        if (String.valueOf(a).matches("[=]")) {
                            paToken += String.valueOf(a);

                            i = j;
                        }
                        setLista(paToken, contadorDelinha);
                        paToken = "";

                    } else if (String.valueOf(pegarCaracter).matches("[>]")) {
                        paToken += String.valueOf(pegarCaracter);
                        char a;
                        int j = i + 1;
                        a = texto.charAt(j);
                        if (String.valueOf(a).matches("[=]")) {
                            paToken += String.valueOf(a);

                            i = j;
                        } else if (String.valueOf(a).matches("[>]")) {
                            paToken += String.valueOf(a);

                            i = j;
                        }
                        setLista(paToken, contadorDelinha);
                        paToken = "";

                    } else if (String.valueOf(pegarCaracter).matches(":")) {
                        paToken += String.valueOf(pegarCaracter);
                        char a;
                        int j = i + 1;
                        a = texto.charAt(j);

                        if (String.valueOf(a).matches("[=]")) {
                            paToken += String.valueOf(a);
                            i = j;
                        }
                        setLista(paToken, contadorDelinha);
                        paToken = "";

                    } else if (String.valueOf(pegarCaracter).matches("[=+;.,*{,},),(,$-]")) {
                        paToken += String.valueOf(pegarCaracter);
                        setLista(paToken, contadorDelinha);
                        paToken = "";
                    } else //trata os comentarios de linha e de bloco
                    if (String.valueOf(pegarCaracter).matches("[/]")) {
                        char a;
                        int j = i + 1;
                        a = texto.charAt(j);
                        if (String.valueOf(a).matches("[/]")) {
                            while (!String.valueOf(a).matches("[\n]")) {

                                a = texto.charAt(j);
                                j++;
                                i = j;
                                i--;
                            }
                        } else if (String.valueOf(a).matches("[*]")) {
                            boolean aox = false;
                            for (j = j; j < texto.length(); j++) {
                                if (String.valueOf(texto.charAt(j)).equals("*")) {
                                    j++;
                                    if (String.valueOf(texto.charAt(j)).equals("/")) {
                                        i = j;
                                        aox = true;
                                    }
                                }
                                if (String.valueOf(texto.charAt(j)).matches("[\n]")) {
                                    contadorDelinha++;
                                }
                            }
                            contadorDelinha--;
                            if (!aox) {
                                setLista("Erro  comentario", contadorDelinha);
                                i = j;
                            }
                        } else {
                            setLista("/", contadorDelinha);
                        }
                    } else {
                        //se nao cair em nenhum é um caracter invalido, o 404 foi escolhido para representar o tipo de erro 
                        token.setCodigo("404");
                        token.setlinha(String.valueOf(contadorDelinha));
                        token.setNome("Invalido");
                        listaToken.adicionar(token);

                    }
                }
            }
        } catch (Exception e) {

            char p1 = paToken.charAt(0);

            if (String.valueOf(p1).matches("[0-9]")) {

                boolean flot = false;
                String palavra1 = paToken;
                for (int j = 0; j < palavra1.length(); j++) {
                    char p2 = palavra1.charAt(j);
                    if (String.valueOf(p2).matches("[,]")) {
                        flot = true;
                    }
                }
                if (!flot) {
                    token.setCodigo("12");
                    token.setlinha(String.valueOf(contadorDelinha));
                    int i = Integer.parseInt(paToken);
                    if (i <= 32768) {
                        token.setNome(paToken);
                        listaToken.adicionar(token);
                        paToken = "";
                    } else {
                        token.setNome("Erro... Excesso de integer");
                        listaToken.adicionar(token);
                        paToken = "";
                    }

                } else {
                    token.setCodigo("17");
                    token.setlinha(String.valueOf(contadorDelinha));
                    float i = Float.parseFloat(paToken);
                    if (i <= 1073741824) {
                        token.setNome(paToken);
                        listaToken.adicionar(token);
                        paToken = "";
                    } else {
                        token.setNome("Erro... Excesso de Float");
                        listaToken.adicionar(token);
                        paToken = "";
                    }

                }
            } else {

                setLista(paToken, contadorDelinha);

                System.out.println(paToken);
            }
        }
            //quando sair do loop e final de arquivo
        
        setLista("$", contadorDelinha);
        ui.getListaMunuAtt(listaToken, p);
        
        Sintatico sintatico = new Sintatico();
        //sintatico.setPegarVar(listaToken);
        return listaToken;

    }

    //método setLista, onde são enviadas as palavras reservadas, nomes de variaveis e o número de linhas

    public void setLista(String palavra, int linha) {

        Token token = new Token();
        switch (palavra) {
            case "while":
                token.setCodigo("1");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;

            case "void":
                token.setCodigo("2");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;

            case "string":
                token.setCodigo("3");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;

            case "return":
                token.setCodigo("4");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;

            case "num_int":
                token.setCodigo("5");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;

            case "num_float":
                token.setCodigo("6");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;

            //case "nome_var":
//                token.setCodigo("7");
//                token.setNome(palavra);
//                token.setlinha(String.valueOf(linha));
//                break;

            case "nome_char":
                token.setCodigo("8");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "nome_string":
                token.setCodigo("9");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;

            case "main":
                token.setCodigo("10");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;

            case "literal":
                token.setCodigo("11");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "integer":
                token.setCodigo("12");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "inicio":
                token.setCodigo("13");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "if":
                token.setCodigo("14");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "i":
                token.setCodigo("15");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "for":
                token.setCodigo("16");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "float":
                token.setCodigo("17");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "fim":
                token.setCodigo("18");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "do":
                token.setCodigo("20");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "cout":
                token.setCodigo("21");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "cin":
                token.setCodigo("22");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "char":
                token.setCodigo("23");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "callfuncao":
                token.setCodigo("24");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case ">>":
                token.setCodigo("25");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case ">=":
                token.setCodigo("26");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case ">":
                token.setCodigo("27");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "==":
                token.setCodigo("28");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "=":
                token.setCodigo("29");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "<=":
                token.setCodigo("30");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "<<":
                token.setCodigo("31");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "<":
                token.setCodigo("32");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "++":
                token.setCodigo("33");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "+":
                token.setCodigo("34");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "}":
                token.setCodigo("35");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "{":
                token.setCodigo("36");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case ";":
                token.setCodigo("37");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case ":":
                token.setCodigo("38");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "/":
                token.setCodigo("39");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case ",":
                token.setCodigo("40");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "*":
                token.setCodigo("41");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case ")":
                token.setCodigo("42");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "(":
                token.setCodigo("43");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "$":
                token.setCodigo("44");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "!=":
                token.setCodigo("45");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "--":
                token.setCodigo("46");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "var"://para teste;
                token.setCodigo("49");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;
            case "-":
                token.setCodigo("47");
                token.setNome(palavra);
                token.setlinha(String.valueOf(linha));
                break;

            default:
               token.setCodigo("7");
               token.setNome(palavra);
               //JOptionPane.showMessageDialog(null, "Identificador--> "+token.getPegar_nome_var() +"\n");
               token.setlinha(String.valueOf(linha));
               break;
        }
        listaToken.adicionar(token);

    }
}
