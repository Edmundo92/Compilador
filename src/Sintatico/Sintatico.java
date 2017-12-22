package Sintatico;

import Lexico.Interface;
import Lexico.Lista;
import Lexico.ListaVariaveis;
import Lexico.Token;
import Lexico.Variaveis;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Sintatico {

    private LinkedList<Integer> pilha = new LinkedList<Integer>();

    //arrays para tipos de var
    ArrayList<String> varFloat = new ArrayList<>();
    ArrayList<String> varInteger = new ArrayList<>();
    ArrayList<String> varString = new ArrayList<>();
    ArrayList<String> varChar = new ArrayList<>();
    String x = "";

    private Lista t;
    Lista lista = new Lista();

    String pegarPilha = "";

    public String getPegarPilha() {
        return pegarPilha;
    }

    public void setPegarPilha(String pegarPilha) {
        this.pegarPilha = pegarPilha;
    }

    private int linha, regra;
    int pegarN = 0;
    int numAtual = 0;
    int num = 0, pegarSimbolo = 0;

    String mensagem = "";
    ArrayList<String> guardarVariaveis = new ArrayList<>();
    ArrayList<String> p = new ArrayList<>();
    ArrayList<String> pilhaArray = new ArrayList<>();
    ArrayList<String> guardarLinhasErro = new ArrayList<>();

    ListaVariaveis li = new ListaVariaveis();
    Variaveis variaveis = new Variaveis();
    Interface ui = new Interface();

    private String nomeToken;
    public static final int AnaliseSintatica_Fim = 0;
    public static final int AnaliseSintatica_SemErros = 1;
    public static final int AnaliseSintatica_ComErros = 2;
    public static final int ErroSemantico = 3;
    private Object pegarNum;

    public String returnErro() {
        return "Erro na linha " + linha + " no token: " + nomeToken;
    }

    public String matriz(String mensagem) {
        return mensagem;
    }

    public Sintatico() {
        pilha.addFirst(44);
        pilha.addFirst(48);

    }

    public Integer Analisar(Lista tokens) {
        for (int i = 0; i < tokens.tamanho(); i++) {

            Token token = tokens.retorna(i);

            int resu = Analisador(Integer.parseInt(token.getCodigo()), token.getNome(), token.getLinha());
            if (resu == AnaliseSintatica_ComErros) {
                linha = Integer.parseInt(token.getLinha());
                nomeToken = token.getNome();
                return AnaliseSintatica_ComErros;
            } else if (resu == ErroSemantico) {

                return ErroSemantico;
            }
        }
        return AnaliseSintatica_Fim;
    }

    public Integer Analisador(Integer sEntrada, String name_Comando, String linha) { //0 - fim , 1- sai sem erros 2-sai comerro

        Integer topPilha;
        Integer simboloEntrada;
        String name = "";

        topPilha = pilha.getFirst();
        simboloEntrada = sEntrada;
        name = name_Comando;
        int guardarTopo;

        //ArrayList<String> name = new ArrayList<>();
        //Lista lista = new Lista();
        //lista.setPilha(pilha.toString());
        do {

            //variaveis.setPilha(pilha.toString());
            //lista.setPilha(pilha.toString());
            Integer pegarNum = pilha.getFirst();

            //ui.campoPilha.setText(li.getListaVariaveis().toString());
            x += pilha.toString() + "\n";
            ui.imprimirMatriz(lista, x);
            System.out.println(simboloEntrada + " " + topPilha + " " + pilha + " " + regra + "\n");

            if (simboloEntrada == 7) {
                pegarN = simboloEntrada;
                mensagem = name;

                if (numAtual == 1) {
                    int number = verificarTipoVar(mensagem);
                    if (number == 0) {
                        JOptionPane.showMessageDialog(null, "Variavel não declarada -> " + name);
                        return ErroSemantico;
                    }
                }

                //JOptionPane.showMessageDialog(null, " -> " + name);
            } else if (simboloEntrada == 44) {
                //JOptionPane.showMessageDialog(null, "Entrou");
                System.out.println("\n\n" + "Nome" + "\t" + "Tipo" + "\n");
                if (varFloat.size() > 0) {
                    for (int i = 0; i < varFloat.size(); i++) {
                        System.out.println(varFloat.get(i) + "\t" + "variavel" + "\n");
                    }
                } else if (varInteger.size() > 0) {
                    for (int i = 0; i < varInteger.size(); i++) {
                        System.out.println(varInteger.get(i) + "\t" + "variavel" + "\n");
                    }
                } else if (varChar.size() > 0) {
                    for (int i = 0; i < varChar.size(); i++) {
                        System.out.println(varChar.get(i) + "\t" + "variavel" + "\n");
                    }
                } else if (varString.size() > 0) {
                    for (int i = 0; i < varString.size(); i++) {
                        System.out.println(varString.get(i) + "\t" + "variavel" + "\n");
                    }
                }

            } else if (simboloEntrada == 23 || simboloEntrada == 17 || simboloEntrada == 3 || simboloEntrada == 12) {
                mensagem = name;
            } else if (simboloEntrada == 13) {
                numAtual = 1;
            } else if (simboloEntrada == 5 || simboloEntrada == 6 || simboloEntrada == 8 || simboloEntrada == 9) {
                pegarSimbolo = simboloEntrada;
            }

            if (topPilha == 15) {
                pilha.removeFirst(); //Retire o elemento do topo da pilha
                topPilha = pilha.getFirst();   //X recebe o topo da pilha
            } else if ((topPilha >= 1) && (topPilha <= 47)) { //Se X é terminal então
                if (topPilha == simboloEntrada) {//Se X=a então
                    //guardarTopo = pilha.getFirst();
                    pilha.removeFirst();//Retire o elemento do topo da pilha

                    return AnaliseSintatica_SemErros; //Sai do Repita // 
                } else {
                    return AnaliseSintatica_ComErros; //Encerra o programa  	
                }
            } else if ((topPilha >= 48) && (topPilha <= 76)) { //Senão (* X é não-terminal*)

                TabelaCodificada tabelaParsing = new TabelaCodificada();
                Integer regra = tabelaParsing.regra(topPilha, simboloEntrada);
                this.regra = regra;
                if (regra != 0) { //Se M(X,a) <> ∅ então (existe uma regra)
                    pilha.removeFirst();//Retire o elemento do topo da pilha 

                    //Coloque o conteúdo da regra na pilha
                    GramaticaCodificada regrasGramatica = new GramaticaCodificada();

                    String regras[] = regrasGramatica.getGramatica(regra);
                    for (int i = (regras.length - 1); i >= 0; i--) {
                        pilha.addFirst(Integer.valueOf(regras[i]));

                    }
                    topPilha = pilha.getFirst(); //X recebe o topo da pilha
                } else {
                    return AnaliseSintatica_ComErros; //Encerra o programa  	
                }
            } else if (topPilha >= 100 && topPilha < 120) { //se for ação semântica

                guardarLinhasErro.add(linha);
                boolean x = analisaSemantico(mensagem, pegarN, topPilha, pegarSimbolo);
                if (x == true) {
                    return ErroSemantico;
                }
                pilha.removeFirst();

                topPilha = pilha.getFirst();
                mensagem = "";
                pegarN = 0;
                num = 0;
                pegarSimbolo = 0;
                //topPilha = pilha.get(pilha.size() - 1);
            }

        } while (topPilha != 44);

        return AnaliseSintatica_Fim;
    }

    //Analisa o semantico
    public Boolean analisaSemantico(String name, Integer action, Integer spilha, Integer pegarSimbolo) {
        Semantico semantico = new Semantico();
        Token token = new Token();
        boolean isValido = false;
        int posAction;
        int posIdent;
        String ident;
        String cAction = "";
        boolean numBoolean = false;

        switch (spilha) {
            case 100:

                if (guardarVariaveis.size() == 0) {
                    guardarVariaveis.add(name);

                } else {

                    for (int j = 0; j < guardarVariaveis.size(); j++) {
                        if (name.equals(guardarVariaveis.get(j))) {
                            JOptionPane.showMessageDialog(null, "Variavel [" + name + "] repetida na linha -> " + guardarLinhasErro.get(j));
                            numBoolean = true;
                        } else {
                            num = 1;
                        }
                    }

                    if (num == 1) {
                        guardarVariaveis.add(name);
                    }

                }

//                variaveis.setNomeVar(name);
//                li.adicionar(variaveis);
                break;
            case 102:
//                int x = 0;
//                //JOptionPane.showMessageDialog(null, "var--> " + name + "  -- " + varFloat.size());
//                for (int i = 0; i < varFloat.size(); i++) {
//                    if (!name.equals(varFloat.get(i))) {
//                        x = 1;
//                    }
//                }
//                if (x == 1) {
//                    JOptionPane.showMessageDialog(null, "Error, variavel [" + name + "], não declarada");
//                }
                break;
            case 107://armazena variaveis nos seus determinados arrays
                if (name.equalsIgnoreCase("float")) {
                    //JOptionPane.showMessageDialog(null, "Tipo da variavel ++: " + name);
                    for (int i = 0; i < guardarVariaveis.size(); i++) {
                        varFloat.add(guardarVariaveis.get(i));
                    }

                } else if (name.equalsIgnoreCase("integer")) {
                    for (int i = 0; i < guardarVariaveis.size(); i++) {
                        varInteger.add(guardarVariaveis.get(i));
                    }
                } else if (name.equalsIgnoreCase("char")) {
                    for (int i = 0; i < guardarVariaveis.size(); i++) {
                        varChar.add(guardarVariaveis.get(i));
                    }
                } else if (name.equalsIgnoreCase("string")) {
                    for (int i = 0; i < guardarVariaveis.size(); i++) {
                        varString.add(guardarVariaveis.get(i));
                    }
                }
                guardarVariaveis.clear();
                break;

            case 108://armazena variaveis do tipo float

                break;

            case 110:
                Integer tipoVar = verificarTipoVar(name);
                //JOptionPane.showMessageDialog(null, "Issoooooooo" + name + " Name var" + pegarSimbolo);
                //JOptionPane.showMessageDialog(null, "Number" + tipoVar);
                if (tipoVar == 1) {//float
                    for (int i = 0; i < varFloat.size(); i++) {
                        if (varFloat.get(i).equals(name)) {
                            if (pegarSimbolo == 5) {
                                JOptionPane.showMessageDialog(null, "Erro, integer no float");
                            } else if (pegarSimbolo == 8) {
                                JOptionPane.showMessageDialog(null, "Erro, char no float");
                            } else if (pegarSimbolo == 9) {
                                JOptionPane.showMessageDialog(null, "Erro, String no float");
                            }
                            numBoolean = true;
                        }
                    }
                } else if (tipoVar == 2) {//int
                    for (int i = 0; i < varInteger.size(); i++) {
                        if (varInteger.get(i).equals(name)) {
                            if (pegarSimbolo == 6) {
                                JOptionPane.showMessageDialog(null, "Erro, float no Integer");
                            } else if (pegarSimbolo == 8) {
                                JOptionPane.showMessageDialog(null, "Erro, char no Integer");
                            } else if (pegarSimbolo == 9) {
                                JOptionPane.showMessageDialog(null, "Erro, String no Integer");
                            }
                            numBoolean = true;
                        }
                    }
                } else if (tipoVar == 3) {//char
                    for (int i = 0; i < varChar.size(); i++) {
                        if (varChar.get(i).equals(name)) {
                            if (pegarSimbolo == 5) {
                                JOptionPane.showMessageDialog(null, "Erro, integer no Char");
                            } else if (pegarSimbolo == 6) {
                                JOptionPane.showMessageDialog(null, "Erro, float no Char");
                            } else if (pegarSimbolo == 9) {
                                JOptionPane.showMessageDialog(null, "Erro, String no Char");
                            }
                            numBoolean = true;
                        }
                    }
                } else if (tipoVar == 4) {//String
                    for (int i = 0; i < varString.size(); i++) {
                        if (varString.get(i).equals(name)) {
                            if (pegarSimbolo == 5) {
                                JOptionPane.showMessageDialog(null, "Erro, integer no String");
                            } else if (pegarSimbolo == 8) {
                                JOptionPane.showMessageDialog(null, "Erro, char no String");
                            } else if (pegarSimbolo == 6) {
                                JOptionPane.showMessageDialog(null, "Erro, float no String");
                            }
                            numBoolean = true;
                        }
                    }
                }
                break;
//            case 203:
//                break;
//            case 204:
//                break;
//
//            case 206:
//                break;
        }
        return numBoolean;
    }

    public void listar(ArrayList guardarVariaveis) {
        for (int j = 0; j < guardarVariaveis.size(); j++) {
            //System.out.print(a.get(j) + "-");
            //JOptionPane.showMessageDialog(null, "--->>>" + guardarVariaveis.get(j));
        }
    }

    public Integer verificarTipoVar(String name) {
        Integer nVar = 0;

        for (int i = 0; i < varFloat.size(); i++) {
            if (varFloat.get(i).equals(name)) {
                nVar = 1;
                //JOptionPane.showMessageDialog(null, "1");
            }
        }

        for (int i = 0; i < varInteger.size(); i++) {
            if (varInteger.get(i).equals(name)) {
                nVar = 2;
            }
        }

        for (int i = 0; i < varChar.size(); i++) {
            if (varChar.get(i).equals(name)) {
                nVar = 3;
            }
        }

        for (int i = 0; i < varString.size(); i++) {
            if (varString.get(i).equals(name)) {
                nVar = 4;
            }
        }

        return nVar;
    }

}
