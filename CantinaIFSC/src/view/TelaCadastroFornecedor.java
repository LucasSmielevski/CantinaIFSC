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
public class TelaCadastroFornecedor extends javax.swing.JDialog {

    /**
     * Creates new form TemplateCadastros2023
     */
    public TelaCadastroFornecedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        utilities.Utilities.ativaDesativa(true, jPanBotoes);
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

    public JButton getjBBuscarCep() {
        return jBBuscarCep;
    }

    public void setjBBuscarCep(JButton jBBuscarCep) {
        this.jBBuscarCep = jBBuscarCep;
    }

    public JComboBox<String> getjCBStatus() {
        return jCBStatus;
    }

    public void setjCBStatus(JComboBox<String> jCBStatus) {
        this.jCBStatus = jCBStatus;
    }

    public JFormattedTextField getjFTFCep() {
        return jFTFCep;
    }

    public void setjFTFCep(JFormattedTextField jFTFCep) {
        this.jFTFCep = jFTFCep;
    }

    public JFormattedTextField getjFTFCnpj() {
        return jFTFCnpj;
    }

    public void setjFTFCnpj(JFormattedTextField jFTFCnpj) {
        this.jFTFCnpj = jFTFCnpj;
    }

    public JFormattedTextField getjFTFTelefone() {
        return jFTFTelefone;
    }

    public void setjFTFTelefone(JFormattedTextField jFTFTelefone) {
        this.jFTFTelefone = jFTFTelefone;
    }

    public JFormattedTextField getjFTFTelefone2() {
        return jFTFTelefone2;
    }

    public void setjFTFTelefone2(JFormattedTextField jFTFTelefone2) {
        this.jFTFTelefone2 = jFTFTelefone2;
    }

    public JTextField getjTFCidade() {
        return jTFCidade;
    }

    public void setjTFCidade(JTextField jTFCidade) {
        this.jTFCidade = jTFCidade;
    }

    public JTextField getjTFComplemento() {
        return jTFComplemento;
    }

    public void setjTFComplemento(JTextField jTFComplemento) {
        this.jTFComplemento = jTFComplemento;
    }

    public JTextField getjTFEmail() {
        return jTFEmail;
    }

    public void setjTFEmail(JTextField jTFEmail) {
        this.jTFEmail = jTFEmail;
    }

    public JTextField getjTFInscrSocial() {
        return jTFInscrSocial;
    }

    public void setjTFInscrSocial(JTextField jTFInscrSocial) {
        this.jTFInscrSocial = jTFInscrSocial;
    }

    public JTextField getjTFLogradouro() {
        return jTFLogradouro;
    }

    public void setjTFLogradouro(JTextField jTFLogradouro) {
        this.jTFLogradouro = jTFLogradouro;
    }

    public JTextField getjTFNome() {
        return jTFNome;
    }

    public void setjTFNome(JTextField jTFNome) {
        this.jTFNome = jTFNome;
    }

    public JTextField getjTFRazaoSocial() {
        return jTFRazaoSocial;
    }

    public void setjTFRazaoSocial(JTextField jTFRazaoSocial) {
        this.jTFRazaoSocial = jTFRazaoSocial;
    }

    public JComboBox<String> getjCBUf() {
        return jCBUf;
    }

    public void setjCBUf(JComboBox<String> jCBUf) {
        this.jCBUf = jCBUf;
    }

    public JTextField getjTFBairro() {
        return jTFBairro;
    }

    public void setjTFBairro(JTextField jTFBairro) {
        this.jTFBairro = jTFBairro;
    }

    public JTextField getjTFId() {
        return jTFId;
    }

    public void setjTFId(JTextField jTFId) {
        this.jTFId = jTFId;
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
        jTFRazaoSocial = new javax.swing.JTextField();
        jTFInscrSocial = new javax.swing.JTextField();
        jLCpf = new javax.swing.JLabel();
        jLRg = new javax.swing.JLabel();
        jLMatricula = new javax.swing.JLabel();
        jLDataNascimento = new javax.swing.JLabel();
        jFTFCnpj = new javax.swing.JFormattedTextField();
        jTFNome = new javax.swing.JTextField();
        jLNome = new javax.swing.JLabel();
        Telefone = new javax.swing.JLabel();
        jFTFTelefone = new javax.swing.JFormattedTextField();
        jTFEmail = new javax.swing.JTextField();
        jTFLogradouro = new javax.swing.JTextField();
        jFTFCep = new javax.swing.JFormattedTextField();
        jLLogradouro = new javax.swing.JLabel();
        jLCep = new javax.swing.JLabel();
        jTFCidade = new javax.swing.JTextField();
        jLCidade = new javax.swing.JLabel();
        jTFComplemento = new javax.swing.JTextField();
        jLComplemento = new javax.swing.JLabel();
        jFTFTelefone2 = new javax.swing.JFormattedTextField();
        Telefone1 = new javax.swing.JLabel();
        jCBStatus = new javax.swing.JComboBox<>();
        jLStatus = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBBuscarCep = new javax.swing.JButton();
        jCBUf = new javax.swing.JComboBox<>();
        jLUf = new javax.swing.JLabel();
        jTFBairro = new javax.swing.JTextField();
        jLBairro = new javax.swing.JLabel();
        jTFId = new javax.swing.JTextField();
        jLId = new javax.swing.JLabel();
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
        jLTitulo.setText("Cadastro Fornecedor");

        jLLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/IFSC_vertical_branco_fundo_transparente.png"))); // NOI18N

        javax.swing.GroupLayout jPanTituloLayout = new javax.swing.GroupLayout(jPanTitulo);
        jPanTitulo.setLayout(jPanTituloLayout);
        jPanTituloLayout.setHorizontalGroup(
            jPanTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanTituloLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLLogo)
                .addGap(94, 94, 94)
                .addComponent(jLTitulo)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanTituloLayout.setVerticalGroup(
            jPanTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanTituloLayout.createSequentialGroup()
                .addComponent(jLLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 640, -1));

        jPanDados.setBackground(new java.awt.Color(0, 102, 0));
        jPanDados.setForeground(new java.awt.Color(204, 204, 204));
        jPanDados.setEnabled(false);

        jLCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLCpf.setText("Cnpj");

        jLRg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLRg.setText("Raz�o Social");

        jLMatricula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLMatricula.setText("Inscri��o Estadual");

        jLDataNascimento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLDataNascimento.setText("Email");

        try {
            jFTFCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTFCnpjActionPerformed(evt);
            }
        });

        jTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNomeActionPerformed(evt);
            }
        });

        jLNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLNome.setText("Nome");

        Telefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Telefone.setText("Fone1");

        try {
            jFTFTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailActionPerformed(evt);
            }
        });

        jTFLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLogradouroActionPerformed(evt);
            }
        });

        try {
            jFTFCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##### - ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLLogradouro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLLogradouro.setText("Logradouro");

        jLCep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLCep.setText("CEP");

        jLCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLCidade.setText("Cidade");

        jTFComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFComplementoActionPerformed(evt);
            }
        });

        jLComplemento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLComplemento.setText("Complemento");

        try {
            jFTFTelefone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        Telefone1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Telefone1.setText("Fone2");

        jCBStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));
        jCBStatus.setSelectedIndex(-1);
        jCBStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBStatusActionPerformed(evt);
            }
        });

        jLStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLStatus.setText("Status");

        jPanel1.setPreferredSize(new java.awt.Dimension(603, 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jBBuscarCep.setText("Buscar");

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

        jLId.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLId.setText("ID");

        javax.swing.GroupLayout jPanDadosLayout = new javax.swing.GroupLayout(jPanDados);
        jPanDados.setLayout(jPanDadosLayout);
        jPanDadosLayout.setHorizontalGroup(
            jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
            .addGroup(jPanDadosLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanDadosLayout.createSequentialGroup()
                        .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanDadosLayout.createSequentialGroup()
                                .addComponent(jFTFCep, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBBuscarCep))
                            .addComponent(jLCep)
                            .addComponent(jLBairro)
                            .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanDadosLayout.createSequentialGroup()
                                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanDadosLayout.createSequentialGroup()
                                        .addComponent(jLCidade)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTFCidade))
                                .addGap(18, 18, 18)
                                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLUf)
                                    .addComponent(jCBUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30))
                            .addGroup(jPanDadosLayout.createSequentialGroup()
                                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLLogradouro)
                                    .addComponent(jTFLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(84, 84, 84))))
                    .addGroup(jPanDadosLayout.createSequentialGroup()
                        .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLComplemento)
                            .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 42, Short.MAX_VALUE))))
            .addGroup(jPanDadosLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanDadosLayout.createSequentialGroup()
                        .addComponent(jLId)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanDadosLayout.createSequentialGroup()
                        .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanDadosLayout.createSequentialGroup()
                        .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLCpf)
                            .addComponent(jLMatricula)
                            .addComponent(jFTFCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLDataNascimento)
                            .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Telefone)
                            .addComponent(jFTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFInscrSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLRg)
                            .addComponent(jLNome)
                            .addComponent(jLStatus)
                            .addComponent(Telefone1)
                            .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFRazaoSocial, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(jTFNome)
                            .addComponent(jFTFTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))))
        );
        jPanDadosLayout.setVerticalGroup(
            jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRg)
                    .addComponent(jLCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTFCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNome)
                    .addComponent(jLDataNascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLMatricula)
                    .addComponent(jLStatus))
                .addGap(14, 14, 14)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFInscrSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Telefone)
                    .addComponent(Telefone1))
                .addGap(2, 2, 2)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCep)
                    .addComponent(jLCidade)
                    .addComponent(jLUf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTFCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscarCep)
                    .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanDadosLayout.createSequentialGroup()
                        .addComponent(jLBairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanDadosLayout.createSequentialGroup()
                        .addComponent(jLLogradouro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLComplemento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 60, 620, 540));

        jPanBotoes.setBackground(new java.awt.Color(255, 255, 255));
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
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });
        jPanBotoes.add(jBCancelar);

        jBGravar.setBackground(new java.awt.Color(51, 204, 0));
        jBGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/OK.png"))); // NOI18N
        jBGravar.setText("Gravar");
        jBGravar.setActionCommand("1");
        jBGravar.setBorder(null);
        jBGravar.setPreferredSize(new java.awt.Dimension(110, 35));
        jBGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGravarActionPerformed(evt);
            }
        });
        jPanBotoes.add(jBGravar);

        jBSair.setBackground(new java.awt.Color(204, 0, 0));
        jBSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Exit.png"))); // NOI18N
        jBSair.setText("Sair");
        jBSair.setActionCommand("0");
        jBSair.setBorder(null);
        jBSair.setPreferredSize(new java.awt.Dimension(110, 35));
        jPanBotoes.add(jBSair);

        getContentPane().add(jPanBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 620, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNomeActionPerformed

    private void jBGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGravarActionPerformed
    }//GEN-LAST:event_jBGravarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jTFEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEmailActionPerformed

    private void jTFLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFLogradouroActionPerformed

    private void jTFComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFComplementoActionPerformed

    private void jFTFCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTFCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTFCnpjActionPerformed

    private void jCBStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBStatusActionPerformed

    private void jTFBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFBairroActionPerformed

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
                TelaCadastroFornecedor dialog = new TelaCadastroFornecedor(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel Telefone;
    private javax.swing.JLabel Telefone1;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBBuscarCep;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBGravar;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBSair;
    private javax.swing.JComboBox<String> jCBStatus;
    private javax.swing.JComboBox<String> jCBUf;
    private javax.swing.JFormattedTextField jFTFCep;
    private javax.swing.JFormattedTextField jFTFCnpj;
    private javax.swing.JFormattedTextField jFTFTelefone;
    private javax.swing.JFormattedTextField jFTFTelefone2;
    private javax.swing.JLabel jLBairro;
    private javax.swing.JLabel jLCep;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLComplemento;
    private javax.swing.JLabel jLCpf;
    private javax.swing.JLabel jLDataNascimento;
    private javax.swing.JLabel jLId;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JLabel jLLogradouro;
    private javax.swing.JLabel jLMatricula;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLRg;
    private javax.swing.JLabel jLStatus;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLUf;
    private javax.swing.JPanel jPanBotoes;
    private javax.swing.JPanel jPanDados;
    private javax.swing.JPanel jPanTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFBairro;
    private javax.swing.JTextField jTFCidade;
    private javax.swing.JTextField jTFComplemento;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFInscrSocial;
    private javax.swing.JTextField jTFLogradouro;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFRazaoSocial;
    // End of variables declaration//GEN-END:variables
}
