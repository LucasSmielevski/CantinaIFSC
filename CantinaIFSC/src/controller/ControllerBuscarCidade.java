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
import model.bo.Cidade;
import model.bo.Cliente;
import service.CidadeService;
import view.TelaBuscaCidade;

/**
 *
 * @author patyx
 */
public class ControllerBuscarCidade implements ActionListener {

    TelaBuscaCidade telaBuscaCidade;

    public ControllerBuscarCidade(TelaBuscaCidade telaBuscaCidade) {
        this.telaBuscaCidade = telaBuscaCidade;

        this.telaBuscaCidade.getjButtonCarregar().addActionListener(this);
        this.telaBuscaCidade.getjButtonSair().addActionListener(this);
        this.telaBuscaCidade.getjButtonFiltrar().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaBuscaCidade.getjPanBotoes());
        utilities.Utilities.limpaComponentes(true, this.telaBuscaCidade.getjPanDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBuscaCidade.getjButtonFiltrar()) {
            utilities.Utilities.ativaDesativa(false, this.telaBuscaCidade.getjPanBotoes());
            if (this.telaBuscaCidade.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção!\nOpção de Filtro Vazia.");
                this.telaBuscaCidade.getjTFFitrar().requestFocus();
            } else {
                List<Cidade> listaCidades = new ArrayList<Cidade>();

                if (this.telaBuscaCidade.getjCBDescricao().getSelectedIndex() == 0) {
                    listaCidades.add(CidadeService.carregar(Integer.parseInt(this.telaBuscaCidade.getjTFFitrar().getText())));

                } else if (this.telaBuscaCidade.getjCBDescricao().getSelectedIndex() == 1) {
                    listaCidades = CidadeService.carregar(this.telaBuscaCidade.getjTFFitrar().getText().trim());
                } else if (this.telaBuscaCidade.getjCBDescricao().getSelectedIndex() == 2) {
                    listaCidades = CidadeService.carregar(this.telaBuscaCidade.getjTFFitrar().getText().trim());
                }

                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaCidade.getjTableDados().getModel();
                tabela.setRowCount(0);
                for (Cidade cidadeAtual : listaCidades) {
                    tabela.addRow(new Object[]{cidadeAtual.getId(),
                        cidadeAtual.getDescricao(), cidadeAtual.getUf()});
                }
            }
        }
        if (e.getSource() == this.telaBuscaCidade.getjButtonCarregar()) {
            controller.ControllerCadastroCidade.codigoCidade = (int) this.telaBuscaCidade.
                    getjTableDados().
                    getValueAt(this.telaBuscaCidade.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaCidade.getjPanBotoes());
            this.telaBuscaCidade.dispose();

            controller.ControllerCadastroEndereco.codigoCidade = (int) this.telaBuscaCidade.
                    getjTableDados().
                    getValueAt(this.telaBuscaCidade.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaCidade.getjPanBotoes());
            this.telaBuscaCidade.dispose();
        }
        if (e.getSource() == this.telaBuscaCidade.getjButtonSair()) {
            this.telaBuscaCidade.dispose();
        }

    }
}
