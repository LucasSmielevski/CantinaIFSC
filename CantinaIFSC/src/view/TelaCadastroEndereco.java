/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author house
 */
public class TelaCadastroEndereco extends javax.swing.JDialog {

    /**
     * Creates new form TemplateCadastros2023
     */
    public TelaCadastroEndereco(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JButton getjBBuscar() {
        return jBBuscar;
    }

    public JButton getjBCancelar() {
        return jBCancelar;
    }

    public JButton getjBGravar() {
        return jBGravar;
    }

    public JButton getjBNovo() {
        return jBNovo;
    }

    public JButton getjBSair() {
        return jBSair;
    }

    public JPanel getjPanBotoes() {
        return jPanBotoes;
    }

    public JPanel getjPanDados() {
        return jPanDados;
    }

    public JFormattedTextField getjFTFCEP() {
        return jFTFCep;
    }

    public JTextField getjTFCidade() {
        return jTFCidade;
    }

    public JTextField getjTFId() {
        return jTFId;
    }

    public JTextField getjTFLogradouro() {
        return jTFLogradouro;
    }

    public JComboBox<String> getjCBUf() {
        return jCBUf;
    }

    public void setjCBUf(JComboBox<String> jCBUf) {
        this.jCBUf = jCBUf;
    }

    public JFormattedTextField getjFTFCep() {
        return jFTFCep;
    }

    public void setjFTFCep(JFormattedTextField jFTFCep) {
        this.jFTFCep = jFTFCep;
    }

    public JTextField getjTFBairro() {
        return jTFBairro;
    }

    public void setjTFBairro(JTextField jTFBairro) {
        this.jTFBairro = jTFBairro;
    }

    public JButton getjBBuscarBairro() {
        return jBBuscarBairro;
    }

    public void setjBBuscarBairro(JButton jBBuscarBairro) {
        this.jBBuscarBairro = jBBuscarBairro;
    }

    public JButton getjBBuscarCidade() {
        return jBBuscarCidade;
    }

    public void setjBBuscarCidade(JButton jBBuscarCidade) {
        this.jBBuscarCidade = jBBuscarCidade;
    }

    public JLabel getjLId() {
        return jLId;
    }

    public void setjLId(JLabel jLId) {
        this.jLId = jLId;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanTitulo = new javax.swing.JPanel();
        jLTitulo = new javax.swing.JLabel();
        jLLogo = new javax.swing.JLabel();
        jPanDados = new javax.swing.JPanel();
        jTFId = new javax.swing.JTextField();
        jLId = new javax.swing.JLabel();
        jLCEP = new javax.swing.JLabel();
        jTFLogradouro = new javax.swing.JTextField();
        jLLogradouro = new javax.swing.JLabel();
        jFTFCep = new javax.swing.JFormattedTextField();
        jLCidade = new javax.swing.JLabel();
        jTFCidade = new javax.swing.JTextField();
        jCBUf = new javax.swing.JComboBox<>();
        jLUf = new javax.swing.JLabel();
        jTFBairro = new javax.swing.JTextField();
        jLBairro = new javax.swing.JLabel();
        jBBuscarBairro = new javax.swing.JButton();
        jBBuscarCidade = new javax.swing.JButton();
        jPanBotoes = new javax.swing.JPanel();
        jBNovo = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jBGravar = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanTitulo.setBackground(new java.awt.Color(0, 102, 0));
        jPanTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanTitulo.setForeground(new java.awt.Color(255, 255, 255));

        jLTitulo.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo.setText("Cadastro Endere�o");

        jLLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/IFSC_vertical_branco_fundo_transparente.png"))); // NOI18N

        javax.swing.GroupLayout jPanTituloLayout = new javax.swing.GroupLayout(jPanTitulo);
        jPanTitulo.setLayout(jPanTituloLayout);
        jPanTituloLayout.setHorizontalGroup(
            jPanTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLLogo)
                .addGap(96, 96, 96)
                .addComponent(jLTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanTituloLayout.setVerticalGroup(
            jPanTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanTituloLayout.createSequentialGroup()
                .addComponent(jLLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, -1));

        jPanDados.setBackground(new java.awt.Color(0, 102, 0));
        jPanDados.setForeground(new java.awt.Color(204, 204, 204));
        jPanDados.setEnabled(false);

        jTFId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIdActionPerformed(evt);
            }
        });

        jLId.setBackground(new java.awt.Color(0, 0, 0));
        jLId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLId.setText("ID");

        jLCEP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLCEP.setText("CEP");

        jTFLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLogradouroActionPerformed(evt);
            }
        });

        jLLogradouro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLLogradouro.setText("Logradouro");

        try {
            jFTFCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##### - ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTFCepActionPerformed(evt);
            }
        });

        jLCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLCidade.setText("Cidade");

        jTFCidade.setEnabled(false);
        jTFCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCidadeActionPerformed(evt);
            }
        });

        jCBUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SC", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SP", "SE", "TO", "\t", " " }));
        jCBUf.setSelectedIndex(-1);

        jLUf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLUf.setText("UF");

        jTFBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFBairroActionPerformed(evt);
            }
        });

        jLBairro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLBairro.setText("Bairro");

        jBBuscarBairro.setBackground(new java.awt.Color(204, 204, 204));
        jBBuscarBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jBBuscarBairro.setToolTipText("");
        jBBuscarBairro.setActionCommand("0");
        jBBuscarBairro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBBuscarBairro.setPreferredSize(new java.awt.Dimension(110, 35));
        jBBuscarBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarBairroActionPerformed(evt);
            }
        });

        jBBuscarCidade.setBackground(new java.awt.Color(204, 204, 204));
        jBBuscarCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jBBuscarCidade.setToolTipText("");
        jBBuscarCidade.setActionCommand("0");
        jBBuscarCidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBBuscarCidade.setPreferredSize(new java.awt.Dimension(110, 35));
        jBBuscarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarCidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanDadosLayout = new javax.swing.GroupLayout(jPanDados);
        jPanDados.setLayout(jPanDadosLayout);
        jPanDadosLayout.setHorizontalGroup(
            jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jBBuscarBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanDadosLayout.createSequentialGroup()
                        .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFTFCep, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLCEP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanDadosLayout.createSequentialGroup()
                                .addComponent(jLCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBBuscarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanDadosLayout.createSequentialGroup()
                                .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLUf)
                            .addComponent(jCBUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanDadosLayout.createSequentialGroup()
                        .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLId)
                            .addGroup(jPanDadosLayout.createSequentialGroup()
                                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLBairro))
                                .addGap(18, 18, 18)
                                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLLogradouro)
                                    .addComponent(jTFLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 15, Short.MAX_VALUE))))
        );
        jPanDadosLayout.setVerticalGroup(
            jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanDadosLayout.createSequentialGroup()
                        .addComponent(jLCEP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanDadosLayout.createSequentialGroup()
                        .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLUf)
                                .addComponent(jLCidade))
                            .addComponent(jBBuscarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLLogradouro)
                    .addComponent(jLBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBBuscarBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 590, 210));

        jPanBotoes.setBackground(new java.awt.Color(204, 204, 204));
        jPanBotoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBNovo.setBackground(new java.awt.Color(51, 204, 0));
        jBNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        jBNovo.setText("Novo");
        jBNovo.setActionCommand("0");
        jBNovo.setBorder(null);
        jBNovo.setPreferredSize(new java.awt.Dimension(110, 35));
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });
        jPanBotoes.add(jBNovo);

        jBBuscar.setBackground(new java.awt.Color(0, 204, 204));
        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jBBuscar.setText("Buscar");
        jBBuscar.setActionCommand("0");
        jBBuscar.setBorder(null);
        jBBuscar.setPreferredSize(new java.awt.Dimension(110, 35));
        jPanBotoes.add(jBBuscar);

        jBCancelar.setBackground(new java.awt.Color(204, 0, 0));
        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancel.png"))); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.setActionCommand("1");
        jBCancelar.setBorder(null);
        jBCancelar.setPreferredSize(new java.awt.Dimension(110, 35));
        jPanBotoes.add(jBCancelar);

        jBGravar.setBackground(new java.awt.Color(51, 204, 0));
        jBGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/OK.png"))); // NOI18N
        jBGravar.setText("Gravar");
        jBGravar.setActionCommand("1");
        jBGravar.setBorder(null);
        jBGravar.setPreferredSize(new java.awt.Dimension(110, 35));
        jPanBotoes.add(jBGravar);

        jBSair.setBackground(new java.awt.Color(204, 0, 0));
        jBSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Exit.png"))); // NOI18N
        jBSair.setText("Sair");
        jBSair.setActionCommand("0");
        jBSair.setBorder(null);
        jBSair.setPreferredSize(new java.awt.Dimension(110, 35));
        jPanBotoes.add(jBSair);

        getContentPane().add(jPanBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 590, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTFIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIdActionPerformed

    private void jFTFCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTFCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTFCepActionPerformed

    private void jTFLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFLogradouroActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jTFCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCidadeActionPerformed

    private void jTFBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFBairroActionPerformed

    private void jBBuscarBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBBuscarBairroActionPerformed

    private void jBBuscarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBBuscarCidadeActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TemplateCadastros2023.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TemplateCadastros2023.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TemplateCadastros2023.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TemplateCadastros2023.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroEndereco dialog = new TelaCadastroEndereco(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBBuscarBairro;
    private javax.swing.JButton jBBuscarCidade;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBGravar;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBSair;
    private javax.swing.JComboBox<String> jCBUf;
    private javax.swing.JFormattedTextField jFTFCep;
    private javax.swing.JLabel jLBairro;
    private javax.swing.JLabel jLCEP;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLId;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JLabel jLLogradouro;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLUf;
    private javax.swing.JPanel jPanBotoes;
    private javax.swing.JPanel jPanDados;
    private javax.swing.JPanel jPanTitulo;
    private javax.swing.JTextField jTFBairro;
    private javax.swing.JTextField jTFCidade;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFLogradouro;
    // End of variables declaration//GEN-END:variables
}