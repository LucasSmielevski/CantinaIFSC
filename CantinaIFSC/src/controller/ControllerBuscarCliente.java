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
import model.bo.Cliente;
import service.ClienteService;
import view.TelaBuscaCliente;

/**
 *
 * @author patyx
 */
public class ControllerBuscarCliente implements ActionListener {

    TelaBuscaCliente telaBuscaCliente;

    public ControllerBuscarCliente(TelaBuscaCliente telaBuscaCliente) {
        this.telaBuscaCliente = telaBuscaCliente;

        this.telaBuscaCliente.getjButtonCarregar().addActionListener(this);
        this.telaBuscaCliente.getjButtonSair().addActionListener(this);
        this.telaBuscaCliente.getjButtonFiltrar().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaBuscaCliente.getjPanBotoes());
        utilities.Utilities.limpaComponentes(true, this.telaBuscaCliente.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBuscaCliente.getjButtonFiltrar()) {
            utilities.Utilities.ativaDesativa(false, this.telaBuscaCliente.getjPanBotoes());
            if (!this.telaBuscaCliente.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                List<Cliente> listaClientes = new ArrayList<Cliente>();

                if (this.telaBuscaCliente.getjComboBoxDescricao().getSelectedIndex() == 0) {
                    listaClientes.add(service.ClienteService.carregar(Integer.parseInt(this.telaBuscaCliente.getjTFFitrar().getText())));

                } else if (this.telaBuscaCliente.getjComboBoxDescricao().getSelectedIndex() == 1) {
                    listaClientes = ClienteService.carregar(this.telaBuscaCliente.getjTFFitrar().getText().trim());
                } else if (this.telaBuscaCliente.getjComboBoxDescricao().getSelectedIndex() == 2) {
                    listaClientes = ClienteService.carregar(this.telaBuscaCliente.getjTFFitrar().getText().trim());
                }

                //Criar um onjeto do tipo tablemodel
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaCliente.getjTableDados().getModel();
                tabela.setRowCount(0);

                for (Cliente clienteatual : listaClientes) {
                    tabela.addRow(new Object[]{clienteatual.getId(),
                        clienteatual.getNome(),
                        clienteatual.getCpf(),
                        clienteatual.getMatricula(),
                        clienteatual.getFone1(),
                        clienteatual.getStatus(),
                        clienteatual.getEndereco().getCep(),
                        clienteatual.getEndereco().getCidade(),
                        clienteatual.getEndereco().getBairro(),
                        clienteatual.getEndereco().getLogradouro(),
                        clienteatual.getComplementoEndereco()});
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aten??o!\nOp??o de Filtro Vazia...");
                this.telaBuscaCliente.getjTFFitrar().requestFocus();
            }
        }
        if (e.getSource() == this.telaBuscaCliente.getjButtonCarregar()) {
            controller.ControllerCadastroCliente.codigoCliente = (int) this.telaBuscaCliente.
                    getjTableDados().getValueAt(this.telaBuscaCliente.getjTableDados().getSelectedRow(), 0);
            controller.ControllerCadastroCarteirinha.codigoCliente = (int) this.telaBuscaCliente.
                    getjTableDados().getValueAt(this.telaBuscaCliente.getjTableDados().getSelectedRow(), 0);

            utilities.Utilities.ativaDesativa(true, this.telaBuscaCliente.getjPanBotoes());
            this.telaBuscaCliente.dispose();
        }
        if (e.getSource() == this.telaBuscaCliente.getjButtonSair()) {
            this.telaBuscaCliente.dispose();
        }
    }

}
