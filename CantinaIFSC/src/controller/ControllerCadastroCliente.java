/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Cliente;
import model.bo.Endereco;
import view.TelaBuscaCliente;
import view.TelaBuscaEndereço;
import view.TelaCadastroCliente;
import controller.ControllerBuscarEndereco;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import model.bo.Cidade;

/**
 *
 * @author patyx
 */
public class ControllerCadastroCliente implements ActionListener {

    TelaBuscaEndereço telaBuscaEndereço;
    TelaCadastroCliente telaCadastroCliente;
    public static int codigoCliente, codigoEndereco;

    public ControllerCadastroCliente(TelaCadastroCliente telaCadastroCliente) {
        this.telaCadastroCliente = telaCadastroCliente;

        this.telaCadastroCliente.getjBNovo().addActionListener(this);
        this.telaCadastroCliente.getjBBuscar().addActionListener(this);
        this.telaCadastroCliente.getjBCancelar().addActionListener(this);
        this.telaCadastroCliente.getjBSair().addActionListener(this);
        this.telaCadastroCliente.getjBGravar().addActionListener(this);
        this.telaCadastroCliente.getjBBuscarCEP().addActionListener(this);

        List<Endereco> listaEndereco = new ArrayList<Endereco>();
        listaEndereco = service.EnderecoService.carregar();

        this.telaCadastroCliente.getjTFBairro().removeAll();
        this.telaCadastroCliente.getjTFCidade().removeAll();
        this.telaCadastroCliente.getjFTFCep().removeAll();

        for (Endereco enderecoAtual : listaEndereco) {
            this.telaCadastroCliente.getjTFBairro().setText(enderecoAtual.getBairro().getDescricao());
            this.telaCadastroCliente.getjTFCidade().setText(enderecoAtual.getCidade().getDescricao());
            this.telaCadastroCliente.getjFTFCep().setText(enderecoAtual.getCep());
        }

        utilities.Utilities.ativaDesativa(true, this.telaCadastroCliente.getjPanBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaCadastroCliente.getjPanDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroCliente.getjBBuscarCEP()) {
            TelaBuscaEndereço telaBuscaEndereço = new TelaBuscaEndereço(null, true);
            ControllerBuscarEndereco controllerBuscarEndereco = new ControllerBuscarEndereco(telaBuscaEndereço);
            telaBuscaEndereço.setVisible(true);

            if (codigoEndereco != 0) {
                Endereco endereco = new Endereco();
                endereco = service.EnderecoService.carregar(codigoEndereco);
                utilities.Utilities.ativaDesativa(false, this.telaCadastroCliente.getjPanBotoes());

                this.telaCadastroCliente.getjFTFCep().setText(endereco.getCep());
                this.telaCadastroCliente.getjTFCidade().setText(endereco.getCidade().getDescricao());
                this.telaCadastroCliente.getjTFLogradouro().setText(endereco.getLogradouro());
                this.telaCadastroCliente.getjCBUf().setSelectedItem(endereco.getCidade().getUf());
                this.telaCadastroCliente.getjTFBairro().setText(endereco.getBairro().getDescricao());
                this.telaCadastroCliente.getjTFId().setEnabled(false);

            }
        } else if (e.getSource() == this.telaCadastroCliente.getjBNovo()) {
            utilities.Utilities.ativaDesativa(false, this.telaCadastroCliente.getjPanBotoes());
            utilities.Utilities.limpaComponentes(true, this.telaCadastroCliente.getjPanDados());
            this.telaCadastroCliente.getjTFId().setEnabled(false);
            this.telaCadastroCliente.getjTFCidade().setEnabled(false);
            this.telaCadastroCliente.getjTFBairro().setEnabled(false);
            this.telaCadastroCliente.getjFTFCep().setEnabled(false);
            this.telaCadastroCliente.getjTFLogradouro().setEnabled(false);
            this.telaCadastroCliente.getjCBUf().setEnabled(false);

        } else if (e.getSource() == this.telaCadastroCliente.getjBCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.telaCadastroCliente.getjPanBotoes());
            utilities.Utilities.limpaComponentes(false, this.telaCadastroCliente.getjPanDados());

        } else if (e.getSource() == this.telaCadastroCliente.getjBGravar()) {
            Cliente cliente = new Cliente();

            int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja gravar este Cliente?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                cliente.setNome(this.telaCadastroCliente.getjTFNome().getText());
                cliente.setCpf(this.telaCadastroCliente.getjFTFCpf().getText());
                cliente.setDataNascimento(this.telaCadastroCliente.getjFTFDataNascimento().getText());
                cliente.setRg(this.telaCadastroCliente.getjTFRG().getText());
                cliente.setMatricula(this.telaCadastroCliente.getjFTFMatricula().getText());
                cliente.setFone1(this.telaCadastroCliente.getjFTFTelefone().getText());
                cliente.setEmail(this.telaCadastroCliente.getjTFEmail().getText());
                cliente.setCpf(this.telaCadastroCliente.getjFTFCpf().getText());
                cliente.setComplementoEndereco(this.telaCadastroCliente.getjTFComplementoEndereco().getText());
                cliente.setStatus('A');

                cliente.setEndereco(service.EnderecoService.carregar(codigoEndereco));
                if (cliente.getNome().isEmpty() || cliente.getRg().isEmpty() || cliente.getEmail().isEmpty()
                        || cliente.getCpf().isEmpty() || cliente.getFone1().isEmpty() || cliente.getDataNascimento().isEmpty()
                        || cliente.getMatricula().isEmpty()) {
                    JOptionPane.showMessageDialog(this.telaCadastroCliente, "Todos os campos devem ser preenchidos", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (this.telaCadastroCliente.getjTFId().getText().equalsIgnoreCase("")) {

                    service.ClienteService.adicionar(cliente);
                    utilities.Utilities.ativaDesativa(true, this.telaCadastroCliente.getjPanBotoes());
                    utilities.Utilities.limpaComponentes(false, this.telaCadastroCliente.getjPanDados());

                } else {

                    cliente.setId(codigoCliente);
                    service.ClienteService.atualizar(cliente);
                    utilities.Utilities.ativaDesativa(true, this.telaCadastroCliente.getjPanBotoes());
                    utilities.Utilities.limpaComponentes(false, this.telaCadastroCliente.getjPanDados());

                }
            } else if (opcao == JOptionPane.NO_OPTION) {
            }

        } else if (e.getSource() == this.telaCadastroCliente.getjBBuscar()) {
            codigoCliente = 0;
            TelaBuscaCliente telaBuscaCliente = new TelaBuscaCliente(null, true);
            ControllerBuscarCliente controllerBuscarCliente = new ControllerBuscarCliente(telaBuscaCliente);
            telaBuscaCliente.setVisible(true);

            if (codigoCliente != 0) {
                Cliente cliente = new Cliente();
                cliente = service.ClienteService.carregar(codigoCliente);

                utilities.Utilities.ativaDesativa(false, this.telaCadastroCliente.getjPanBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaCadastroCliente.getjPanDados());

                this.telaCadastroCliente.getjTFId().setText(cliente.getId() + "");
                this.telaCadastroCliente.getjFTFCpf().setText(cliente.getCpf());
                this.telaCadastroCliente.getjTFRG().setText(cliente.getRg());
                this.telaCadastroCliente.getjTFNome().setText(cliente.getNome());
                this.telaCadastroCliente.getjFTFDataNascimento().setText(cliente.getDataNascimento());
                this.telaCadastroCliente.getjFTFMatricula().setText(cliente.getMatricula());
                this.telaCadastroCliente.getjTFEmail().setText(cliente.getEmail());
                this.telaCadastroCliente.getjFTFTelefone().setText(cliente.getFone1());
                this.telaCadastroCliente.getjFTFTelefone1().setText(cliente.getFone2());

                this.telaCadastroCliente.getjFTFCep().setText(cliente.getEndereco().getCep());
                this.telaCadastroCliente.getjTFCidade().setText(cliente.getEndereco().getCidade().getDescricao());
                this.telaCadastroCliente.getjCBUf().setSelectedItem(cliente.getEndereco().getCidade().getUf());
                this.telaCadastroCliente.getjTFLogradouro().setText(cliente.getEndereco().getLogradouro());
                this.telaCadastroCliente.getjTFBairro().setText(cliente.getEndereco().getBairro().getDescricao());
                this.telaCadastroCliente.getjTFComplementoEndereco().setText(cliente.getComplementoEndereco());
                this.telaCadastroCliente.getjTFId().setEnabled(false);
                this.telaCadastroCliente.getjTFCidade().setEnabled(false);
                this.telaCadastroCliente.getjTFBairro().setEnabled(false);
                this.telaCadastroCliente.getjFTFCep().setEnabled(false);
                this.telaCadastroCliente.getjTFLogradouro().setEnabled(false);
                this.telaCadastroCliente.getjCBUf().setEnabled(false);

            }
        } else if (e.getSource()
                == this.telaCadastroCliente.getjBSair()) {
            this.telaCadastroCliente.dispose();
        }

    }
}
