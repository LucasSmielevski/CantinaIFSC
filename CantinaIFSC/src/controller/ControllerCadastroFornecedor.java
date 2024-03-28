/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import model.bo.Fornecedor;
import view.TelaBuscaFornecedor;
import view.TelaCadastroFornecedor;
import view.TelaBuscaEndereço;

/**
 *
 * @author patyx
 */
public class ControllerCadastroFornecedor implements ActionListener {

    TelaCadastroFornecedor telaCadastroFornecedor;
    public static int codigoFornecedor, codigoEndereco;

    public ControllerCadastroFornecedor(TelaCadastroFornecedor telaCadastroFornecedor) {
        this.telaCadastroFornecedor = telaCadastroFornecedor;

        this.telaCadastroFornecedor.getjBNovo().addActionListener(this);
        this.telaCadastroFornecedor.getjBBuscar().addActionListener(this);
        this.telaCadastroFornecedor.getjBCancelar().addActionListener(this);
        this.telaCadastroFornecedor.getjBSair().addActionListener(this);
        this.telaCadastroFornecedor.getjBGravar().addActionListener(this);
        this.telaCadastroFornecedor.getjBBuscarCep().addActionListener(this);

        List<Endereco> listaEndereco = new ArrayList<Endereco>();
        listaEndereco = service.EnderecoService.carregar();

        for (Endereco enderecoAtual : listaEndereco) {
            this.telaCadastroFornecedor.getjTFBairro().setText(enderecoAtual.getBairro().getDescricao());
            this.telaCadastroFornecedor.getjTFCidade().setText(enderecoAtual.getCidade().getDescricao());
            this.telaCadastroFornecedor.getjFTFCep().setText(enderecoAtual.getCep());
        }

        utilities.Utilities.ativaDesativa(true, this.telaCadastroFornecedor.getjPanBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaCadastroFornecedor.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroFornecedor.getjBBuscarCep()) {
            TelaBuscaEndereço telaBuscaEndereço = new TelaBuscaEndereço(null, true);
            ControllerBuscarEndereco controllerBuscarEndereco = new ControllerBuscarEndereco(telaBuscaEndereço);
            telaBuscaEndereço.setVisible(true);

            if (codigoEndereco != 0) {
                Endereco endereco = new Endereco();
                endereco = service.EnderecoService.carregar(codigoEndereco);
                utilities.Utilities.ativaDesativa(false, this.telaCadastroFornecedor.getjPanBotoes());

                this.telaCadastroFornecedor.getjFTFCep().setText(endereco.getCep());
                this.telaCadastroFornecedor.getjTFCidade().setText(endereco.getCidade().toString());
                this.telaCadastroFornecedor.getjTFLogradouro().setText(endereco.getLogradouro());
                this.telaCadastroFornecedor.getjCBUf().setSelectedItem(endereco.getCidade().getUf());
                this.telaCadastroFornecedor.getjTFBairro().setText(endereco.getBairro().toString());
                this.telaCadastroFornecedor.getjTFId().setEnabled(false);
            }
        } else if (e.getSource() == this.telaCadastroFornecedor.getjBNovo()) {
            utilities.Utilities.ativaDesativa(false, this.telaCadastroFornecedor.getjPanBotoes());
            utilities.Utilities.limpaComponentes(true, this.telaCadastroFornecedor.getjPanDados());
            this.telaCadastroFornecedor.getjTFId().setEnabled(false);
            this.telaCadastroFornecedor.getjTFCidade().setEnabled(false);
            this.telaCadastroFornecedor.getjTFBairro().setEnabled(false);
            this.telaCadastroFornecedor.getjFTFCep().setEnabled(false);
            this.telaCadastroFornecedor.getjTFLogradouro().setEnabled(false);
            this.telaCadastroFornecedor.getjCBUf().setEnabled(false);

        } else if (e.getSource() == this.telaCadastroFornecedor.getjBCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.telaCadastroFornecedor.getjPanBotoes());
            utilities.Utilities.limpaComponentes(false, this.telaCadastroFornecedor.getjPanDados());

        } else if (e.getSource() == this.telaCadastroFornecedor.getjBGravar()) {
            Fornecedor fornecedor = new Fornecedor();
            Endereco endereco = new Endereco();

            int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja gravar este fornecedor?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {

                fornecedor.setCnpj(this.telaCadastroFornecedor.getjFTFCnpj().getText());
                fornecedor.setRazaoSocial(this.telaCadastroFornecedor.getjTFRazaoSocial().getText());
                fornecedor.setEmail(this.telaCadastroFornecedor.getjTFEmail().getText());
                fornecedor.setNome(this.telaCadastroFornecedor.getjTFNome().getText());
                fornecedor.setInscricaoEstadual(this.telaCadastroFornecedor.getjTFInscrSocial().getText());
                //fornecedor.setStatus(this.telaCadastroFornecedor.getjCBStatus().getSelectedItem().toString().charAt(0));
                fornecedor.setFone1(this.telaCadastroFornecedor.getjFTFTelefone().getText());
                fornecedor.setFone2(this.telaCadastroFornecedor.getjFTFTelefone2().getText());
                fornecedor.setComplementoEndereco(this.telaCadastroFornecedor.getjTFComplemento().getText());

                fornecedor.setEndereco(service.EnderecoService.carregar(codigoEndereco));

                utilities.Utilities.ativaDesativa(true, this.telaCadastroFornecedor.getjPanBotoes());
                utilities.Utilities.limpaComponentes(false, this.telaCadastroFornecedor.getjPanDados());

                if (this.telaCadastroFornecedor.getjTFId().getText().equalsIgnoreCase("")) {

                    service.FornecedorService.adicionar(fornecedor);
                    utilities.Utilities.ativaDesativa(true, this.telaCadastroFornecedor.getjPanBotoes());
                    utilities.Utilities.limpaComponentes(false, this.telaCadastroFornecedor.getjPanDados());

                } else {
                    fornecedor.setEndereco(service.EnderecoService.carregar(codigoEndereco));

                    fornecedor.setId(codigoFornecedor);
                    service.FornecedorService.atualizar(fornecedor);

                    utilities.Utilities.ativaDesativa(true, this.telaCadastroFornecedor.getjPanBotoes());
                    utilities.Utilities.limpaComponentes(false, this.telaCadastroFornecedor.getjPanDados());

                }
            } else if (opcao == JOptionPane.NO_OPTION) {
            }

        } else if (e.getSource() == this.telaCadastroFornecedor.getjBBuscar()) {
            codigoFornecedor = 0;
            TelaBuscaFornecedor telaBuscaFornecedor = new TelaBuscaFornecedor(null, true);
            ControllerBuscarFornecedor controllerBuscarFornecedor = new ControllerBuscarFornecedor(telaBuscaFornecedor);
            telaBuscaFornecedor.setVisible(true);

            if (codigoFornecedor != 0) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor = service.FornecedorService.carregar(codigoFornecedor);
                System.out.println(codigoFornecedor);

                utilities.Utilities.ativaDesativa(false, this.telaCadastroFornecedor.getjPanBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaCadastroFornecedor.getjPanDados());

                this.telaCadastroFornecedor.getjTFId().setText(fornecedor.getId() + "");
                this.telaCadastroFornecedor.getjFTFCnpj().setText(fornecedor.getCnpj());
                this.telaCadastroFornecedor.getjTFRazaoSocial().setText(fornecedor.getRazaoSocial());
                this.telaCadastroFornecedor.getjTFEmail().setText(fornecedor.getEmail());
                this.telaCadastroFornecedor.getjTFNome().setText(fornecedor.getNome());
                this.telaCadastroFornecedor.getjTFInscrSocial().setText(fornecedor.getInscricaoEstadual());
                this.telaCadastroFornecedor.getjCBStatus().setSelectedItem(fornecedor.getStatus());
                this.telaCadastroFornecedor.getjFTFTelefone().setText(fornecedor.getFone1());
                this.telaCadastroFornecedor.getjFTFTelefone2().setText(fornecedor.getFone2());
                this.telaCadastroFornecedor.getjTFComplemento().setText(fornecedor.getComplementoEndereco());

                this.telaCadastroFornecedor.getjFTFCep().setText(fornecedor.getEndereco().getCep());
                this.telaCadastroFornecedor.getjTFCidade().setText(fornecedor.getEndereco().getCidade().getDescricao());
                this.telaCadastroFornecedor.getjCBUf().setSelectedItem(fornecedor.getEndereco().getCidade().getUf());
                this.telaCadastroFornecedor.getjTFLogradouro().setText(fornecedor.getEndereco().getLogradouro());
                this.telaCadastroFornecedor.getjTFBairro().setText(fornecedor.getEndereco().getBairro().getDescricao());
                this.telaCadastroFornecedor.getjTFId().setEnabled(false);
                this.telaCadastroFornecedor.getjTFCidade().setEnabled(false);
                this.telaCadastroFornecedor.getjTFBairro().setEnabled(false);
                this.telaCadastroFornecedor.getjFTFCep().setEnabled(false);
                this.telaCadastroFornecedor.getjTFLogradouro().setEnabled(false);
                this.telaCadastroFornecedor.getjCBUf().setEnabled(false);
            }
        } else if (e.getSource()
                == this.telaCadastroFornecedor.getjBSair()) {
            this.telaCadastroFornecedor.dispose();
        }
    }
}
