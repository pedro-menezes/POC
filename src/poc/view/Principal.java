/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poc.control.CampeonatoController;
import poc.model.Campeonato;
import poc.model.Campo;
import poc.model.MatrizDistancia;
import poc.model.ModelDistancia;
import poc.model.Time;

/**
 *
 * @author pedro_menezes
 */
public class Principal extends javax.swing.JFrame {

    private static Campeonato campeonato = new Campeonato();

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    public void addInternal(JInternalFrame jIFrame) {
        desktopPane.add(jIFrame);
        centralizar(jIFrame);
        jIFrame.setVisible(true);
    }

    public void organizarTabela() {
        DefaultTableModel modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Código");
        modeloTabela.addColumn("Time");
        modeloTabela.addColumn("Prioridade");

        ArrayList<Time> times = campeonato.getTimes();

        if (times.isEmpty()) {
            modeloTabela.addRow(new String[]{"Sem informação", "Sem informação", "Sem informação"});
        } else {
            for (int i = 0; i < times.size(); i++) {
                modeloTabela.addRow(new String[]{String.valueOf(times.get(i).getCodigo()), times.get(i).getNome(),String.valueOf(times.get(i).getPrioridade())});
            }
        }
        tableTimes.setModel(modeloTabela);
        tableTimes.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seletorArquivos = new javax.swing.JFileChooser();
        toolBar = new javax.swing.JToolBar();
        buttonAbrir = new javax.swing.JButton();
        butonSalvar = new javax.swing.JButton();
        buttonAddTime = new javax.swing.JButton();
        buttonDistancias = new javax.swing.JButton();
        buttonTabela = new javax.swing.JButton();
        buttonAtualizar = new javax.swing.JButton();
        desktopPane = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTimes = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemAddTime = new javax.swing.JMenuItem();
        itemDistancias = new javax.swing.JMenuItem();
        separatorUm = new javax.swing.JPopupMenu.Separator();
        itemTabela = new javax.swing.JMenuItem();
        separatorDois = new javax.swing.JPopupMenu.Separator();
        itemAbrir = new javax.swing.JMenuItem();
        itemSalvar = new javax.swing.JMenuItem();
        itemSalvarComo = new javax.swing.JMenuItem();
        itemSair = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerador de Tabelas");
        setBackground(new java.awt.Color(255, 255, 255));

        toolBar.setForeground(new java.awt.Color(255, 255, 255));
        toolBar.setRollover(true);
        toolBar.setToolTipText("");

        buttonAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poc/view/icons/abrir.png"))); // NOI18N
        buttonAbrir.setToolTipText("Abrir...\n");
        buttonAbrir.setFocusable(false);
        buttonAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAbrirActionPerformed(evt);
            }
        });
        toolBar.add(buttonAbrir);

        butonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poc/view/icons/salvar.png"))); // NOI18N
        butonSalvar.setToolTipText("Salvar");
        butonSalvar.setFocusable(false);
        butonSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butonSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        butonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonSalvarActionPerformed(evt);
            }
        });
        toolBar.add(butonSalvar);

        buttonAddTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poc/view/icons/addTime.png"))); // NOI18N
        buttonAddTime.setToolTipText("Adicionar Time");
        buttonAddTime.setFocusable(false);
        buttonAddTime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonAddTime.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonAddTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddTimeActionPerformed(evt);
            }
        });
        toolBar.add(buttonAddTime);

        buttonDistancias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poc/view/icons/distancia.png"))); // NOI18N
        buttonDistancias.setToolTipText("Cadastrar Distâncias");
        buttonDistancias.setFocusable(false);
        buttonDistancias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonDistancias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonDistancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDistanciasActionPerformed(evt);
            }
        });
        toolBar.add(buttonDistancias);

        buttonTabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poc/view/icons/gerarTabela.png"))); // NOI18N
        buttonTabela.setToolTipText("Gerar Tabela");
        buttonTabela.setFocusable(false);
        buttonTabela.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonTabela.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTabelaActionPerformed(evt);
            }
        });
        toolBar.add(buttonTabela);

        buttonAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poc/view/icons/atualizar.png"))); // NOI18N
        buttonAtualizar.setToolTipText("Atualizar");
        buttonAtualizar.setFocusable(false);
        buttonAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonAtualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarActionPerformed(evt);
            }
        });
        toolBar.add(buttonAtualizar);

        desktopPane.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                desktopPaneComponentResized(evt);
            }
        });

        tableTimes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Símbolos", "Times", "Sede"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableTimes);

        desktopPane.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE))
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
            .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
        );

        menuBar.setBackground(new java.awt.Color(255, 255, 255));
        menuBar.setForeground(new java.awt.Color(255, 255, 255));

        menuArquivo.setText("Arquivo");

        itemAddTime.setText("Adicionar Time");
        menuArquivo.add(itemAddTime);

        itemDistancias.setText("Cadastrar Distâncias");
        menuArquivo.add(itemDistancias);
        menuArquivo.add(separatorUm);

        itemTabela.setText("Gerar Tabela");
        menuArquivo.add(itemTabela);
        menuArquivo.add(separatorDois);

        itemAbrir.setText("Abrir...");
        itemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirActionPerformed(evt);
            }
        });
        menuArquivo.add(itemAbrir);

        itemSalvar.setText("Salvar");
        menuArquivo.add(itemSalvar);

        itemSalvarComo.setText("Salvar como...");
        menuArquivo.add(itemSalvarComo);

        itemSair.setText("Sair");
        itemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairActionPerformed(evt);
            }
        });
        menuArquivo.add(itemSair);

        menuBar.add(menuArquivo);

        menuAjuda.setText("Ajuda");
        menuBar.add(menuAjuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirActionPerformed
        // TODO add your handling code here:
        this.abrirSeletorArquivos(evt);
    }//GEN-LAST:event_itemAbrirActionPerformed

    private void itemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairActionPerformed
        // TODO add your handling code here:
        int opcao = JOptionPane.showConfirmDialog(rootPane, "Deseja sair?");
        if (opcao == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_itemSairActionPerformed

    private void buttonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAbrirActionPerformed
        // TODO add your handling code here:
        this.abrirSeletorArquivos(evt);
    }//GEN-LAST:event_buttonAbrirActionPerformed

    private void buttonAddTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddTimeActionPerformed
        AdicionarTime addTime = new AdicionarTime(campeonato);
        verifInternal(addTime);


    }//GEN-LAST:event_buttonAddTimeActionPerformed

    private void buttonDistanciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDistanciasActionPerformed
        // TODO add your handling code here:
        Distancia dist = new Distancia(campeonato);
        verifInternal(dist);
    }//GEN-LAST:event_buttonDistanciasActionPerformed

    private void desktopPaneComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_desktopPaneComponentResized
        // TODO add your handling code here:
        this.centralizarTudo();
    }//GEN-LAST:event_desktopPaneComponentResized

    private void butonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonSalvarActionPerformed
        // TODO add your handling code here:
        ArrayList<Time> time = campeonato.getTimes();
        ArrayList<ModelDistancia> distancias = campeonato.getDistancias();
        String newLine = System.getProperty("line.separator");
        File arquivo = new File("Arquivo.champ");
        try {
            if (arquivo.createNewFile()) {
                System.out.println("O arquivo foi criado");
            } else {
                System.out.println("O arquivo não foi criado, talvez ele já exista");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (FileWriter fw = new FileWriter(arquivo)) {
            fw.write(time.size() + newLine);
            for (Time time1 : time) {
                fw.write(time1.getCodigo() + ";" + time1.getNome() + ";" + time1.getCampo().getNome() + ";" + time1.getPrioridade() + newLine);
            }
            for (ModelDistancia distancia : distancias) {
                fw.write(distancia.getTimeA().getCodigo() + ";" + distancia.getTimeB().getCodigo() + ";" + distancia.getDistancia() + newLine);
            }
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_butonSalvarActionPerformed

    private void buttonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtualizarActionPerformed
        // TODO add your handling code here:
        organizarTabela();
    }//GEN-LAST:event_buttonAtualizarActionPerformed

    private void buttonTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTabelaActionPerformed
        // TODO add your handling code here:
        CampeonatoController champControl = new CampeonatoController();
        champControl.gerarTabela(campeonato);
    }//GEN-LAST:event_buttonTabelaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    private void abrirSeletorArquivos(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();

        int returnVal = seletorArquivos.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = seletorArquivos.getSelectedFile();
            String caminhoArquivo = file.getAbsolutePath();
            System.out.println("CERTO");
            interpretarArquivo(caminhoArquivo);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

    public void interpretarArquivo(String caminhoArquivo) {
        ArrayList<String> elementos = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));

            while (br.ready()) {

                String linha = br.readLine();

                String[] dadosArquivo = linha.split(";");

                for (int i = 0; i < dadosArquivo.length; i++) {
                    System.out.println(dadosArquivo[i]);
                    elementos.add(dadosArquivo[i]);
                }
            }
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar o arquvio", "Erro de carregamento", ERROR);
        }
        fornecerDados(elementos);
    }

    private void fornecerDados(ArrayList<String> elementosArquivo) {
        ArrayList<String> times = new ArrayList<String>();
        ArrayList<String> distancias = new ArrayList<String>();
        Time time = new Time();
        Campo campo = new Campo();
        ModelDistancia distancia = new ModelDistancia();
        CampeonatoController champControl = new CampeonatoController();
        int cont = 0, cont1 = 1, cont2 = 2, cont3 =3;
        /*       fw.write(time1.getCodigo() + ";" + time1.getNome() + ";" + time1.getCampo().getNome() + ";" + time1.getPrioridade() + newLine);
            }
            for (ModelDistancia distancia : distancias) {
                fw.write(distancia.getTimeA().getCodigo() + ";" + distancia.getTimeB().getCodigo() + ";" + distancia.getDistancia() + newLine);
           */
        
        for (int i = 0; i < (elementosArquivo.size()/2); i++) {
            time.setCodigo(Integer.parseInt(elementosArquivo.get(i+cont)));
            time.setNome(elementosArquivo.get(i+cont1));
            campo.setNome(elementosArquivo.get(i+cont2));
            campo.setCodigo(i);
            time.setCampo(campo);
            time.setPrioridade(i+cont3);
            cont = cont + 4;
            cont1 = cont1 + 4;
            cont2 = cont2 + 4;
            cont3 = cont3 + 4;
            champControl.cadastrarTime(time, campeonato);
        }
     {
            
        }
    }

    private void centralizarTudo() {
        JInternalFrame[] array = desktopPane.getAllFrames();
        for (JInternalFrame internal : array) {
            Dimension desktopSize = desktopPane.getSize();
            Dimension jInternalFrameSize = internal.getSize();
            internal.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                    (desktopSize.height - jInternalFrameSize.height) / 2);
        }
    }

    private void verifInternal(JInternalFrame internal) {
        boolean verif = false;
        JInternalFrame[] array = desktopPane.getAllFrames();

        for (JInternalFrame internals : array) {
            if (internals.getClass().equals(internal.getClass())) {
                Toolkit.getDefaultToolkit().beep();
                internals.moveToFront();
                centralizar(internals);
                verif = true;
                break;
            }
        }

        if (!verif) {
            addInternal(internal);
        }
    }

    private void centralizar(JInternalFrame internal) {
        Dimension desktopSize = desktopPane.getSize();
        Dimension jInternalFrameSize = internal.getSize();
        internal.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butonSalvar;
    private javax.swing.JButton buttonAbrir;
    private javax.swing.JButton buttonAddTime;
    private javax.swing.JButton buttonAtualizar;
    private javax.swing.JButton buttonDistancias;
    private javax.swing.JButton buttonTabela;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itemAbrir;
    private javax.swing.JMenuItem itemAddTime;
    private javax.swing.JMenuItem itemDistancias;
    private javax.swing.JMenuItem itemSair;
    private javax.swing.JMenuItem itemSalvar;
    private javax.swing.JMenuItem itemSalvarComo;
    private javax.swing.JMenuItem itemTabela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JFileChooser seletorArquivos;
    private javax.swing.JPopupMenu.Separator separatorDois;
    private javax.swing.JPopupMenu.Separator separatorUm;
    private javax.swing.JTable tableTimes;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
