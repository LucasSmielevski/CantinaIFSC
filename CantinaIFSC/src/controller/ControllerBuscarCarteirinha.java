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
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaCarteirinha;
import model.bo.Carteirinha;
import service.CarteirinhaService;

/**
 *
 * @author patyx
 */
public class ControllerBuscarCarteirinha implements ActionListener {

    TelaBuscaCarteirinha telaBuscaCarteirinha;

    public ControllerBuscarCarteirinha(TelaBuscaCarteirinha telaBuscaCarteirinha) {
        this.telaBuscaCarteirinha = telaBuscaCarteirinha;

        this.telaBuscaCarteirinha.getjButtonCarregar().addActionListener(this);
        this.telaBuscaCarteirinha.getjButtonSair().addActionListener(this);
        this.telaBuscaCarteirinha.getjButtonFiltrar().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaBuscaCarteirinha.getjPanBotoes());
        utilities.Utilities.limpaComponentes(true, this.telaBuscaCarteirinha.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBuscaCarteirinha.getjButtonFiltrar()) {
            utilities.Utilities.ativaDesativa(false, this.telaBuscaCarteirinha.getjPanBotoes());

            if (!this.telaBuscaCarteirinha.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                List<Carteirinha> listaCarteirinhas = new ArrayList<Carteirinha>();

                if (this.telaBuscaCarteirinha.getjComboBox1().getSelectedIndex() == 0) {
                    listaCarteirinhas.add(service.CarteirinhaService.carregar(Integer.parseInt(this.telaBuscaCarteirinha.getjTFFitrar().getText())));

                } else if (this.telaBuscaCarteirinha.getjComboBox1().getSelectedIndex() == 1) {
                    listaCarteirinhas = CarteirinhaService.carregar(this.telaBuscaCarteirinha.getjTFFitrar().getText().trim());
                } else if (this.telaBuscaCarteirinha.getjComboBox1().getSelectedIndex() == 2) {
                    listaCarteirinhas = CarteirinhaService.carregar(this.telaBuscaCarteirinha.getjTFFitrar().getText().trim());
                }

                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaCarteirinha.getjTableDados().
                        getModel();

                for (Carteirinha carteirinhaatual : listaCarteirinhas) {
                    tabela.addRow(new Object[]{carteirinhaatual.getId(), carteirinhaatual.getCodigoBarra(),
                        carteirinhaatual.getDataGeracao(), carteirinhaatual.getDataCancelamento(),
                        carteirinhaatual.getCliente().getId(), carteirinhaatual.getCliente().getNome()});
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aten??o!\nOp??o de Filtro Vazia...");
                this.telaBuscaCarteirinha.getjTFFitrar().requestFocus();
            }
        }
        if (e.getSource() == this.telaBuscaCarteirinha.getjButtonCarregar()) {

            controller.ControllerCadastroCarteirinha.codigoCarteirinha = (int) this.telaBuscaCarteirinha.
                    getjTableDados().getValueAt(this.telaBuscaCarteirinha.getjTableDados().getSelectedRow(), 0);
            controller.ControllerVendas.codigoCarteirinha = (int) this.telaBuscaCarteirinha.getjTableDados().
                    getValueAt(this.telaBuscaCarteirinha.getjTableDados().getSelectedRow(), 0);

            utilities.Utilities.ativaDesativa(true, this.telaBuscaCarteirinha.getjPanBotoes());
            this.telaBuscaCarteirinha.dispose();
        }
        if (e.getSource() == this.telaBuscaCarteirinha.getjButtonSair()) {
            this.telaBuscaCarteirinha.dispose();
        }

    }
}
