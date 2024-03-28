/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Cidade;
import view.TelaBuscaCarteirinha;
import view.TelaBuscaCidade;
import view.TelaCadastroCidade;

/**
 *
 * @author patyx
 */
public class ControllerCadastroCidade implements ActionListener {

    TelaCadastroCidade telaCadastroCidade;
    public static int codigoCidade;

    public ControllerCadastroCidade(TelaCadastroCidade telaCadastroCidade) {
        this.telaCadastroCidade = telaCadastroCidade;

        this.telaCadastroCidade.getjBNovo().addActionListener(this);
        this.telaCadastroCidade.getjBBuscar().addActionListener(this);
        this.telaCadastroCidade.getjBCancelar().addActionListener(this);
        this.telaCadastroCidade.getjBSair().addActionListener(this);
        this.telaCadastroCidade.getjBGravar().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaCadastroCidade.getjPanBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaCadastroCidade.getjPanDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroCidade.getjBNovo()) {
            utilities.Utilities.ativaDesativa(false, this.telaCadastroCidade.getjPanBotoes());
            utilities.Utilities.limpaComponentes(true, this.telaCadastroCidade.getjPanDados());

            this.telaCadastroCidade.getjTFId().setEnabled(false);

        } else if (e.getSource() == this.telaCadastroCidade.getjBCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.telaCadastroCidade.getjPanBotoes());
            utilities.Utilities.limpaComponentes(false, this.telaCadastroCidade.getjPanDados());

        } else if (e.getSource() == this.telaCadastroCidade.getjBGravar()) {
            Cidade cidade = new Cidade();
            cidade.setDescricao(this.telaCadastroCidade.getjTFDescricao().getText());
            cidade.setUf(this.telaCadastroCidade.getjCBUf().getSelectedItem().toString());

            if (cidade.getDescricao().isEmpty() || cidade.getUf().isEmpty()) {
                JOptionPane.showMessageDialog(this.telaCadastroCidade, "Todos os campos devem ser preenchidos", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (this.telaCadastroCidade.getjTFId().getText().equalsIgnoreCase("")) {

                service.CidadeService.adicionar(cidade);

            } else {
                cidade.setId(Integer.parseInt(this.telaCadastroCidade.getjTFId().getText()));
                service.CidadeService.atualizar(cidade);
            }
            utilities.Utilities.ativaDesativa(true, this.telaCadastroCidade.getjPanBotoes());
            utilities.Utilities.limpaComponentes(false, this.telaCadastroCidade.getjPanDados());

        } else if (e.getSource() == this.telaCadastroCidade.getjBBuscar()) {
            codigoCidade = 0;
            TelaBuscaCidade telaBuscaCidade = new TelaBuscaCidade(null, true);
            ControllerBuscarCidade controllerBuscarCidade = new ControllerBuscarCidade(telaBuscaCidade);
            telaBuscaCidade.setVisible(true);

            if (codigoCidade != 0) {
                Cidade cidade = new Cidade();
                cidade = service.CidadeService.carregar(codigoCidade);
                utilities.Utilities.ativaDesativa(false, this.telaCadastroCidade.getjPanBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaCadastroCidade.getjPanDados());

                this.telaCadastroCidade.getjTFDescricao().setText(cidade.getDescricao());
                this.telaCadastroCidade.getjTFId().setText(cidade.getId() + "");
                this.telaCadastroCidade.getjCBUf().setSelectedItem(cidade.getUf());

                this.telaCadastroCidade.getjTFId().setEnabled(false);
            }
        } else if (e.getSource() == this.telaCadastroCidade.getjBSair()) {
            this.telaCadastroCidade.dispose();
        }
    }

}
