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
import model.bo.Funcionario;
import view.TelaBuscaFuncionario;

/**
 *
 * @author patyx
 */
public class ControllerBuscarFuncionario implements ActionListener {

    TelaBuscaFuncionario telaBuscaFuncionario;

    public ControllerBuscarFuncionario(TelaBuscaFuncionario telaBuscaFuncionario) {
        this.telaBuscaFuncionario = telaBuscaFuncionario;

        this.telaBuscaFuncionario.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFuncionario.getjButtonSair().addActionListener(this);
        this.telaBuscaFuncionario.getjButtonFiltrar().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaBuscaFuncionario.getjPanBotoes());
        utilities.Utilities.limpaComponentes(true, this.telaBuscaFuncionario.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBuscaFuncionario.getjButtonFiltrar()) {
            utilities.Utilities.ativaDesativa(false, this.telaBuscaFuncionario.getjPanBotoes());
            if (!this.telaBuscaFuncionario.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

                if (this.telaBuscaFuncionario.getjCBDescricao().getSelectedIndex() == 0) {
                    listaFuncionarios.add(service.FuncionarioService.carregar(Integer.parseInt(this.telaBuscaFuncionario.getjTFFitrar().getText())));

                } else if (this.telaBuscaFuncionario.getjCBDescricao().getSelectedIndex() == 1) {
                    listaFuncionarios = service.FuncionarioService.carregar(this.telaBuscaFuncionario.getjTFFitrar().getText().trim());
                } else if (this.telaBuscaFuncionario.getjCBDescricao().getSelectedIndex() == 2) {
                    listaFuncionarios = service.FuncionarioService.carregar(this.telaBuscaFuncionario.getjTFFitrar().getText().trim());
                }

                //Criar um onjeto do tipo tablemodel
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
                tabela.setRowCount(0);

                for (Funcionario funcionarioatual : listaFuncionarios) {
                    tabela.addRow(new Object[]{funcionarioatual.getId(), funcionarioatual.getStatus(),
                        funcionarioatual.getCpf(), funcionarioatual.getNome(),
                        funcionarioatual.getRg(), funcionarioatual.getEmail(),
                        funcionarioatual.getFone1(), funcionarioatual.getUsuario(), funcionarioatual.getEndereco().getCep(),
                        funcionarioatual.getEndereco().getCidade() + "/" + funcionarioatual.getEndereco().getCidade().getUf(),
                        funcionarioatual.getEndereco().getBairro(), funcionarioatual.getEndereco().getLogradouro(),
                        funcionarioatual.getComplementoEndereco()});
                }

            } else {
                JOptionPane.showMessageDialog(null, "Aten??o!\nOp??o de Filtro Vazia...");
                this.telaBuscaFuncionario.getjTFFitrar().requestFocus();
            }
        }
        if (e.getSource() == this.telaBuscaFuncionario.getjButtonCarregar()) {
            controller.ControllerCadastroFuncionario.codigoFuncionario = (int) this.telaBuscaFuncionario.
                    getjTableDados().getValueAt(this.telaBuscaFuncionario.getjTableDados().getSelectedRow(), 0);
            controller.ControllerVendas.codigoFuncionario = (int) this.telaBuscaFuncionario.
                    getjTableDados().getValueAt(this.telaBuscaFuncionario.getjTableDados().getSelectedRow(), 0);

            utilities.Utilities.ativaDesativa(true, this.telaBuscaFuncionario.getjPanBotoes());
            this.telaBuscaFuncionario.dispose();

        }
        if (e.getSource() == this.telaBuscaFuncionario.getjButtonSair()) {
            this.telaBuscaFuncionario.dispose();
        }
    }
}
