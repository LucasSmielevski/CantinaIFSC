/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.swing.JOptionPane;
import model.bo.Carteirinha;
import model.bo.Cliente;
import view.TelaBuscaCarteirinha;
import view.TelaBuscaCliente;
import view.TelaCadastroCarteirinha;

/**
 *
 * @author patyx
 */
public class ControllerCadastroCarteirinha implements ActionListener {

    TelaCadastroCarteirinha telaCadastroCarteirinha;
    public static int codigoCarteirinha, codigoCliente;

    public ControllerCadastroCarteirinha(TelaCadastroCarteirinha telaCadastroCarteirinha) {
        this.telaCadastroCarteirinha = telaCadastroCarteirinha;

        this.telaCadastroCarteirinha.getjBNovo().addActionListener(this);
        this.telaCadastroCarteirinha.getjBBuscar().addActionListener(this);
        this.telaCadastroCarteirinha.getjBCancelar().addActionListener(this);
        this.telaCadastroCarteirinha.getjBSair().addActionListener(this);
        this.telaCadastroCarteirinha.getjBGravar().addActionListener(this);
        this.telaCadastroCarteirinha.getjBGerar().addActionListener(this);
        this.telaCadastroCarteirinha.getjButtonBuscarCliente().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaCadastroCarteirinha.getjPanBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaCadastroCarteirinha.getjPanDados());
        this.telaCadastroCarteirinha.getjTFIdCliente().setEnabled(false);
        this.telaCadastroCarteirinha.getjTFNomeCliente().setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroCarteirinha.getjBNovo()) {
            utilities.Utilities.ativaDesativa(false, this.telaCadastroCarteirinha.getjPanBotoes());
            utilities.Utilities.limpaComponentes(true, this.telaCadastroCarteirinha.getjPanDados());
            this.telaCadastroCarteirinha.getjTFId().setEnabled(false);
            this.telaCadastroCarteirinha.getjTFCodigoBarra().setEnabled(false);
            this.telaCadastroCarteirinha.getjFTFDataCancelamento().setEnabled(false);
            this.telaCadastroCarteirinha.getjTFIdCliente().setEnabled(false);
            this.telaCadastroCarteirinha.getjTFNomeCliente().setEnabled(false);
            // Obter a data atual
            LocalDate dataAtual = LocalDate.now();

            // Formatador para exibir a data no formato desejado
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Converter a data em uma string formatada
            String dataFormatada = dataAtual.format(formatter);

            // Definir a data formatada no campo de texto
            this.telaCadastroCarteirinha.getjFTFDataGeracao().setText(dataFormatada);
            this.telaCadastroCarteirinha.getjFTFDataGeracao().setEnabled(false);

        } else if (e.getSource() == this.telaCadastroCarteirinha.getjBGerar()) {
            Random gerador = new Random();
            String gerar = Integer.toString(1000 + gerador.nextInt(8000));

            //imprime sequência de 10 números inteiros aleatórios
            for (int i = 1; i < 2; i++) {
                this.telaCadastroCarteirinha.getjTFCodigoBarra().setText(gerar);
            }
        } else if (e.getSource() == this.telaCadastroCarteirinha.getjBCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.telaCadastroCarteirinha.getjPanBotoes());
            utilities.Utilities.limpaComponentes(false, this.telaCadastroCarteirinha.getjPanDados());

        } else if (e.getSource() == this.telaCadastroCarteirinha.getjBGravar()) {
            Carteirinha carteirinha = new Carteirinha();
            if (this.telaCadastroCarteirinha.getjTFId().getText().equalsIgnoreCase("")) {
                carteirinha.setCodigoBarra(this.telaCadastroCarteirinha.getjTFCodigoBarra().getText());

                carteirinha.setDataGeracao(this.telaCadastroCarteirinha.getjFTFDataGeracao().getText());
                carteirinha.setDataCancelamento(this.telaCadastroCarteirinha.getjFTFDataCancelamento().getText());

                carteirinha.setCliente(service.ClienteService.carregar(codigoCliente));
                if (carteirinha.getCodigoBarra().isEmpty() || this.telaCadastroCarteirinha.getjTFNomeCliente().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this.telaCadastroCarteirinha, "Todos os campos devem ser preenchidos", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (this.telaCadastroCarteirinha.getjTFId().getText().equalsIgnoreCase("")) {
                    service.CarteirinhaService.adicionar(carteirinha);
                    utilities.Utilities.ativaDesativa(true, this.telaCadastroCarteirinha.getjPanBotoes());
                    utilities.Utilities.limpaComponentes(false, this.telaCadastroCarteirinha.getjPanDados());
                } else {
                    carteirinha.setId(codigoCliente);
                    service.CarteirinhaService.atualizar(carteirinha);
                    utilities.Utilities.ativaDesativa(true, this.telaCadastroCarteirinha.getjPanBotoes());
                    utilities.Utilities.limpaComponentes(false, this.telaCadastroCarteirinha.getjPanDados());
                }
            }

            utilities.Utilities.ativaDesativa(true, this.telaCadastroCarteirinha.getjPanBotoes());
            utilities.Utilities.limpaComponentes(false, this.telaCadastroCarteirinha.getjPanDados());

        } else if (e.getSource() == this.telaCadastroCarteirinha.getjBBuscar()) {
            codigoCarteirinha = 0;
            TelaBuscaCarteirinha telaBuscaCarteirinha = new TelaBuscaCarteirinha(null, true);
            ControllerBuscarCarteirinha controllerBuscarCarteirinha = new ControllerBuscarCarteirinha(telaBuscaCarteirinha);
            telaBuscaCarteirinha.setVisible(true);
            Carteirinha carteirinha = new Carteirinha();

            if (codigoCarteirinha != 0) {
                carteirinha = service.CarteirinhaService.carregar(codigoCarteirinha);
                utilities.Utilities.ativaDesativa(false, this.telaCadastroCarteirinha.getjPanBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaCadastroCarteirinha.getjPanDados());

                this.telaCadastroCarteirinha.getjTFId().setText(carteirinha.getId() + "");
                this.telaCadastroCarteirinha.getjTFCodigoBarra().setText(carteirinha.getCodigoBarra());
                this.telaCadastroCarteirinha.getjFTFDataGeracao().setText(carteirinha.getDataGeracao());
                this.telaCadastroCarteirinha.getjFTFDataCancelamento().setText(carteirinha.getDataCancelamento());
                this.telaCadastroCarteirinha.getjTFNomeCliente().setText(carteirinha.getCliente().getNome());
                this.telaCadastroCarteirinha.getjTFIdCliente().setText(Integer.toString(carteirinha.getCliente().getId()));

                this.telaCadastroCarteirinha.getjTFId().setEnabled(false);
                this.telaCadastroCarteirinha.getjTFCodigoBarra().setEnabled(false);
                this.telaCadastroCarteirinha.getjTFIdCliente().setEnabled(false);
                this.telaCadastroCarteirinha.getjTFNomeCliente().setEnabled(false);
                this.telaCadastroCarteirinha.getjFTFDataGeracao().setEnabled(false);

            }
        } else if (e.getSource() == this.telaCadastroCarteirinha.getjButtonBuscarCliente()) {
            TelaBuscaCliente telaBuscaCliente = new TelaBuscaCliente(null, true);
            ControllerBuscarCliente controllerBuscarCliente = new ControllerBuscarCliente(telaBuscaCliente);
            telaBuscaCliente.setVisible(true);

            if (codigoCliente != 0) {
                Cliente cliente = new Cliente();
                cliente = service.ClienteService.carregar(codigoCliente);
                utilities.Utilities.ativaDesativa(false, this.telaCadastroCarteirinha.getjPanBotoes());

                this.telaCadastroCarteirinha.getjTFIdCliente().setText(Integer.toString(cliente.getId()));
                this.telaCadastroCarteirinha.getjTFNomeCliente().setText(cliente.getNome());
                this.telaCadastroCarteirinha.getjTFIdCliente().setEnabled(false);
                this.telaCadastroCarteirinha.getjTFNomeCliente().setEnabled(false);

            }

        } else if (e.getSource() == this.telaCadastroCarteirinha.getjBSair()) {
            this.telaCadastroCarteirinha.dispose();
        }
    }

}
