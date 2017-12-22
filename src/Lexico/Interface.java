package Lexico;

import Lexico.ListaVariaveis;
import Sintatico.Sintatico;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

public class Interface extends javax.swing.JFrame {

    Token token = new Token();
    Lista listaToken = new Lista();
    ListaVariaveis listaPilha = new ListaVariaveis();
    public DefaultTableModel modeloTable;
    public DefaultTableModel mTable;
    String x = "";
    
    ArrayList<String> p = new ArrayList<>();

    public Interface() {
        initComponents();
        //getListaMunuAtt(listaToken);
        //getListVariaveis(lista);

    }

    public void salvar() {

        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        //JFileChooser fc = new JFileChooser();
        //Exibe o diálogo. Deve ser passado por parâmetro o JFrame de origem.
        fc.showSaveDialog(this);
        //Captura o objeto File que representa o arquivo selecionado.
        File selFile = fc.getSelectedFile();
        String nomearquivo = selFile.getAbsolutePath();
        String conteudo = AreaCodigo.getText();
        gravarArquivo(nomearquivo, conteudo);
    }

    private void gravarArquivo(String nomeArquivo, String textoArquivo) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(nomeArquivo, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textoArquivo);
            bufferedWriter.flush();
//Se chegou ate essa linha, conseguiu salvar o arquivo com sucesso.
            JOptionPane.showMessageDialog(this, "Salvo com sucesso");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: " + ex.getMessage());
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: "
                            + ex.getMessage());
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: "
                            + ex.getMessage());
                }
            }
        }
    }

    //Função Abrir arquivo//
    public void abrir() {
        JFileChooser fc = new JFileChooser();
        //Exibe o diálogo. Deve ser passado por parâmetro o JFrame de origem.
        fc.showOpenDialog(this);
        //Captura o objeto File que representa o arquivo selecionado.
        File selFile = fc.getSelectedFile();
        // System.out.println(selFile.getAbsolutePath());
        String nomeArquivo = selFile.getAbsolutePath();
        String conteudo = lerArquivo(nomeArquivo);
        AreaCodigo.setText(conteudo);
    }

    private String lerArquivo(String nomeArquivo) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(nomeArquivo);
            bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            while (bufferedReader.ready()) {
                sb.append(bufferedReader.readLine());
                sb.append("\n");
            }
            return sb.toString();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo: "
                    + ex.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao abriro arquivo: " + ex.getMessage());
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao abri o arquivo: " + ex.getMessage());
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaCodigo = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableSemantico = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        campoPilha = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java / C 1.0.0");
        setBackground(java.awt.SystemColor.activeCaption);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AreaCodigo.setColumns(20);
        AreaCodigo.setRows(5);
        jScrollPane2.setViewportView(AreaCodigo);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 660, 270));

        jButton1.setText("Executar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcExecutar(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Token", "Linha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("Campo Variaveis", jScrollPane1);

        tableSemantico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Categoria", "Tipo"
            }
        ));
        jScrollPane5.setViewportView(tableSemantico);

        jTabbedPane1.addTab("tab3", jScrollPane5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 890, 200));

        jScrollPane3.setViewportView(campoPilha);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 220, 270));

        jMenu2.setText("Arquivos");

        jMenuItem1.setText("novo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoProjeto(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("abrir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirProjeto(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setText("salvar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarProjeto(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sobre");

        jMenuItem5.setText("Sobre");
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Ajuda");
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarProjeto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarProjeto
        if (!"".equals(AreaCodigo.getText().trim())) {
            salvar();
        }
    }//GEN-LAST:event_salvarProjeto

    private void funcExecutar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcExecutar
        if (!"".equals(AreaCodigo.getText().trim())) {

            listaToken.linpar();
            //listaPilha.linpar();
            //getListaMunuAtt(listaToken);
            //getListVariaveis(listavar);
            String texto = String.valueOf(AreaCodigo.getText());
            ControllerClassifica cc = new ControllerClassifica();
            listaToken = cc.getPalavra(texto);
            Sintatico Sintatico = new Sintatico();
            String mensagem = null;

            if (Sintatico.Analisar(listaToken) == Sintatico.AnaliseSintatica_ComErros) {

                JOptionPane.showMessageDialog(null, Sintatico.returnErro());
            }

            //getListaMunuAtt(listaToken);
            //LinkedList<Integer> number = token.getPilha();
            //System.out.println("---> " + number);
            /// listaToken = cc.getPalavra(texto);
            getListaMunuAtt(listaToken, p);
            //imprimirMatriz(listaToken, p);
           
            
        }
         
        
    }//GEN-LAST:event_funcExecutar

    private void novoProjeto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoProjeto
        if (!"".equals(AreaCodigo.getText().trim())) {
            int Confirm = JOptionPane.showConfirmDialog(null, "Deseja Salvar este arquivo?", "sim ou nao", JOptionPane.YES_NO_OPTION);
            if (Confirm == JOptionPane.YES_OPTION) {
                salvar();
            } else {
                AreaCodigo.setText("");
                listaToken.linpar();
                getListaMunuAtt(listaToken, p);
                //getListVariaveis(listavar);
            }
        }


    }//GEN-LAST:event_novoProjeto

    private void abrirProjeto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirProjeto
        if ("".equals(AreaCodigo.getText().trim())) {
            abrir();
        } else {
            int Confirm = JOptionPane.showConfirmDialog(null, "Deseja Salvar este arquivo?", "sim ou nao", JOptionPane.YES_NO_OPTION);
            if (Confirm == JOptionPane.YES_OPTION) {
                salvar();
            } else {
                AreaCodigo.setText("");
                abrir();
            }
        }
    }//GEN-LAST:event_abrirProjeto
    //tabela
    
    
    public void getListaMunuAtt(Lista li, ArrayList p) {
        //Atualiza a grid
        modeloTable = (DefaultTableModel) jTable1.getModel();
        mTable = (DefaultTableModel) tableSemantico.getModel();

        while (modeloTable.getRowCount() > 0) {
            modeloTable.removeRow(0);
        }

        for (int i = 0; i < li.getLista().size(); i++) {
            Token c = new Token();
            c = li.getLista().get(i);
            modeloTable.addRow(new Object[]{c.getCodigo(), c.getNome(), c.getLinha()});
        }
        jTable1.setModel(modeloTable);

        //modeloTable = (DefaultTableModel) tableSemantico.getModel();
        for (int i = 0; i < p.size(); i++) {
            //Variaveis v = new Variaveis();
            //v = l.get(i);
            //JOptionPane.showMessageDialog(null, "Tipo da variavel: " + l.get(i));
            //x = v.getNomeVar().toString();
            //JOptionPane.showMessageDialog(null, "variavel x: " + x);
            
            //mTable.addRow(new String[]{p.get(i).toString(), "EEEEEEEEE", "EEEEEEEEE"});

        }
        tableSemantico.setModel(mTable);
        
        //JOptionPane.showMessageDialog(null, "Tamanho da pilha" + li.getPilha().size());

    }
    
    
    
    public void getListVariaveis(ArrayList l) {
        JOptionPane.showMessageDialog(null, "Veio até aqui, xééé");

        modeloTable = (DefaultTableModel) tableSemantico.getModel();
        while (modeloTable.getRowCount() > 0) {
            modeloTable.removeRow(0);
        }

        for (int i = 0; i < l.size(); i++) {

            //Variaveis v = new Variaveis();
            //v = l.get(i);
            //JOptionPane.showMessageDialog(null, "Tipo da variavel: " + l.get(i));
            //x = v.getNomeVar().toString();
            //JOptionPane.showMessageDialog(null, "variavel x: " + x);
            modeloTable.addRow(new String[]{"xmmmmmmmmmm", "EEEEEEEEE", "EEEEEEEEE"});

        }
        tableSemantico.setModel(modeloTable);

    }

    /**
     *
     * @param Integer
     */
    
    public void imprimirMatriz(Lista listaToken, String p) {
        String x = "";
        
        //if(p.size() > 0){
            
            for(int i=0; i<p.length(); i++){
            //token = listaToken.getLista().get(i);
            
            x+= "edededededed"+"\n";
            //JOptionPane.showMessageDialog(null, "[ ] "+p);
            
        //}
        }
        campoPilha.setText(x);
        
        
        //campoPilha.setText(li.getListaVariaveis().toString());
        //JOptionPane.showMessageDialog(null, "Pilha tamanho" +li.getListaVariaveis().toString()+"\n");
        //pilhaArray.add(li.getListaVariaveis().toString());
//        for (int i = 0; i < p.size(); i++) {
////            Variaveis var = new Variaveis();
////            var = p.getListaVariaveis().get(i);
////            campoPilha.setText("eeeeeeee");
//            //JOptionPane.showMessageDialog(null, "Pilha tamanho" + p.size()+" --- "+p.get(i));
//        }  
//JOptionPane.showMessageDialog(null, " [ ] "+pilhaArray.size());
    }

    String varPilha = "";

    public String getVarPilha() {
        return varPilha;
    }

    public void setVarPilha(String varPilha) {
        this.varPilha = varPilha;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    public void setTexte() {

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaCodigo;
    public javax.swing.JEditorPane campoPilha;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable tableSemantico;
    // End of variables declaration//GEN-END:variables

}
