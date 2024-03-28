/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import model.bo.Funcionario;
import view.TelaBuscaEndereço;
import view.TelaBuscaFuncionario;

import view.TelaCadastroFuncionario;

/**
 *
 * @author patyx
 */
public class ControllerCadastroFuncionario implements ActionListener {

    TelaCadastroFuncionario telaCadastroFuncionario;
    public static int codigoFuncionario, codigoEndereco;

    public ControllerCadastroFuncionario(TelaCadastroFuncionario telaCadastroFuncionario) {
        this.telaCadastroFuncionario = telaCadastroFuncionario;

        this.telaCadastroFuncionario.getjBNovo().addActionListener(this);
        this.telaCadastroFuncionario.getjBBuscar().addActionListener(this);
        this.telaCadastroFuncionario.getjBCancelar().addActionListener(this);
        this.telaCadastroFuncionario.getjBSair().addActionListener(this);
        this.telaCadastroFuncionario.getjBGravar().addActionListener(this);
        this.telaCadastroFuncionario.getjBBuscarCEP().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaCadastroFuncionario.getjPanBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaCadastroFuncionario.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroFuncionario.getjBNovo()) {
            utilities.Utilities.ativaDesativa(false, this.telaCadastroFuncionario.getjPanBotoes());
            utilities.Utilities.limpaComponentes(true, this.telaCadastroFuncionario.getjPanDados());
            this.telaCadastroFuncionario.getjTFId().setEnabled(false);
            this.telaCadastroFuncionario.getjTFMostraSenha().setEnabled(false);
            this.telaCadastroFuncionario.getjTFCidade().setEnabled(false);
            this.telaCadastroFuncionario.getjTFBairro().setEnabled(false);
            this.telaCadastroFuncionario.getjFTFCep().setEnabled(false);
            this.telaCadastroFuncionario.getjTFLogradouro().setEnabled(false);
            this.telaCadastroFuncionario.getjCBUf().setEnabled(false);
            this.telaCadastroFuncionario.getjFTFDataNascimento().setEnabled(false);

        } else if (e.getSource() == this.telaCadastroFuncionario.getjBBuscarCEP()) {
            TelaBuscaEndereço telaBuscaEndereço = new TelaBuscaEndereço(null, true);
            ControllerBuscarEndereco controllerBuscarEndereco = new ControllerBuscarEndereco(telaBuscaEndereço);
            telaBuscaEndereço.setVisible(true);

            if (codigoEndereco != 0) {
                Endereco endereco = new Endereco();
                endereco = service.EnderecoService.carregar(codigoEndereco);
                utilities.Utilities.ativaDesativa(false, this.telaCadastroFuncionario.getjPanBotoes());

                this.telaCadastroFuncionario.getjFTFCep().setText(endereco.getCep());
                this.telaCadastroFuncionario.getjTFCidade().setText(endereco.getCidade().toString());
                this.telaCadastroFuncionario.getjTFLogradouro().setText(endereco.getLogradouro());
                this.telaCadastroFuncionario.getjCBUf().setSelectedItem(endereco.getCidade().getUf());
                this.telaCadastroFuncionario.getjTFBairro().setText(endereco.getBairro().toString());
                this.telaCadastroFuncionario.getjTFId().setEnabled(false);
            }
        } else if (e.getSource() == this.telaCadastroFuncionario.getjBCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.telaCadastroFuncionario.getjPanBotoes());
            utilities.Utilities.limpaComponentes(false, this.telaCadastroFuncionario.getjPanDados());

        } else if (e.getSource() == this.telaCadastroFuncionario.getjBGravar()) {

            Funcionario funcionario = new Funcionario();

            int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja gravar este funcionário?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {

                funcionario.setCpf(this.telaCadastroFuncionario.getjFTFCpf().getText());
                funcionario.setNome(this.telaCadastroFuncionario.getjTFNome().getText());
                funcionario.setDataNascimento(this.telaCadastroFuncionario.getjFTFDataNascimento().getText());
                funcionario.setRg(this.telaCadastroFuncionario.getjTFRG().getText());
                funcionario.setStatus(this.telaCadastroFuncionario.getjCBStatus().getSelectedItem().toString().charAt(0));
                funcionario.setEmail(this.telaCadastroFuncionario.getjTFEmail().getText());
                funcionario.setFone1(this.telaCadastroFuncionario.getjFTFTelefone().getText());
                funcionario.setFone2(this.telaCadastroFuncionario.getjFTFTelefone1().getText());
                funcionario.setUsuario(this.telaCadastroFuncionario.getjTFUsuario().getText());
                funcionario.setSenha(this.telaCadastroFuncionario.getjPFSenha().getText());
                funcionario.setComplementoEndereco(this.telaCadastroFuncionario.getjTFComplementoEndereco().getText());

                funcionario.setEndereco(service.EnderecoService.carregar(codigoEndereco));

                utilities.Utilities.ativaDesativa(true, this.telaCadastroFuncionario.getjPanBotoes());
                utilities.Utilities.limpaComponentes(false, this.telaCadastroFuncionario.getjPanDados());
                telaCadastroFuncionario.getjTFMostraSenha().setText("");
                if (this.telaCadastroFuncionario.getjTFId().getText().equalsIgnoreCase("")) {
                   
                    service.FuncionarioService.adicionar(funcionario);
                    
                    utilities.Utilities.ativaDesativa(true, this.telaCadastroFuncionario.getjPanBotoes());
                    utilities.Utilities.limpaComponentes(false, this.telaCadastroFuncionario.getjPanDados());

                } else {
                    funcionario.setId(codigoFuncionario);
                    service.FuncionarioService.atualizar(funcionario);
                }
                
            } else if (opcao == JOptionPane.NO_OPTION) {
                utilities.Utilities.ativaDesativa(false, this.telaCadastroFuncionario.getjPanBotoes());
            }
        } else if (e.getSource() == this.telaCadastroFuncionario.getjBBuscar()) {
            TelaBuscaFuncionario telaBuscaFuncionario = new TelaBuscaFuncionario(null, true);
            ControllerBuscarFuncionario controllerBuscarFuncionario = new ControllerBuscarFuncionario(telaBuscaFuncionario);
            telaBuscaFuncionario.setVisible(true);
            Funcionario funcionario = new Funcionario();

            if (codigoFuncionario != 0) {
                funcionario = service.FuncionarioService.carregar(codigoFuncionario);
                utilities.Utilities.ativaDesativa(false, this.telaCadastroFuncionario.getjPanBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaCadastroFuncionario.getjPanDados());

                this.telaCadastroFuncionario.getjTFId().setText(funcionario.getId() + "");
                this.telaCadastroFuncionario.getjFTFCpf().setText(funcionario.getCpf());
                this.telaCadastroFuncionario.getjTFNome().setText(funcionario.getNome());
                this.telaCadastroFuncionario.getjTFEmail().setText(funcionario.getEmail());
                this.telaCadastroFuncionario.getjFTFTelefone().setText(funcionario.getFone1());
                this.telaCadastroFuncionario.getjFTFTelefone1().setText(funcionario.getFone2());
                this.telaCadastroFuncionario.getjCBStatus().setSelectedItem(funcionario.getStatus());
                this.telaCadastroFuncionario.getjTFComplementoEndereco().setText(funcionario.getComplementoEndereco());
                this.telaCadastroFuncionario.getjFTFCep().setText(funcionario.getEndereco().getCep());
                this.telaCadastroFuncionario.getjTFCidade().setText(funcionario.getEndereco().getCidade().getDescricao());
                this.telaCadastroFuncionario.getjCBUf().setSelectedItem(funcionario.getEndereco().getCidade().getUf());
                this.telaCadastroFuncionario.getjTFLogradouro().setText(funcionario.getEndereco().getLogradouro());
                this.telaCadastroFuncionario.getjTFBairro().setText(funcionario.getEndereco().getBairro().getDescricao());
                this.telaCadastroFuncionario.getjTFId().setEnabled(false);
            }
        } else if (e.getSource() == this.telaCadastroFuncionario.getjBSair()) {
            this.telaCadastroFuncionario.dispose();

        }
    }
}
