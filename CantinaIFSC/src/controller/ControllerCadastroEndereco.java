/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ControllerCadastroBairro.codigo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import model.bo.Produto;
import view.TelaBuscaBairro;
import view.TelaBuscaCidade;
import view.TelaBuscaEndereço;
import view.TelaCadastroEndereco;
import view.TelaBuscaEndereço;
import service.ProdutoService;
import view.TelaBuscaProduto;

/**
 *
 * @author patyx
 */
public class ControllerCadastroEndereco implements ActionListener {

    TelaCadastroEndereco telaCadastroEndereco;
    public static int codigoCidade, codigoBairro, codigoEndereco, codigo;

    public ControllerCadastroEndereco(TelaCadastroEndereco telaCadastroEndereco) {
        this.telaCadastroEndereco = telaCadastroEndereco;

        this.telaCadastroEndereco.getjBNovo().addActionListener(this);
        this.telaCadastroEndereco.getjBBuscar().addActionListener(this);
        this.telaCadastroEndereco.getjBCancelar().addActionListener(this);
        this.telaCadastroEndereco.getjBSair().addActionListener(this);
        this.telaCadastroEndereco.getjBGravar().addActionListener(this);
        this.telaCadastroEndereco.getjBBuscarBairro().addActionListener(this);
        this.telaCadastroEndereco.getjBBuscarCidade().addActionListener(this);

        List<Cidade> listaCidades = new ArrayList<Cidade>();
        List<Bairro> listaBairros = new ArrayList<Bairro>();

        listaCidades = service.CidadeService.carregar();
        listaBairros = service.BairroService.carregar();

        this.telaCadastroEndereco.getjTFId().setEnabled(false);
        this.telaCadastroEndereco.getjTFCidade().setEnabled(false);
        this.telaCadastroEndereco.getjTFBairro().setEnabled(false);
        this.telaCadastroEndereco.getjBBuscarBairro().setEnabled(false);
        this.telaCadastroEndereco.getjBBuscarCidade().setEnabled(false);
        this.telaCadastroEndereco.getjFTFCEP().setEnabled(false);
        this.telaCadastroEndereco.getjTFLogradouro().setEnabled(false);
        this.telaCadastroEndereco.getjCBUf().setEnabled(false);
        utilities.Utilities.ativaDesativa(true, this.telaCadastroEndereco.getjPanBotoes());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroEndereco.getjBNovo()) {
            utilities.Utilities.ativaDesativa(false, this.telaCadastroEndereco.getjPanBotoes());
            utilities.Utilities.limpaComponentes(true, this.telaCadastroEndereco.getjPanDados());
            this.telaCadastroEndereco.getjTFId().setEnabled(false);
            this.telaCadastroEndereco.getjTFCidade().setEnabled(false);
            this.telaCadastroEndereco.getjTFBairro().setEnabled(false);

        } else if (e.getSource() == this.telaCadastroEndereco.getjBBuscarBairro()) {
            TelaBuscaBairro telaBuscaBairro = new TelaBuscaBairro(null, true);
            ControllerBuscarBairro telBuscarBairro = new ControllerBuscarBairro(telaBuscaBairro);
            telaBuscaBairro.setVisible(true);
            this.telaCadastroEndereco.getjTFCidade().setEnabled(false);
            this.telaCadastroEndereco.getjTFBairro().setEnabled(false);
            if (codigoBairro != 0) {
                Bairro bairro = new Bairro();
                bairro = service.BairroService.carregar(codigoBairro);

                this.telaCadastroEndereco.getjTFBairro().setText(bairro.getDescricao());
            }

        } else if (e.getSource() == this.telaCadastroEndereco.getjBBuscarCidade()) {
            TelaBuscaCidade telaBuscaCidade = new TelaBuscaCidade(null, true);
            ControllerBuscarCidade controllerBuscarCidade = new ControllerBuscarCidade(telaBuscaCidade);
            telaBuscaCidade.setVisible(true);
            this.telaCadastroEndereco.getjTFCidade().setEnabled(false);
            this.telaCadastroEndereco.getjTFBairro().setEnabled(false);
            if (codigoCidade != 0) {
                Cidade cidade = new Cidade();
                cidade = service.CidadeService.carregar(codigoCidade);

                this.telaCadastroEndereco.getjTFCidade().setText(cidade.getDescricao());
                this.telaCadastroEndereco.getjCBUf().setSelectedItem(cidade.getUf());
            }
            //Cancelar
        } else if (e.getSource() == this.telaCadastroEndereco.getjBCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.telaCadastroEndereco.getjPanBotoes());
            utilities.Utilities.limpaComponentes(false, this.telaCadastroEndereco.getjPanDados());
            this.telaCadastroEndereco.getjLId().setEnabled(true);

            //Gravar
        } else if (e.getSource() == this.telaCadastroEndereco.getjBGravar()) {
            Endereco endereco = new Endereco();
            this.telaCadastroEndereco.getjTFCidade().setEnabled(false);
            this.telaCadastroEndereco.getjTFBairro().setEnabled(false);
            endereco.setLogradouro(this.telaCadastroEndereco.getjTFLogradouro().getText());
            endereco.setCep(this.telaCadastroEndereco.getjFTFCep().getText());
            endereco.setStatus('A');
            
          

            endereco.setCidade(service.CidadeService.carregar(codigoCidade));
            endereco.setBairro(service.BairroService.carregar(codigoBairro));

            if (endereco.getCep().isEmpty() || endereco.getLogradouro().isEmpty()) {
                JOptionPane.showMessageDialog(this.telaCadastroEndereco, "Todos os campos devem ser preenchidos", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (this.telaCadastroEndereco.getjTFId().getText().equalsIgnoreCase("")) {
                //novo objeto a persistir
                service.EnderecoService.adicionar(endereco);
                utilities.Utilities.ativaDesativa(true, this.telaCadastroEndereco.getjPanBotoes());
                utilities.Utilities.limpaComponentes(false, this.telaCadastroEndereco.getjPanDados());

                this.telaCadastroEndereco.getjTFId().setEnabled(false);

            } else {
                //? um objeto existente sendo atualizado
                endereco.setId(Integer.parseInt(this.telaCadastroEndereco.getjTFId().getText()));
                service.EnderecoService.atualizar(endereco);
                utilities.Utilities.ativaDesativa(true, this.telaCadastroEndereco.getjPanBotoes());
                utilities.Utilities.limpaComponentes(false, this.telaCadastroEndereco.getjPanDados());

                this.telaCadastroEndereco.getjTFId().setEnabled(false);
            }
        } else if (e.getSource() == this.telaCadastroEndereco.getjBBuscar()) {
            codigoEndereco = 0;
            TelaBuscaEndereço telaBuscaEndereço = new TelaBuscaEndereço(null, true);
            ControllerBuscarEndereco controllerBuscarEndereco = new ControllerBuscarEndereco(telaBuscaEndereço);
            telaBuscaEndereço.setVisible(true);

            if (codigoEndereco != 0) {
                Endereco endereco = new Endereco();
                endereco = service.EnderecoService.carregar(codigoEndereco);
                utilities.Utilities.ativaDesativa(false, this.telaCadastroEndereco.getjPanBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaCadastroEndereco.getjPanDados());

                this.telaCadastroEndereco.getjTFId().setText(endereco.getId() + "");
                this.telaCadastroEndereco.getjFTFCEP().setText(endereco.getCep());
                this.telaCadastroEndereco.getjTFCidade().setText(endereco.getCidade().getDescricao());
                this.telaCadastroEndereco.getjTFLogradouro().setText(endereco.getLogradouro());
                this.telaCadastroEndereco.getjCBUf().setSelectedItem(endereco.getCidade().getUf());
                this.telaCadastroEndereco.getjTFBairro().setText(endereco.getBairro().getDescricao());
                this.telaCadastroEndereco.getjTFId().setEnabled(false);
                this.telaCadastroEndereco.getjTFCidade().setEnabled(false);
                this.telaCadastroEndereco.getjTFBairro().setEnabled(false);

            }
        } else if (e.getSource()
                == this.telaCadastroEndereco.getjBSair()) {
            this.telaCadastroEndereco.dispose();
        }
    }
}
